package com.ford.bguneser.lastexam.model.entity;

import java.util.ArrayList;
import java.util.List;




public class Employee extends AbstractEntity {
	private static final long serialVersionUID = 1L;
	private String firstname;
	private String lastname;
	private List<Task> tasks = new ArrayList<Task>();
	

	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}



	public List<Task> getTasks() {
		return tasks;
	}
	public void setTasks(List<Task> tasks) {
		this.tasks = tasks;
	}


}
