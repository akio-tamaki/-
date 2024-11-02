package c19;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Properties;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
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
@WebServlet("/c19/attribute4")
public class Attribute4 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	/**
	 * @see Servlet#init(ServletConfig)
	 */
	@Override
	public void init() throws ServletException {
		try {
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
			for (String name : p.stringPropertyNames()) {
				context.setAttribute(name, p.getProperty(name));
			}
		} catch (IOException e) {
			throw new ServletException("ファイルの読み込みに失敗しました。");
		}
	}
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		// ヘッダー出力
		Page.header(out);
		
		out.println("アプリケーション属性を設定しました。");
		
		// フッター出力
		Page.footer(out);
	}

}
