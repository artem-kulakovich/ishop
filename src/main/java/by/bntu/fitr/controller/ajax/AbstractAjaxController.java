package by.bntu.fitr.controller.ajax;

import by.bntu.fitr.constants.Constants;
import by.bntu.fitr.form.ProductForm;
import by.bntu.fitr.service.*;
import by.bntu.fitr.service.impl.ServiceManager;
import org.json.JSONArray;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "AbstractAjaxController")
public abstract class AbstractAjaxController extends HttpServlet {
    private ProductService productService;
    private OrderService orderService;
    private AccountService accountService;
    private CommentService commentService;

    @Override
    public void init() throws ServletException {
        productService = ServiceManager.getInstance(getServletContext()).getProductService();
        orderService = ServiceManager.getInstance(getServletContext()).getOrderService();
        accountService = ServiceManager.getInstance(getServletContext()).getAccountService();
        commentService = ServiceManager.getInstance(getServletContext()).getCommentService();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    public ProductForm createProductForm(int id, int count) {
        return new ProductForm(id, count);
    }

    public ProductService getProductService() {
        return productService;
    }

    public OrderService getOrderService() {
        return orderService;
    }

    public AccountService getAccountService() {
        return accountService;
    }

    public CommentService getCommentService() {
        return commentService;
    }

    public void sendJsonResponse(HttpServletResponse response, JSONArray jsonArray) throws IOException {
        PrintWriter printWriter = response.getWriter();
        printWriter.write(jsonArray.toString());
    }

    public void forwardToPage(HttpServletRequest request, HttpServletResponse response, String page) throws ServletException, IOException {
        request.getRequestDispatcher(Constants.ROOT_PAGE_PATH + page).forward(request, response);
    }

    public void forwardToFragment(HttpServletRequest request, HttpServletResponse response, String fragment) throws ServletException, IOException {
        request.getRequestDispatcher(Constants.ROOT_FRAGMENT_PATH + fragment).forward(request, response);
    }


}
