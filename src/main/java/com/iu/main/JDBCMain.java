package com.iu.main;

import com.iu.main.departments.DepartmentController;
import com.iu.main.departments.DepartmentDAO;
import com.iu.main.employees.EmployeeController;
import com.iu.main.employees.EmployeeDAO;
import com.iu.main.locations.LocationController;
import com.iu.main.locations.LocationDAO;

public class JDBCMain {

	public static void main(String[] args) {
		
		System.out.println("start");
		DepartmentController dc = new DepartmentController();
		LocationController lc = new LocationController();
		EmployeeController ec = new EmployeeController();
		
		try {
			ec.start();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
//		LocationDAO locationDAO = new LocationDAO();
//		try {
//			locationDAO.getDetail(1000);
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
//		try {
//			dc.start();
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
//		try {
//			lc.start();
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
		
	}
	

}
