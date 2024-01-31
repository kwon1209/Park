package sec03.ex01;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

/**
 * Servlet Filter implementation class EncoderFilter
 */
// @WebFilter("/*")
public class EncoderFilter implements Filter {
	ServletContext context;

	public void init(FilterConfig fConfig) throws ServletException {
		System.out.println("utf-8 인코딩............");
		context = fConfig.getServletContext();

	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws ServletException, IOException {
		System.out.println("doFilter 호출");
		request.setCharacterEncoding("utf-8");
		String context = ((HttpServletRequest) request).getContextPath();
		String pathinfo = ((HttpServletRequest) request).getRequestURI();
		//String realPath = request.getRealPath(pathinfo);
		String realPath = request.getRealPath(pathinfo);
		String mesg = " Context  정보:" + context + "\n URI 정보 : " + pathinfo + "\n 물리적 경로:  " + realPath;
		System.out.println(mesg);

		long begin = System.currentTimeMillis(); 
		//Chain.doFilter() 메서드 위쪽에 있음으로 요청필터에서 처리전 시각  구함
		
		chain.doFilter(request, response);
		
		long end = System.currentTimeMillis();
		//Chain.doFilter() 메서드 밑에 있음으로 응답 필터에서 요청처리 후의 시각을 구함
		
		System.out.println("작업 시간:" + (end - begin) + "ms");
		//요청 처리 후 시각 - 처리 전 시각 = 요청 작업 시간을 구함
	}

	/**
	 * 
	 * 
	 * /**
	 * 
	 * @see Filter#destroy()
	 */
	public void destroy() {
		System.out.println("destroy 호출");
	}

}
