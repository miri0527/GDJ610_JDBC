package com.iu.main.employees;

import java.util.ArrayList;
import java.util.Scanner;

public class EmployeeController {
	Scanner scanner;
	EmployeeDAO employeeDAO;
	EmployeeView employeeView;
	
	public EmployeeController() {
		scanner = new Scanner(System.in);
		employeeDAO = new EmployeeDAO();
		employeeView = new EmployeeView();
	}
	
	
	public void start() throws Exception {
		boolean check = true;
		while(check) {
			System.out.println("1.사원정보리스트");
			System.out.println("2.개별사원정보");
			System.out.println("3.사원검색");
			System.out.println("4.종료");
			
			int select = scanner.nextInt();
			
			EmployeeDTO employeeDTO;
			switch(select) {
				case 1:
					ArrayList<EmployeeDTO> ar = employeeDAO.getList();
					employeeView.view(ar);
					break;
				case 2:
					System.out.println("사원번호를 입력");
					int num = scanner.nextInt();
					employeeDTO = employeeDAO.getDetail(num);
					if(employeeDTO !=null) {
						employeeView.view(employeeDTO);
					}else {
						employeeView.view("데이터가 없습니다");
					}
					
					break;
				case 3:
					System.out.println("사원이름 검색");
					String name = scanner.next();
					employeeDTO = employeeDAO.getSearch(name);
					if(employeeDTO !=null) {
						employeeView.view(employeeDTO);
					}else {
						employeeView.view("데이터가 없습니다");
					}
					break;
				default:
					check = false;
			}
		
		}
	}
}
