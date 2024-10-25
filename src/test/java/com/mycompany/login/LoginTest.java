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
   // private String username = "kyl_1";
    //private String password = "Ch&&sec@ke99!";
   
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
        String password = "";
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
        String reg_password = "Ch";
        Login instance = new Login();
        String expResult = "";
        String result = instance.registerUser(reg_username, reg_password);
        assertEquals(expResult, result);
        
    }

    @Test
    public void testInvalid_RegisterUser() {
        System.out.println("registerUser");
        String reg_username = "Kyle!!!!!";
        String reg_password = "password";
        Login instance = new Login();
        String expResult = "";
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
        String password = "";
        Login instance = new Login();
        Boolean expResult = null;
        Boolean result = instance.loginUser(username, password);
        assertEquals(expResult, result);
    }

     @Test
    public void testInvalid_LoginUser() {
        System.out.println("loginUser");
        String username = "Kyle!!!!!!";
        String password = "password";
        Login instance = new Login();
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
        String username = "";
        String password = "";
        String firstName = "";
        String lastName = "";
        Login instance = new Login();
        String expResult = "";
        String result = instance.returnLoginStatus(username, password, firstName, lastName);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
