package by.bntu.fitr.controller.ajax;

import by.bntu.fitr.model.MailSender;

import javax.mail.MessagingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "RegistrationAccountController", urlPatterns = "/ajax/registration-account")
public class RegistrationAccountController extends AbstractAjaxController {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter printWriter = response.getWriter();
        String userName = request.getParameter("userName");
        String code = request.getParameter("code");
        String uniqueCode = request.getParameter("uniqueCode");

        if (getAccountService().getAccountByUserName(userName) == null && code.equals(uniqueCode)) {
            String firstName = request.getParameter("firstName");
            String lastName = request.getParameter("lastName");
            String email = request.getParameter("email");
            String password = request.getParameter("password");
            getAccountService().addAccount(userName, firstName, lastName, email, password);

            try {
                MailSender mailSender = new MailSender();
                mailSender.sendMail(email, "Авторизация", "Добро пожаловать!\nВаш аккаунт - " + userName + "\nВаш пароль - " + password, false);
            } catch (MessagingException e) {
                e.printStackTrace();
            } finally {
                printWriter.write("success");
            }

        } else {
            printWriter.write("error");
        }
    }

}
