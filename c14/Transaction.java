package c14;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.InitialContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import tool.Page;
import tool.SqlTools;

/**
 * Servlet implementation class Search
 */
@WebServlet("/c14/transaction")
public class Transaction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@SuppressWarnings({ "resource"})
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		// ヘッダー出力
		Page.header(out);
		
		Connection con = null;
		PreparedStatement ps = null;
		
		try {
			InitialContext ic = new InitialContext();
			// 
			DataSource ds = (DataSource) ic.lookup("java:/comp/env/jdbc/book");
			// コネクションを取得
			con = ds.getConnection();
			// オートコミットなし
			con.setAutoCommit(false);
			
			// パラメーター取得
			String name = request.getParameter("name");
			int price = Integer.parseInt(request.getParameter("price"));
			
			ps = con.prepareStatement(SqlTools.getSql("C14INSERT"));
			ps.setString(1, name);
			ps.setInt(2, price);
			ps.executeUpdate();
			
			ps = con.prepareStatement(SqlTools.getSql("C14SEARCH2"));
			ps.setString(1, name);
			ResultSet rs = ps.executeQuery();
			
			int line = 0;
			while (rs.next()) {
				line = rs.getInt("COUNT");
				
			}
			
			if (line == 1) {
				con.commit();
				out.println("商品を登録しました。");
			} else {
				con.rollback();
				out.println("商品はすでに登録されています。");
			}
						
			
		// 例外発生時の処理
		} catch (Exception e) {
			e.printStackTrace();
						
		} finally {
			try {
				// PreparedStatementの切断
				if (ps != null) {
					ps.close();
				}
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
