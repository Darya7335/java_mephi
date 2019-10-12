package com.darya7335.web;

import javax.servlet.annotation.WebFilter;
import java.io.IOException;
import javax.servlet.http.Cookie;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebFilter(filterName = "ServletFilter")
public class ServletFilter implements Filter {
    private SingltoneSet setId;

    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest httpReq = (HttpServletRequest) req;
        HttpServletResponse httpResp = (HttpServletResponse) resp;
        Cookie[] cookies = httpReq.getCookies();
        String cookieValue = "";
        String[] address = httpReq.getRequestURI().split("/");
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("sessionId")) {
                    cookieValue = cookie.getValue();
                }
            }
        }
        if (setId.containsSessionId(cookieValue)) {
            httpReq.getRequestDispatcher("/hello_inside.jsp").forward(req, resp);
        } else {

            if (address.length != 0 && address[address.length - 1] != null) {

                if (address[address.length - 1].equals("hello_inside.html") || address[address.length - 1].equals("hello_inside.jsp")) {
                    httpResp.sendRedirect(httpReq.getContextPath() + "/count_to_get_in.html");
                } else {
                    chain.doFilter(req, resp);
                }

            }

        }
    }

    public void init(FilterConfig config) throws ServletException {
        setId = SingltoneSet.getInstance();     //инициализировали setId
    }

}

