package project;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Employeeassessment")
public class Employeeassessment extends HttpServlet {
	Connection con;
	PreparedStatement  ps1;
	ResultSet rs;
	public void doPost(HttpServletRequest req,HttpServletResponse res)throws IOException {
		try {
			int E_id=Integer.parseInt(req.getParameter("E_id"));
			String  Ename=req.getParameter("E_name");
			
			String sat=Ename.toString();
			Cookie ck=new Cookie("UN",sat);
			ck.setMaxAge(60*60);
			res.addCookie(ck);
			
			
			String str1 = "SELECT * FROM  employee1 where E_id=? and E_name=?";
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee","root","root");
			
			
			ps1=con.prepareStatement(str1);
			ps1.setInt(1,E_id);
			ps1.setString(2, Ename);
			rs=ps1.executeQuery();
			if(rs.next()) {
				int E_id1=rs.getInt("E_id");
				String E_name1=rs.getString("E_name");
				int salary1=rs.getInt("salary");
				int age1=rs.getInt("age");
				String gender1=rs.getString("gender");
				String D_O_J1=rs.getString("D_O_J");
				PrintWriter pw=res.getWriter();
				
					pw.println("E_id" +E_id1 +"E_name" +E_name1 +"salary" +salary1  +"age" +age1 +" gender" +gender1 +"D_O_J" +D_O_J1);
			}
			else {
				   RequestDispatcher rd=req.getRequestDispatcher("employeelogin.html");
				   PrintWriter pw=res.getWriter();
				    pw.println("invalid");
					
				}
				
			
		} catch(SQLException e) {
			e.printStackTrace();

		}
		

	}
	public void destroy(HttpServletRequest req,HttpServletResponse res) {
		try {
			con.close();
			ps1.close();
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	}




