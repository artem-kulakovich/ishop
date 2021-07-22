package by.bntu.fitr.filter;

import by.bntu.fitr.constants.Constants;
import by.bntu.fitr.model.ShoppingCart;
import by.bntu.fitr.util.SessionUtils;

import javax.mail.Session;
import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(filterName = "ValidationCartFilter")
public class CheckValidationCartFilter extends AbstractFilter {

    @Override
    public void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
        ShoppingCart shoppingCart = SessionUtils.getCurrentShoppingCart(request);
        if (shoppingCart.getShoppingCart() == null || shoppingCart.getShoppingCart().size() == 0) {
            response.sendRedirect("/product?page=1");
        } else {
            chain.doFilter(request, response);
        }
    }


}
