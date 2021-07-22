package by.bntu.fitr.controller.ajax;

import by.bntu.fitr.constants.Constants;
import by.bntu.fitr.entity.Account;
import by.bntu.fitr.model.MailSender;
import by.bntu.fitr.util.SessionUtils;

import javax.mail.MessagingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "ChangePasswordController", urlPatterns = "/ajax/change-password")
public class ChangePasswordController extends AbstractAjaxController {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter printWriter = response.getWriter();
        String password = request.getParameter("password");
        String newPassword = request.getParameter("newPassword");

        Account account = SessionUtils.getCurrentAccount(request);
        if (password.equals(account.getPassword())) {
            getAccountService().changePassword(account.getId(), newPassword);
            try {
                MailSender mailSender = new MailSender();
                mailSender.sendMail(account.getEmail(), "Авторизация", "Пароль успешно сменен.\nВаш новый пароль - " + newPassword, false);
            } catch (MessagingException e) {
                e.printStackTrace();
            } finally {
                printWriter.write("success");
            }
        }
    }

}
