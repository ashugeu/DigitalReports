package com.ramanclasses.daoimpl;

import java.sql.Types;

import org.springframework.jdbc.core.simple.SimpleJdbcDaoSupport;

import com.ramanclasses.dao.AdminDao;
import com.ramanclasses.reportsql.UserSql;

public class AdminDaoImpl extends SimpleJdbcDaoSupport implements AdminDao{

	@Override
	public UserDetail getUserDetail(String email) {
		// TODO Auto-generated method stub
		Object [] params = new Object [] {email};
		int [] types = new int [] {Types.INTEGER} ;
		
		UserDetail userDetail=null;
		
		try
		{
			userDetail = (UserDetail)getJdbcTemplate().queryForObject(UserSql.GET_USER_DETAILS, params, types, new UserDetailMapper());
		}catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		
		return userDetail;
	}

}
