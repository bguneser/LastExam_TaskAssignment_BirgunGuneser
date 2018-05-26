package com.ford.bguneser.lastexam.model.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class Task extends AbstractEntity {
	private static final long serialVersionUID = 1L;
	private String taskname;
	private Date expiredate;
	private Date beginingdate;
	private List<Employee> employees = new ArrayList<>();

	public String getTaskname() {
		return taskname;
	}
	public void setTaskname(String taskname) {
		this.taskname = taskname;
	}

	public Date getExpiredate() {
		return expiredate;
	}
	public void setExpiredate(Date expiredate) {
		this.expiredate = expiredate;
	}

	public Date getBeginingdate() {
		return beginingdate;
	}
	public void setBeginingdate(Date beginingdate) {
		this.beginingdate = beginingdate;
	}

	public List<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}
}
