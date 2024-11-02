package c04;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tool.Page;

/**
 * Servlet implementation class Hello5
 */
@WebServlet("/c04/hello5")
public class Hello5 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out=response.getWriter();
		LocalDateTime dt = LocalDateTime.of(2023, 10, 31, 11, 15);
        /**String time = dt.getYear() + "年" +
    		   dt.getMonthValue() + "月" +
    		   dt.getDayOfMonth() + "日" +
    		   dt.getHour() + "時" +
    		   dt.getMinute() + "分";
         */
         		
		Page.header(out);
		
		// body要素
				// 「現在の日時」出力内容（日時固定）
				String ldate = LocalDate.of(2023, 10, 31).format(DateTimeFormatter.ofPattern("Y年LL月dd日"));
				String ltime = LocalTime.of(11, 15).format(DateTimeFormatter.ofPattern("KK時mm分"));
				// 「現在の日時」出力内容（日時可変）
				/*
				LocalDateTime ldt = LocalDateTime.now();
				String ldate = ldt.format(DateTimeFormatter.ofPattern("Y年LL月dd日"));
				String ltime = ldt.format(DateTimeFormatter.ofPattern("KK時mm分"));
				*/

		
		out.println("<p>Congraturations!</p>");
		out.println("<p>おめでとう！</p>");
		out.println( "現在の日時：" + ltime);
		
		Page.footer(out);
	}

}
