package bean;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Product;
import tool.Page;

/**
 * Servlet implementation class Bean
 */
@WebServlet("/bean/bean")
public class Bean extends HttpServlet {
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
		// Productクラスのオブジェクト生成
		Product product = new Product();
		
		product.setId(1);
		product.setName("まぐろ");
		product.setPrice(100);
		
		out.println(product.getId());
		out.println(":");
		out.println(product.getName());
		out.println(":");
		out.println(product.getPrice());
		
		// フッター出力
		Page.footer(out);
	
	}

}
