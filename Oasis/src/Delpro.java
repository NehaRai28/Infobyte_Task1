

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

@WebServlet("/Delpro")
public class Delpro extends HttpServlet {

       
    
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out=response.getWriter();
		response.setContentType("text/html"); 
		String book_id=request.getParameter("book_id");
		try{

		    Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/oasis","root","thelav28");
			String qr="delete from oasis where book_id=?";
			PreparedStatement ps=con.prepareStatement(qr);
			ps.setString(1, book_id);
			int i=ps.executeUpdate();
		
			out.println("<script>window.alert('successfully deleted!!')</script>");
			con.close();
			
			}catch(Exception e)
			{
				out.println(e);
			}
	}

}
