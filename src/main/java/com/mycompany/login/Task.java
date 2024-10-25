package com.mycompany.login;

/**
 *
 * @author Simthandile Mompei
 */
public class Task {

    private String[] taskName;
    private  int[] taskNumber;
    private  String[] taskDescription;
    private  String[] developerDetails;
    private int[] taskDuration;
    private String[] taskID;
    private String[] taskStatus;

 public Task(int no_Tasks){
     // Initialize arrays based on the number of tasks
        taskName = new String[no_Tasks];
        taskDescription = new String[no_Tasks];
        developerDetails = new String[no_Tasks];
        taskDuration = new int[no_Tasks];
        taskNumber = new int[no_Tasks];
        taskID = new String[no_Tasks];
        taskStatus = new String[no_Tasks];
 }
    public void addtask(int index, String taskName, String taskDescription, String developerDetails, int taskDuration, String taskStatus) {
         // Set the task details in the arrays
        this.taskName[index] = taskName;
        this.taskDescription[index] = taskDescription;
        this.developerDetails[index] = developerDetails;
        this.taskDuration[index] = taskDuration;
        this.taskNumber[index] = index;
        this.taskID[index] = createTaskID(taskName, developerDetails, this.taskNumber[index]);
        this.taskStatus[index] = taskStatus;

    }

    public boolean checkTaskDescription(String description) {
        return description.length() <= 50;
    }

    public String createTaskID(String taskName, String developerdetails, int taskNumber) {
        String firstinital = taskName.length() >= 2 ? taskName.substring(0, 2).toUpperCase() : taskName.toUpperCase();
        String secondInital = developerdetails.length() >= 3 ? developerdetails.substring(developerdetails.length()-3).toUpperCase() : developerdetails.toUpperCase();
        return firstinital + ":" + taskNumber + ":" + secondInital;
    }

    public String printTaskDetails(int index) {
        return "Task Name: " + taskName[index] + "\n"
                + "Task Number: " + taskNumber[index] + "\n"
                + "Task Description: " + taskDescription[index] + "\n"
                + "Developer Details: " + developerDetails[index] + "\n"
                + "Task Duration: " + taskDuration[index] + "\n"
                + "TaskID: " + taskID[index] + "\n"
                + "Task Status: " + taskStatus[index] + "\n";

    }

    public int returnTotalHours(int Duration) {
        return Duration;
    }
}
