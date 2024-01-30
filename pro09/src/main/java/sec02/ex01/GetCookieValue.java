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
			/*request 의 getCookiese()메서드를 호출해 브라우저에게 쿠키 정보를 요청한 후 쿠키 정보를 배열로 가져옴
			 * 	여기서 배열로 가져온 이유는 여러 개의 쿠키가 동시에 전송될 수 있기 때문
			 * 
			 */
			
			for(int i=0; i<allValues.length; i++) {
				if(allValues[i].getName().equals("cookieTest")) {
					out.println("<h2>Cookie 값 가져오기:" + 
								URLDecoder.decode(allValues[i].getValue(),"utf-8"));
				}//배열에서 저장할 때 사용한 쿠키 이름인 cookieTest로 검색해 쿠키 값을 가져옵니다.
				
				/*
				 * allValues 배열에 저장된 모든 쿠키를 반복하면서 각 쿠키의 이름이 "cookieTest"인지 확인합니다. 만약 이름이
				 * "cookieTest"인 쿠키를 찾으면, 해당 쿠키의 값을 UTF-8 형식으로 디코딩합니다. 디코딩한 값을 HTML로 출력합니다. 이
				 * 코드는 주로 특정 쿠키를 찾아 그 값을 화면에 표시하는 용도로 사용될 수 있습니다. 여기서는 "cookieTest"라는 이름을 가진 쿠키의
				 * 값을 출력하는 예시입니다
				 */
				
			}
	
	
	
	}

}
