package com.simplewebapp.servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/registration")
public class Registartion extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
	
	RequestDispatcher dispatcher=null;
	Connection connectionRegistration = null;
	PreparedStatement userAdd = null;
	
	System.out.println("sucsess connection presets");	
	
	String login= request.getParameter("login");
	String password= request.getParameter("password");
	String password2= request.getParameter("password2");
	String nickname= request.getParameter("nickname");	
	
	System.out.println("sucsess parametrs request");
	
	if (login.equals("") || password.equals("")||password2.equals("")||nickname.equals("")) {
		
		request.setAttribute("status","voidErr");
		dispatcher = request.getRequestDispatcher("registration.jsp");
		dispatcher.forward(request, response);
		
		System.out.println("sucsess check void textbars");
	}else if(!password.equals(password2)) {
		request.setAttribute("status","passwordErr");
		dispatcher = request.getRequestDispatcher("registration.jsp");
		dispatcher.forward(request, response);
		
		System.out.println("sucsess equals passwords");
	}else {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connectionRegistration = DriverManager.getConnection("jdbc:mysql://localhost:3306/webapp?serverTimezone=UTC","root","root");
		
			System.out.println("sucsess connection with BD");
		
			try {
				userAdd= connectionRegistration.prepareStatement("insert into users(login,password,nickname) values(?,?,?)");
				userAdd.setString(1, login);
				userAdd.setString(2, password);
				userAdd.setString(3, nickname);
				
				System.out.println("sucsess userAdd parametrs");
				
				int rowCount = userAdd.executeUpdate();
				if (rowCount >0) {
					request.setAttribute("status", "success");
					System.out.println("sucsess");
					}else{
						request.setAttribute("status", "failed");
						System.out.println("failed");
					}
			
				System.out.println("sucsess check request");
			
				dispatcher = request.getRequestDispatcher("registration.jsp");
				dispatcher.forward(request, response);
			
				System.out.println("sucsess link to registration");
			}catch(Exception e){
				System.out.println("user dublicated");
				request.setAttribute("status", "userErr");
				dispatcher = request.getRequestDispatcher("registration.jsp");
				dispatcher.forward(request, response);
				e.printStackTrace();
			}
			
		
			}catch(Exception e) {
				System.out.println("error connection");
				request.setAttribute("status", "bdErr");
				dispatcher = request.getRequestDispatcher("registration.jsp");
				dispatcher.forward(request, response);
				e.printStackTrace();
			}finally {
				if (userAdd != null) {
					try {userAdd.close();}
					catch (SQLException e) { /* Ignored */}
					System.out.println("sucsess close userAdd");
				}
				if (connectionRegistration != null) {
					try {connectionRegistration.close();}
					catch (SQLException e) { /* Ignored */}
					System.out.println("sucsess close connection");
				}	
			}
	}
	}
}




