package by.bntu.fitr.service.impl;

import by.bntu.fitr.entity.Comment;
import by.bntu.fitr.exception.InternalServerErrorException;
import by.bntu.fitr.jdbc.JDBCUtils;
import by.bntu.fitr.jdbc.ResultSetHandler;
import by.bntu.fitr.jdbc.ResultSetHandlerFactory;
import by.bntu.fitr.service.CommentService;


import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Properties;

public class CommentServiceImpl implements CommentService {
    private Properties properties;
    private ResultSetHandler<List<Comment>> commentsResultSetHandler =
            ResultSetHandlerFactory.getListResultSetHandler(ResultSetHandlerFactory.commentResultSetHandler);

    public CommentServiceImpl(Properties properties) {
        this.properties = properties;
    }

    @Override
    public void addComment(int accountId, int productId, String text) {
        try (Connection connection = JDBCUtils.getConnection(properties)) {
            JDBCUtils.insert(connection, "INSERT INTO comment(text,account_id,product_id) Values(?,?,?)"
                    , text, accountId, productId);
        } catch (SQLException e) {
            throw new InternalServerErrorException("Can't execute SQL request: " + e.getMessage(), e);
        }
    }

    @Override
    public List<Comment> getAllComment(int productId, int limit, int offset) {
        try (Connection connection = JDBCUtils.getConnection(properties)) {
            return JDBCUtils.select(connection, commentsResultSetHandler, "SELECT *FROM comment WHERE product_id = ? LIMIT ? OFFSET ? ROWS"
                    , productId, limit, offset);
        } catch (SQLException e) {
            throw new InternalServerErrorException("Can't execute SQL request: " + e.getMessage(), e);
        }
    }

    @Override
    public void deleteCommentById(int id) {
        try (Connection connection = JDBCUtils.getConnection(properties)) {
            JDBCUtils.delete(connection, "DELETE FROM comment WHERE id = ?", id);
        } catch (SQLException e) {
            throw new InternalServerErrorException("Can't execute SQL request: " + e.getMessage(), e);
        }
    }
}
