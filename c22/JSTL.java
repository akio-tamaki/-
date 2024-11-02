package c22;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Product;
import dao.ProductDAO;

/**
 * Servlet implementation class Attribute
 */
@WebServlet("/c22/jstl")
public class JSTL extends HttpServlet {
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		Connection con = null;

		try {
			// 商品テーブルDAOの生成
			ProductDAO dao = new ProductDAO();
			// コネクション取得
			con = dao.getConnection();
			List<Product> list = dao.search(con, "");

			request.setAttribute("list", list);
			request.getRequestDispatcher("jstl2.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace(out);
		} finally {
			// クローズ処理
			try {
				if (con != null) {
					// コネクションのクローズ
					con.close();
				}
			} catch (SQLException e) {
				e.printStackTrace(out);
			}
		}
	}

}
