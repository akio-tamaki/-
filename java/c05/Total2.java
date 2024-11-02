package c05;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tool.Page;

/**
 * Servlet implementation class Total2
 */
@WebServlet("/c05/total2")
public class Total2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset = UTF-8");
		PrintWriter out = response.getWriter();
		
		try {
			request.setCharacterEncoding("UTF-8");
			int prmPrice = Integer.parseInt(request.getParameter("price"));
			int prmCount = Integer.parseInt(request.getParameter("count"));
			int prmDelivery = Integer.parseInt(request.getParameter("delivery"));
			
			int total = (prmPrice * prmCount) + prmDelivery;
			
			//ヘッダー出力
			Page.header(out);
			
			out.println("<p>" + prmPrice + "円×" + prmCount + "個＋" + "送料" + prmDelivery + "円＝" +total + "円</p>");
			//フッター出力
			Page.footer(out);
		} catch (NumberFormatException e) {
			out.println("数値を入力してください");
		}
		
	}

}
