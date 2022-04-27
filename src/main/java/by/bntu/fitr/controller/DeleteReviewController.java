package by.bntu.fitr.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "DeleteReviewController", urlPatterns = "/product/reviews/delete-review")
public class DeleteReviewController extends AbstractController {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int commentId = Integer.parseInt(request.getParameter("commentId"));
        int productId = Integer.parseInt(request.getParameter("productId"));
        getCommentService().deleteCommentById(commentId);
        response.sendRedirect("/product/reviews?productId=" + productId);

    }
}
