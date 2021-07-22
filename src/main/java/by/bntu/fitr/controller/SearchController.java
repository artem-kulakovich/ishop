package by.bntu.fitr.controller;

import by.bntu.fitr.constants.Constants;
import by.bntu.fitr.entity.Product;
import by.bntu.fitr.form.SearchForm;
import by.bntu.fitr.util.SearchingUtils;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet(name = "SearchController", urlPatterns = "/product/search")
public class SearchController extends AbstractController {


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        SearchForm searchForm = createSearchForm(request);
        int offset = (Integer.parseInt(request.getParameter("page")) - 1) * Constants.LIMIT_PRODUCT_PER_PAGE;
        List<Product> productList = SearchingUtils.SearchOption(getProductService()
                , searchForm, Constants.LIMIT_PRODUCT_PER_PAGE, offset);

        /*
        if (searchForm.getCategories().size()==0
                && (searchForm.getSearchingProduct() == null || searchForm.getSearchingProduct().isEmpty())) {
            productList = getProductService().getAllProducts(Constants.LIMIT_PRODUCT_PER_PAGE,offset);
        } else if (searchForm.getCategories().size() == 0 && searchForm.getSearchingProduct() != null) {
            productList = getProductService().getProductsByName(searchForm.getSearchingProduct()
                    ,Constants.LIMIT_PRODUCT_PER_PAGE,offset);
        } else if (searchForm.getCategories().size() != 0 && (searchForm.getSearchingProduct() == null || searchForm.getSearchingProduct().isEmpty())) {
            productList = getProductService().getProductsByCategories(searchForm.getCategories()
                    ,Constants.LIMIT_PRODUCT_PER_PAGE,offset);
        } else {
            productList = getProductService().getProductsBySearchingRequest(searchForm
                    ,Constants.LIMIT_PRODUCT_PER_PAGE,offset);
        }
         */

        request.setAttribute("searchForm", searchForm);
        request.setAttribute("productList", productList);
        forwardToPage(request, response, "catalog.jsp");
    }
}
