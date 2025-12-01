package com.notifications.user_interface.config.filters;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import org.springframework.core.io.ClassPathResource;
import java.io.IOException;

public class SpaFallbackFilter implements Filter {

	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) res;
		String path = request.getRequestURI();

		if (path.startsWith("/api") || path.startsWith("/actuator") || path.contains(".")) {
			chain.doFilter(req, res);
			return;
		}

		ClassPathResource resource = new ClassPathResource("static" + path);
		if (resource.exists()) {
			chain.doFilter(req, res);
			return;
		}

		request.getRequestDispatcher("/index.html").forward(request, response);
	}
}