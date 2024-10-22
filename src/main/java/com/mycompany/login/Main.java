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
        System.out.println(user.registerUser(username,password));

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
            System.out.println(user.returnLoginStatus(login_Username, login_Password,firstName,lastName));
        }

        final JDialog dialog = new JDialog();
        dialog.setAlwaysOnTop(true);

        Task newTask = new Task();
        if (user.loginUser(username, password)) {
            JOptionPane.showMessageDialog(dialog, "Welcome to EasyKanban");

            
    
            //While user is logged in
            while (user.loginUser(username, password)) {

                //Display menu options
                int selection = Integer.parseInt(JOptionPane.showInputDialog(null, "1. Add Tasks\n2.Show Report\n3.Quit", "Select an option: ",JOptionPane.PLAIN_MESSAGE ));

                switch (selection) {
                    case 1:
                        newTask.addtask();
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

            }
        }
    }
}
