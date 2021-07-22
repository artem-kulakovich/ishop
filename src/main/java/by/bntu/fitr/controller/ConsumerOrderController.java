package by.bntu.fitr.controller;

import by.bntu.fitr.constants.Constants;
import by.bntu.fitr.entity.Account;
import by.bntu.fitr.entity.Order;
import by.bntu.fitr.util.SessionUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ConsumerOrderController", urlPatterns = "/account/orders")
public class ConsumerOrderController extends AbstractController {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Account account = SessionUtils.getCurrentAccount(request);
        List<Order> orderList = getOrderService().getOrdersByConsumer(account.getId());
        request.setAttribute("orderList", orderList);
        request.setAttribute("url","/WEB-INF/jsp/fragment/order-list.jsp");
        forwardToPage(request,response,"account.jsp");
    }


}
