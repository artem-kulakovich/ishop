package by.bntu.fitr.controller;

import by.bntu.fitr.entity.Account;
import by.bntu.fitr.entity.Message;
import by.bntu.fitr.util.SessionUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "AccountMessageController", urlPatterns = "/account/message")
public class AccountMessageController extends AbstractController {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Account account = SessionUtils.getCurrentAccount(request);
        List<Message> messageList = getMessageService().getMessagesByAccountId(account.getId());
        request.setAttribute("messageList", messageList);
        request.setAttribute("url", "/WEB-INF/jsp/fragment/message.jsp");
        forwardToPage(request, response, "account.jsp");
    }


}
