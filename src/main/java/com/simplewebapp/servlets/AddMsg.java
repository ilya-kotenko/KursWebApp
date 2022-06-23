package com.simplewebapp.servlets;

import java.io.IOException;
import java.net.URLEncoder;
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
import javax.servlet.http.HttpSession;

@WebServlet("/addMsg")
public class AddMsg extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
		RequestDispatcher dispatcher=null;
    	Connection connectionAddMsg = null;
    	PreparedStatement addMsg = null;
    	
    	HttpSession session = request.getSession();

    	String login= (String) session.getAttribute("login");
    	String msg=request.getParameter("msg");

    	if (msg.equals("")) {
    		request.setAttribute("status","voidErr");
    		dispatcher = request.getRequestDispatcher("registration.jsp");
    		dispatcher.forward(request, response);
    	}else {
    		try {
    			Class.forName("com.mysql.cj.jdbc.Driver");
    			connectionAddMsg = DriverManager.getConnection("jdbc:mysql://localhost:3306/webapp?serverTimezone=UTC","root","root");
    			try {
    				addMsg= connectionAddMsg.prepareStatement("insert into msg(nickname,msg) values(?,?)");
    				addMsg.setString(1, login);
    				addMsg.setString(2, msg);
    				
    				int rowCount = addMsg.executeUpdate();
    				if (rowCount >0) {
    					request.setAttribute("status", "success");
    					System.out.println("sucsess");
    					}else{
    						request.setAttribute("status", "failed");
    						System.out.println("failed");
    					}
    				dispatcher = request.getRequestDispatcher("lk.jsp");
    				dispatcher.forward(request, response);
    			}catch (Exception e) {
    				request.setAttribute("status", "failed");
    				dispatcher = request.getRequestDispatcher("lk.jsp");
    				dispatcher.forward(request, response);
    				e.printStackTrace();
				}
    		}catch (Exception e) {
    			System.out.println("error connection");
				request.setAttribute("status", "bdErr");
				dispatcher = request.getRequestDispatcher("lk.jsp");
				dispatcher.forward(request, response);
				e.printStackTrace();
			}finally {
				if (addMsg != null) {
					try {addMsg.close();}
					catch (SQLException e) { /* Ignored */}
					System.out.println("sucsess close userAdd");
				}
				if (connectionAddMsg != null) {
					try {connectionAddMsg.close();}
					catch (SQLException e) { /* Ignored */}
					System.out.println("sucsess close connection");
				}	
			}
    	}
    	}
	}
    	


