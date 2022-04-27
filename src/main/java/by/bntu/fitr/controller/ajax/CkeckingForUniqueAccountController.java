package by.bntu.fitr.controller.ajax;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "CkeckingForUniqueAccountController", urlPatterns = "/ajax/check-duplicate-users")
public class CkeckingForUniqueAccountController extends AbstractAjaxController {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter printWriter = response.getWriter();
        String userName = request.getParameter("userName");
        if (getAccountService().getAccountByUserName(userName) == null) {
            printWriter.write("0");
        } else {
            printWriter.write("1");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
