package c19;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Properties;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tool.Page;

/**
 * Servlet implementation class File
 */
@WebServlet("/c19/file")
public class File extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		// ヘッダー出力
		Page.header(out);
		// ServletContextオブジェクト取得
		ServletContext context = getServletContext();
		// getRealPathメソッドによりサーバ上のパスを取得
		String path = context.getRealPath("/WEB-INF/setting.txt");
		
		// 取得したパスを使用し、FileInputStreamオブジェクトを作成
		FileInputStream in = new FileInputStream(path);
		// Propertiesクラスの生成
		Properties p = new Properties();
		// loadメソッドを使用し、ファイルのを読み込む
		p.load(in);
		in.close();
		
		for (String key : p.stringPropertyNames()) {
			out.println("<p>" + key + " : " + p.getProperty(key) + "</p>");
		}
		// フッター出力
		Page.footer(out);
	}

}
