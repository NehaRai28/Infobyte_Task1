

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


@WebServlet("/issuepg")
public class issuepg extends HttpServlet {
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		response.setContentType("text/html");
		String username=request.getParameter("username");
		String bookname=request.getParameter("bookname");
		String book_id=request.getParameter("book_id");
		String issuedate=request.getParameter("issuedate");
		String returndate=request.getParameter("returndate");
		String querry=request.getParameter("querry");
		try{

		    Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/oasis","root","thelav28");
			String qr="insert into oasisd values(?,?,?,?,?,?)";
			PreparedStatement ps=con.prepareStatement(qr);
			ps.setString(1, username);
			ps.setString(2, bookname);
			ps.setString(3, book_id);
			ps.setString(4, issuedate);
			ps.setString(5, returndate);
			ps.setString(6, querry);
			int i=ps.executeUpdate();
			out.println("<script>window.alert('You have successfully issued!!')</script>");
			con.close();
			
			}catch(Exception e)
			{
				out.println(e);
			}
		}
	}


