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
public class TaskTest {

    private Task taskManager = new Task();

    /**
     * Test of add task method, of class Task.
     */
    @Test
    public void testAddtask() {
        System.out.println("addtask");
        taskManager.initializeTasks(3);
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
        assertEquals(expResult, result, "Task successfully captured");
    }

    @Test
    public void testCheckTaskDescription_Unsuccessful() {
        // Test with an invalid description (> 50 characters)
        System.out.println("checkTaskDescription");
        String description = "Create login to authenticate user using password and username";
        boolean expResult = false;
        boolean result = taskManager.checkTaskDescription(description);
        assertEquals(expResult, result, "Please enter a task description of less than 50 characters");
    }

    /**
     * Test of createTaskID method, of class Task.
     */
    @Test
    public void testCreateTaskID() {
        // Test task ID generation
        System.out.println("createTaskID");
        String taskName = "Add Feature";
        String developerdetails = "Robyn Byron";
        int taskNumber = 1;
        String expResult = "AD:1:RON";
        String result = taskManager.createTaskID(taskName, developerdetails, taskNumber);
        assertEquals(expResult, result);

        //Additional Tests
        assertEquals("CR:0:KEN", taskManager.createTaskID("Create Report", "Ben Laken", 0));
        //String [] taskNames = {"Create report", "Create something "};
    }

    /**
     * Test of returnTotalHours method, of class Task.
     */
    @Test
    public void testReturnTotalHours() {
        System.out.println("returnTotalHours");
        // Test with multiple task durations
        int[] durations = {10, 12, 55, 11, 1};
        int expectedTotal = 89;
        assertEquals(expectedTotal, taskManager.returnTotalHours(durations));

    }

    @Test
    public void testReturnTotalHours_TwoTasks() {
        System.out.println("returnTotalHours");
        taskManager.initializeTasks(2);
        // Add multiple tasks with known durations
        taskManager.addtask(0, "Login Feature", "Create Login to authenticate user", "Robyn Harrison", 8, "To Do");
        taskManager.addtask(1, "Add Task Feature", "Create Add Task feature", "Mike Smith", 10, "Doing");
        int[] durations = {taskManager.getTaskDuration(0), taskManager.getTaskDuration(1)};
        int expectedTotal = 18;
        assertEquals(expectedTotal, taskManager.returnTotalHours(durations));

    }
//*******************************************PART 3 Testing********************************************************************************************
    @Test
    public void testArraysPopulatedCorrectly() {
        taskManager.initializeTasks(4);
        // Populate tasks using sample data
        taskManager.addtask(0, "Create Login", "Authentication feature", "Mike Smith", 5, "To Do");
        taskManager.addtask(1, "Create Add Features", "Feature implementation", "Edward Harrison", 8, "Doing");
        taskManager.addtask(2, "Create Reports", "Generate reports", "Samantha Paulson", 2, "Done");
        taskManager.addtask(3, "Add Arrays", "Implement array handling", "Glenda Oberholzer", 11, "To Do");

        // Validate developer array
        String[] expectedDevelopers = {"Mike Smith", "Edward Harrison", "Samantha Paulson", "Glenda Oberholzer"};
        for (int i = 0; i < expectedDevelopers.length; i++) {
            assertEquals(expectedDevelopers[i], taskManager.getDeveloperDetails(i));
        }
    }

    /**
     * Test of displayTasksWithStatusDone method, of class Task.
     */
     @Test
    public void testDisplayTaskWithLongestDuration() {
        taskManager.initializeTasks(4);
        // Populate tasks
        taskManager.addtask(0, "Create Login", "Authentication feature", "Mike Smith", 5, "To Do");
        taskManager.addtask(1, "Create Add Features", "Feature implementation", "Edward Harrison", 8, "Doing");
        taskManager.addtask(2, "Create Reports", "Generate reports", "Samantha Paulson", 2, "Done");
        taskManager.addtask(3, "Add Arrays", "Implement array handling", "Glenda Oberholzer", 11, "To Do");

        // Validate longest task
        String longestTask = taskManager.displayTaskWithLongestDuration();
        assertTrue(longestTask.contains("Glenda Oberholzer"));
        assertTrue(longestTask.contains("11")); // Duration
    }

    /**
     * Test of searchTaskByName method, of class Task.
     */
     @Test
    public void testSearchTaskByName() {
        taskManager.initializeTasks(3);
        // Populate tasks
        taskManager.addtask(0, "Create Login", "Authentication feature", "Mike Smith", 5, "To Do");
        taskManager.addtask(1, "Create Add Features", "Feature implementation", "Edward Harrison", 8, "Doing");

        // Search for a specific task by name
        String searchResult = taskManager.searchTaskByName("Create Login");
        assertTrue(searchResult.contains("Create Login"));
        assertTrue(searchResult.contains("Mike Smith"));
        assertTrue(searchResult.contains("To Do"));

        // Test for a non-existent task
        String notFoundResult = taskManager.searchTaskByName("Nonexistent Task");
        assertEquals("Task not found.", notFoundResult);
    }
    /**
     * Test of searchTasksByDeveloper method, of class Task.
     */
    @Test
    public void testSearchTasksByDeveloper() {
        System.out.println("SearchTasksByDeveloper");
        taskManager.initializeTasks(3);
        // Populate tasks
        taskManager.addtask(0, "Create Login", "Authentication feature", "Mike Smith", 5, "To Do");
        taskManager.addtask(1, "Create Add Features", "Feature implementation", "Mike Smith", 8, "Doing");

        // Search tasks by developer
        String tasksByDeveloper = taskManager.searchTasksByDeveloper("Mike Smith");
        assertTrue(tasksByDeveloper.contains("Create Login"));
        assertTrue(tasksByDeveloper.contains("Create Add Features"));
    }


    /**
     * Test of deleteTaskByName method, of class Task.
     */
   @Test
    public void testDeleteTaskByName() {
        System.out.println("deleteTaskByName");
        taskManager.initializeTasks(3);
        // Populate tasks
        taskManager.addtask(0, "Create Login", "Authentication feature", "Mike Smith", 5, "To Do");
        taskManager.addtask(1, "Create Add Features", "Feature implementation", "Edward Harrison", 8, "Doing");

        // Delete a task
        String deleteResult = taskManager.deleteTaskByName("Create Login");
        assertEquals("Task deleted successfully.", deleteResult);

        // Ensure the task is no longer in the array
        String searchResult = taskManager.searchTaskByName("Create Login");
        assertEquals("Task not found.", searchResult);
    }

    /**
     * Test of displayAllTasks method, of class Task.
     */
  @Test
    public void testDisplayAllTasks() {
        // Populate tasks
        taskManager.addtask(0, "Create Login", "Authentication feature", "Mike Smith", 5, "To Do");
        taskManager.addtask(1, "Create Add Features", "Feature implementation", "Edward Harrison", 8, "Doing");

        // Display all tasks
        String allTasks = taskManager.displayAllTasks();
        assertTrue(allTasks.contains("Create Login"));
        assertTrue(allTasks.contains("Create Add Features"));
    }
}
