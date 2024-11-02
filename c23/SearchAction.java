package c23;

import java.sql.Connection;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Product;
import dao.ProductDAO;
import tool.Action;


/**
 * 商品情報検索クラス
 * @author c3user
 *
 */
public class SearchAction extends Action {
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		// Connectionオブジェクト定義
		Connection con = null;
		
		try {
			// search.jspから入力された検索キーワードをリクエストパラメーターから取得
			String keyword = request.getParameter("keyword");
			// 商品テーブルDAOの生成
			ProductDAO dao = new ProductDAO();
			// コネクション取得
			con = dao.getConnection();
			List<Product> list = dao.search(con, keyword);
			// リクエスト属性にリストを設定
			request.setAttribute("list", list);
		
		} finally {
			// コネクションの切断
			if (con != null) {
				con.close();
			}
		}	
		
		return "list.jsp";
		
	}
		
}
