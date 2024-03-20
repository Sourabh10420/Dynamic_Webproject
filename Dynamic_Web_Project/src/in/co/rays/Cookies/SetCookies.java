package in.co.rays.Cookies;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Set")
public class SetCookies extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	
			String name = req.getParameter("login");
			String value = req.getParameter("password");

			Cookie c = new Cookie(name, value);
			c.setMaxAge(-1);
			resp.addCookie(c);
		}
	}

