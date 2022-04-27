package by.bntu.fitr.controller.ajax;

import by.bntu.fitr.entity.Account;
import by.bntu.fitr.model.MailSender;
import by.bntu.fitr.model.OrderHandler;
import by.bntu.fitr.model.ShoppingCart;
import by.bntu.fitr.util.SessionUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "MakeOrderController", urlPatterns = "/ajax/make-order")
public class MakeOrderController extends AbstractAjaxController {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ShoppingCart shoppingCart = SessionUtils.getCurrentShoppingCart(request);
        Account account = SessionUtils.getCurrentAccount(request);
        PrintWriter printWriter = response.getWriter();

        OrderHandler orderHandler = new OrderHandler(shoppingCart, account);
        try {
            getOrderService().makeOrder(orderHandler);
            MailSender mailSender = new MailSender();
            mailSender.sendMail(account.getEmail(), "Заказ успешно обработан", orderHandler.getInfo(), false);
            SessionUtils.updateShoppingCart(shoppingCart,request);
            printWriter.write("success");
        } catch (Exception e) {
            printWriter.write("error");
            e.printStackTrace();
        }
    }
}
