package com.ramanclasses.daoimpl;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class UserDetailMapper implements RowMapper {

	@Override
	public Object mapRow(ResultSet rs, int rownum) throws SQLException {
		// TODO Auto-generated method stub
		//Long userId = Long.valueOf(rs.getLong("U_ID"));
		String userName = rs.getString("EMAIL");
		String name = rs.getString("NAME");
		String userType = rs.getString("USERTYPE");
		String activeFrom = rs.getString("ACTIVEFROM");
		
		UserDetail model = new UserDetail();
		model.setUsername(userName);
		model.setName(name);
		model.setUserType(userType);
		model.setActiveFrom(activeFrom);
		return null;
	}

}
