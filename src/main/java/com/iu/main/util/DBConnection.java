package com.iu.main.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBConnection {
	
	public static Connection getConnection() throws Exception { //같은 거 여러번 쓰기 싫어서 return해줘서 갖다준다
		//1. 접속 정보 준비
		
		//1.id
		String username = "hr";
		//2.pw
		String password = "hr";
		//3.url
		String url = "jdbc:oracle:thin:@localhost:1521/XEPDB1";
		
		//4.driver
		String driver="oracle.jdbc.driver.OracleDriver";
		
		Class.forName(driver); 
		//요즘은 없어도 됨
		
		
		//2. DB접속 실행
		Connection connection = DriverManager.getConnection(url,username,password);
		
		return connection;
		
	}
	
	public static void disConnect(PreparedStatement st, Connection connection) throws SQLException {
		st.close();
		connection.close();
	}
	
	public static void disConnect(ResultSet rs, PreparedStatement st, Connection connection ) throws SQLException {
		rs.close();
		st.close();
		connection.close();
		
	}
}
