package com.control;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class StudentRecordRetrieve
 */
public class StudentRecordRetrieve extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static Connection con=null;
	public static ResultSet rs=null;
	public static ResultSet rs2=null;
	public static ResultSet rs3=null;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentRecordRetrieve() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		DBConnection dbConnection=new DBConnection();
		con=dbConnection.getConnection();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setContentType("text/html");
		PrintWriter pw=response.getWriter();
		
		String classno=request.getParameter("classname");
		
		
		try {
			
			Statement st=con.createStatement();
			
			//pw.write("<marquee><h3>Class "+classno+" Details</h3></marquee>");
			pw.write("<center><h3>Class "+classno+" Details</h3></center>");
			pw.write("<br>");
			pw.write("<br>");
			String query1="select name from student where classes_id=%s";
			rs=st.executeQuery(String.format(query1, classno));
			
			pw.write("<h4>Students for class</h4>");
			//pw.write("<br>");
			while(rs.next())
			{
				pw.write(rs.getString(1));
				pw.write("<br>");
			}
			pw.write("<br>");
			pw.write("<br>");
			
			pw.write("<h4>Subjects for class</h4>");
			//pw.write("<br>");
			
			rs2=st.executeQuery("select distinct name from subject where subject.id in (select subject_id from class_subject)");
			
			while(rs2.next())
			{
				pw.write(rs2.getString(1));
				pw.write("<br>");
			}
			
			pw.write("<br>");
			pw.write("<br>");
			
			pw.write("<h4>Teachers for class</h4>");
			//pw.write("<br>");
			rs3=st.executeQuery("select distinct name from teacher where teacher.id in (select teacher_id from class_teacher)");
			while(rs3.next())
			{
				pw.write(rs3.getString(1));
				pw.write("<br>");
			}
			//con.close();
			
		} catch (SQLException e) {
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
