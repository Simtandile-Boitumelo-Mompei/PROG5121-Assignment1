package com.mycompany.login;

import java.util.*;
import javax.swing.*;

public class Main {

    public static void main(String[] args) {

        //Declare variables that will be stored for the Login class
        String username;
        String password;
        String firstName;
        String lastName;

        // Variables for user login
        String loginUsername;
        String loginPassword;

        // Scanner object for console input during registration
        Scanner userInput = new Scanner(System.in);

        //User registration process
        System.out.println("************************Register your profile********************************");
        System.out.print("Enter your first name: ");
        firstName = userInput.next();

        System.out.print("Enter your last name: ");
        lastName = userInput.next();

        System.out.print("Enter username: ");
        username = userInput.next();

        System.out.print("Enter password: ");
        password = userInput.next();

        // Create a Login object for user authentication
        Login user = new Login();

        // Register the user and display the result
        System.out.println(user.registerUser(username, password, firstName, lastName));

        // Scanner for console input during login
        Scanner userLogin = new Scanner(System.in);

        // Validate user registration details before allowing login
        if (user.checkUserName(username) && user.checkPasswordComplexity(password)) {
            //User login process, Prompt user
            System.out.println("==================Login to your profile===================");
            System.out.print("Enter username: ");
            loginUsername = userLogin.next();

            System.out.print("Enter password: ");
            loginPassword = userLogin.next();

            // Display login status
            System.out.println(user.returnLoginStatus(loginUsername, loginPassword, firstName, lastName));
        }

        // Task management system setup
        Task taskManager = new Task();
        final JDialog dialog = new JDialog();
        dialog.setAlwaysOnTop(true);

        //Display welcome message
        JOptionPane.showMessageDialog(dialog, "Welcome to EasyKanban");

        int totalTaskDuration; // Tracks the total duration for all tasks

        // Check if the user is successfully logged in
        if (user.loginUser(username, password)) {

            //While user is logged in
            while (user.loginUser(username, password)) {
                // Display menu options
                String menu = """
                            1. Add Task
                            2. Show report
                            3. Display tasks with status Done
                            4. Display task with longest duration
                            5. Search task by name
                            6. Search tasks by developer
                            7. Delete task by name
                            8. Quit
                            """;
                int userSelection;
                try {
                    userSelection = Integer.parseInt(JOptionPane.showInputDialog(null, menu, "Menu Options", JOptionPane.PLAIN_MESSAGE));
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(dialog, "Invalid input. Please enter a number.");
                    continue;// Restart the loop for invalid input
                }

                //Switch statement for menu options
                switch (userSelection) {
                    case 1 -> {

                        //Prompt user to enter the number of tasks
                        int numberOfTasks;
                        try {
                            numberOfTasks = Integer.parseInt(JOptionPane.showInputDialog("Enter the number of tasks:"));
                        } catch (NumberFormatException e) {
                            JOptionPane.showMessageDialog(dialog, "Invalid number. Please try again.");
                            continue;
                        }

                        taskManager.initializeTasks(numberOfTasks); // Initialize task arrays
                        // Store task durations
                        int[] taskDurations = new int[numberOfTasks];

                        for (int i = 0; i < numberOfTasks; i++) {
                            //Prompt user to enter task name
                            String taskName = JOptionPane.showInputDialog("Enter task name: ");

                            // Validate task description length
                            String taskDescription;
                            while (true) {
                                taskDescription = JOptionPane.showInputDialog("Enter task description (must be 50 characters): ");
                                if (taskManager.checkTaskDescription(taskDescription)) {
                                    JOptionPane.showMessageDialog(null, "Task description successfully captured.");
                                    break;
                                } else {
                                    JOptionPane.showMessageDialog(null, "Please enter decription with less than 50 characters.");
                                }
                            }

                            //Prompt user to enter developer details
                            String developerDetails = JOptionPane.showInputDialog("Enter developer details(First Name and Last Name): ");

                            // Get task duration and validate input
                            int taskDuration;
                            try {
                                taskDuration = Integer.parseInt(JOptionPane.showInputDialog("Enter task duration (in hours):"));
                                taskDurations[i] = taskDuration; // Store each task's duration
                            } catch (NumberFormatException e) {
                                JOptionPane.showMessageDialog(dialog, "Invalid duration. Please try again.");
                                continue;
                            }

                            // Prompt for task status
                            String[] optionsToChoose = {"To Do", "Doing", "Done"};
                            String taskStatus = (String) JOptionPane.showInputDialog(null, "Choose task status: ", "Select task status",
                                    JOptionPane.QUESTION_MESSAGE, null, optionsToChoose, optionsToChoose[2]);

                            // Add the task to the task manager
                            taskManager.addTask(i,taskName, taskStatus, developerDetails, taskDuration, taskStatus);

                            // Display task details
                            JOptionPane.showMessageDialog(null, "Task successfully captured\n" + taskManager.printTaskDetails(i));
                        }
                        // Display the total duration of all tasks
                        totalTaskDuration = taskManager.returnTotalHours(taskDurations);
                        JOptionPane.showMessageDialog(null, "Total duration for all tasks:\n" + totalTaskDuration);
                    }
                    case 2 ->
                        JOptionPane.showMessageDialog(null, taskManager.displayAllTasks(
                                taskManager.getTaskNames(),
                                taskManager.getTaskDescriptions(),
                                taskManager.getDeveloperDetails(),
                                taskManager.getTaskDurations(),
                                taskManager.getTaskIDs(),
                                taskManager.getTaskStatuses()));
                    case 3 ->
                        JOptionPane.showMessageDialog(null, taskManager.displayTasksWithStatusDone(
                                taskManager.getTaskStatuses(),
                                taskManager.getDeveloperDetails(),
                                taskManager.getTaskNames(),
                                taskManager.getTaskDurations()));
                    case 4 ->
                        JOptionPane.showMessageDialog(null, taskManager.displayTaskWithLongestDuration(
                                taskManager.getDeveloperDetails(),
                                taskManager.getTaskDurations()));
                    case 5 -> {
                        // Search for a task by name
                        String taskToSearch = JOptionPane.showInputDialog("Enter task name to search:");
                        JOptionPane.showMessageDialog(null, taskManager.searchTaskByName(
                                taskToSearch,
                                taskManager.getTaskNames(),
                                taskManager.getDeveloperDetails(),
                                taskManager.getTaskStatuses()));
                    }
                    case 6 -> {
                        // Search for tasks by developer
                        String developerName = JOptionPane.showInputDialog("Enter developer name to search:");
                        JOptionPane.showMessageDialog(null, taskManager.searchTasksByDeveloper(
                                developerName,
                                taskManager.getTaskNames(),
                                taskManager.getTaskStatuses()));
                    }
                    case 7 -> {
                        // Delete a task by name
                        String taskToDelete = JOptionPane.showInputDialog("Enter task name to delete:");
                        JOptionPane.showMessageDialog(null, taskManager.deleteTaskByName(
                                taskToDelete,
                                taskManager.getTaskNames()));
                    }
                    case 8 -> {
                        // Exit the program
                        JOptionPane.showMessageDialog(dialog, "Goodbye!");
                        System.exit(0);
                    }
                    default ->
                        JOptionPane.showMessageDialog(null, "Entered invalid input - enter values available");
                }
                dialog.dispose();
            }
        }
    }
}
