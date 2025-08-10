package com.wipro.beans;

public class Department {
	
	String deptCode;
	String departmentName;
	public String getDeptCode() {
		return deptCode;
	}
	public void setDeptCode(String deptCode) {
		this.deptCode = deptCode;
	}
	public String getDepartmentName() {
		return departmentName;
	}
	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}
	@Override
	public String toString() {
		return "Department [deptCode=" + deptCode + ", departmentName=" + departmentName + "]";
	}
	public Department(String deptCode, String departmentName) {
		super();
		this.deptCode = deptCode;
		this.departmentName = departmentName;
	}
	public Department() {
		super();
	}
	
	

}
