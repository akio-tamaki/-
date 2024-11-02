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
 * Servlet implementation class All
 */
@WebServlet("/c14/all2")
public class All2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		Page.header(out);
		
		Connection con = null;
		PreparedStatement ps = null;
		
		try {
			
			// InitialContextオブジェクト取得
			InitialContext ic = new InitialContext();
			// DataSourceオブジェクト取得
			DataSource ds = (DataSource) ic.lookup("java:/comp/env/jdbc/book");
			// コネクションを取得
			con = ds.getConnection();
			// コネクションからPreparedStatementオブジェクト取得
			ps = con.prepareStatement(SqlTools.getSql("C14ALL"));
			// SQL文を実行して検索結果取得
			ResultSet rs = ps.executeQuery();

			// 検索結果を判断し、存在する場合。すべてレスポンスに設定する
			while (rs.next()) {
				// 商品番号を取得
				out.println(rs.getInt("ID"));
				out.println(":");
				// 商品名を取得
				out.println(rs.getString("NAME"));
				out.println(":");
				// 価格を取得
				out.println(rs.getInt("PRICE"));
				out.println("<br>");

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

