package c06;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tool.Page;

/**
 * Servlet implementation class Control
 */
@WebServlet("/c06/control")
public class Control extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		//ヘッダー出力
		Page.header(out);
		
		request.setCharacterEncoding("UTF-8");
		ArrayList<String> names = Collections.list(request.getParameterNames());
		for (String name : names) {
			String[] values = request.getParameterValues(name);
			for (String value : values) {
				out.println("<p>" + name + " = " + value + "</p>");
			}
		}
		//フッター出力
		Page.footer(out);
	}

}
