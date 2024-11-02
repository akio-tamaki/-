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
 * Servlet implementation class Select
 */
@WebServlet("/c06/select")
public class Select extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		request.setCharacterEncoding("UTF-8");
		String prmCount = request.getParameter("count");
		String prmPayment = request.getParameter("payment");
		String prmReview = request.getParameter("review");
		String prmMail = request.getParameter("mail");
		
		//ヘッダー出力
		Page.header(out);
		out.println("<p>" + prmCount + "個の商品をカートに入れました。</p>");
		out.println("<p>お支払い方法を " + prmPayment + "に設定しました。</p>");
		out.println("<p> ご感想ありがとうございます。</p>");
		out.println("<p>「" + prmReview + "」</p>");
		if ("1".equals(prmMail)) {
			out.println("<p>メールをお送ります。</p>");
		} else {
			out.println("<p>メールをお送りしません。</p>");
		}
		//フッター出力
		Page.footer(out);
	}

}
