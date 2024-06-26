package project;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Loginassessment")
public class Loginassessment extends HttpServlet {
	public void service(HttpServletRequest req,HttpServletResponse res) throws IOException {
	try {
		String userid=req.getParameter("userid");
		String sname=req.getParameter("sname");
		String str1 = "SELECT * FROM studentsmark where userid = ? and sname = ?";
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee","root","root");
		PreparedStatement  ps1=con.prepareStatement(str1);
		
		ps1.setString(1, userid);
		ps1.setString(2, sname);
		ResultSet rs=ps1.executeQuery();
		if(rs.next()) {
			int userid1=rs.getInt("userid");
			String sname1=rs.getString("sname");
			int n3=rs.getInt("mark1");
			int n4=rs.getInt("mark2");
			PrintWriter pw=res.getWriter();
			
				pw.println("userid" +userid1 +"sname" +sname1 +"mark1" +n3  +"mark2" +n4);
		}
		else {
			   PrintWriter pw=res.getWriter();
			    pw.println("invalid");
				
			}
			
		
	} catch(SQLException e) {
		e.printStackTrace();

	}
	

}
}
