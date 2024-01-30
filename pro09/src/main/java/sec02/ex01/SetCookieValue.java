package sec02.ex01;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SetCookieValue
 */
@WebServlet("/set")
public class SetCookieValue extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		Date d = new Date();
		 // import java.util.Date;�� import�� /���� �ð��� ������ 
		Cookie c = new Cookie("cookieTest", URLEncoder.encode("JSP���α׷����Դϴ�.","utf-8"));
		/*
		 *Cookie API(import javax.servlet.http.Cookie;)�� �ҷ���(import).
		 *1.Cookie Ŭ������ �ν��Ͻ� 'c'�� ������
		 *2.������(new Cookie)���� �ΰ��� �Ű������� ���� 
		 *	*��Ű�� �̸�(name)�� ��Ÿ���� ���ڿ�"cookieTest"�� ������ 
		 *	*��Ű�� ��(value)�� "JSP���α׷����Դϴ�."�� �ϰ� UTF-8 �������� ������.
		 *		* URLEncoder.encode�Լ��� ����� ������ �ѱ��̳� Ư�� ���ڸ� �����ϰ� ó���ϱ� ����
		 */		
		c.setMaxAge(-1); // ���� ��Ű�� �����մϴ�.
		//c.setMaxAge(5); //24*60*60 �� 24�ð��� ���Ѵ�. ����� 5�� ���ȸ� ������
		/*
		 * ��Ű�� �������� 
		 * 	Persistence ��Ű (���Ϸ� ����, ���� ����or ���� ��(�ð�) ����� �����, �α��� ���� or �˾�â ���� �� ���)
		 *  Session ��Ű�� (������ ������ ������,����Ʈ ���� �� Session ���� ������ �����Ҷ� ���) �ִ�.
		 * 
		 * 
		 */		response.addCookie(c); //������ ��Ű�� �������� ������
		out.println("����ð�: "+d);
		out.println("<br> ���ڿ��� Cookie�� �����մϴ�.");
		
		
	
	
	}

}
