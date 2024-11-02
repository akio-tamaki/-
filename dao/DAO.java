package dao;

import java.sql.Connection;

import javax.naming.InitialContext;
import javax.sql.DataSource;


public class DAO {
	/** データソース　*/
	private static DataSource ds;
	/** 
	 * コネクション取得
	 * @return		コネクション
	 * @throws Exception	予期せぬ例外
	 */
	public Connection getConnection() throws Exception {
		// データソースを取得
		if (ds == null) {
			// フィールドのデータソースが未設定の場合、データソースを取得して、フィールドに設定する。
			// InitialContexオブジェクト取得
			InitialContext ic = new InitialContext();
			// DataSourceオブジェクト取得
			ds = (DataSource) ic.lookup("java:/comp/env/jdbc/book");
			
		}
		//コネクションを取得
		return ds.getConnection();
		
	}
	
}
