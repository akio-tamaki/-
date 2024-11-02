package c19;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tool.Page;

/**
 * Servlet implementation class File
 */
@WebServlet("/c19/attribute2")
public class Attribute2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		// ヘッダー出力
		Page.header(out);
		// ServletContextオブジェクト取得
		ServletContext context = getServletContext();
		// アプリケーション属性名一覧を取得し、String型リストに代入
		List<String> list = Collections.list(context.getAttributeNames());
		// 取得したリストを拡張for文で処理		
		for (String name : list) {
			// 取り出した属性名に対応する値をgetAttributeメソッドで取得し、出力
			out.println("<p>" + name + " : " + context.getAttribute(name) + "</p>");
		}
		// フッター出力
		Page.footer(out);
	}

}
