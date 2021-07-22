package by.bntu.fitr.service.impl;

import by.bntu.fitr.entity.Order;
import by.bntu.fitr.entity.Product;
import by.bntu.fitr.exception.InternalServerErrorException;
import by.bntu.fitr.form.ProductForm;
import by.bntu.fitr.jdbc.JDBCUtils;
import by.bntu.fitr.jdbc.ResultSetHandler;
import by.bntu.fitr.jdbc.ResultSetHandlerFactory;
import by.bntu.fitr.model.OrderHandler;
import by.bntu.fitr.model.ShoppingCart;
import by.bntu.fitr.service.OrderService;


import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Properties;

public class OrderServiceImpl implements OrderService {
    private Properties properties;
    private ShoppingCart shoppingCart = new ShoppingCart();
    private ResultSetHandler<Product> productResultSetHandler =
            ResultSetHandlerFactory.getSingleResultSetHandler(ResultSetHandlerFactory.productResultSetHandler);
    private ResultSetHandler<List<Order>> ordersResultSetHandler =
            ResultSetHandlerFactory.getListResultSetHandler(ResultSetHandlerFactory.orderResultSetHandler);


    public OrderServiceImpl(Properties properties) {
        this.properties = properties;
    }


    @Override
    public void addProductToShoppingCart(ShoppingCart shoppingCart, ProductForm productForm) {
        try (Connection connection = JDBCUtils.getConnection(properties)) {
            Product product = JDBCUtils.select(connection, productResultSetHandler
                    , "SELECT *from product where id = ?", productForm.getProductId());

            if (product == null) {
                throw new InternalServerErrorException("product not found by id " + productForm.getProductId());
            }

            shoppingCart.addProductToCart(product, productForm.getCount());
        } catch (SQLException e) {
            throw new InternalServerErrorException("Can't execute SQL request: " + e.getMessage(), e);
        }
    }

    @Override
    public void removeProductFromShoppingCart(ShoppingCart shoppingCart, ProductForm productForm) {
        shoppingCart.removeProductFromCart(productForm.getProductId(), productForm.getCount());
    }

    @Override
    public void makeOrder(OrderHandler orderHandler) {
        try (Connection connection = JDBCUtils.getConnection(properties)) {
            JDBCUtils.insert(connection, "INSERT INTO \"order\"(cost,info,account_id) VALUES(?,?,?)"
                    , orderHandler.getCost(), orderHandler.getInfo(), orderHandler.getConsumer());
        } catch (SQLException e) {
            throw new InternalServerErrorException("Can't execute SQL request: " + e.getMessage(), e);
        }
    }

    @Override
    public List<Order> getOrdersByConsumer(int consumer) {
        try (Connection connection = JDBCUtils.getConnection(properties)) {
            return JDBCUtils.select(connection, ordersResultSetHandler, "SELECT *FROM \"order\" WHERE account_id = ?", consumer);
        } catch (SQLException e) {
            throw new InternalServerErrorException("Can't execute SQL request: " + e.getMessage(), e);
        }
    }

    @Override
    public void deleteOrderById(int orderId, int accountId) {
        try (Connection connection = JDBCUtils.getConnection(properties)) {
            JDBCUtils.delete(connection, "DELETE FROM \"order\" WHERE id = ? AND account_id = ?", orderId, accountId);
        } catch (SQLException e) {
            throw new InternalServerErrorException("Can't execute SQL request: " + e.getMessage(), e);
        }
    }
}
