package filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class EncodeFilter implements Filter{

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		//编码转换
				request.setCharacterEncoding("UTF-8");
				response.setContentType("text/html;charset=UTF-8");
				//后续操作
				//直接进入到下一流程
				chain.doFilter(request, response);
				
		
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

}
