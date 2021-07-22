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

@WebServlet(name = "SendEmailController", urlPatterns = "/ajax/send-email")
public class SendEmailController extends AbstractAjaxController {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter printWriter = response.getWriter();
        try {
            MailSender mailSender = new MailSender();
            mailSender.sendMail(request.getParameter("email"), "Ishop registration", "Код авторизации\n\n",true);
            printWriter.write(mailSender.getUniqueCode());
        } catch (MessagingException e) {
            printWriter.write("Email not found");
            e.printStackTrace();
        }
    }


}
