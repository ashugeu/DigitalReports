package com.ramanclasses.daoimpl;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class UserDetailMapper implements RowMapper {

	@Override
	public Object mapRow(ResultSet rs, int rownum) throws SQLException {
		// TODO Auto-generated method stub
		//Long userId = Long.valueOf(rs.getLong("U_ID"));
		String userName = rs.getString("username");
		String name = rs.getString("NAME");
		String userType = rs.getString("USERTYPE");
		String activeFrom = rs.getString("ACTIVE_FROM");
		String lastLogin = rs.getString("LAST_LOGIN");
		String email = rs.getString("EMAIL");
		
		
		UserDetail model = new UserDetail();
		model.setUsername(userName);
		model.setName(name);
		model.setUserType(userType);
		model.setActiveFrom(activeFrom);
		model.setEmail(email);
		model.setLastLogin(lastLogin);
		
		return model;
	}

}
