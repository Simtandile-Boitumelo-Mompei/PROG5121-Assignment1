
package com.mycompany.login;

/**
 *
 * @author Simthandile Mompei
 */
public class Task {
    private String taskName;
    private int taskNumber;
    private String taskDescription;
    private String developerDetails;
    private int taskDuration;
    private String taskID;
    private String taskStatus;
    
    //Create constructor for the classs
    public Task(String taskname, int taskNumber,String taskdescription,String developerdetails,int taskduration,String taskstatus){
        this.taskName = taskname;
        this.taskNumber = taskNumber ;
        this.taskDescription = taskdescription;
        this.developerDetails = developerdetails;
        this.taskDuration = taskduration;
        this.taskID = createTaskID();
        this.taskStatus = taskstatus;
    }
    
    public String setTaskDescription(String taskDescription){
        return this.taskDescription = taskDescription;
    }
    public boolean checkTaskDescription(String taskdescription){
        return taskdescription.length() <= 50;
    }
    
     public String createTaskID(){
        return taskName.substring(0,2).toUpperCase() + ":"+taskNumber+":"+developerDetails.substring(developerDetails.length() - 3).toUpperCase();
    }
    
    public String printTaskDetails(){
        return "Task Name: "+taskName + "\n"+
               "Task Number: "+ taskNumber + "\n"+
               "Task Description: "+taskDescription+"\n"+
               "Developer Details: "+ developerDetails+"\n"+
               "Task Duration: "+taskDuration +"\n"+
               "TaskID: "+ taskID+"\n"+
               "Task Status: "+ taskStatus + "\n";       
                
    } 
    
    public int returnTotalHours(int taskDuration){
        return taskDuration;
    }
}