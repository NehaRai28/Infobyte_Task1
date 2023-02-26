

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/showlist")
public class showlist extends HttpServlet {

       
 
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		PrintWriter out=response.getWriter();
	    response.setContentType("text/html");
	    try{
	    	Class.forName("com.mysql.jdbc.Driver");
	    	Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/oasis","root","thelav28");
	    	 String qr="select * from oasis";
	    	 Statement st=con.createStatement();
	    	 ResultSet rs=st.executeQuery(qr);
	    	 if(rs.next())
	    	 {
	    		 out.println("<table align=center border=1px>");
	    		 out.println("<th>book_id</th>");
	    		 out.println("<th>bookname</th>");
	    		 out.println("<th>booklang</th>");
	    		 
	    		 do{
	    			 String book_id=rs.getString("book_id");
	    				String bookname=rs.getString("bookname");
	    				String booklang=rs.getString("booklang");
	    				
	    				out.println("<tr>");
	    				
	    				out.println("<td>");
	    				out.println(book_id);	
	    				out.println("</td>");
	    				
	    				out.println("<td>");
	    				out.println(bookname);
	    				out.println("</td>");
	    				
	    				out.println("<td>");
	    				out.println(booklang);
	    				out.println("</td>");
	    				
	    				
	    				
	    				out.println("<td>");
	    			    out.println("<a href=Delpro?book_id="+book_id+">Delete</a>");
	    				out.println("</td>");
	    				
	    				
	    				out.println("</tr>");
	    			
	    		 }while(rs.next());
	    		 out.println("</table>");
	    	 }
	    	 else
	    	 {
	    		 out.println("No records found");
	    	 }
		}catch(Exception e)
	    {
			out.println(e);
	    }
		}
	}


