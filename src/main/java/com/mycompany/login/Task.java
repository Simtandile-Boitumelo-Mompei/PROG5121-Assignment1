
package com.mycompany.login;

/**
 *
 * @author Simthandile Mompei
 */
public class Task {
    private String TaskName;
    private int TaskNumber;
    private String TaskDescription;
    private String DeveloperDetails;
    private int TaskDuration;
    private String TaskID;
    private String TaskStatus;
    
    //Create constructor for the classs
    public Task(String taskname, int tasknumber, String taskdescription,String developerdetails,int taskduration,String taskID,String taskstatus){
        this.TaskName = taskname;
        this.TaskNumber = tasknumber;
        this.TaskDescription = taskdescription;
        this.DeveloperDetails = developerdetails;
        this.TaskDuration = taskduration;
        this.TaskID = taskID;
        this.TaskStatus = taskstatus;
    }
    
}
