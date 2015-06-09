package com.ramanclasses.dao;

import com.ramanclasses.daoimpl.User;




public interface CommonDao {
	
	public Boolean isUserExists(String email,String password);
	public String getUserType(int userId);
	public User getUser(String email);
	public void setLastLogin(Long id);
	public Long getUserId(String email);
	
}
