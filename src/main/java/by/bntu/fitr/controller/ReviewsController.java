package by.bntu.fitr.controller;

import by.bntu.fitr.constants.Constants;
import by.bntu.fitr.entity.Account;
import by.bntu.fitr.entity.Comment;
import by.bntu.fitr.entity.Product;
import by.bntu.fitr.model.CommentWrapper;
import by.bntu.fitr.util.SessionUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "ReviewsController", urlPatterns = "/product/reviews")
public class ReviewsController extends AbstractController {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Account account = SessionUtils.getCurrentAccount(request);
        if (account == null) {
            redirectToUrl(response, "/account");
        } else {
            int productId = Integer.parseInt(request.getParameter("productId"));
            getCommentService().addComment(account.getId(), productId, request.getParameter("text"));
            redirectToUrl(response, "/product/reviews?productId=" + productId);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int productId = Integer.parseInt(request.getParameter("productId"));
        Product product = getProductService().getProductById(productId);
        List<Comment> commentList = getCommentService().getAllComment(productId, Constants.LIMIT_COMMENT_PER_PAGE, 0);
        List<CommentWrapper> commentWrapperList = CommentWrapper
                .getCommentWrapperList(commentList, getAccountService());
        request.setAttribute("commentList", commentWrapperList);
        request.setAttribute("product", product);
        forwardToPage(request, response, "reviews.jsp");
    }
}
