package dbAccess;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class LoginCheck extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private DBConnection newConnection;
	
    public LoginCheck() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String username = request.getParameter("uname");
		String password = request.getParameter("password");
		
		
		try {
			newConnection = new DBConnection();
			
			if(newConnection.searchUser(username, password)) {
				response.sendRedirect("success.jsp");
			}
			
			else {
				boolean result = newConnection.searchUser(username, password);
				
				if(result == true) {
					response.sendRedirect("success.jsp");
				}
				else {
					response.sendRedirect("error.jsp");
				}
				
			}
			
			
			
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}

}
