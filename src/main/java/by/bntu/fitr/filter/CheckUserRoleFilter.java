package by.bntu.fitr.filter;

import by.bntu.fitr.constants.Constants;
import by.bntu.fitr.entity.Account;
import by.bntu.fitr.util.SessionUtils;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(filterName = "CheckUserRoleFilter")
public class CheckUserRoleFilter extends AbstractFilter {


    @Override
    public void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
        Account account = SessionUtils.getCurrentAccount(request);
        if (account.getRole().equals(Constants.ADMIN_ROLE)) {
            chain.doFilter(request, response);
        } else {
            response.sendRedirect("/main");
        }

    }


}
