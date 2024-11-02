package c14;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;

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
 * Servlet implementation class Insert
 */
@WebServlet("/c14/insert")
public class Insert extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
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
			DataSource ds = (DataSource) ic.lookup("java:/comp/env/jdbc/book");
			con = ds.getConnection();
			// パラメーター取得
			String name = request.getParameter("name");
			int price = Integer.parseInt(request.getParameter("price"));
			
			ps = con.prepareStatement(SqlTools.getSql("C14SEARCH2"));
			//String sql = SqlTools.getSql("C14INSERT");
			//ps = con.prepareStatement(sql);
			ps.setString(1, name);
			ps.setInt(2, price);
			int line = ps.executeUpdate();
			
			if (line > 0) {
				out.println("追加に成功しました。");
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
