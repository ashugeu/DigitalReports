package com.ramanclasses.dao;

import java.util.List;
import java.util.Map;
import javax.sql.DataSource;
import com.ramanclasses.daoimpl.StatBox;


public interface StatBoxDao {

	List<StatBox> getStatBoxDetails(Long u_id);
	
	public int getCountTotalRegisteredStudents();
}
