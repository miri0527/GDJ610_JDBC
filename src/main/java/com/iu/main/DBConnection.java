package com.iu.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DBConnection {
	
	public void getConnection() throws Exception {
		//1.id
		String username = "hr";
		//2.pw
		String password = "hr";
		//3.url
		String url = "jdbc:oracle:thin:@localhost:1521/XEPDB1";
		//4.driver
		String driver="oracle.jdbc.driver.OracleDriver";
		
		Class.forName(driver);
		
		//로그인 성공
		Connection connection = DriverManager.getConnection(url,username,password);
		
		//db에서 regions 테이블 가져오기
		String sql = "SELECT * FROM DEPARTMENTS WHERE DEPARTMENT_ID=10";
		
		//query문 동기화, 준비
		PreparedStatement st = connection.prepareStatement(sql);
		
		ResultSet rs = st.executeQuery();
		
		//rs에 region_id와 region_name이 들어가있음
		while(rs.next()) {
			System.out.println(rs.getInt("DEPARTMENT_ID") + "\t");
			//꺼내고싶음 column명 꺼냄
			System.out.println(rs.getString("DEPARTMENT_NAME") + "\t");
			System.out.println(rs.getInt("MANAGER_ID")+ "\t");
			System.out.println(rs.getInt("LOCATION_ID"));
		}
		
		
	}
}
