package by.bntu.fitr.service.impl;

import by.bntu.fitr.constants.Constants;
import by.bntu.fitr.entity.Product;
import by.bntu.fitr.jdbc.JDBCUtils;
import by.bntu.fitr.service.ProductService;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;


import java.io.IOException;
import java.util.Properties;


public class ProductServiceImplTest {
    private static Properties properties = new Properties();
    private static ProductService productService;
    private static String url = "C:\\Users\\Artyom\\IdeaProjects\\Ishop\\src\\main\\resources\\fake_properties.properties";


    @BeforeClass
    public static void initialization() {
        try {
            JDBCUtils.loadProperties(url, properties);
            productService = new ProductServiceImpl(properties);
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }

    }

    @Test
    public void getAllProducts_CheckingForGettingAllProduct_ShouldReturnNotNull() {
        Assert.assertNotNull(productService.getAllProducts(Constants.LIMIT_PRODUCT_PER_PAGE, 0));
    }

    @Test
    public void getProductsById_CheckingForGettingProductById_ShouldReturnOneProduct() {
        Assert.assertNotNull(productService.getProductById(1));
    }

    @Test
    public void getProductsById_CheckingForGettingProductWithNotExistingId_ShouldtReturnProduct() {
        Assert.assertNull(productService.getProductById(541));
    }

    @Test
    public void getProductsById_CheckingForGettingCertainProduct_ShouldReturnTrue() {
        Product expectedProduct = new Product();
        expectedProduct.setId(1);
        expectedProduct.setName("Iphone");
        expectedProduct.setCount(13);

        Product actualProduct = productService.getProductById(1);

        Assert.assertTrue(expectedProduct.getId() == actualProduct.getId() &&
                expectedProduct.getName().equals(actualProduct.getName()) &&
                expectedProduct.getCount() == actualProduct.getCount());
    }

    @Test
    public void getProductsById_CheckingForGettingCertainProduct_ShouldReturnFalse() {
        Product expectedProduct = new Product();
        expectedProduct.setId(2);
        expectedProduct.setName("dfjsj");
        expectedProduct.setCount(130);


        Product actualProduct = productService.getProductById(1);

        Assert.assertFalse(expectedProduct.getId() == actualProduct.getId() &&
                expectedProduct.getName().equals(actualProduct.getName()) &&
                expectedProduct.getCount() == actualProduct.getCount());
    }

    @Test
    public void getProductCount_CheckingForGettingCertainProductCount_ShouldReturnTrue() {
        Assert.assertTrue(productService.getCountOfProduct("SELECT *FROM product") == 44);
    }

    @Test
    public void getProductCount_CheckingForGettingCertainProductCount_ShouldReturnFalse() {
        Assert.assertFalse(productService.getCountOfProduct("SELECT *FROM product") == 12);
    }
}