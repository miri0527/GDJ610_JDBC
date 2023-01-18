package com.iu.main.departments;

import java.util.ArrayList;
import java.util.Scanner;

public class DepartmentController {
	private Scanner scanner;
	private DepartmentDAO  departmentDAO;
	private DepartmentView departmentView;
	
	public DepartmentController() {
		scanner = new Scanner(System.in);
		departmentDAO = new DepartmentDAO();
		departmentView = new DepartmentView();
		
	}
	
	
	public void start() throws Exception {
		boolean check = true;
		
		while(check) {
			System.out.println("1.부서리스트");
			System.out.println("2.부서상세정보");
			System.out.println("3.종      료");
			int select = scanner.nextInt();
			
			switch(select) {
				case 1:
					 ArrayList<DepartmentDTO> ar = departmentDAO.getList();
					 departmentView.view(ar);
					 
					break;
				case 2:
					System.out.println("부서 번호를 입력하세요");
					int num = scanner.nextInt();
					 DepartmentDTO departmentDTO = departmentDAO.getDetail(num);
					 
					 if(departmentDTO !=null) {
						 departmentView.view(departmentDTO);
					 }else {
						 departmentView.view("데이터가 없습니다");
					 }
					break;
				default :
					check = false;
			}
		}
	}
}
