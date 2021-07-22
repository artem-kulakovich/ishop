package by.bntu.fitr.controller.ajax;

import by.bntu.fitr.constants.Constants;
import by.bntu.fitr.controller.AbstractController;
import by.bntu.fitr.entity.Account;
import by.bntu.fitr.util.SessionUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "DeleteOrderController",urlPatterns = "/ajax/account/orders/delete-order")
public class DeleteOrderController extends AbstractAjaxController {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter printWriter = response.getWriter();
        int orderId = Integer.parseInt(request.getParameter("orderId"));
        Account account = SessionUtils.getCurrentAccount(request);
        getOrderService().deleteOrderById(orderId,account.getId());
        printWriter.write("success");
    }

}
