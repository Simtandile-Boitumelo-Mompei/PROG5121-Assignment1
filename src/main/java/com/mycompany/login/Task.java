package com.mycompany.login;

import javax.swing.JOptionPane;
import javax.xml.datatype.Duration;

/**
 *
 * @author Simthandile Mompei
 */
public class Task {

    private static String[] taskName;
    private static int[] taskNumber;
    private static String[] taskDescription;
    private static String[] developerDetails;
    private static int[] taskDuration;
    private static String[] taskID;
    private static String[] taskStatus;

    //Create constructor for the classs
//    public Task(String taskname, int taskNumber,String taskdescription,String developerdetails,int taskduration,String taskstatus){
//        this.taskName = taskname;
//        this.taskNumber = taskNumber ;
//        this.taskDescription = taskdescription;
//        this.developerDetails = developerdetails;
//        this.taskDuration = taskduration;
//        this.taskID = createTaskID();
//        this.taskStatus = taskstatus;
//    }
    public void addtask() {

        //Array for taskStatus options
        String[] optionsToChoose = {"To Do", "Doing", "Done"};
        //Prompt user to enter the number of tasks
        int no_Tasks = Integer.parseInt(JOptionPane.showInputDialog("Enter the number of tasks: "));

        //Declare an object array to add task objects
        //For loop for adding task details
        for (int i = 0; i < no_Tasks; i++) {
            taskName = new String[no_Tasks];
            taskName[i] = JOptionPane.showInputDialog("Enter task name: ");
            
            taskDescription = new String[no_Tasks];
            //taskDescription[i] = JOptionPane.showInputDialog("Enter task description (must be 50 characters): ");
            

            
            while (true) {
                String description = JOptionPane.showInputDialog("Enter task description (must be 50 characters): ");
                if (checkTaskDescription(description)) {
                    taskDescription[i] = description;
                    JOptionPane.showMessageDialog(null, "Task successfully captured.");
                    break;
                } else {
                    JOptionPane.showMessageDialog(null, "Task not successfully captured.");
                }
            }

            //
            developerDetails = new String[no_Tasks];
            developerDetails[i] = JOptionPane.showInputDialog("Enter developer details(First Name and Last Name): ");
            

            //
            taskDuration = new int[no_Tasks];
            taskDuration[i] = Integer.parseInt(JOptionPane.showInputDialog("Enter total hours for task: "));
            taskDuration[i] += returnTotalHours(taskDuration[i]);
            
            taskNumber = new int[no_Tasks];
            taskNumber[i] = i ;
            
            taskID = new String[no_Tasks];
            taskID[i] = createTaskID(taskName[i], developerDetails[i], taskNumber[i]);
            
            
            taskStatus = new String[no_Tasks];
            taskStatus[i] = (String) JOptionPane.showInputDialog(null, "Choose task status: ", "Select task status",
                    JOptionPane.QUESTION_MESSAGE, null, optionsToChoose, optionsToChoose[2]);

            JOptionPane.showMessageDialog(null, "Task successfully captured\n" + printTaskDetails(i,taskID[i]));
        }

    }

    public boolean checkTaskDescription(String description) {
        return description.length() <= 50;
    }

    public String createTaskID(String taskName, String developerdetails, int taskNumber) {
        String firstinital = taskName.length() >= 2 ? taskName.substring(0, 2).toUpperCase() : taskName.toUpperCase();
        String secondInital = developerdetails.length() >= 3 ? developerdetails.substring(developerdetails.length()-3, 3).toUpperCase() : developerdetails.toUpperCase();
        return firstinital + ":" + taskNumber + ":" + secondInital;
    }

    public String printTaskDetails(int menu, String taskId) {
        return "Task Name: " + taskName[menu] + "\n"
                + "Task Number: " + taskNumber[menu] + "\n"
                + "Task Description: " + taskDescription[menu] + "\n"
                + "Developer Details: " + developerDetails[menu] + "\n"
                + "Task Duration: " + taskDuration[menu] + "\n"
                + "TaskID: " + taskId + "\n"
                + "Task Status: " + taskStatus[menu] + "\n";

    }

    public int returnTotalHours(int Duration) {
        return Duration;
    }
}
