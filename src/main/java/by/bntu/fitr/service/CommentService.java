package by.bntu.fitr.service;

import by.bntu.fitr.entity.Comment;

import java.util.List;

public interface CommentService {
    public void addComment(int accountId,int productId,String text);
    public List<Comment> getAllComment(int productId,int limit,int offset);
    public void deleteCommentById(int id);
}
