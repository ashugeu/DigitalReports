package com.ramanclasses.daoimpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.List;
import java.util.Map;

import javax.swing.tree.RowMapper;
import javax.swing.tree.TreePath;

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

	@Override
	public List<String> getAllFieldsById(int u_id) {
		// TODO Auto-generated method stub
		Object [] params = new Object [] {u_id};
		int [] types = new int [] {Types.NUMERIC} ;
		List<String> studentForm=null;	
		try
		{
			studentForm = getJdbcTemplate().queryForList(UserSql.GET_STUDENT_FORM_FIELDS, params, types, String.class);
			
		}catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
				
		return studentForm;
	}

}
