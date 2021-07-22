package by.bntu.fitr.filter;

import by.bntu.fitr.model.ShoppingCart;
import by.bntu.fitr.util.SessionUtils;
import org.apache.catalina.Session;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebFilter(filterName = "RestoreCartFilter")
public class  RestoreCartFilter extends AbstractFilter{
    @Override
    public void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
        if(SessionUtils.getCurrentShoppingCart(request)==null){
            SessionUtils.setCurrentShoppingCart(new ShoppingCart(),request);
        }
        chain.doFilter(request,response);
    }
}
