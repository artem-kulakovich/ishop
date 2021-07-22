package by.bntu.fitr.controller;

import by.bntu.fitr.constants.Constants;
import by.bntu.fitr.util.CookiesUtils;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "SignOutController", urlPatterns = "/sign-out")
public class SignOutController extends AbstractController {


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getSession().setAttribute(Constants.USER, null);
        CookiesUtils.destroyCookie(request,response);
        redirectToUrl(response,"/main");
    }
}
