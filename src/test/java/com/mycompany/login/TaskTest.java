/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.login;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;

/**
 *
 * @author RC_Student_lab
 */
public class TaskTest {

    private Task taskManager = new Task();

    @BeforeEach
    public void setUp() {
        taskManager = new Task();
        taskManager.initializeTasks(4);

        // Populate tasks using sample data
        taskManager.addTask(0, "Create Login", "Authentication feature", "Mike Smith", 5, "To Do");
        taskManager.addTask(1, "Create Add Features", "Feature implementation", "Edward Harrison", 8, "Doing");
        taskManager.addTask(2, "Create Reports", "Generate reports", "Samantha Paulson", 2, "Done");
        taskManager.addTask(3, "Add Arrays", "Implement array handling", "Glenda Oberholzer", 11, "To Do");

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
        // Add multiple tasks with known durations
        int[] durations = {8, 10};
        int expectedTotal = 18;
        assertEquals(expectedTotal, taskManager.returnTotalHours(durations));

    }
//*******************************************PART 3 Testing********************************************************************************************

    @Test
    public void testDeveloperArraysPopulatedCorrectly() {

        System.out.println("Developer Details Length: " + taskManager.getDeveloperDetails().length);

        // Validate developer array
        assertArrayEquals(new String[]{"Mike Smith", "Edward Harrison", "Samantha Paulson", "Glenda Oberholzer"}, taskManager.getDeveloperDetails());
        String[] developers = taskManager.getDeveloperDetails();
        assertNotNull(developers); // Ensure the array is not null
        assertEquals(4, developers.length);
    }

    /**
     * Test of displayTasksWithStatusDone method, of class Task.
     */
    @Test
    public void testDisplayTaskWithLongestDuration() {

        // Call the method to find the task with the longest duration
        String longestTask = taskManager.displayTaskWithLongestDuration(
                taskManager.getDeveloperDetails(),
                taskManager.getTaskDurations()
        );

        // Validate the output
        assertTrue(longestTask.contains("Glenda Oberholzer"));
        assertTrue(longestTask.contains("11")); // Expected longest duration

    }

    /**
     * Test of searchTaskByName method, of class Task.
     */
    @Test
    public void testSearchTaskByName() {
        // Search for a specific task by name
        String searchResult = taskManager.searchTaskByName("Create Login", taskManager.getTaskNames(), taskManager.getDeveloperDetails(), taskManager.getTaskStatuses());
        assertTrue(searchResult.contains("Create Login"));
        assertTrue(searchResult.contains("Mike Smith"));
        assertTrue(searchResult.contains("To Do"));

        //Test for a non-existent task
        String notFoundResult = taskManager.searchTaskByName("Nonexistent Task", taskManager.getTaskNames(), taskManager.getDeveloperDetails(), taskManager.getTaskStatuses());
        assertEquals("Task not found.", notFoundResult);
    }

    /**
     * Test of searchTasksByDeveloper method, of class Task.
     */
    @Test
    public void testSearchTasksByDeveloper() {
        System.out.println("SearchTasksByDeveloper");

        // Search tasks by developer
        String tasksByDeveloper = taskManager.searchTasksByDeveloper("Samantha Paulson", taskManager.getTaskNames(), taskManager.getTaskStatuses());
        assertTrue(tasksByDeveloper.contains("Create Reports"));

    }

    /**
     * Test of deleteTaskByName method, of class Task.
     */
    @Test
    public void testDeleteTaskByName() {
        System.out.println("deleteTaskByName");
        // Delete a task
        String deleteResult = taskManager.deleteTaskByName("Create Login", taskManager.getTaskNames());
        assertEquals("Task deleted successfully.", deleteResult);

        // Ensure the task is no longer in the array
        String searchResult = taskManager.searchTaskByName("Create Login", taskManager.getTaskNames(), taskManager.getDeveloperDetails(), taskManager.getTaskStatuses());
        assertEquals("Task not found.", searchResult);
    }
}
