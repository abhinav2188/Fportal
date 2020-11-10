package controllers;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.LoginBean;

@WebServlet("/login")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public LoginController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("login get request");
		RequestDispatcher rd = request.getRequestDispatcher("/");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("login request");
		PrintWriter pw = response.getWriter();
		String name = request.getParameter("username");
		String pass = request.getParameter("password");
		LoginBean bean = new LoginBean();
		bean.setName(name);
		bean.setPassword(pass);
		boolean status = bean.validate();
		if(status==true) {
			System.out.println("validated");
			HttpSession session = request.getSession(true);
			session.setAttribute("uuid", bean.getName());
			pw.print("<p style='color:green; padding:1rem;'>Login Successful!</p>");
			request.getRequestDispatcher("/").include(request, response);
		}else {
			pw.print("<p style='color:red; padding:1rem;'>Incorrect Username or password!</p>");
			request.getRequestDispatcher("/").include(request, response);
		}
		pw.close();
	}
}
