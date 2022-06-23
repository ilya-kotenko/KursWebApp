package com.simplewebapp.servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.simplewebapp.classes.MsgBox;
import com.simplewebapp.classes.User;

@WebServlet("/lk")
public class Lk extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("lk start");
		
		RequestDispatcher dispatcher=null;
    	Connection connectionLk = null;
    	PreparedStatement lkSearch = null;
    	
    	HttpSession session = request.getSession();
    	
    	List<MsgBox> msgs = new ArrayList<MsgBox>() ;

    	String userType = (String) session.getAttribute("userType");
    	String lkSeachString="select * from msg";
    	System.out.println("Check userType on null");
    	if(userType==(null)) {
    		System.out.println("userType is null");
    		dispatcher = request.getRequestDispatcher("lk.jsp");
			dispatcher.forward(request, response);
    	}else {
    		System.out.println("userType not null");
    	try {
    		System.out.println("connection to BD");
    		Class.forName("com.mysql.cj.jdbc.Driver");
    		connectionLk = DriverManager.getConnection("jdbc:mysql://localhost:3306/webapp?serverTimezone=UTC","root","root");
    		lkSearch = connectionLk.prepareStatement(lkSeachString);
    		
			ResultSet result = lkSearch.executeQuery();
			System.out.println("get messages");
			while (result.next())
            {

                MsgBox msger = new MsgBox(result.getString("nickname"), result.getString("msg"));
                msgs.add(msger);
                
                System.out.println(msger.getNickname());
                System.out.println(msger.getMsg());
        
            }
			System.out.println("list sacsess");

			request.setAttribute("msgs", msgs);
			
			dispatcher = request.getRequestDispatcher("/lkAdministrator.jsp");
			dispatcher.forward(request, response);
			
    	}catch (Exception e) {
    		System.out.println("error connection");
			request.setAttribute("status", "bdErr");
			dispatcher = request.getRequestDispatcher("index.jsp");
			dispatcher.forward(request, response);
			e.printStackTrace();
		}finally {
			if (lkSearch != null) {
				try {lkSearch.close();}
				catch (SQLException e) { /* Ignored */}
			}
			if (connectionLk != null) {
				try {connectionLk.close();}
				catch (SQLException e) { /* Ignored */}
			}	
		}
    	}
	}

}
