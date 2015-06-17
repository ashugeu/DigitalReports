package com.ramanclasses.dao;

import java.util.List;

import com.ramanclasses.daoimpl.StudentForm;

public interface StudentFormDao {

	List<StudentForm> getStudentFormFields(int u_id);

}
