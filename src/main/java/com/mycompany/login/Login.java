
package com.mycompany.login;

/**
 * @author Simthandile Mompei
 */
public class Login {
    private String username;
    private String password;
    private String firstName;
    private String lastName;

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

    public boolean checkUserName(){

        return username.contains("_") && username.length()<=5;
       // return username.contains("_") && username.length()<=5;
    }

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

        if(upperCaseLetter == 1 && specialCharacter == 1 && digit == 1){
            return true;
        }else{
            return false;
        }
    }

}

