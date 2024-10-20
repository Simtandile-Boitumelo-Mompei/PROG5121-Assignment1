
package com.mycompany.login;

import java.util.*;
import javax.swing.JOptionPane;

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
        Login user = new Login(username,password,firstName,lastName);
        
        //Call registerUser method
        System.out.println(user.registerUser());
        
        //Initialise new scanner object to store login details
        Scanner userLogin = new Scanner(System.in);
        
        //If statement to check correct registration before user is allowed to login
        if(user.checkUserName() && user.checkPasswordComplexity()){
            //User login process, Prompt user
            System.out.println("==================Login to your profile===================");
            System.out.print("Enter username: ");
            login_Username = userLogin.next();

            System.out.print("Enter password: ");
            login_Password = userLogin.next();
            
            //Call method that returns user login status
            System.out.println(user.returnLoginStatus(login_Username,login_Password));
        }
        
        if(user.loginUser(username,password)){
            JOptionPane.showMessageDialog(null, "Welcome to EasyKanban");
            
            while(user.loginUser(username, password)){
                String [] options = {"1 ","2","3"};
               
                int selection = (int) JOptionPane.showInputDialog(null, "Select an option: \n 1. Add Tasks\n 2. Show Report\n 3. Quit", "Menu"
                ,JOptionPane.INFORMATION_MESSAGE,null,options, options[0]);
                
                switch(selection){
                    case 1 -> JOptionPane.showMessageDialog(null, "We adding tasks");
                    case 2 -> JOptionPane.showMessageDialog(null, "Coming Soon");
                    case 3 -> JOptionPane.showMessageDialog(null, "Closing program");
                    default -> JOptionPane.showMessageDialog(null, "Entered invalid input");
                }
                
            }
        }
    }
}
