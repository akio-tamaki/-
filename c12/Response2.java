package c12;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tool.Page;

/**
 * Servlet implementation class Response2
 */
@WebServlet("/c12/response2")
public class Response2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		Page.header(out);
		
		out.println("<p>Method<br>" + request.getMethod() + "</P>");
		out.println("<p>Request URI<br>" + request.getRequestURI() + "</P>");
		out.println("<p>Context Path<br>" + request.getServletPath() + "</P>");
		out.println("<p>Servlet Path<br>" + request.getServletPath() + "</P>");
		out.println("<p>Query String<br>" + request.getQueryString() + "</P>");
		out.println("<p>Protocol<br>" + request.getProtocol() + "</P>");
		
		
		out.println("<p>Request URL<br>" + request.getRequestURL() + "</P>");
		out.println("<p>Scheme<br>" + request.getScheme() + "</P>");
		out.println("<p>Server Name<br>" + request.getServerName() + "</P>");
		out.println("<p>Server Port<br>" + request.getServerPort() + "</P>");
		
		Page.footer(out);
	}

}
