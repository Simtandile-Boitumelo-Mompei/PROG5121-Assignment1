/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.login;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author RC_Student_lab
 */
public class TaskTest {
    
    private Task taskManager;
    
    @BeforeEach
    public void setUp() {
         // Initialize Task manager with a specified number of tasks
        taskManager = new Task();
        taskManager.initializeTasks(3); // Example for 3 tasks
    }
    
    /**
     * Test of add task method, of class Task.
     */
    @Test
    public void testAddtask() {
        System.out.println("addtask");
        int index = 0;
        String taskName = "Login";
        String taskDescription = "Create login to authenticate user";
        String developerDetails = "Robyn Harrison";
        int taskDuration = 8;
        String taskStatus = "To do";
        
        //Add sample task
        taskManager.addtask(index, taskName, taskDescription, developerDetails, taskDuration, taskStatus);
        
        //Check if the task details were set correctly
        // Use getter methods to verify task details
        assertEquals(taskName, taskManager.getTaskName(index));
        assertEquals(taskDescription, taskManager.getTaskDescription(index));
        assertEquals(developerDetails, taskManager.getDeveloperDetails(index));
        assertEquals(taskDuration, taskManager.getTaskDuration(index));
        assertEquals(taskStatus, taskManager.getTaskStatus(index));
        assertEquals("LO:0:SON", taskManager.getTaskID(index));
    
    }

    /**
     * Test of checkTaskDescription method, of class Task.
     */
    @Test
    public void testCheckTaskDescription_Success() {
        // Test with a valid description (<= 50 characters)
        System.out.println("checkTaskDescription");
        String description = "Create login to authenticate user";
        boolean expResult = true;
        boolean result = taskManager.checkTaskDescription(description);
        assertEquals(expResult, result);
    }

    @Test
    public void testCheckTaskDescription_Unsuccessful() {
         // Test with an invalid description (> 50 characters)
        System.out.println("checkTaskDescription");
        String description = "Create login to authenticate user using password and username";
        boolean expResult = false;
        boolean result = taskManager.checkTaskDescription(description);
        assertEquals(expResult, result);
    }
    /**
     * Test of createTaskID method, of class Task.
     */
    @Test
    public void testCreateTaskID() {
         // Test task ID generation
        System.out.println("createTaskID");
        String taskName = "Login";
        String developerdetails = "Robyn Harrison";
        int taskNumber = 0;
        String expResult = "LO:0:SON";
        String result = taskManager.createTaskID(taskName, developerdetails, taskNumber);
        assertEquals(expResult, result);
    }

    /**
     * Test of printTaskDetails method, of class Task.
     */
    @Test
    public void testPrintTaskDetails() {
        System.out.println("printTaskDetails");
        int index = 0;
        taskManager.addtask(index,"Login","Create user authentication","Robyn Harrison",8,"To Do");
        String expResult = """
                           Task Name: Login
                           Task Number: 0
                           Task Description: Create user authentication
                           Developer Details: Robyn Harrison
                           Task Duration: 8
                           TaskID: LO:0:SON
                           Task Status: To Do
                           """;
        String result = taskManager.printTaskDetails(index);
        assertEquals(expResult, result);
    }

    /**
     * Test of returnTotalHours method, of class Task.
     */
    @Test
    public void testReturnTotalHours() {
        System.out.println("returnTotalHours");
        // Test with multiple task durations
        int[] durations = {10,12,55,11,1};  
        int expectedTotal = 89;
        assertEquals(expectedTotal, taskManager.returnTotalHours(durations));
    
    }
    
}