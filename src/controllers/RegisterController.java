package controllers;

import dao.UserDao;
import dto.LogResponseDto;
import dto.RegisterRequestDto;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/register")
public class RegisterController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public RegisterController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("register get request");
		RequestDispatcher rd = request.getRequestDispatcher("register.jsp");
		rd.forward(request, response);
	}
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("register post req");
		
		RegisterRequestDto dto = new RegisterRequestDto();
		dto.setFirstName(request.getParameter("first_name"));
		dto.setLastName(request.getParameter("last_name"));
		dto.setEmail(request.getParameter("email"));
		dto.setPassword(request.getParameter("password"));
		dto.setMobile(request.getParameter("mobile"));
		
		UserDao dao = new UserDao(request.getServletContext());
		LogResponseDto resDto = dao.registerUser(dto);
		
		
		System.out.println(resDto.toString());
		if(resDto.getUid() != -1) {
			HttpSession session = request.getSession(true);
			session.setAttribute("uid", resDto.getUid());
			request.setAttribute("msg","new user registered");
			session.setAttribute("uname", resDto.getFullName());
			request.getRequestDispatcher("popup.jsp").include(request, response);
			request.getRequestDispatcher("home.jsp").include(request, response);
		}else {
			request.setAttribute("msg", resDto.getErrorMsg());
			request.getRequestDispatcher("popup.jsp").include(request, response);
			request.getRequestDispatcher("register.jsp").include(request, response);			
		}

	}

}
