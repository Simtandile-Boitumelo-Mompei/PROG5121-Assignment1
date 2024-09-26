
package com.mycompany.login;

import java.util.*;

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
        
        user.registerUser();
        
        //Initialise new scanner object to store login details
        Scanner userLogin = new Scanner(System.in);
        
        //User login process, Prompt user
        System.out.println("=============Login to your profile===================");
        System.out.print("Enter username: ");
        login_Username = userLogin.next();
       
        System.out.print("Enter password: ");
        login_Password = userLogin.next();
        
        System.out.println(user.loginUser(login_Username, login_Password));
        
    }
}
