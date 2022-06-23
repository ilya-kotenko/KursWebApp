package com.simplewebapp.classes;

public class User {

	 private String login;
	 private String nickname;
	 private String userType;
	 
	 public User(String login, String nickname,String userType)  {
	        this.login = login;
	        this.nickname = nickname;
	        this.userType= userType;
	    }
	 
	 public String getLogin() {
	        return login;
	    }
	 
	 public void setLogin(String login) {
	        this.login=login;
	    }
	 
	 public String getNickname() {
	        return nickname;
	    }
	 
	 public void setNickname(String nickname) {
		 	this.nickname=nickname;
	    }
	 
	 public String getUserType() {
	 		return userType;
		}

	public void setUserType(String userType) {
			this.userType=userType;
		}
}
