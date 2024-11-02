package c06;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tool.Page;

/**
 * Servlet implementation class Checkbox
 */
@WebServlet("/c06/checkbox")
public class Checkbox extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		request.setCharacterEncoding("UTF-8");
		String[] prmGenre = request.getParameterValues("genre");
		
		Page.header(out);
		if (prmGenre == null) {
			out.println("お買い得情報はお送りしません。");
		} else {
			for (String item : prmGenre) {
				out.println("「"+ item +"」");
			}
			out.println("に関するお買い得情報をお送りします。");
		}
		
		Page.footer(out);
	
	}

}
