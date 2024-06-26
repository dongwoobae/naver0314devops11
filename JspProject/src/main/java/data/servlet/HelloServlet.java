package data.servlet;

import java.io.IOException;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HelloServlet
 */
@WebServlet("/study1")
public class HelloServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setAttribute("message", "안녕하세요, 비트캠프입니다");
		request.setAttribute("num1", 8);
		request.setAttribute("num2", 5);
		request.setAttribute("today", new Date());
		//test1.jsp로 forward로 이동(url 주소 안바뀜, response,request 그대로 전달)
		//redirect는 url이 바뀌고 response, request 전달 안됨
		RequestDispatcher rd = request.getRequestDispatcher("./day0513/test1.jsp");//forward 할 곳 지정
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
