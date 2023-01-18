package com.iu.main.employees;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.iu.main.util.DBConnection;

public class EmployeeDAO {
	
	//1.사원정보리스트
	public ArrayList<EmployeeDTO> getList() throws Exception {
		ArrayList<EmployeeDTO> ar = new ArrayList<EmployeeDTO>();
		Connection connection = DBConnection.getConnection();
		
		
		String sql = "SELECT EMPLOYEE_ID , LAST_NAME , FIRST_NAME ,JOB_ID , DEPARTMENT_ID "
				+ "FROM EMPLOYEES ORDER BY HIRE_DATE DESC";
		
		PreparedStatement st = connection.prepareStatement(sql);
		
		ResultSet rs = st.executeQuery();
		
		while(rs.next()) {
			EmployeeDTO employeeDTO = new EmployeeDTO();
			employeeDTO.setEmployee_id(rs.getInt("EMPLOYEE_ID"));
			employeeDTO.setLast_name(rs.getString("LAST_NAME"));
			employeeDTO.setFirst_name(rs.getString("FIRST_NAME"));
			employeeDTO.setJob_id(rs.getString("JOB_ID"));
			employeeDTO.setDepartment_id(rs.getInt("DEPARTMENT_ID"));
			ar.add(employeeDTO);
			
		}
		
		DBConnection.disConnect(rs, st, connection);
		
		return ar;
	}
	
	//2.개별사원정보
	public EmployeeDTO getDetail(int employeed_id) throws Exception {
		Connection connection = DBConnection.getConnection();
		
		String sql = "SELECT * FROM EMPLOYEES  WHERE EMPLOYEE_ID = ?";
		
		PreparedStatement st = connection.prepareStatement(sql);
		
		st.setInt(1, employeed_id);
		
		ResultSet rs = st.executeQuery();
		
		EmployeeDTO employeeDTO = null;
		if(rs.next()) {
			employeeDTO = new EmployeeDTO(); //밖에다가 객체 생성하면 객체가 있다고 나와서 주소값은 null값이 아닌게 되지만 
			//값은 null이기때문에 null값이 나온다
			employeeDTO.setEmployee_id(rs.getInt("EMPLOYEE_ID"));
			employeeDTO.setFirst_name(rs.getString("FIRST_NAME"));
			employeeDTO.setLast_name(rs.getString("LAST_NAME"));
			employeeDTO.setEmail(rs.getString("EMAIL"));
			employeeDTO.setPhone_number(rs.getString("PHONE_NUMBER"));
			employeeDTO.setHire_date(rs.getDate("HIRE_DATE"));
			employeeDTO.setJob_id(rs.getString("JOB_ID"));
			employeeDTO.setSalary(rs.getInt("SALARY"));
			employeeDTO.setCommission_pct(rs.getDouble("COMMISSION_PCT"));
			employeeDTO.setManager_id(rs.getInt("MANAGER_ID"));
			employeeDTO.setDepartment_id(rs.getInt("DEPARTMENT_ID"));
		}
		//연결끊기
		DBConnection.disConnect(rs, st, connection);
		
		return employeeDTO;
		
	}
	//3.사원검색(사원이름으로 검색)
		public EmployeeDTO getSearch(String search) throws Exception {
			
			Connection connection = DBConnection.getConnection();
			
			String sql = "SELECT * FROM EMPLOYEES WHERE LAST_NAME LIKE ?";
			
			PreparedStatement st = connection.prepareStatement(sql);
			st.setString(1, "%" + search + "%");
			
			ResultSet rs = st.executeQuery();
			
			EmployeeDTO employeeDTO = null;
			while(rs.next()) {
				employeeDTO = new EmployeeDTO();
				employeeDTO.setEmployee_id(rs.getInt("EMPLOYEE_ID"));
				employeeDTO.setFirst_name(rs.getString("FIRST_NAME"));
				employeeDTO.setLast_name(rs.getString("LAST_NAME"));
				employeeDTO.setEmail(rs.getString("EMAIL"));
				employeeDTO.setPhone_number(rs.getString("PHONE_NUMBER"));
				employeeDTO.setHire_date(rs.getDate("HIRE_DATE"));
				employeeDTO.setJob_id(rs.getString("JOB_ID"));
				employeeDTO.setSalary(rs.getInt("SALARY"));
				employeeDTO.setCommission_pct(rs.getDouble("COMMISSION_PCT"));
				employeeDTO.setManager_id(rs.getInt("MANAGER_ID"));
				employeeDTO.setDepartment_id(rs.getInt("DEPARTMENT_ID"));
				
			}
			
			//연결 끊기
			DBConnection.disConnect(rs, st, connection);
			return employeeDTO ;
		}

	
}
