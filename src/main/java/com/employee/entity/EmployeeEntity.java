package com.employee.entity;

import lombok.NonNull;

public class EmployeeEntity {

	private int id;
	private String empname;
	private String empmail;
	private String empnumber;
	private int empage;
	private String empcity;
	
	public int getId(){
		return this.id;
	}
	
	public String getEmpname(){
		return this.empname;
	}
	
	public String getEmpmail(){
		return this.empmail;
	}
	
	public String getEmpnumber(){
		return this.empnumber;
	}
	
	public String getEmpcity(){
		return this.empcity;
	}
	public int getEmpage(){
		return this.empage;
	}
	
	
	public void setId(int id){
		this.id=id;
	}
	
	public void setEmpname(String emp){
		this.empname=emp;
	}
	
	public void setEmpmail(String emp){
		this.empmail=emp;
	}
	
	public void setEmpnumber(String emp){
		this.empnumber=emp;
	}
	
	public void setEmpcity(String emp){
		this.empcity=emp;
	}
	
	public void setEmpage(int emp){
		this.empage=emp;
	}
	
}
