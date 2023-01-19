package com.iu.main.departments;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.iu.main.util.DBConnection;

public class DepartmentDAO {
	
	//delete
	public int deleteData(DepartmentDTO departmentDTO) throws Exception {
		Connection connection = DBConnection.getConnection();
		
		String sql = "DELETE DEPARTMENTS WHERE DEPARTMENT_ID=?";
		
		PreparedStatement st = connection.prepareStatement(sql);
		
		st.setInt(1, departmentDTO.getDepartment_id());
		
		int result = st.executeUpdate();
		DBConnection.disConnect(st, connection);
		return result;
	}
	
	
	//Insert
	public int setData(DepartmentDTO departmentDTO) throws Exception {
		Connection connection = DBConnection.getConnection();
		
		String sql = "INSERT INTO DEPARTMENTS (DEPARTMENT_ID, DEPARTMENT_NAME, MANAGER_ID, LOCATION_ID)"
				+ "VALUES (DEPARTMENTS_SEQ.NEXTVAL, ?, ?, ?)";
		PreparedStatement st = connection.prepareStatement(sql);
		
		st.setString(1, departmentDTO.getDepartment_name());
		st.setInt(2, departmentDTO.getDepartment_id() );
		st.setInt(3, departmentDTO.getLocation_id());
		
		int result = st.executeUpdate();
		DBConnection.disConnect(st, connection);
		return result;
	}
	
	
	//Update
	public int updateData(DepartmentDTO departmentDTO) throws Exception{
		Connection connection =DBConnection.getConnection();
		
		String sql = "UPDATE DEPARTMENTS SET DEPARTMENT_NAME=?, MANAGER_ID=?, LOCATION_ID=? "
				+ "WHERE DEPARTMENT_ID=?";
		PreparedStatement st = connection.prepareStatement(sql);
		
		st.setNString(1, departmentDTO.getDepartment_name());
		st.setInt(2, departmentDTO.getManager_id());
		st.setInt(3, departmentDTO.getLocation_id());
		st.setInt(4, departmentDTO.getDepartment_id());
		
		int result = st.executeUpdate();
		//연결끊기
		DBConnection.disConnect(st, connection);
		return result;
	}
	
	public DepartmentDTO getDetail(int department_id) throws Exception{ //한 개 가져오기
		
		Connection connection = DBConnection.getConnection();
		
		String sql = "SELECT * FROM DEPARTMENTS WHERE DEPARTMENT_ID=?";
		PreparedStatement st = connection.prepareStatement(sql);
		
		//?세팅
		st.setInt(1, department_id); //인덱스 번호 오라클은 1번으로 시작 -> ?의 인덱스
		
		ResultSet rs = st.executeQuery();
		
		DepartmentDTO departmentDTO = new DepartmentDTO();
		
		if(rs.next()){
			departmentDTO.setDepartment_id(rs.getInt("DEPARTMENT_ID"));
			departmentDTO.setDepartment_name(rs.getString("DEPARTMENT_NAME"));
			departmentDTO.setManager_id(rs.getInt("MANAGER_ID"));
			departmentDTO.setLocation_id(rs.getInt("LOCATION_ID"));
			
//			System.out.println(rs.getInt("DEPARTMENT_ID"));
//			System.out.println(rs.getString("DEPARTMENT_NAME"));
//			System.out.println(rs.getInt("MANAGER_ID")); //null은 int타입으로 되어있기 때문에 0으로 프린트됨
//			System.out.println(rs.getInt("LOCATION_ID"));	
		}
		
		DBConnection.disConnect(rs, st, connection);
		
		return departmentDTO;
	}
	
	public ArrayList<DepartmentDTO> getList() throws Exception{ //여러 개 가져오기
		
		
//		DBConnection dbConnection = new DBConnection(); //DBConnection타입 리턴
//		Connection connection = dbConnection.getConnection(); - >static 쓰기 전
		
		ArrayList<DepartmentDTO> ar = new ArrayList<DepartmentDTO>();
		Connection connection = DBConnection.getConnection(); //static
		
		
//		//1.접속 정보 준비
//		String user = "hr";
//		String password = "hr";
//		String url = "jdbc:oracle:thin:@localhost:1521/XEPDB1";
//		
//		//2 DB 접속
//		Connection connection = DriverManager.getConnection(url, user, password);
//		//System.out.println(connection);
		
		
		//3.Query문 생성
		String sql = "SELECT * FROM DEPARTMENTS"; 
		
		//4.Query문 미리 전송
		PreparedStatement st = connection.prepareStatement(sql);
		
		//5.? 세팅
	
		//6.최종 전송 및 결과 처리
		ResultSet rs = st.executeQuery();
		
		while(rs.next()) {
			DepartmentDTO departmentDTO = new DepartmentDTO();
			departmentDTO.setDepartment_id(rs.getInt("DEPARTMENT_ID"));
			departmentDTO.setDepartment_name(rs.getString("DEPARTMENT_NAME"));
			departmentDTO.setManager_id(rs.getInt("MANAGER_ID"));
			departmentDTO.setLocation_id(rs.getInt("LOCATION_ID"));
			ar.add(departmentDTO);
		}
		
		//7.연결 해제
//		rs.close();
//		st.close();
//		connection.close();
		DBConnection.disConnect(rs, st, connection);
		return ar;
	}
}
