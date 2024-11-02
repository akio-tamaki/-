package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import bean.Product;
import tool.SqlTools;

/**
 * 商品テーブルDAO
 * @author c3user
 *
 */

public class ProductDAO extends DAO {

	/**
	 * 商品テーブルデータ検索メソッド
	 * @param con			コネクション
	 * @param keyword		検索キーワード
	 * @return				商品情報リスト
	 * @throws Exception	Exception例外
	 */
	public List<Product> search(Connection con, String keyword) throws Exception {
	
		List <Product> list = new ArrayList<>();
	
		// PreparedStatementオブジェクト取得
		PreparedStatement ps = con.prepareStatement(SqlTools.getSql("C14SEARCH"));
		ps.setString(1, "%" + keyword + "%");
		// ResultSetオブジェクトの取得
		ResultSet rs = ps.executeQuery();
				
		// 検索結果を判断し、存在する場合、すべてレスポンスに設定する
		while (rs.next()) {
			// Productクラスのオブジェクト生成
			Product product = new Product();
			// 商品番号を取得
			product.setId(rs.getInt("ID"));
			// 商品名を取得
			product.setName(rs.getString("NAME"));
			// 価格を取得
			product.setPrice(rs.getInt("PRICE"));
			// 商品情報リストに追加			
			list.add(product);
		}
			
		// PreparedStatementのクローズ処理
		ps.close();
		// 戻り値（商品情報リスト）返却	
		return list;
	}
		
	/**
	 * 商品テーブルデータ新設メソッド
	 * @param con			コネクション
	 * @param product		商品情報
	 * @return				新設件数
	 * @throws Exception	Exception例外
	 */
	public int insert(Connection con, Product product) throws Exception {
		
		// PreparedStatementオブジェクト取得
		PreparedStatement ps = con.prepareStatement(SqlTools.getSql("C14INSERT"));
		ps.setString(1, product.getName());
		ps.setInt(2, product.getPrice());
		// 新設件数取得			
		int line = ps.executeUpdate();
		// PreparedStatementのクローズ処理
		ps.close();
		// 戻り値（新設件数）返却
		return line;
		
	}
}
