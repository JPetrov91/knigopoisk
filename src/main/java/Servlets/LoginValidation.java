package Servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Database.UserDAO;
import Models.User;

/**
 * Servlet implementation class LoginValidation
 */
public class LoginValidation extends HttpServlet {
	private static final long serialVersionUID = 1L;
	UserDAO userDAO = new UserDAO();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginValidation() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String login, password;
		login = request.getParameter("user_login");
		password = request.getParameter("user_password");
		User user = userDAO.getByLogin(login);
		if(user == null) response.getWriter().append("Login or password is incorrect");
		System.out.println(user.getPassword());
		if(password.equals(user.getPassword())) {
			response.getWriter().append("Login is succesful");
			response.sendRedirect("index.jsp");
		}
		else {
			response.getWriter().append("Login or password is incorrect");
		}
	}

}
