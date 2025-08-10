package com.wipro.filter;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/login")
public class LoginServlet extends HttpServlet{
	
	  static String url="jdbc:mysql://localhost:3306/wipro";
	  static String userId="root";
	  static String passWord="root";
	  
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection(url,userId,passWord);
			String sqlQuery="insert into student(username,password) values(?,?)";
			PreparedStatement ps=con.prepareStatement(sqlQuery);
			ps.setString(1,req.getParameter("name"));
			ps.setString(2,req.getParameter("password"));
			ps.executeUpdate();	
			} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
