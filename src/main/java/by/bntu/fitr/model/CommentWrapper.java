package by.bntu.fitr.model;

import by.bntu.fitr.entity.Account;
import by.bntu.fitr.entity.Comment;
import by.bntu.fitr.service.AccountService;

import java.util.ArrayList;
import java.util.List;

public class CommentWrapper {
    private String userName;
    private String email;
    private String created;
    private int accountId;
    private int productId;
    private String text;
    private int id;

    public CommentWrapper(Account account, Comment comment) {
        userName = account.getUserName();
        id = comment.getId();
        accountId = comment.getAccountId();
        productId = comment.getProductId();
        text = comment.getText();
        created = comment.getCreated();
        email = account.getEmail();
    }

    public static List<CommentWrapper> getCommentWrapperList(List<Comment> commentList, AccountService accountService) {
        List<CommentWrapper> commentWrapperList = new ArrayList<>();
        for (int i = 0; i <commentList.size(); i++) {
            commentWrapperList.add(new CommentWrapper
                    (accountService.getAccountById(commentList.get(i).getAccountId()),commentList.get(i)));
        }
        return commentWrapperList;
    }


    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
