package com.wipro.methodReference;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class EmployeeSelect {

    static String url = "jdbc:mysql://localhost:3306/wipro";
    static String username = "root";
    static String password = "root";
    static void selectData()
    {
    	String sqlQuery="select * from newemployee where age>30 and salary>55000";
    	try {
    		Connection con = DriverManager.getConnection(url, username, password);
    		Statement stmt=con.createStatement();
    		ResultSet rs = stmt.executeQuery(sqlQuery);
    		while(rs.next())
    		{
    			System.out.println("id="+rs.getInt(1)+" name="+rs.getString(2)+"age="+rs.getInt(3)+" salary="+rs.getDouble(4));
    		}
    	}
    	catch (Exception e) {
    		e.printStackTrace();
		}
    }
    	public static void main(String[] args) {
        
        selectData(); 
    	}

}
