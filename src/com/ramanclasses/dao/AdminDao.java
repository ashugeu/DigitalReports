package com.ramanclasses.dao;

import com.ramanclasses.daoimpl.UserDetail;

public interface AdminDao {
	
	UserDetail getUserDetail(String email);
	
}
