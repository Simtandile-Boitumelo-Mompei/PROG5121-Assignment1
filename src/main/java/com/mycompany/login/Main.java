
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
        String loginUsername = "";
        String loginPassword = "";

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
        Login user1 = new Login(username,password,firstName,lastName);
        
        user1.registerUser();
        
    }
}
