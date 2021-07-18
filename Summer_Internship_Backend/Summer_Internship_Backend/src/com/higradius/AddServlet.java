package com.higradius;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * Servlet implementation class AddServlet
 */
@WebServlet("/AddServlet")
public class AddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		int executionStatus = 0;
		
		
		String Customer_name=request.getParameter("name");
		String Customer_ID=request.getParameter("number");
		
		String due_date=request.getParameter("duedate");
		String  Amount=(request.getParameter("amount"));
		String invoice_iD=request.getParameter("Invoice");
		String note=request.getParameter("notes");
		
		String url="jdbc:mysql://localhost:3306/highradius";
		String uname="root";
		String pass="root";
		try {
			 
		
	        
	            
			 
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection(url,uname,pass);
		System.out.println("Connected!!");
		//Creating a Statement object
		PreparedStatement stmt=con.prepareStatement("INSERT INTO mytable(cust_number,name_customer, due_in_date,total_open_amount, invoice_id,Notes) values (?, ?, ?, ?, ?, ?)");
		stmt.setString(1,Customer_ID);
		stmt.setString(2, Customer_name);
		stmt.setString(3,due_date);
		stmt.setString(4, Amount);
		stmt.setString(5, invoice_iD);
		stmt.setString(6, note);
		executionStatus=stmt.executeUpdate();
		System.out.println("Executed!!"+executionStatus);
		con.close();
		
		
		
		
		System.out.println("customer Name: "+Customer_name);
		System.out.println("Customer ID:"+invoice_iD);
		System.out.println("Inovice Id :"+due_date);

		System.out.println("Clear Date: "+Customer_ID);
		System.out.println("Amount: "+Amount);
		System.out.println("Notes: "+note);
		
		PrintWriter out = response.getWriter();
		out.print("Hello");
        out.println("<html><body><b>Successfully Inserted"
                    + "</b></body></html>");
		
		

		} catch (SQLException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
}
