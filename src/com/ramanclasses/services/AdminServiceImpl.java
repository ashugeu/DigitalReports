package com.ramanclasses.services;

import com.ramanclasses.dao.AdminDao;
import com.ramanclasses.daoimpl.UserDetail;


public class AdminServiceImpl {
	
	public static AdminDao adminDao;

	public static UserDetail getUserDetail(String email){
		return adminDao.getUserDetail(email);
	}

	public static void setAdminDao(AdminDao statBoxDao) {
		AdminServiceImpl.adminDao = statBoxDao;
	}


}
