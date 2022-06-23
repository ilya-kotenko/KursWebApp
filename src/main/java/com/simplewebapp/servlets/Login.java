package com.simplewebapp.servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.simplewebapp.classes.User;

@WebServlet("/login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
    	RequestDispatcher dispatcher=null;
    	Connection connection = null;
    	PreparedStatement userSearch = null;
    	
    	User user = new User(null ,null ,null );
    	String login = request.getParameter("login");
		String password = request.getParameter("password");
		
		HttpSession session = request.getSession();
	
		if (login .equals("") ||  password.equals("")) {
			request.setAttribute("status","voidErr");
			dispatcher = request.getRequestDispatcher("login.jsp");
			dispatcher.forward(request, response);
		}else {
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/webapp?serverTimezone=UTC","root","root");
				userSearch = connection.prepareStatement("select * from users where login = ? and password = ?");
			
				userSearch.setString(1, login);
				userSearch.setString(2, password);
				ResultSet result = userSearch.executeQuery();
			
				if (result.next()) {
					user.setLogin(result.getString("login"));
					user.setNickname(result.getString("nickname"));
					user.setUserType(result.getString("userType"));
					session.setAttribute("userType", user.getUserType());
					session.setAttribute("login", user.getLogin());
					session.setAttribute("nickname", user.getNickname());
					

					dispatcher = request.getRequestDispatcher("index.jsp");
				}else {
					request.setAttribute("status", "loginErr");
					dispatcher = request.getRequestDispatcher("login.jsp");
				}
				System.out.println("sucsess");
				dispatcher.forward(request, response);
				}catch (Exception e) {
					System.out.println("error connection");
					request.setAttribute("status", "bdErr");
					dispatcher = request.getRequestDispatcher("login.jsp");
					dispatcher.forward(request, response);
					e.printStackTrace();
				}finally {
					if (userSearch != null) {
						try {userSearch.close();}
						catch (SQLException e) { /* Ignored */}
					}
					if (connection != null) {
						try {connection.close();}
						catch (SQLException e) { /* Ignored */}
					}	
				}
			}
       }
   }
