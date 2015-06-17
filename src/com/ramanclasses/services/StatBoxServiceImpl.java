package com.ramanclasses.services;

import java.util.List;

import com.ramanclasses.dao.StatBoxDao;
import com.ramanclasses.daoimpl.StatBox;



public class StatBoxServiceImpl {

	public static StatBoxDao statBoxDao;

	public static void setStatBoxDao(StatBoxDao statBoxDao) {
		StatBoxServiceImpl.statBoxDao = statBoxDao;
	}

	public static List<StatBox> getStatBoxDetails(Long u_id){
		return statBoxDao.getStatBoxDetails(u_id);
	}
	
	public static int getCountTotalRegisteredStudents(){
		return statBoxDao.getCountTotalRegisteredStudents();
	}
	
}
