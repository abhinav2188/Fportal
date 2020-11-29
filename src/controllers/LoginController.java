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

import dao.UserDao;
import dto.LoginRequestDto;
import dto.LogResponseDto;

@WebServlet("/login")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public LoginController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("login get request");
		RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("login request");
		PrintWriter pw = response.getWriter();
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		LoginRequestDto dto = new LoginRequestDto();
		dto.setEmail(email);
		dto.setPassword(password);
		
		UserDao dao = new UserDao(request.getServletContext());
		
		LogResponseDto resDto = dao.loginUser(dto);
		System.out.println(resDto.toString());
		if(resDto.getUid() != -1) {
			HttpSession session = request.getSession(true);
			session.setAttribute("uid", resDto.getUid());
			request.setAttribute("msg","logged in as "+resDto.getFullName());
			session.setAttribute("uname", resDto.getFullName());
			request.getRequestDispatcher("popup.jsp").include(request, response);
			request.getRequestDispatcher("home.jsp").include(request, response);
		}else {
			request.setAttribute("msg", resDto.getErrorMsg());
			request.getRequestDispatcher("popup.jsp").include(request, response);
			request.getRequestDispatcher("login.jsp").include(request, response);			
		}

		pw.close();
	}
}
