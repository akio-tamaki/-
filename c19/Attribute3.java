package c19;

import java.io.IOException;
import java.io.PrintWriter;

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
@WebServlet("/c19/attribute3")
public class Attribute3 extends HttpServlet {
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
		// 属性名debugを取得し、文字列(String)に変換
		String debug = (String) context.getAttribute("debug");
		// 値がyesならば、文字出力
		if (debug.equals("yes")) {
			out.println("<p>デバッグモードで実行します。</p>");
		}
		// 属性名memoryを取得し、IntegerクラスのparseIntメソッドを使用し整数intに変換
		int memory = Integer.parseInt((String) context.getAttribute("memory"));
		// 値が1000000よりも小さければ、文字出力
		if (memory < 1000000) {
			out.println("<p>省メモリモードで実行します。</p>");
		}
		// フッター出力
		Page.footer(out);
	}

}
