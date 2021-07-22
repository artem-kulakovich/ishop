package by.bntu.fitr.controller;

import by.bntu.fitr.constants.Constants;
import by.bntu.fitr.entity.Account;
import by.bntu.fitr.util.SessionUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "FeedBackController", urlPatterns = "/main/send-feedback")
public class FeedBackController extends AbstractController {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Account account = SessionUtils.getCurrentAccount(request);
        getMessageService().addMessage(account.getId(), request.getParameter("msg")
                , account.getEmail(), account.getUserName());
        redirectToUrl(response, "/main");
    }
}
