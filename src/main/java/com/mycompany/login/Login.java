
package com.mycompany.login;

/**
 * @author Simthandile Mompei
 */
public class Login {
    private String username;
    private String password;
    private String firstName;
    private String lastName;

    //Login class constructor
    public Login(String username, String password, String firstname, String lastname){
        this.username = username;
        this.password = password;
        this.firstName = firstname;
        this.lastName = lastname;
        
    }
    
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    //Method that checks username length contains an underscore and length is 5 characters
    public boolean checkUserName(){
        return username.contains("_") && username.length()<=5;
    }

    //Method to check the complexity of user's password
    public boolean checkPasswordComplexity(){
        int length = password.length();
        int digit = 0;
        int upperCaseLetter = 0;
        int specialCharacter = 0;
        char ch;
        int count = 0;

        if(length < 8){

            return false;
        }
        else {
            while (count < length) {
                ch = password.charAt(count);
                if (Character.isUpperCase(ch)) {
                    upperCaseLetter = 1;
                } else if (Character.isDigit(ch)) {
                    digit = 1;
                } else if (!Character.isAlphabetic(ch) && !Character.isDigit(ch)) {
                    specialCharacter = 1;
                }
                count++;

            }
        }

        return upperCaseLetter == 1 && specialCharacter == 1 && digit == 1;
    }
    
    //Method that checks if username and password are correctly formatted before registering a user
    public String registerUser(){   
      if(!checkUserName()){
          return "Username is not correctly formatted"+
                   ", please ensure that your username contains an underscore"+
                   " and is no more than 5 characters in length";     
      }else{
          System.out.println("Username captured successfully");
      }
      
      if(checkPasswordComplexity()){
          return "Password captured successfully ";
      }else{ 
         return "Password is not correctly formatted, please ensure"+
                   " that the password at least 8 letters, a capital letter"+
                   " a number and a special character";
      }
    }
    
    //Method to compare username and password to stored variables
    public Boolean loginUser(String username, String password){
        return this.getUsername().equals(username) && this.getPassword().equals(password);
    }
    
    //Method to check if user login was successful
     public String  returnLoginStatus(String username, String password){
        if(loginUser(username,password)){
            return "Welcome "+ this.getFirstName()+", "+ this.getLastName()+" it's great to see you.";
        }
        else{
            return "Username or password is incorrect, please try again!";
        }
    }
}

