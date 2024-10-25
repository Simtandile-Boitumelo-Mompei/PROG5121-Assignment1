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

        if (user.loginUser(username, password)) {
            JOptionPane.showMessageDialog(dialog, "Welcome to EasyKanban");

            //While user is logged in
            while (user.loginUser(username, password)) {

                //Display menu options
                int selection = Integer.parseInt(JOptionPane.showInputDialog(null, "1. Add Tasks\n2.Show Report\n3.Quit", "Select an option: ", JOptionPane.PLAIN_MESSAGE));

                switch (selection) {
                    case 1:
                        //Array for taskStatus options
                        String[] optionsToChoose = {"To Do", "Doing", "Done"};

                        //Prompt user to enter the number of tasks
                        int no_Tasks = Integer.parseInt(JOptionPane.showInputDialog("Enter the number of tasks: "));
                        Task newTask = new Task(no_Tasks);

                        //For loop for adding task details
                        for (int i = 0; i < no_Tasks; i++) {

                            String taskName = JOptionPane.showInputDialog("Enter task name: ");

                            while (true) {
                                String description = JOptionPane.showInputDialog("Enter task description (must be 50 characters): ");
                                if (newTask.checkTaskDescription(description)) {
                                    JOptionPane.showMessageDialog(null, "Task successfully captured.");
                                    break;
                                } else {
                                    JOptionPane.showMessageDialog(null, "Task not successfully captured.");
                                }
                            }

                            //
                            String developerDetails = JOptionPane.showInputDialog("Enter developer details(First Name and Last Name): ");

                            //
                            int taskDuration = Integer.parseInt(JOptionPane.showInputDialog("Enter total hours for task: "));
                            totalHours += newTask.returnTotalHours(taskDuration);

                            String taskStatus = (String) JOptionPane.showInputDialog(null, "Choose task status: ", "Select task status",
                                    JOptionPane.QUESTION_MESSAGE, null, optionsToChoose, optionsToChoose[2]);

                            newTask.addtask(i, taskName, taskStatus, developerDetails, taskDuration, taskStatus);

                            JOptionPane.showMessageDialog(null, "Task successfully captured\n" + newTask.printTaskDetails(i));
                        }
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
