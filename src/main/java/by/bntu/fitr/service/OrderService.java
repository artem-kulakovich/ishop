package by.bntu.fitr.service;

import by.bntu.fitr.entity.Order;
import by.bntu.fitr.entity.Product;
import by.bntu.fitr.form.ProductForm;
import by.bntu.fitr.model.OrderHandler;
import by.bntu.fitr.model.ShoppingCart;

import java.util.List;

public interface OrderService {
    public void addProductToShoppingCart(ShoppingCart shoppingCart, ProductForm productForm);
    public void removeProductFromShoppingCart(ShoppingCart shoppingCart,ProductForm productForm);
    public void makeOrder(OrderHandler orderHandler);
    public List<Order> getOrdersByConsumer(int consumer);
    public void deleteOrderById(int orderId,int accountId);
}
