package com.mycompany.login;

import javax.swing.JOptionPane;

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
    private int no_Tasks;
    private int index = 0;

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
        this.no_Tasks = no_Tasks;
        taskName = new String[no_Tasks];
        taskDescription = new String[no_Tasks];
        developerDetails = new String[no_Tasks];
        taskDuration = new int[no_Tasks];
        taskNumber = new int[no_Tasks];
        taskID = new String[no_Tasks];
        taskStatus = new String[no_Tasks];
    }

    public void addtask(int taskNumber, String taskName, String taskDescription, String developerDetails, int taskDuration, String taskStatus) {
        // Set the task details in the arrays
        if(index < no_Tasks){
        this.taskNumber[index] = taskNumber;
        this.taskName[index] = taskName;
        this.taskDescription[index] = taskDescription;
        this.developerDetails[index] = developerDetails;
        this.taskDuration[index] = taskDuration;
        this.taskID[index] = createTaskID(taskName, developerDetails, this.taskNumber[index]);//Call createTaskID to create automated TaskID
        this.taskStatus[index] = taskStatus;
        index++;
        }else{
            JOptionPane.showMessageDialog(null, "Task limit reached. Cannot add more tasks.");
        }

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

    public String displayTasksWithStatusDone() {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < index; i++) {
            if ("Done".equalsIgnoreCase(taskStatus[i])) {
                result.append("Developer: ").append(developerDetails[i])
                      .append("\nTask Name: ").append(taskName[i])
                      .append("\nDuration: ").append(taskDuration[i]).append(" hours\n");
            }
        }
        return result.toString();
    }

    public String displayTaskWithLongestDuration() {
       int maxDurationIndex = 0;
        for (int i = 1; i < index; i++) {
            if (taskDuration[i] > taskDuration[maxDurationIndex]) {
                maxDurationIndex = i;
            }
        }
        return "Developer: " + developerDetails[maxDurationIndex] + ", Duration: " + taskDuration[maxDurationIndex] + " hours";
    }
    
     // c. Search for a task by name and display Task Name, Developer, and Status
    public String searchTaskByName(String searchName) {
        for (int i = 0; i < index; i++) {
            if (taskName[i].equalsIgnoreCase(searchName)) {
                return "Task Name: " + taskName[i] + ", Developer: " + developerDetails[i] + ", Status: " + taskStatus[i];
            }
        }
        return "Task not found.";
    }
    
     // d. Search for tasks by developer name and display Task Name and Status
    public String searchTasksByDeveloper(String developerName) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < index; i++) {
            if (developerDetails[i].equalsIgnoreCase(developerName)) {
                result.append("Task Name: ").append(taskName[i])
                      .append("\nStatus: ").append(taskStatus[i]).append("\n");
            }
        }
        return result.length() > 0 ? result.toString() : "No tasks found for this developer.";
    }

      // e. Delete a task by name
    public String deleteTaskByName(String task) {
        for (int i = 0; i < index; i++) {
            if (taskName[i].equalsIgnoreCase(task)) {
                // Shift elements to the left to remove the task
                for (int j = i; j < index - 1; j++) {
                    taskName[j] = taskName[j + 1];
                    taskDescription[j] = taskDescription[j + 1];
                    developerDetails[j] = developerDetails[j + 1];
                    taskDuration[j] = taskDuration[j + 1];
                    taskStatus[j] = taskStatus[j + 1];
                    taskID[j] = taskID[j + 1];
                }
                index--;
                return "Task deleted successfully.";
            }
        }
        return "Task not found.";
    }

    // f. Display report of all tasks
    public String displayAllTasks() {
        StringBuilder report = new StringBuilder();
        for (int i = 0; i < index; i++) {
            report.append("Task Name: ").append(taskName[i])
                  .append("\nTask Number: ").append(i + 1)
                  .append("\nTask Description: ").append(taskDescription[i])
                  .append("\nDeveloper: ").append(developerDetails[i])
                  .append("\nDuration: ").append(taskDuration[i])
                  .append("\nTask ID: ").append(taskID[i])
                  .append("\nStatus: ").append(taskStatus[i]).append("\n\n");
        }
        return report.toString();
    }
}
