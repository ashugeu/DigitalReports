package com.ramanclasses.reportsql;

public interface UserSql {

		public static final String FIND_USER_EXIST = "SELECT CASE WHEN EXISTS ("+
				"SELECT * FROM users WHERE email=? and password=?) THEN 'True' ELSE 'False' END";
		public static final String GET_USER_TYPE = "select usertype from users where u_id=?";
		public static final String GET_USER_ID = "select u_id from users where email=?";
		public static final String GET_REPORTS = "select * from reports where u_id=?";
		public static final String GET_USER_DETAILS = "select * from userdetails where email=?";
		public static final String UPADTE_LAST_LOGIN = "update userdetails set last_login=? where u_id=?";
		public static final String GET_USER = "select * from users where email=?";
}
