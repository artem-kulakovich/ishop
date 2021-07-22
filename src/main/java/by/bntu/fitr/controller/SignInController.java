package by.bntu.fitr.controller;

import by.bntu.fitr.constants.Constants;
import by.bntu.fitr.entity.Account;
import by.bntu.fitr.util.CookiesUtils;
import by.bntu.fitr.util.SessionUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "SignInController", urlPatterns = "/sign-in")
public class SignInController extends AbstractController {


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userName = request.getParameter("userName");
        String password = request.getParameter("password");
        String url = (String) request.getSession().getAttribute("url");
        request.getSession().setAttribute("url", null);


        Account account = getAccountService().getAccountByUserName(userName);
        if (account != null && account.getPassword().equals(password)) {
            SessionUtils.setCurrentAccount(account, request);
            CookiesUtils.setCookies(request, response);
            redirectToUrl(response, (url != null ? url : "/account"));
        } else {
            forwardToPage(request, response, "authorization.jsp");
        }
    }
}
