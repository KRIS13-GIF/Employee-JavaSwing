/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui_project;

import java.io.*; 
/**
 *
 * @author user
 */
public class Job implements Serializable { // creating as objects
    private double salary;
    private String nameOfJob;

    public Job(double salary, String nameOfJob) {
        this.salary = salary;
        this.nameOfJob = nameOfJob;
    }
    public boolean equals(Job job)
    {
        if(this.salary==job.salary && this.nameOfJob.equals(job.nameOfJob))
        {
            return true; // compare 2 objects
        }
        else{
            return false;
        }
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getNameOfJob() {
        return nameOfJob;
    }

    public void setNameOfJob(String nameOfJob) {
        this.nameOfJob = nameOfJob;
    }
    
    
    
    
    
    
}
