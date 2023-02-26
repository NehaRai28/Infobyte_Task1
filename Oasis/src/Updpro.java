

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


@WebServlet("/Updpro")
public class Updpro extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		response.setContentType("text/html");
		String book_id=request.getParameter("book_id");
		String bookname=request.getParameter("bookname");
		String booklang=request.getParameter("booklang");
		
		try{

		    Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/oasis","root","thelav28");
			String qr="update oasis set book_id=?,bookname=?,booklang=?";
			PreparedStatement ps=con.prepareStatement(qr);
			ps.setString(1, book_id);
			ps.setString(2, bookname);
			ps.setString(3, booklang);
		
			int i=ps.executeUpdate();
			out.println("<script>window.alert('successfully update!!')</script>");
			con.close();
			
			}catch(Exception e)
			{
				out.println(e);
			}
	}

}
