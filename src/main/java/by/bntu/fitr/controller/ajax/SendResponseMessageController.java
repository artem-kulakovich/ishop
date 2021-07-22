package by.bntu.fitr.controller.ajax;

import by.bntu.fitr.controller.AbstractController;
import by.bntu.fitr.entity.Account;
import by.bntu.fitr.model.MailSender;
import by.bntu.fitr.util.SessionUtils;

import javax.mail.MessagingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

@WebServlet(name = "SendResponseMessageController", urlPatterns = "/ajax/send-response-message")
public class SendResponseMessageController extends AbstractController {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter printWriter = response.getWriter();
        try {
            getMessageService().deleteMessageById(Integer.parseInt(request.getParameter("id")));
            MailSender mailSender = new MailSender();
            mailSender.sendMail(request.getParameter("email"), "Обратная связь", request.getParameter("msg"), false);
            printWriter.write("success");
        } catch (MessagingException e) {
            e.printStackTrace();
        }


    }

}
