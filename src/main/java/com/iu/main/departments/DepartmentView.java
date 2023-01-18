package com.iu.main.departments;

import java.util.ArrayList;

public class DepartmentView {
	
	//view
	
	public void view(String msg) {
		System.out.println(msg);
	}
	public void view(ArrayList<DepartmentDTO> ar) {
		for (DepartmentDTO departmentDTO : ar) {
			this.view(departmentDTO);
		}
	}
	
	//한개 출력하는 view
	
	public void view(DepartmentDTO departmentDTO) {
		System.out.println("Department_id : " + departmentDTO.getDepartment_id());
		System.out.println("Department_name: " + departmentDTO.getDepartment_name());
		System.out.println("Manager_id: "  +departmentDTO.getManager_id());
		System.out.println("Location_id: " + departmentDTO.getLocation_id());
	}
}
