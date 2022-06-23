package com.simplewebapp.classes;

public class MsgBox {

	 private String nickname;
	 private String msg;
	 
	 public MsgBox(String nickname, String msg)  {

	        this.nickname = nickname;
	        this.msg= msg;
	    }
	 
	 public String getMsg() {
	        return msg;
	    }
	 
	 public void setLogin(String msg) {
	        this.msg=msg;
	    }
	 
	 public String getNickname() {
	        return nickname;
	    }
	 
	 public void setNickname(String nickname) {
		 	this.nickname=nickname;
	    }
	 
}