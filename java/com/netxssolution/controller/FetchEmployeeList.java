package com.netxssolution.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.netxssolutions.dao.EmployeeDao;

@WebServlet("/employee")
public class FetchEmployeeList extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		EmployeeDao ed = new EmployeeDao();
		ResultSet rs = ed.getAllData();
		HttpSession hs = req.getSession();
		hs.setAttribute("1", rs);
		RequestDispatcher rd = req.getRequestDispatcher("ViewEmployees.jsp");
		rd.forward(req, resp);
	}
}
