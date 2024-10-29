package com.mycompany.login;

/**
 *
 * @author Simthandile Mompei
 */
public class Task {

    private String[] taskName;
    private int[] taskNumber;
    private String[] taskDescription;
    private String[] developerDetails;
    private int[] taskDuration;
    private String[] taskID;
    private String[] taskStatus;

    // Getter methods for each field to help with testing
    public String getTaskName(int index) {
        return taskName[index];
    }

    public String getTaskDescription(int index) {
        return taskDescription[index];
    }

    public String getDeveloperDetails(int index) {
        return developerDetails[index];
    }

    public int getTaskDuration(int index) {
        return taskDuration[index];
    }

    public int getTaskNumber(int index) {
        return taskNumber[index];
    }

    public String getTaskID(int index) {
        return taskID[index];
    }

    public String getTaskStatus(int index) {
        return taskStatus[index];
    }

    public void initializeTasks(int no_Tasks) {
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
        this.taskID[index] = createTaskID(taskName, developerDetails, this.taskNumber[index]);//Call createTaskID to create automated TaskID
        this.taskStatus[index] = taskStatus;

    }
    //Method that checks that the task Decription length is length is below 50
    public boolean checkTaskDescription(String description) {
        return description.length() <= 50;
    }
    //Method that create TaskID
    public String createTaskID(String taskName, String developerdetails, int taskNumber) {
        String firstinital = taskName.length() >= 2 ? taskName.substring(0, 2).toUpperCase() : taskName.toUpperCase();
        String secondInital = developerdetails.length() >= 3 ? developerdetails.substring(developerdetails.length() - 3).toUpperCase() : developerdetails.toUpperCase();
        return firstinital + ":" + taskNumber + ":" + secondInital;
    }
    //Method to display task details
    public String printTaskDetails(int index) {
        return "Task Name: " + taskName[index] + "\n"
                + "Task Number: " + taskNumber[index] + "\n"
                + "Task Description: " + taskDescription[index] + "\n"
                + "Developer Details: " + developerDetails[index] + "\n"
                + "Task Duration: " + taskDuration[index] + "\n"
                + "TaskID: " + taskID[index] + "\n"
                + "Task Status: " + taskStatus[index] + "\n";

    }
    //Method that returns the total duration of tasks
   public int returnTotalHours(int[] durations) {
        int totalHours = 0;
        //Loop throught durations array and add values to totalHours variable
        for (int duration : durations) {
            totalHours += duration;
        }
        return totalHours;
    }
}
