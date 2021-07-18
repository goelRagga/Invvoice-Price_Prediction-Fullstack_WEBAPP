package com.higradius;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DeleteServlet
 */
@WebServlet("/DeleteServlet")
public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteServlet() {
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
		doGet(request, response);
String deleteTable = null;
		
		try {
			String url="jdbc:mysql://localhost:3306/highradius";
			String uname="root";
			String pass="root";
			
			String invoiceID = request.getParameter("invoiceid");
			System.out.println(invoiceID);
			
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(url,uname,pass);
			String sql_statement = "DELETE FROM mytable WHERE invoice_id = ?";
			
		
				PreparedStatement st = con.prepareStatement(sql_statement);
				st.setString(1, invoiceID);
				System.out.println(st);
				st.executeUpdate();
				System.out.println("Deleted");
				PrintWriter out = response.getWriter();
				out.print("Hello");
		        out.println("<html><body><b>Successfully Deleted"
		                    + "</b></body></html>");

			con.close();
		}
		catch(Exception e) {

		}
	}

}
