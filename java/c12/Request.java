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
 * Servlet implementation class Reqest
 */
@WebServlet("/c12/request")
public class Request extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		Page.header(out);

		out.println("<p>Request URL<br>" + request.getRequestURL() + "</P>");
		out.println("<p>Host<br>" + request.getHeader("Host") + "</p>");
		out.println("<p>User-Agent<br>" + request.getHeader("User-Agent") + "</p>");
		out.println("<p>Remote Address<br>" + request.getRemoteAddr() + "</p>");

		Page.footer(out);
	}

}
