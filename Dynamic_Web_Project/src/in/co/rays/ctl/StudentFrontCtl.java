package in.co.rays.ctl;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebFilter(filterName = "StudentFrontCtl", urlPatterns = "*.SM")
public class StudentFrontCtl  implements Filter {
	

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;

		HttpSession session = req.getSession();
		
		String uri =req.getRequestURI();
		
		System.out.println("uri =>" + uri);
		
	if (session.getAttribute("admin") == null) {
		
			req.setAttribute("error", "Session expired...plz login again..!!");
			
			req.setAttribute("uri", uri);
			
			RequestDispatcher rd = req.getRequestDispatcher("StudentLoginView.jsp");
			rd.forward(req, resp);
		} else {
			chain.doFilter(request, response);
		}

	}

	@Override
	public void destroy() {

	}

}
