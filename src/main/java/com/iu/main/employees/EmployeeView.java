package com.iu.main.employees;

import java.util.ArrayList;

public class EmployeeView {
	
	public void view(String msg) {
		System.out.println(msg);
	}
	
	public void view(ArrayList<EmployeeDTO> ar) {
		for (EmployeeDTO employeeDTO : ar) {
			this.view(employeeDTO);
		}
	}
	
	public void view(EmployeeDTO employeeDTO) {
		System.out.println("Employee_id: " + employeeDTO.getEmployee_id());
		System.out.println("First_name: " + employeeDTO.getFirst_name());
		System.out.println("Last_name; " + employeeDTO.getLast_name());
		System.out.println("Email: " + employeeDTO.getEmail());
		System.out.println("Phone_number: " + employeeDTO.getPhone_number());
		System.out.println("Hire_date: " + employeeDTO.getHire_date());
		System.out.println("Job_id: " + employeeDTO.getJob_id());
		System.out.println("Salary: " + employeeDTO.getSalary());
		System.out.println("Commission_pct: " + employeeDTO.getCommission_pct());
		System.out.println("Manager_id: " + employeeDTO.getManager_id());
		System.out.println("Department_id: " + employeeDTO.getDepartment_id());
	}
}
