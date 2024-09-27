
package com.mycompany.login;


import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Simthandile Mompei
 */
public class LoginTest {
    
    /**
     * Test of checkUserName method, of class Login.
     */
    @Test
    public void testInvalidCheckUserName() {
        System.out.println("checkUserName");
        Login instance = new Login("Kyle!!!","password","Kyle","Byers");
        boolean expResult = false;
        boolean result = instance.checkUserName();
        assertEquals(expResult, result);    
    }
    
    @Test
    public void testValidCheckUserName() {
        System.out.println("checkUserName");
        Login instance = new Login("kyl_1","Ch&&sec@ke99!","Kyle","Byers");
        boolean expResult = true;
        boolean result = instance.checkUserName();
        assertEquals(expResult, result);    
    }
    /**
     * Test of checkPasswordComplexity method, of class Login.
     */
    @Test
    public void testInvalidCheckPasswordComplexity() {
        System.out.println("checkPasswordComplexity");
        Login instance = new Login("Kyle!!!","password","Kyle","Byers");
        boolean expResult = false;
        boolean result = instance.checkPasswordComplexity();
        assertEquals(expResult, result);  
    }
    
    @Test
    public void testValidCheckPasswordComplexity() {
        System.out.println("checkPasswordComplexity");
        Login instance = new Login("kyl_1","Ch&&sec@ke99!","Kyle","Byers");
        boolean expResult = true;
        boolean result = instance.checkPasswordComplexity();
        assertEquals(expResult, result);  
    }

    /**
     * Test of registerUser method, of class Login.
     */
    @Test
    public void testRegisterUser_WrongUsername() {
        System.out.println("registerUser");
        Login instance = new Login("username","Ch&&sec@ke99!","Kyle","Byers");
        String expResult = "Username is not correctly formatted"+
                   ", please ensure that your username contains an underscore"+
                   " and is no more than 5 characters in length";
        String result = instance.registerUser();
        assertEquals(expResult, result);
        
    }
    @Test
    public void testRegisterUser_WrongPassword() {
        System.out.println("registerUser");
        Login instance = new Login("kyl_1","password","Kyle","Byers");
        String expResult = "Password is not correctly formatted, please ensure"+
                   " that the password at least 8 letters, a capital letter"+
                   " a number and a special character";
        String result = instance.registerUser();
        assertEquals(expResult, result);
        
    }
    
    @Test
    public void testValidRegisterUser_CorrectPassword() {
        System.out.println("registerUser");
        Login instance = new Login("kyl_1","Ch&&sec@ke99!","Kyle","Byers");
        String expResult = "Password captured successfully ";
        String result = instance.registerUser();
        assertEquals(expResult, result);
        
    }
    /**
     * Test of loginUser method, of class Login.
     */
    @Test
    public void testInvalidLoginUser() {
        System.out.println("loginUser");
        String username = "kyle!!!";
        String password = "password";
        Login instance = new Login("kyl_1","Ch&&sec@ke99!","Kyle","Byers");
        Boolean expResult = false;
        Boolean result = instance.loginUser(username, password);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testValidLoginUser() {
        System.out.println("loginUser");
        String username = "kyl_1";
        String password = "Ch&&sec@ke99!";
        Login instance = new Login("kyl_1","Ch&&sec@ke99!","Kyle","Byers");
        Boolean expResult = true;
        Boolean result = instance.loginUser(username, password);
        assertEquals(expResult, result);
    }

    /**
     * Test of returnLoginStatus method, of class Login.
     */
    @Test
    public void testInvalidReturnLoginStatus() {
        System.out.println("returnLoginStatus");
        String username = "kyle!!!!";
        String password = "password";
        Login instance = new Login("kyl_1","Ch&&sec@ke99!","Kyle","Byers");
        String expResult = "Username or password is incorrect, please try again!";
        String result = instance.returnLoginStatus(username, password);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testValidReturnLoginStatus_Valid() {
        System.out.println("returnLoginStatus");
        String username = "kyl_1";
        String password = "Ch&&sec@ke99!";
        Login instance = new Login("kyl_1","Ch&&sec@ke99!","Kyle","Byers");
        String expResult = "Welcome "+ instance.getFirstName()+", "+instance.getLastName()+" it's great to see you.";
        String result = instance.returnLoginStatus(username, password);
        assertEquals(expResult, result);
    }
    
}
