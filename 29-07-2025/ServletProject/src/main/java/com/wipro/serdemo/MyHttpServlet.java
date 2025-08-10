package com.wipro.serdemo;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/welcome")
public class MyHttpServlet extends HttpServlet
{
	protected void doGet(HttpServletRequest req,HttpServletResponse resp)
	{
		System.out.println("doGet Method of MyHttpServlet");
	}
}
