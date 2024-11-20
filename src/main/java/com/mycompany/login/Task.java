package com.mycompany.login;

import javax.swing.JOptionPane;

/**
 *
 * @author Simthandile Mompei
 */
public class Task {

    // Arrays to store task information
    private String[] taskNames;          // Stores task names
    private int[] taskNumbers;           // Stores task numbers
    private String[] taskDescriptions;   // Stores task descriptions
    private String[] developerDetails;   // Stores developer details
    private int[] taskDurations;         // Stores task durations in hours
    private String[] taskIDs;            // Stores task IDs
    private String[] taskStatuses;       // Stores task statuses
    private int totalTasks;              // Maximum number of tasks allowed
    private int taskCount = 0;           // Tracks the number of tasks added

    // Getter methods for accessing task details during testing
    public String getTaskName(int index) {
        return taskNames[index];
    }

    public String getTaskDescription(int index) {
        return taskDescriptions[index];
    }

    public String getDeveloperDetails(int index) {
        return developerDetails[index];
    }

    public int getTaskDuration(int index) {
        return taskDurations[index];
    }

    public int getTaskNumber(int index) {
        return taskNumbers[index];
    }

    public String getTaskID(int index) {
        return taskIDs[index];
    }

    public String getTaskStatus(int index) {
        return taskStatuses[index];
    }

    //Initializes arrays to store task information.
    public void initializeTasks(int totalTasks) {
        // Initialize arrays based on the number of tasks
        this.totalTasks = totalTasks;
        taskNames = new String[totalTasks];
        taskDescriptions = new String[totalTasks];
        developerDetails = new String[totalTasks];
        taskDurations = new int[totalTasks];
        taskNumbers = new int[totalTasks];
        taskIDs = new String[totalTasks];
        taskStatuses = new String[totalTasks];
    }

    public void addTask(int taskNumber, String taskName, String taskDescription, String developerDetails, int taskDuration, String taskStatus) {
        // Set the task details in the arrays
        if (taskCount < totalTasks) {
            this.taskNumbers[taskCount] = taskNumber;
            this.taskNames[taskCount] = taskName;
            this.taskDescriptions[taskCount] = taskDescription;
            this.developerDetails[taskCount] = developerDetails;
            this.taskDurations[taskCount] = taskDuration;
            this.taskIDs[taskCount] = createTaskID(taskName, developerDetails, this.taskNumbers[taskCount]);//Call createTaskID to create automated TaskID
            this.taskStatuses[taskCount] = taskStatus;
            taskCount++;
        } else {
            JOptionPane.showMessageDialog(null, "Task limit reached. Cannot add more tasks.");
        }

    }

    //Validates that the task description is 50 characters or less.
    public boolean checkTaskDescription(String description) {
        return description.length() <= 50;
    }

    //Generates a unique Task ID using parts of the task name and developer details.
    public String createTaskID(String taskName, String developerdetails, int taskNumber) {
        String namePrefix = taskName.length() >= 2 ? taskName.substring(0, 2).toUpperCase() : taskName.toUpperCase();
        String developerSuffix = developerdetails.length() >= 3 ? developerdetails.substring(developerdetails.length() - 3).toUpperCase() : developerdetails.toUpperCase();
        return namePrefix + ":" + taskNumber + ":" + developerSuffix;
    }

