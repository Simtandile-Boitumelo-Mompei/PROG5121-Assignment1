
package com.mycompany.login;

import java.util.*;
import javax.swing.Icon;
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
            
            //Declare task variables
            String taskName;
            String taskDescription;
            String developerDetails;
            String taskStatus ;
            int taskDuration;
            
            
            while(user.loginUser(username, password)){
                //Display menu options
                String selection = JOptionPane.showInputDialog(null,"1. Add Tasks\n2.Show Report\n3.Quit","Select an option: ", 0);
                
                switch(selection){
                    case "1" : 
                        int no_Tasks = Integer.parseInt(JOptionPane.showInputDialog("Enter the number of tasks: "));
                       Task [] tasks = new Task[no_Tasks];
                       
                        for(int i = 0; i < no_Tasks;i++){
                            taskName = JOptionPane.showInputDialog("Enter task name: ");
                            
                            taskDescription = JOptionPane.showInputDialog("Enter task description (must be 50 characters): ");
                            developerDetails = JOptionPane.showInputDialog("Enter developer details(First Name and Last Name): ");
                            taskDuration = Integer.parseInt(JOptionPane.showInputDialog("Enter total hours for task: "));
                            taskStatus = JOptionPane.showInputDialog(null,"Select Task Status\n1. To Do\n2.Doing\n3.Done","Select Task Status: ", 0);
                         
                            tasks[i] = new Task(taskName,i,taskDescription,developerDetails,taskDuration,taskStatus);
                            taskDuration += tasks[i].returnTotalHours();
                            
                            JOptionPane.showMessageDialog(null, "Task successfully captured\n"+ tasks[i].printTaskDetails() + taskDuration);
                            
                        }
                    break;
                    case "2" : JOptionPane.showMessageDialog(null, "Coming Soon");
                    break;
                    case "3" : JOptionPane.showMessageDialog(null, "Closing program");
                    break;
                    default : JOptionPane.showMessageDialog(null, "Entered invalid input");
                }
                
            }
        }
    }
}
