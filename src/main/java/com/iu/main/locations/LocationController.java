package com.iu.main.locations;

import java.util.ArrayList;
import java.util.Scanner;

public class LocationController {
	Scanner scanner;
	LocationDAO locationDAO;
	
	public LocationController() {
		this.scanner = new Scanner(System.in);
		locationDAO = new LocationDAO();
	}
	
	public void start() throws Exception {
		ArrayList<LocationDTO> ar;
		boolean check = true;
		while(check) {
		System.out.println("1.지역 전체 출력");
		System.out.println("2.지역 상세 정보");
		System.out.println("3.주소     입력");
		System.out.println("4.종       료");
		int select = scanner.nextInt();
		
		switch(select) {
			case 1:
				ar =  locationDAO.getList();
				break;
			case 2:
				System.out.println("지역 번호를 입력하세요");
				int num = scanner.nextInt();
				locationDAO.getDetail(num);
				break;
			case 3:
				System.out.println("검색할 주소 입력");
				String add = scanner.next();
				ar = locationDAO.getFind(add);
			default:
				check =false;
		}
		
	   }
	}
}
