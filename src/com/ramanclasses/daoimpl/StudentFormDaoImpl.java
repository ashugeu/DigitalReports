package com.ramanclasses.daoimpl;

import java.sql.Types;
import java.util.List;

import org.springframework.jdbc.core.simple.SimpleJdbcDaoSupport;

import com.ramanclasses.dao.StudentFormDao;
import com.ramanclasses.reportsql.UserSql;

public class StudentFormDaoImpl extends SimpleJdbcDaoSupport implements StudentFormDao {

	@Override
	public List<StudentForm> getStudentFormFields(int u_id) {
		// TODO Auto-generated method stub
		Object [] params = new Object [] {u_id};
		int [] types = new int [] {Types.NUMERIC} ;
		List<StudentForm> studentForm=null;	
		try
		{
			studentForm = (List<StudentForm>) getJdbcTemplate().query(UserSql.GET_ADD_STUDENT_FORM_FIELD, params, types, new StudentFormMapper());
		}catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
				
		return studentForm;
	}

}
