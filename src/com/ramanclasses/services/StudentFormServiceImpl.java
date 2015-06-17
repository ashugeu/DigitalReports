package com.ramanclasses.services;

import java.util.List;

import com.ramanclasses.dao.StudentFormDao;
import com.ramanclasses.daoimpl.StudentForm;

public class StudentFormServiceImpl {

	public static StudentFormDao studentFormDao;
	
	public static void setStudentFormDao(StudentFormDao studentFormDao) {
		StudentFormServiceImpl.studentFormDao = studentFormDao;
	}

	public static List<StudentForm> getStudentFormFields(int u_id) {
		// TODO Auto-generated method stub
		return studentFormDao.getStudentFormFields(u_id);
	}

}