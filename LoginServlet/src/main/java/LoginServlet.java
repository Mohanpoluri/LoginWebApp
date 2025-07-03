

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

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		String name=request.getParameter("uname");
		String pass=request.getParameter("pass");
		
		String url = "jdbc:mysql://localhost:3306/mydb";  // Replace with your DB name
        String user = "root";                                // Replace with your DB username
        String password = "mohan";                    // Replace with your DB password
        Connection con;
        Statement stmt;
        ResultSet rs;

        try {

        	Class.forName("com.mysql.cj.jdbc.Driver");
        	con = DriverManager.getConnection(url, user, password);
        	 stmt = con.createStatement();

            // Create Statement
           String query="select * from user where userId='"+name+"' and password ='"+pass+"'";
           rs =stmt.executeQuery(query);
          
            if(rs.next()) {
            	response.sendRedirect("welcome.html");
            	
            }else {
            	out.print(name+" User Not found in the database");
            }
            rs.close();
        	con.close();
        	stmt.close();
		
	}catch(Exception e) {
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
