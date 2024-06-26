package project;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class gettingdata
 */
@WebServlet("/gettingdata")
public class gettingdata extends HttpServlet {
	public void doPost(HttpServletRequest req,HttpServletResponse res)throws IOException {
  HttpSession gsp=req.getSession();
  String data=(String)gsp.getAttribute("E_name");
  PrintWriter pw=res.getWriter();
	
	pw.println(data);
  
	}

}
