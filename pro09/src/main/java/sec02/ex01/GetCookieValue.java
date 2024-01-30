package sec02.ex01;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class GetCookieValue
 */
@WebServlet("/get")
public class GetCookieValue extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		response.setContentType("Text/html; charset=utf-8");
			PrintWriter out = response.getWriter();
			Cookie[] allValues = request.getCookies();
			/*request �� getCookiese()�޼��带 ȣ���� ���������� ��Ű ������ ��û�� �� ��Ű ������ �迭�� ������
			 * 	���⼭ �迭�� ������ ������ ���� ���� ��Ű�� ���ÿ� ���۵� �� �ֱ� ����
			 * 
			 */
			
			for(int i=0; i<allValues.length; i++) {
				if(allValues[i].getName().equals("cookieTest")) {
					out.println("<h2>Cookie �� ��������:" + 
								URLDecoder.decode(allValues[i].getValue(),"utf-8"));
				}//�迭���� ������ �� ����� ��Ű �̸��� cookieTest�� �˻��� ��Ű ���� �����ɴϴ�.
				
				/*
				 * allValues �迭�� ����� ��� ��Ű�� �ݺ��ϸ鼭 �� ��Ű�� �̸��� "cookieTest"���� Ȯ���մϴ�. ���� �̸���
				 * "cookieTest"�� ��Ű�� ã����, �ش� ��Ű�� ���� UTF-8 �������� ���ڵ��մϴ�. ���ڵ��� ���� HTML�� ����մϴ�. ��
				 * �ڵ�� �ַ� Ư�� ��Ű�� ã�� �� ���� ȭ�鿡 ǥ���ϴ� �뵵�� ���� �� �ֽ��ϴ�. ���⼭�� "cookieTest"��� �̸��� ���� ��Ű��
				 * ���� ����ϴ� �����Դϴ�
				 */
				
			}
	
	
	
	}

}
