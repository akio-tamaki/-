package c11;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LifeCycle
 */
@WebServlet("/c11/life-cycle")
public class LifeCycle extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

		@Override
		public void init() throws ServletException {
			System.out.println("init");
		}
	
		public void serice(
				HttpServletRequest request, HttpServletResponse response
				)throws ServletException,IOException{
			System.out.println("service");
			super.service(request, response);
		}
		
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet");
	}
	@Override
	public void destroy() {
		System.out.println("destroy");
	}

}
