package by.bntu.fitr.controller;

import by.bntu.fitr.constants.Constants;
import by.bntu.fitr.entity.Category;
import by.bntu.fitr.entity.Product;
import by.bntu.fitr.model.Pagination;
import by.bntu.fitr.service.ProductService;
import by.bntu.fitr.service.impl.ProductServiceImpl;
import by.bntu.fitr.service.impl.ServiceManager;
import org.apache.catalina.Session;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet(name = "ProductController", urlPatterns = "/product")
public class ProductController extends AbstractController {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Product> productList = getProductService().getAllProducts(Constants.LIMIT_PRODUCT_PER_PAGE
                ,(Integer.parseInt(request.getParameter("page"))-1)*Constants.LIMIT_PRODUCT_PER_PAGE);
        request.setAttribute("productList",productList);
        forwardToPage(request, response, "catalog.jsp");
    }
}
