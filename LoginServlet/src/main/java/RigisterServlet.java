
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RigisterServlet
 */
@WebServlet("/RigisterServlet")
public class RigisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RigisterServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
	        throws ServletException, IOException {

	    response.setContentType("text/html");
	    PrintWriter out = response.getWriter();

	    String name = request.getParameter("uname");
	    String pass = request.getParameter("pass");

	    String url = "jdbc:mysql://localhost:3306/mydb";
	    String user = "root";
	    String password = "mohan";

	    try {
	        Class.forName("com.mysql.cj.jdbc.Driver");
	        Connection con = DriverManager.getConnection(url, user, password);
	        Statement stmt = con.createStatement();

	        String query = "INSERT INTO user VALUES ('" + name + "', '" + pass + "')";
	        int result = stmt.executeUpdate(query); 

	        if (result > 0) {
	        	 response.sendRedirect("index.html");
	        } else {
	            out.println("<h3>Something went wrong. Please try again.</h3>");
	        }

	        stmt.close();
	        con.close();

	    } catch (Exception e) {
	        e.printStackTrace();
	        out.println("<h3>Error: " + e.getMessage() + "</h3>");
	    }
	}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
