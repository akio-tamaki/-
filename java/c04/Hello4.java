package c04;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tool.Page;

/**
 * Servlet implementation class Hello4
 */
@WebServlet("/c04/hello4")
public class Hello4 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out=response.getWriter();
		//共通フッター出力
		Page.header(out);
		
		out.println("<p>Hello!</p>");
		out.println("<p>こんにちは！</p>");
		out.println("<p>" + new java.util.Date() + "</p>");
		//共通フッター出力
		Page.footer(out);
		
	}

}
