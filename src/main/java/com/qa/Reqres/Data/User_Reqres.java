package com.qa.Reqres.Data;
//Plain old Java Object
public class User_Reqres {
	
	String name;
	String Job;
	
	public User_Reqres(String name,String Job)
	{
	  this.name=name;
	  this.Job=Job;
	}
	//getters and Setters
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getJob() {
		return Job;
	}
	public void setJob(String job) {
		Job = job;
	}
	
}
