package by.bntu.fitr.filter;

import by.bntu.fitr.constants.Constants;
import by.bntu.fitr.entity.Account;
import by.bntu.fitr.util.CookiesUtils;

import javax.mail.Session;
import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(filterName = "AuthorizationFilter")
public class CheckAuthorizationFilter extends AbstractFilter {


    @Override
    public void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
        Cookie cookie = CookiesUtils.getCookies(request, response);
        if (cookie != null) {
            Account account = getAccountService().getAccountByUserName(cookie.getValue());
            request.getSession().setAttribute(Constants.USER, account);
        }

        request.getSession().setAttribute("url", request.getRequestURI() +
                (request.getQueryString() == null ? "" : "?" + request.getQueryString()));

        if (request.getSession().getAttribute(Constants.USER) == null) {
            request.getRequestDispatcher(Constants.ROOT_PAGE_PATH + "authorization.jsp").forward(request, response);
        } else {
            chain.doFilter(request, response);
        }
    }


}
