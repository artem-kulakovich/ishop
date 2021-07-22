package by.bntu.fitr.filter;

import by.bntu.fitr.constants.Constants;
import by.bntu.fitr.controller.AbstractController;
import by.bntu.fitr.entity.Category;
import by.bntu.fitr.entity.Product;
import by.bntu.fitr.model.Pagination;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebFilter(filterName = "CategoryFilter")
public class CategoryFilter extends AbstractFilter {
    public void destroy() {
    }

    @Override
    public void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
        List<Category> countProductsInCategories = getCategoryService().getAllCategories();
        //List<Product> productList = getProductService().getAllProducts(Constants.LIMIT_PRODUCT_PER_PAGE,0);
        //request.setAttribute("productList", productList);
       // Pagination pagination = new Pagination();
        request.setAttribute("countProductsInCategories", countProductInCategories(countProductsInCategories));
        //request.getSession().setAttribute("pages", Pagination.getCountOfPage(getProductService().getCountOfProduct()));
        chain.doFilter(request,response);
    }


    private Map<Integer,Integer> countProductInCategories(List<Category> categoryList) {
        Map<Integer, Integer> countProductInCategories = new HashMap<>();
        for (int i = 0; i < categoryList.size(); i++) {
            countProductInCategories.put(categoryList.get(i).getId()
                    , getCategoryService().countProductInCategory(categoryList.get(i).getId()));
        }
        return countProductInCategories;

    }

}
