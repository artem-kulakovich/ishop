package by.bntu.fitr.jdbc;

import by.bntu.fitr.entity.*;
import by.bntu.fitr.jdbc.ResultSetHandler;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class ResultSetHandlerFactory {

    public static ResultSetHandler<Product> productResultSetHandler = new ResultSetHandler<Product>() {
        @Override
        public Product handle(ResultSet resultSet) throws SQLException {
            Product product = new Product();
            product.setName(resultSet.getString("name"));
            product.setDescription(resultSet.getString("description"));
            product.setImage(resultSet.getString("image"));
            product.setCount(resultSet.getInt("count"));
            product.setId(resultSet.getInt("id"));
            product.setCost(resultSet.getDouble("cost"));
            return product;
        }
    };

    public static ResultSetHandler<Category> categoryResultSetHandler = new ResultSetHandler<Category>() {
        @Override
        public Category handle(ResultSet resultSet) throws SQLException {
            Category category = new Category();
            category.setId(resultSet.getInt("id"));
            category.setName(resultSet.getString("name"));
            return category;
        }
    };

    public static ResultSetHandler<Account> accountResultSetHandler = new ResultSetHandler<Account>() {
        @Override
        public Account handle(ResultSet resultSet) throws SQLException {
            Account account = new Account();
            account.setEmail(resultSet.getString("email"));
            account.setFirsName(resultSet.getString("first_name"));
            account.setLastName(resultSet.getString("last_name"));
            account.setUserName(resultSet.getString("user_name"));
            account.setRole(resultSet.getString("role"));
            account.setPassword(resultSet.getString("password"));
            account.setId(resultSet.getInt("id"));
            account.setDate(resultSet.getString("created"));
            return account;
        }
    };

    public static ResultSetHandler<Order> orderResultSetHandler = new ResultSetHandler<Order>() {
        @Override
        public Order handle(ResultSet resultSet) throws SQLException {
            Order order = new Order();
            order.setId(resultSet.getInt("id"));
            order.setConsumer(resultSet.getInt("account_id"));
            order.setCost(resultSet.getDouble("cost"));
            order.setDate(resultSet.getString("created"));
            order.setInfo(resultSet.getString("info"));
            return order;
        }
    };

    public static ResultSetHandler<Message> messageResultSetHandler = new ResultSetHandler<Message>() {
        @Override
        public Message handle(ResultSet resultSet) throws SQLException {
            Message message = new Message();
            message.setId(resultSet.getInt("id"));
            message.setBody(resultSet.getString("body"));
            message.setDate(resultSet.getString("created"));
            message.setAccountId(resultSet.getInt("account_id"));
            message.setEmail(resultSet.getString("email"));
            message.setUserName(resultSet.getString("user_name"));
            return message;
        }
    };

    public static ResultSetHandler<Comment> commentResultSetHandler = new ResultSetHandler<Comment>() {
        @Override
        public Comment handle(ResultSet resultSet) throws SQLException {
            Comment comment = new Comment();
            comment.setId(resultSet.getInt("id"));
            comment.setAccountId(resultSet.getInt("account_id"));
            comment.setProductId(resultSet.getInt("product_id"));
            comment.setText(resultSet.getString("text"));
            comment.setCreated(resultSet.getString("created"));
            return comment;
        }
    };


    public static <T> ResultSetHandler<List<T>> getListResultSetHandler(ResultSetHandler<T> oneRowResultSetHandler) {
        return new ResultSetHandler<List<T>>() {
            @Override
            public List<T> handle(ResultSet resultSet) throws SQLException {
                List<T> list = new ArrayList<>();
                while (resultSet.next()) {
                    list.add(oneRowResultSetHandler.handle(resultSet));
                }
                return list;
            }
        };
    }

    public static <T> ResultSetHandler<T> getSingleResultSetHandler(ResultSetHandler<T> oneRowResultSetHandler) {
        return new ResultSetHandler<T>() {
            @Override
            public T handle(ResultSet resultSet) throws SQLException {
                if (resultSet.next()) {
                    return oneRowResultSetHandler.handle(resultSet);
                } else {
                    return null;
                }
            }
        };
    }
}
