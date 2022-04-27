package by.bntu.fitr.service.impl;

import by.bntu.fitr.exception.InternalServerErrorException;
import by.bntu.fitr.form.ProductForm;
import by.bntu.fitr.jdbc.JDBCUtils;
import by.bntu.fitr.model.ShoppingCart;
import by.bntu.fitr.service.OrderService;
import by.bntu.fitr.service.ProductService;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.IOException;
import java.util.Properties;


public class OrderServiceImplTest {

    private static Properties properties = new Properties();
    private static OrderService orderService;
    private static String url = "C:\\Users\\Artyom\\IdeaProjects\\Ishop\\src\\main\\resources\\fake_properties.properties";


    @BeforeClass
    public static void initialization() {
        try {
            JDBCUtils.loadProperties(url, properties);
            orderService = new OrderServiceImpl(properties);
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }

    @Test
    public void addProductToShoppingCart_CheckingForCorrectAddingProductInShoppingCart_ShouldReturnTrue() {
        ShoppingCart shoppingCart = new ShoppingCart();
        int size = shoppingCart.getShoppingCart().size();
        orderService.addProductToShoppingCart(shoppingCart, new ProductForm(1, 1));
        Assert.assertTrue(size + 1 == shoppingCart.getShoppingCart().size());
    }

    @Test(expected = InternalServerErrorException.class)
    public void addProductToShoppingCart_CheckingForUnCorrectAddingProductInShoppingCart_ShouldReturnException() {
        ShoppingCart shoppingCart = new ShoppingCart();
        int size = shoppingCart.getShoppingCart().size();
        orderService.addProductToShoppingCart(shoppingCart, new ProductForm(-1, -1));
    }

    @Test
    public void addProductToShoppingCart_CheckingForUnCorrectAddingProductInShoppingCart_ShouldReturnFalse() {
        ShoppingCart shoppingCart = new ShoppingCart();
        int size = shoppingCart.getShoppingCart().size();
        orderService.addProductToShoppingCart(shoppingCart, new ProductForm(1, 0));
        Assert.assertFalse(size + 2 == shoppingCart.getShoppingCart().size());
    }


    @Test
    public void removeProductFromShoppingCart_CheckingForCorrectRemovingProductFromShoppingCart_ShouldReturnTrue() {
        ShoppingCart shoppingCart = new ShoppingCart();
        orderService.addProductToShoppingCart(shoppingCart, new ProductForm(1, 3));
        orderService.addProductToShoppingCart(shoppingCart, new ProductForm(2, 3));
        int size = shoppingCart.getShoppingCart().size();
        orderService.removeProductFromShoppingCart(shoppingCart, new ProductForm(1, 0));
        Assert.assertTrue(shoppingCart.getShoppingCart().size() == size-1);
    }

    @Test
    public void removeProductFromShoppingCart_CheckingForUnCorrectRemovingProductFromShoppingCart_ShouldReturnFalse() {
        ShoppingCart shoppingCart = new ShoppingCart();
        orderService.addProductToShoppingCart(shoppingCart, new ProductForm(1, 3));
        orderService.addProductToShoppingCart(shoppingCart, new ProductForm(2, 3));
        int size = shoppingCart.getShoppingCart().size();
        orderService.removeProductFromShoppingCart(shoppingCart, new ProductForm(1, 1));
        Assert.assertFalse(shoppingCart.getShoppingCart().size() == size-1);
    }

    @Test
    public void getOrdersByConsumer_CheckingForCorrectGettingOrderByUser_ShouldReturnNotNull() {
        Assert.assertNotNull(orderService.getOrdersByConsumer(1));
    }

    @Test
    public void getOrdersByConsumer_CheckingForUnCorrectGettingOrderByUser_ShouldReturnEmptySet() {
        Assert.assertTrue(orderService.getOrdersByConsumer(111).size() == 0);
    }

}