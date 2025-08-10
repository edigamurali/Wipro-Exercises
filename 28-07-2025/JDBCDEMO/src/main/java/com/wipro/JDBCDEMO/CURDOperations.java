package com.wipro.JDBCDEMO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;


public class CURDOperations {
    
    static String url = "jdbc:mysql://localhost:3306/wipro";
    static String username = "root";
    static String password = "root";

    static  void insertData() 
    {
        String sqlQuery = "INSERT INTO employee(emp_name, department) VALUES (?, ?)";
        
        try 
        {
        	Connection con = DriverManager.getConnection(url, username, password);
            PreparedStatement ps = con.prepareStatement(sqlQuery);
            ps.setString(1, "Joe");
            ps.setString(2, "Tester");
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    static void selectData()
    {
    	String sqlQuery="select * from employee";
    	try {
    		Connection con = DriverManager.getConnection(url, username, password);
    		Statement stmt=con.createStatement();
    		ResultSet rs = stmt.executeQuery(sqlQuery);
    		while(rs.next())
    		{
    			System.out.println("id="+rs.getInt(1)+" name="+rs.getString(2)+" deportment="+rs.getString(3));
    		}
    	}
    	catch (Exception e) {
    		e.printStackTrace();
		}
    }
    public static void main(String[] args) {
        
        insertData();
        selectData(); 
    }
}
