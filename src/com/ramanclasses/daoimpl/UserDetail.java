package com.ramanclasses.daoimpl;

public class UserDetail {

		private String username;
		private String userType;
		private String name;
		private String activeFrom;
		private String lastLogin;
		private String email;
		
		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public String getLastLogin() {
			return lastLogin;
		}

		public void setLastLogin(String lastLogin) {
			this.lastLogin = lastLogin;
		}

		public String getActiveFrom() {
			return activeFrom;
		}

		public void setActiveFrom(String activeFrom) {
			this.activeFrom = activeFrom;
		}

		public String getUserType() {
			return userType;
		}

		public void setUserType(String userType) {
			this.userType = userType;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getUsername() {
			return username;
		}

		public void setUsername(String username) {
			this.username = username;
		}

		
}
