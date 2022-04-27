package by.bntu.fitr.service.impl;


import by.bntu.fitr.jdbc.JDBCUtils;
import by.bntu.fitr.service.CommentService;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.IOException;
import java.util.Properties;

public class CommentServiceImplTest {
    private static Properties properties = new Properties();
    private static CommentService commentService;
    private static String url = "C:\\Users\\Artyom\\IdeaProjects\\Ishop\\src\\main\\resources\\fake_properties.properties";

    @BeforeClass
    public static void initialization() {
        try {
            JDBCUtils.loadProperties(url, properties);
            commentService = new CommentServiceImpl(properties);
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }

    @Test
    public void addComment_CheckingForAddingComment_ShouldReturnSizeOneMore() {
        int size = commentService.getAllComment(1, 100, 0).size();
        commentService.addComment(1, 1, "hello");
        Assert.assertTrue(size == (commentService.getAllComment(1, 100, 0).size() - 1));
    }

    @Test
    public void deleteComment_CheckingForDeletingComment_ShouldReturnSizeOneLess() {
        int size = commentService.getAllComment(1, 100, 0).size();
        commentService.deleteCommentById(24);
        Assert.assertTrue(size - 1 == (commentService.getAllComment(1, 100, 0).size()));
    }

    @Test
    public void getAllComments_CheckingForGettingAllComments_ShouldReturnNotNull() {
        Assert.assertNotNull(commentService.getAllComment(1,100,0));
    }

    @Test
    public void getAllComments_CheckingForGettingAllComments_ShouldReturnEmptySet() {
        Assert.assertTrue(commentService.getAllComment(255,100,0).size() == 0);
    }

}