    //Displays the details of a specific task.
    public String printTaskDetails(int index) {
        return "Task Name: " + taskNames[index] + "\n"
                + "Task Number: " + taskNumbers[index] + "\n"
                + "Task Description: " + taskDescriptions[index] + "\n"
                + "Developer Details: " + developerDetails[index] + "\n"
                + "Task Duration: " + taskDurations[index] + "\n"
                + "TaskID: " + taskIDs[index] + "\n"
                + "Task Status: " + taskStatuses[index] + "\n";

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
//***********************************************PART 3 Methods****************************************************************************************************
    //Displays all tasks with a status of "Done."

    public String displayTasksWithStatusDone(String[] statuses, String[] developers, String[] names, int[] durations) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < taskCount; i++) {
            if ("Done".equalsIgnoreCase(statuses[i])) {
                result.append("Developer: ").append(developers[i])
                        .append("\nTask Name: ").append(names[i])
                        .append("\nDuration: ").append(durations[i]).append(" hours\n");
            }
        }
        return result.toString();
    }

    //Finds and displays the task with the longest duration.
    public String displayTaskWithLongestDuration(String[] developers, int[] durations) {
        int maxDurationIndex = 0;
        for (int i = 1; i < taskCount; i++) {
            if (durations[i] > durations[maxDurationIndex]) {
                maxDurationIndex = i;
            }
        }
        return "Developer: " + developers[maxDurationIndex] + "\nDuration: " + durations[maxDurationIndex] + " hours";
    }

    //  Search for a task by name and display Task Name, Developer, and Status
    public String searchTaskByName(String searchName, String[] names, String[] developers, String[] statuses) {
        for (int i = 0; i < taskCount; i++) {
            if (names[i].equalsIgnoreCase(searchName)) {
                return "Task Name: " + names[i] + "\nDeveloper: " + developers[i] + "\nStatus: " + statuses[i];
            }
        }
        return "Task not found.";
    }

    // Search for tasks by developer name and display Task Name and Status
    public String searchTasksByDeveloper(String developerName, String[] names, String[] statuses) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < taskCount; i++) {
            if (developerDetails[i].equalsIgnoreCase(developerName)) {
                result.append("Task Name: ").append(names[i])
                        .append("\nStatus: ").append(statuses[i]).append("\n");
            }
        }
        return result.length() > 0 ? result.toString() : "No tasks found for this developer.";
    }

    // Delete a task by name
    public String deleteTaskByName(String name, String[] names) {
        for (int i = 0; i < taskCount; i++) {
            if (names[i].equalsIgnoreCase(name)) {
                // Shift elements to the left to remove the task
                for (int j = i; j < taskCount - 1; j++) {
                    taskNames[j] = taskNames[j + 1];
                    taskDescriptions[j] = taskDescriptions[j + 1];
                    developerDetails[j] = developerDetails[j + 1];
                    taskDurations[j] = taskDurations[j + 1];
                    taskStatuses[j] = taskStatuses[j + 1];
                    taskIDs[j] = taskIDs[j + 1];
                }
                // Clear the last slot 
                taskNames[taskCount - 1] = null;
                taskDescriptions[taskCount - 1] = null;
                developerDetails[taskCount - 1] = null;
                taskDurations[taskCount - 1] = 0;
                taskIDs[taskCount - 1] = null;
                taskStatuses[taskCount - 1] = null;
                taskCount--;
                return "Task deleted successfully.";
            }
        }
        return "Task not found.";
    }

    // Display report of all tasks
    public String displayAllTasks(String[] names,String[] descriptions, String[] developers, int[] durations, String[] ids, String[] statuses) {
        StringBuilder report = new StringBuilder();
        for (int i = 0; i < taskCount; i++) {
            report.append("Task Name: ").append(names[i])
                    .append("\nTask Number: ").append(i + 1)
                    .append("\nTask Description: ").append(descriptions[i])
                    .append("\nDeveloper: ").append(developers[i])
                    .append("\nDuration: ").append(durations[i])
                    .append("\nTask ID: ").append(ids[i])
                    .append("\nStatus: ").append(statuses[i]).append("\n\n");
        }
        return report.toString();
    }
//*************************************************Getters**********************************************************************************************
    public String[] getTaskNames() {
        return taskNames;
    }

    public int[] getTaskNumbers() {
        return taskNumbers;
    }

    public String[] getTaskDescriptions() {
        return taskDescriptions;
    }

    public String[] getDeveloperDetails() {
        return developerDetails;
    }

    public int[] getTaskDurations() {
        return taskDurations;
    }

    public String[] getTaskIDs() {
        return taskIDs;
    }

    public String[] getTaskStatuses() {
        return taskStatuses;
    }
}

