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
 * Servlet implementation class Reserve
 */
@WebServlet("/c06/reserve")
public class Reserve extends HttpServlet {
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
		String prmCount = request.getParameter("count");
		String prmSeat = request.getParameter("seat");
		
		out.println(prmCount + "名様で" + prmSeat + "席のご予約を承りました。");
		String[] prmOption = request.getParameterValues("option");
		if (prmOption != null) {
			for (String s : prmOption ) {
			
				out.println("「" + s + "」");
			}
			out.println("をご用意します。");
		}
		
		
		//フッター出力
				Page.footer(out);
	}

}
