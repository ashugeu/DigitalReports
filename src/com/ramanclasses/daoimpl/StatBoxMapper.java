package com.ramanclasses.daoimpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import org.springframework.jdbc.core.RowMapper;

public class StatBoxMapper implements RowMapper {

	@Override
	public Object mapRow(ResultSet rs, int rownum) throws SQLException {
		// TODO Auto-generated method stub
		//Long userId = Long.valueOf(rs.getLong("U_ID"));
		int id = rs.getInt("id");
		int u_id = rs.getInt("u_id");
		Date last_modified = rs.getDate("last_modified");
		int attribute_id = rs.getInt("attribute_id");
		
		
		StatBox model = new StatBox();
		model.setId(id);
		model.setU_id(u_id);
		model.setAttribute_id(attribute_id);
		model.setLast_modified(last_modified);
		
		return model;
	}

}
