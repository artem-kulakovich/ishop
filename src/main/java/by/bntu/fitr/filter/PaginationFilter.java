package by.bntu.fitr.filter;

import by.bntu.fitr.constants.Constants;
import by.bntu.fitr.form.SearchForm;
import by.bntu.fitr.model.Pagination;
import by.bntu.fitr.service.ProductService;
import by.bntu.fitr.service.impl.ServiceManager;
import by.bntu.fitr.util.SearchingUtils;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@WebFilter(filterName = "PaginationFilter")
public class PaginationFilter extends AbstractFilter {
    public void destroy() {
    }

    @Override
    public void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
        Pagination pagination = new Pagination(request.getRequestURI()
                , request.getParameterValues("category")
                , request.getParameter("search"));

        SearchForm searchForm = new SearchForm(request.getParameterValues("category")
                , request.getParameter("search"));

        Map<Integer, String> pages = pagination.getPages(SearchingUtils.SearchOption(getProductService()
                ,searchForm,getProductService().getCountOfProduct("SELECT *FROM product"),0).size());

        request.setAttribute("pages", pages);
        chain.doFilter(request, response);
    }
}
