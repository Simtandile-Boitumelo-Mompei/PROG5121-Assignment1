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

        //Declare variables that will be compared against stored variables
        String login_Username;
        String login_Password;

        //Initialise Scanner object for registering user
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

        //Initialise Login object
        Login user = new Login();

        //Call registerUser method
        System.out.println(user.registerUser(username, password));

        //Initialise new scanner object to store login details
        Scanner userLogin = new Scanner(System.in);

        //If statement to check correct registration before user is allowed to login
        if (user.checkUserName(username) && user.checkPasswordComplexity(password)) {
            //User login process, Prompt user
            System.out.println("==================Login to your profile===================");
            System.out.print("Enter username: ");
            login_Username = userLogin.next();

            System.out.print("Enter password: ");
            login_Password = userLogin.next();

            //Call method that returns user login status
            System.out.println(user.returnLoginStatus(login_Username, login_Password, firstName, lastName));
        }

        final JDialog dialog = new JDialog();
        dialog.setAlwaysOnTop(true);

        int totalHours = 0;
        //Declare Task Class object
        Task newTask = new Task();

        //If statement to check if user is logged in
        if (user.loginUser(username, password)) {
            //Display welcome message
            JOptionPane.showMessageDialog(dialog, "Welcome to EasyKanban");

            //While user is logged in
            while (user.loginUser(username, password)) {

                //Display menu options
                int selection = Integer.parseInt(JOptionPane.showInputDialog(null, "1. Add Tasks\n2.Show Report\n3.Quit", "Select an option: ", JOptionPane.PLAIN_MESSAGE));

                //Switch statement for menu options
                switch (selection) {
                    case 1:
                        //Array to store taskStatus options
                        String[] optionsToChoose = {"To Do", "Doing", "Done"};

                        //Prompt user to enter the number of tasks
                        int no_Tasks = Integer.parseInt(JOptionPane.showInputDialog("Enter the number of tasks: "));
                        newTask.initializeTasks(no_Tasks); // Initialize task arrays

                        // Array to hold each task’s duration
                        int[] durations = new int[no_Tasks];

                        //For loop to promt user to add task details using JOptionPane
                        for (int i = 0; i < no_Tasks; i++) {
                            //Prompt user to enter task name
                            String taskName = JOptionPane.showInputDialog("Enter task name: ");
                            String taskDescription;
                            while (true) {
                                taskDescription = JOptionPane.showInputDialog("Enter task description (must be 50 characters): ");
                                //Check if task description meets required length by calling checkTaskDescription method
                                if (newTask.checkTaskDescription(taskDescription)) {
                                    JOptionPane.showMessageDialog(null, "Task successfully captured.");
                                    break;
                                } else {
                                    JOptionPane.showMessageDialog(null, "Task not successfully captured.");
                                }
                            }

                            //Prompt user to enter developer details
                            String developerDetails = JOptionPane.showInputDialog("Enter developer details(First Name and Last Name): ");

                            //Prompt user to enter task duration in hours and add it to existing totalHours variable
                            int taskDuration = Integer.parseInt(JOptionPane.showInputDialog("Enter total hours for task: "));
                            durations[i] = taskDuration;  // Store each task’s duration in the array
                            
                            //JOption menu display option
                            String taskStatus = (String) JOptionPane.showInputDialog(null, "Choose task status: ", "Select task status",
                                    JOptionPane.QUESTION_MESSAGE, null, optionsToChoose, optionsToChoose[2]);

                            //Call addtask method from Task Class, using for loop increment as taskNumber
                            newTask.addtask(i, taskName, taskStatus, developerDetails, taskDuration, taskStatus);

                            //Message Dialog to display task details
                            JOptionPane.showMessageDialog(null, "Task successfully captured\n" + newTask.printTaskDetails(i));
                        }
                         // Call returnTotalHours with the array of durations and display the result
                        totalHours = newTask.returnTotalHours(durations);
                        JOptionPane.showMessageDialog(null, "Total duration for all tasks:\n" + totalHours);
                        break;
                    case 2:
                        JOptionPane.showMessageDialog(null, "Coming Soon");
                        break;
                    case 3:
                        JOptionPane.showMessageDialog(null, "Closing program");
                        System.exit(0);
                        break;
                    default:
                        JOptionPane.showMessageDialog(null, "Entered invalid input - enter values available");
                }
                dialog.dispose();
            }
        }
    }
}
