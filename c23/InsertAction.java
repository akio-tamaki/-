package c23;

import java.sql.Connection;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Product;
import dao.ProductDAO;
import tool.Action;


/**
 * 商品情報追加クラス
 * @author c3user
 *
 */
public class InsertAction extends Action {
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		// Connectionオブジェクト定義
		Connection con = null;
		
		try {
			// リクエストパラメーター取得(商品名nameと価格price)
			String name = request.getParameter("name");
			int price = Integer.parseInt(request.getParameter("price"));
			
			// 商品テーブルDAOの生成
			ProductDAO dao = new ProductDAO();
			// コネクションの取得
			con = dao.getConnection();
			// オートコミットなし
			con.setAutoCommit(false);
			// オブジェクト取得し、商品名と価格を設定する
			Product product = new Product();
			product.setName(name);
			product.setPrice(price);
			// 新設件数取得	
			dao.insert(con, product);
			// コミット
			con.commit();
			
			// 商品情報検索
			List<Product> list = dao.search(con, "");
			// リクエスト属性にリストを設定
			request.setAttribute("list", list);
		
		} catch (Exception e) {
			// ロールバック
			con.rollback();
			throw e;
		
		} finally {
			// コネクションのクローズ処理
			if (con != null) {
				con.close();
			}
		
		}
	
		// フォワード先であるlist.jspに返す
		return "list.jsp";
		
	}
		
}
