package com.iu.main.locations;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.iu.main.departments.DepartmentDAO;
import com.iu.main.departments.DepartmentDTO;
import com.iu.main.util.DBConnection;

public class LocationDAO {
	
	//update
	public void setData(LocationDTO locationDTO) throws Exception{
		Connection connection = DBConnection.getConnection();
		
		
		
	}
	
	public ArrayList<LocationDTO> getFind(String search) throws Exception {
		ArrayList<LocationDTO> ar = new ArrayList<LocationDTO>();
		
		Connection connection = DBConnection.getConnection();
		
		String sql = "SELECT * FROM LOCATIONS WHERE STREET_ADDRESS LIKE ?";
		
		PreparedStatement st = connection.prepareStatement(sql);
		
		st.setString(1, "%" + search + "%");
		
		ResultSet rs = st.executeQuery();
		
		while(rs.next()) { 
			LocationDTO locationDTO = new LocationDTO();
			locationDTO.setLocation_id(rs.getInt("LOCATION_ID"));
			locationDTO.setStreet_address(rs.getString("STREET_ADDRESS"));
			locationDTO.setPostal_code(rs.getString("POSTAL_CODE"));
			locationDTO.setState_province(rs.getString("STATE_PROVINCE"));
			locationDTO.setCountry_id(rs.getString("COUNTRY_ID"));
			locationDTO.setCity(rs.getString("CITY"));
			ar.add(locationDTO);
		}
		return ar;
	}
	
	public LocationDTO getDetail(int location_id) throws Exception { //한 개만 출력
		
		Connection connection = DBConnection.getConnection();
		String sql = "SELECT * FROM LOCATIONS WHERE LOCATION_ID=?";
		
		PreparedStatement st = connection.prepareStatement(sql);
		
		st.setInt(1, location_id);
		
		//최종 전송 및 실행
		ResultSet rs = st.executeQuery();
		
		//실행 한 것을 돌려서 print -> student처럼 view로 나눠서 만들어보기
		
		LocationDTO locationDTO = new LocationDTO();
		if(rs.next()) {
			locationDTO.setLocation_id(rs.getInt("LOCATION_ID"));
			locationDTO.setStreet_address(rs.getString("STREET_ADDRESS"));
			locationDTO.setPostal_code(rs.getString("POSTAL_CODE"));
			locationDTO.setState_province(rs.getString("STATE_PROVINCE"));
			locationDTO.setCountry_id(rs.getString("COUNTRY_ID"));
			locationDTO.setCity(rs.getString("CITY"));
			
		}
		
		
		//연결 끊기
		DBConnection.disConnect(rs, st, connection);
		return locationDTO;
	}
	
	
	public ArrayList<LocationDTO> getList() throws Exception{ //여러 개 출력
		
//		DBConnection dbConnection = new DBConnection(); //DBConnection타입 리턴 
//		Connection connection = dbConnection.getConnection();
		
		ArrayList<LocationDTO> ar = new ArrayList<LocationDTO>();
		Connection connection = DBConnection.getConnection(); //static
//		//1.접속 정보 준비
//		String user = "hr";
//		String password = "hr";
//		String url = "jdbc:oracle:thin:@localhost:1521/XEPDB1";
//		
//		//2 DB 접속
//		Connection connection = DriverManager.getConnection(url,password,user);
//		//System.out.println(connection);
		
		//3.Query문 생성
		String sql = "SELECT * FROM LOCATIONS";	
		
		//4.Query문 미리 전송
		PreparedStatement st = connection.prepareStatement(sql);
		
		//5.? 세팅
				
		//6.최종 전송 및 결과 처리
		ResultSet rs = st.executeQuery();
		
		while(rs.next()) {
			LocationDTO locationDTO = new LocationDTO();
			locationDTO.setLocation_id(rs.getInt("LOCATION_ID"));
			locationDTO.setStreet_address(rs.getString("STREET_ADDRESS"));
			locationDTO.setPostal_code(rs.getString("POSTAL_CODE"));
			locationDTO.setState_province(rs.getString("STATE_PROVINCE"));
			locationDTO.setCountry_id(rs.getString("COUNTRY_ID"));
			locationDTO.setCity(rs.getString("CITY"));
			ar.add(locationDTO);
		}
		
		//7.연결 끊기
		DBConnection.disConnect(rs, st, connection);
		return ar;
	}
	
	
}
