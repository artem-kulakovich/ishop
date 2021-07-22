package by.bntu.fitr.filter;

import by.bntu.fitr.service.AccountService;
import by.bntu.fitr.service.CategoryService;
import by.bntu.fitr.service.ProductService;
import by.bntu.fitr.service.impl.ServiceManager;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public abstract class AbstractFilter implements Filter {
    private CategoryService categoryService;
    private ProductService productService;
    private AccountService accountService;

    public void destroy() {
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        HttpServletResponse httpServletResponse = (HttpServletResponse) response;
        doFilter(httpServletRequest, httpServletResponse, chain);
    }

    public abstract void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException;

    public void init(FilterConfig config) throws ServletException {
        categoryService = ServiceManager.getInstance(config.getServletContext()).getCategoryService();
        productService = ServiceManager.getInstance(config.getServletContext()).getProductService();
        accountService = ServiceManager.getInstance(config.getServletContext()).getAccountService();
    }

    public CategoryService getCategoryService() {
        return categoryService;
    }

    public ProductService getProductService() {
        return productService;
    }

    public AccountService getAccountService() {
        return accountService;
    }
}
