package c15;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Product;
import dao.ProductDAO;
import tool.Page;

/**
 * Servlet implementation class Search
 */
@WebServlet("/c15/search")
public class Search extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		Page.header(out);
		
		Connection con = null;
		PreparedStatement ps = null;
		
		try {
			// 商品テーブルDAOの生成
			ProductDAO dao = new ProductDAO();
			// Connectionオブジェクト取得
			con = dao.getConnection();

			String keyword = request.getParameter("keyword");
			List <Product> list = dao.search(con, keyword);
			
			if (list.size() > 0) {
				for (Product product : list) {
				
					out.println(product.getId());
					out.println(":");
					out.println(product.getName());
					out.println(":");
					out.println(product.getPrice());
					out.println("<br>");
				}			
			} else {
				// 検索結果が存在しない場合
				out.println("商品名が「" + keyword + "」に該当する商品情報は存在しません。");
			}
		
		// 例外発生時の処理
		} catch (Exception e) {
			e.printStackTrace();
						
		} finally {
			try {
				// コネクションの切断
				if (con != null) {
					con.close();
				}
			// 例外発生時の処理
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		Page.footer(out);
				
	}

}
