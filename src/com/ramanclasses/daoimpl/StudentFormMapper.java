package com.ramanclasses.daoimpl;

import java.sql.ResultSet;
import java.sql.SQLException;



import org.springframework.jdbc.core.RowMapper;


public class StudentFormMapper implements RowMapper {

	@Override
	public Object mapRow(ResultSet rs, int rownum) throws SQLException {
		// TODO Auto-generated method stub
		String field = rs.getString("field");
		
		StudentForm model = new StudentForm();
		
		model.setField(field);
		
		return model;
	}

}
