package by.bntu.fitr.controller;

import by.bntu.fitr.entity.Message;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "GetAllMessageController",urlPatterns = "/admin-panel/message/get-all-message")
public class GetAllMessageController extends AbstractController {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Message> messageList  = getMessageService().getAllMessage();
        request.setAttribute("messageList",messageList);
        forwardToPage(request,response,"admin-page/admin-message.jsp");
    }


}
