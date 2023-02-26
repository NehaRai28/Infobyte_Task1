

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/showlistI")
public class showlistI extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		response.setContentType("text/html");
		
		
		try{
	    	Class.forName("com.mysql.jdbc.Driver");
	    	Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/oasis","root","thelav28");
	    	 String qr="select * from oasisd";
	    	 Statement st=con.createStatement();
	    	 ResultSet rs=st.executeQuery(qr);
	    	 if(rs.next())
	    	 {
	    		 out.println("<table align=center border=1px>");
	    		 
	    		 out.println("<th>user name</th>");
	    		 out.println("<th>book name</th>");
	    		 out.println("<th>book_id</th>");
	    		 out.println("<th>issue date</th>");
	    		 out.println("<th>return date</th>");
	    		 out.println("<th>queries</th>");
	    		 do{

	    			 String username=rs.getString("username");
	    			 String bookname=rs.getString("bookname");
	    			 String book_id=rs.getString("book_id");
	    				String issuedate=rs.getString("issuedate");
	    				String returndate=rs.getString("returndate");
	    				String querry=rs.getString("querry");
	    				
	    				out.println("<tr>");
	    				
	    				out.println("<td>");
	    				out.println(username);	
	    				out.println("</td>");
	    				
	    				out.println("<td>");
	    				out.println(bookname);	
	    				out.println("</td>");
	    				
	    				out.println("<td>");
	    				out.println(book_id);	
	    				out.println("</td>");
	    				
	    				out.println("<td>");
	    				out.println(issuedate);
	    				out.println("</td>");
	    				
	    				out.println("<td>");
	    				out.println(returndate);
	    				out.println("</td>");
	    				
	    				out.println("<td>");
	    				out.println(querry);
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
	    }	}

}
