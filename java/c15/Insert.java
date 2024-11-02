package c15;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Product;
import dao.ProductDAO;
import tool.Page;

/**
 * Servlet implementation class Insert
 */
@WebServlet("/c15/insert")
public class Insert extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@SuppressWarnings({ "null", "unused" })
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		// ヘッダー出力
		Page.header(out);
		// コネクションを取得
		Connection con = null;
		
		try {
			// 商品テーブルDAOの生成
			ProductDAO dao = new ProductDAO();
			// コネクションを取得
			con = dao.getConnection();
			// オートコミットなし
			con.setAutoCommit(false);
			// パラメーター取得
			String name = request.getParameter("name");
			int price =Integer.parseInt(request.getParameter("price"));
			// オブジェクト取得し、商品名と価格を設定する
			Product product = new Product();
			product.setName(name);
			product.setPrice(price);
			
			int line = dao.insert(con, product);
			
			if (line > 0) {
				// コミットする
				con.commit();
				out.println("追加に成功しました。");
			}
			
		} catch (Exception e) {
			e.printStackTrace(out);
			
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
