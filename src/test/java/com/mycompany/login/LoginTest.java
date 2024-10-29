/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.login;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author RC_Student_lab
 */
public class LoginTest {
 
    /**
     * Test of checkUserName method, of class Login.
     */
    @Test
    public void testValid_CheckUserName() {
        System.out.println("checkUserName");
        String name = "kyl_1";
        Login instance = new Login();
        boolean expResult = true;
        boolean result = instance.checkUserName(name);
        assertEquals(expResult, result);
       
    }
    
    @Test
    public void testInvalid_CheckUserName() {
        System.out.println("checkUserName");
        String name = "Kyle!!!!";
        Login instance = new Login();
        boolean expResult = false;
        boolean result = instance.checkUserName(name);
        assertEquals(expResult, result);
       
    }
    /**
     * Test of checkPasswordComplexity method, of class Login.
     */
    @Test
    public void testValid_CheckPasswordComplexity() {
        System.out.println("checkPasswordComplexity");
        String password = "Ch&&sec@ke99!";
        Login instance = new Login();
        boolean expResult = true;
        boolean result = instance.checkPasswordComplexity(password);
        assertEquals(expResult, result);
    }

    @Test
    public void testInvalid_CheckPasswordComplexity() {
        System.out.println("checkPasswordComplexity");
        String password = "password";
        Login instance = new Login();
        boolean expResult = false;
        boolean result = instance.checkPasswordComplexity(password);
        assertEquals(expResult, result);
    }

    /**
     * Test of registerUser method, of class Login.
     */
    @Test
    public void testValid_RegisterUser() {
        System.out.println("registerUser");
        String reg_username = "kyl_1";
        String reg_password = "Ch&&sec@ke99!";
        Login instance = new Login();
        String expResult = "Password captured successfully ";
        String result = instance.registerUser(reg_username, reg_password);
        assertEquals(expResult, result);
        
    }
  /**
     * Test of registerUser method, of class Login.
     */
    @Test
    public void testInvalid_Username_RegisterUser() {
        System.out.println("registerUser");
        String reg_username = "Kyle!!!!!";
        String reg_password = "Ch&&sec@ke99!";
        Login instance = new Login();
        String expResult = "Username is not correctly formatted"
                    + ", please ensure that your username contains an underscore"
                    + " and is no more than 5 characters in length";
        String result = instance.registerUser(reg_username, reg_password);
        assertEquals(expResult, result);
        
    }
    @Test
    public void testInvalid_RegisterUser() {
        System.out.println("registerUser");
        String reg_username = "kyl_1";
        String reg_password = "password";
        Login instance = new Login();
        String expResult = "Password is not correctly formatted, please ensure"
                    + " that the password at least 8 letters, a capital letter"
                    + " a number and a special character";
        String result = instance.registerUser(reg_username, reg_password);
        assertEquals(expResult, result);
        
    }
    /**
     * Test of loginUser method, of class Login.
     */
    @Test
    public void testValid_LoginUser() {
        System.out.println("loginUser");
        String username = "kyl_1";
        String password = "Ch&&sec@ke99!";
        Login instance = new Login();
        instance.setUsername("kyl_1");
        instance.setPassword("Ch&&sec@ke99!");
        Boolean expResult = true;
        Boolean result = instance.loginUser(username, password);
        assertEquals(expResult, result);
    }

     @Test
    public void testInvalid_LoginUser() {
        System.out.println("loginUser");
        String username = "Kyle!!!!!!";
        String password = "password";
        Login instance = new Login();
        instance.setUsername("kyl_1");
        instance.setPassword("Ch&&sec@ke99!");
        Boolean expResult = false;
        Boolean result = instance.loginUser(username, password);
        assertEquals(expResult, result);
    }

    /**
     * Test of returnLoginStatus method, of class Login.
     */
    @Test
    public void testReturnLoginStatus() {
        System.out.println("returnLoginStatus");
        String username = "kyl_1";
        String password = "Ch&&sec@ke99!";
        String firstName = "Kyle";
        String lastName = "Williams";
        Login instance = new Login();
        instance.setUsername("kyl_1");
        instance.setPassword("Ch&&sec@ke99!");
        String expResult = "Welcome " + firstName + ", " + lastName + " it's great to see you.";
        String result = instance.returnLoginStatus(username, password, firstName, lastName);
        assertEquals(expResult, result);
        
    }
    
     @Test
    public void testInvalid_ReturnLoginStatus() {
        System.out.println("returnLoginStatus");
        String username = "kyl_1";
        String password = "Ch&&sec@ke99!";
        String firstName = "Kyle";
        String lastName = "Williams";
        Login instance = new Login();
        instance.setUsername("Kyle!!!");
        instance.setPassword("Ch&&sec@ke99!");
        String expResult = "Username or password is incorrect, please try again!";
        String result = instance.returnLoginStatus(username, password, firstName, lastName);
        assertEquals(expResult, result);
        
    }
    
}
