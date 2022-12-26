package com.netxssolutions.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;

import com.netxssolution.dto.Employee;

public class EmployeeDao {
	
	public void saveEmployee(Employee employee) {
		try {

			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee_table", "root", "root");
			PreparedStatement ps = con
					.prepareStatement("insert into employee (Name,Address,Gender,Salary,Birthdate) values(?,?,?,?,?)");
			ps.setString(1, employee.getName());
			ps.setString(2, employee.getAddress());
			ps.setInt(3, employee.getGender());
			ps.setDouble(4, employee.getSalary());
			Date date = new Date(employee.getBirthDate().getTime());
			ps.setDate(5, date);
			ps.execute();
			con.close();

		} catch (ClassNotFoundException | SQLException e) {

			e.printStackTrace();
		}
	}

	public void deleteEmployee(int id) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee_table", "root", "root");
			PreparedStatement ps = con.prepareStatement("delete  from employee where employeeid=?");
			ps.setInt(1, id);
			ps.execute();

		} catch (ClassNotFoundException | SQLException e) {

			e.printStackTrace();
		}
	}
   public ResultSet getAllData() {
	   try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/employee_table", "root", "root");
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery("select * from employee");
			return rs ;
   }
	   catch (ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
		}
	   return null ;
}
}
