package com.netxssolution.controller;

import java.io.IOException;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.netxssolution.dto.Employee;
import com.netxssolutions.dao.EmployeeDao;


@WebServlet("/employeeDetails")
public class SaveEmployee extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		EmployeeDao employeeDao = new EmployeeDao();

		String name = req.getParameter("name");
		String date = req.getParameter("date");
		String date2 = "";

		char[] a = date.toCharArray();
		for (char b : a) {
			if (b == '-') {
				b = '/';
			}
			date2 = date2 + b;

		}
	
		String address = req.getParameter("address");
		Byte gender = Byte.parseByte(req.getParameter("gender"));
		Double salary = Double.parseDouble(req.getParameter("idnumber"));

		try {
			Date date1 = new SimpleDateFormat("yyyy/MM/dd").parse(date2);;

			Employee employee = new Employee();
			employee.setName(name);
			employee.setBirthDate(date1);
			employee.setAddress(address);
			employee.setGender(gender);
			employee.setSalary(salary);

			employeeDao.saveEmployee(employee);

			RequestDispatcher rd = req.getRequestDispatcher("employee");
			rd.forward(req, resp);
		} catch (ParseException e) {

			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
