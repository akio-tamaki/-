package c05;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tool.Page;

/**
 * Servlet implementation class Form
 */
@WebServlet("/c05/form")
public class Form extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();

		// フォームよりデータを受信
				request.setCharacterEncoding("UTF-8");
				String name = request.getParameter("name");
				String gen = request.getParameter("gen");
				String address = request.getParameter("select");
				String[] hobby = request.getParameterValues("other");

				// 「性別」の出力形式
				String sex;
				if (gen.equals("M")) {
					sex = "男性";
				} else {
					sex = "女性";
				}

				// 「住所」の出力形式
				String address_jp;
				switch (address) {
				case "FU":
					address_jp = "福岡県";
					break;
				case "SA":
					address_jp = "佐賀県";
					break;
				case "KU":
					address_jp = "熊本県";
					break;
				default:
					address_jp = "";
				}

				// 「気になること」の出力形式
				String result = "";
				if (hobby != null) {
					for (String s : hobby) {
						switch (s) {
						case "0":
							result += "旅行";
							break;
						case "1":
							result += "映画";
							break;
						case "2":
							result += "釣り";
							break;
						default:
							result += "";
						}
						result += "・";
					}
					result = result.substring(0, result.length() - 1);
				} else {
					result = "なし";
				}

				// ヘッダー出力
				Page.header(out);

				// body要素
				out.println("<p>お名前：" + name + "</p>");
				out.println("<p>性別：" + sex + "</p>");
				out.println("<p>住所（都道府県）：" + address_jp + "</p>");
				out.println("<p>気になること：" + result + "</p>");

				// フッター出力
				Page.footer(out);
			}

		}
