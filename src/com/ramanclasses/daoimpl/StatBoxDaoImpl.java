package com.ramanclasses.daoimpl;

import java.sql.Types;
import java.util.List;
import java.util.Map;
import javax.sql.DataSource;

import org.springframework.jdbc.core.simple.SimpleJdbcDaoSupport;

import com.ramanclasses.dao.StatBoxDao;
import com.ramanclasses.reportsql.UserSql;

public class StatBoxDaoImpl extends SimpleJdbcDaoSupport implements StatBoxDao{

	public List<StatBox> getStatBoxDetails(Long u_id) {
		// TODO Auto-generated method stub
		Object [] params = new Object [] {u_id};
		int [] types = new int [] {Types.NUMERIC} ;
		List<StatBox> statBox=null;	
		try
		{
			statBox = (List<StatBox>) getJdbcTemplate().query(UserSql.GET_STAT_BOX, params, types, new StatBoxMapper());
		}catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
				
		return statBox;
	}
	
	public int getCountTotalRegisteredStudents(){
		int count=0;
		try
		{
			count = getJdbcTemplate().queryForObject(UserSql.COUNT_TOTAL_STUDENTS, Integer.class);
		}catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
				
		return count;
	}

}
