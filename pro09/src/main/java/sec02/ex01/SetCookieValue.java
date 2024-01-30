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
		 // import java.util.Date;를 import함 /현재 시간을 보여줌 
		Cookie c = new Cookie("cookieTest", URLEncoder.encode("JSP프로그래밍입니다.","utf-8"));
		/*
		 *Cookie API(import javax.servlet.http.Cookie;)를 불러옴(import).
		 *1.Cookie 클래스의 인스턴스 'c'를 생성함
		 *2.생성자(new Cookie)에는 두개의 매개변수를 전달 
		 *	*쿠키의 이름(name)을 나타내는 문자열"cookieTest"로 설정함 
		 *	*쿠키의 값(value)을 "JSP프로그래밍입니다."로 하고 UTF-8 형식으로 설정함.
		 *		* URLEncoder.encode함수를 사용한 이유는 한글이나 특수 문자를 안전하게 처리하기 위함
		 */		
		c.setMaxAge(-1); // 세션 쿠키를 생성합니다.
		//c.setMaxAge(5); //24*60*60 은 24시간을 뜻한다. 현재는 5초 동안만 유지됨
		/*
		 * 쿠키의 종류에는 
		 * 	Persistence 쿠키 (파일로 저장, 파일 삭제or 설정 값(시간) 종료시 종료됨, 로그인 유무 or 팝업창 제한 때 사용)
		 *  Session 쿠키가 (브라우저 종류시 종류됨,사이트 접속 시 Session 인증 정보를 유지할때 사용) 있다.
		 * 
		 * 
		 */		response.addCookie(c); //생성된 쿠키를 브라우저로 전송함
		out.println("현재시간: "+d);
		out.println("<br> 문자열을 Cookie에 저장합니다.");
		
		
	
	
	}

}
