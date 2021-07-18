package com.higradius;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * Servlet implementation class dummyServlet
 */
@WebServlet("/dummyServlet")
public class DummyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DummyServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		String url="jdbc:mysql://localhost:3306/highradius";
		String uname="root";
		String pass="root";
		
		try {
			 ArrayList<Response> heads = new ArrayList<Response>();
		
	        
	            
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection(url,uname,pass);
		//Creating a Statement object
		Statement stmt = con.createStatement();
		//Retrieving the data
		ResultSet rs = stmt.executeQuery("SELECT * FROM mytable ");
			
				while(rs.next()) {
					Response resp = new Response();
					resp.setCustomer_ID(rs.getString("cust_number"));
					resp.setCustomer_name(rs.getString("name_customer"));
					resp.setAmount(rs.getFloat("total_open_amount"));
					resp.setInvoice_iD(rs.getString("invoice_id"));
					resp.setDue_date(rs.getDate("due_in_date"));
					resp.setClear_date(rs.getDate("clear_date"));
					resp.setNotes(rs.getString("Notes"));
					heads.add(resp);
				}
				
				rs.close();
				stmt.close();
				con.close();
				
				 Gson gson = new GsonBuilder().setPrettyPrinting().create();
				 String data = gson.toJson(heads);
				
				 PrintWriter out = response.getWriter();
				 response.setContentType("application/json");  
				 response.setCharacterEncoding("UTF-8");
				 out.print(data);
				 out.flush();
			} catch (SQLException | ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
