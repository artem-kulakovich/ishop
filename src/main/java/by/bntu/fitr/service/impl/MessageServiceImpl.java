package by.bntu.fitr.service.impl;

import by.bntu.fitr.entity.Message;
import by.bntu.fitr.exception.InternalServerErrorException;
import by.bntu.fitr.jdbc.JDBCUtils;
import by.bntu.fitr.jdbc.ResultSetHandler;
import by.bntu.fitr.jdbc.ResultSetHandlerFactory;
import by.bntu.fitr.service.MessageService;


import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Properties;

public class MessageServiceImpl implements MessageService {
    private Properties properties;
    private ResultSetHandler<List<Message>> messagesResultSetHandler =
            ResultSetHandlerFactory.getListResultSetHandler(ResultSetHandlerFactory.messageResultSetHandler);


    public MessageServiceImpl(Properties properties) {
        this.properties = properties;
    }

    @Override
    public List<Message> getAllMessage() {
        try (Connection connection = JDBCUtils.getConnection(properties)) {
            return JDBCUtils.select(connection, messagesResultSetHandler, "SELECT *FROM message");
        } catch (SQLException e) {
            throw new InternalServerErrorException("Can't execute SQL request: " + e.getMessage(), e);
        }
    }

    @Override
    public void addMessage(int accountId, String msg, String email, String userName) {
        try (Connection connection = JDBCUtils.getConnection(properties)) {
            JDBCUtils.insert(connection, "INSERT INTO message(body,email,account_id,user_name) VALUES(?,?,?,?)", msg, email, accountId, userName);
        } catch (SQLException e) {
            throw new InternalServerErrorException("Can't execute SQL request: " + e.getMessage(), e);
        }
    }

    @Override
    public List<Message> getMessagesByAccountId(int accountId) {
        try (Connection connection = JDBCUtils.getConnection(properties)) {
            return JDBCUtils.select(connection, messagesResultSetHandler, "SELECT *FROM message WHERE account_id = ?", accountId);
        } catch (SQLException e) {
            throw new InternalServerErrorException("Can't execute SQL request: " + e.getMessage(), e);
        }
    }

    @Override
    public void deleteMessageById(int id) {
        try (Connection connection = JDBCUtils.getConnection(properties)) {
            JDBCUtils.delete(connection, "DELETE FROM message WHERE id = ?", id);
        } catch (SQLException e) {
            throw new InternalServerErrorException("Can't execute SQL request: " + e.getMessage(), e);
        }
    }
}
