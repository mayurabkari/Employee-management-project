package com.netxssolution.controller;
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

import com.netxssolutions.dao.EmployeeDao;

@WebServlet("/deleteEmployee")
public class EmployeeDelete extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		int id1 = Integer.parseInt(id);

		EmployeeDao employeeDao = new EmployeeDao();
		employeeDao.deleteEmployee(id1);

		RequestDispatcher rd = req.getRequestDispatcher("/employee");
		rd.forward(req, resp);
	}
}
