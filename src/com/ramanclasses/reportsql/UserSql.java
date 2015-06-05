package com.ramanclasses.reportsql;

public interface UserSql {

		public static final String FIND_USER_EXIST = "select * from users where email=? and password=?";
		public static final String GET_USER_TYPE = "select usertype from users where u_id=?";
		public static final String GET_USER_ID = "select u_id from users where email=?";
		public static final String GET_REPORTS = "select * from reports where u_id=?";
		public static final String GET_USER_DETAILS = "select * from userdetails where u_id=?";
}
