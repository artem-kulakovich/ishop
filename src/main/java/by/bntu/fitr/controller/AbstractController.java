package by.bntu.fitr.controller;

import by.bntu.fitr.constants.Constants;
import by.bntu.fitr.form.ProductForm;
import by.bntu.fitr.form.SearchForm;
import by.bntu.fitr.model.Pagination;
import by.bntu.fitr.service.*;
import by.bntu.fitr.service.impl.ServiceManager;
import org.json.JSONArray;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


public abstract class AbstractController extends HttpServlet {
    private ProductService productService;
    private CategoryService categoryService;
    private OrderService orderService;
    private AccountService accountService;
    private MessageService messageService;
    private CommentService commentService;

    @Override
    public void init() throws ServletException {
        productService = ServiceManager.getInstance(getServletContext()).getProductService();
        categoryService = ServiceManager.getInstance(getServletContext()).getCategoryService();
        orderService = ServiceManager.getInstance(getServletContext()).getOrderService();
        accountService = ServiceManager.getInstance(getServletContext()).getAccountService();
        messageService = ServiceManager.getInstance(getServletContext()).getMessageService();
        commentService = ServiceManager.getInstance(getServletContext()).getCommentService();
    }

    public ProductService getProductService() {
        return productService;
    }

    public CategoryService getCategoryService() {
        return categoryService;
    }

    public void forwardToPage(HttpServletRequest request, HttpServletResponse response, String page) throws ServletException, IOException {
        request.getRequestDispatcher(Constants.ROOT_PAGE_PATH + page).forward(request, response);
    }

    public void forwardToFragment(HttpServletRequest request, HttpServletResponse response, String fragment) throws ServletException, IOException {
        request.getRequestDispatcher(Constants.ROOT_FRAGMENT_PATH + fragment).forward(request, response);
    }

    public void redirectToUrl(HttpServletResponse response, String url) throws IOException {
        response.sendRedirect(url);
    }

    public OrderService getOrderService() {
        return orderService;
    }

    public SearchForm createSearchForm(HttpServletRequest request) {
        return new SearchForm(request.getParameterValues("category")
                , request.getParameter("search"));
    }

    public ProductForm createProductForm(HttpServletRequest request) {
        if (request.getParameter("product_count") == null) {
        }
        return new ProductForm(Integer.parseInt(request.getParameter("product_id")), 1);
    }

    public AccountService getAccountService() {
        return accountService;
    }

    public MessageService getMessageService() {
        return messageService;
    }

    public CommentService getCommentService() {
        return commentService;
    }
}
