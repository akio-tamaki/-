package c16;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Product;

/**
 * Servlet implementation class Attribute
 */
@WebServlet("/c16/attribute")
public class Attribute extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 商品情報の生成
		Product product = new Product();
		// 商品番号
		product.setId(1);
		// 商品名
		product.setName("まぐろ");
		// 価格
		product.setPrice(100);
		
		request.setAttribute("product", product);
		request.getRequestDispatcher("attribute.jsp").forward(request, response);
	
	}

}
