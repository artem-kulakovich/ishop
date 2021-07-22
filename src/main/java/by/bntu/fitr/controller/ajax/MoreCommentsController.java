package by.bntu.fitr.controller.ajax;

import by.bntu.fitr.constants.Constants;
import by.bntu.fitr.entity.Account;
import by.bntu.fitr.entity.Comment;
import by.bntu.fitr.json.JSONOHandlerFactory;
import by.bntu.fitr.model.CommentWrapper;

import org.json.JSONArray;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "MoreCommentsController", urlPatterns = "/ajax/more-comments")
public class MoreCommentsController extends AbstractAjaxController {


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int productId = Integer.parseInt(request.getParameter("productId"));
        int index = Integer.parseInt(request.getParameter("index"));
        List<Comment> commentList = getCommentService().getAllComment(productId, Constants.LIMIT_COMMENT_PER_PAGE, Constants.LIMIT_COMMENT_PER_PAGE * index);
        List<CommentWrapper> commentWrapperList = CommentWrapper.getCommentWrapperList(commentList,getAccountService());
        request.setAttribute("commentList",commentWrapperList);
        //JSONArray jsonArray = JSONOHandlerFactory.getJsonArray(JSONOHandlerFactory.commentJsonObjectHandler,commentWrapperList);
        //sendJsonResponse(response,jsonArray);
        request.setAttribute("commentList",commentWrapperList);
        forwardToFragment(request,response,"comment-list.jsp");
    }
}
