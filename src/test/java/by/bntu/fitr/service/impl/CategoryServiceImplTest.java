package by.bntu.fitr.service.impl;


import by.bntu.fitr.jdbc.JDBCUtils;
import by.bntu.fitr.service.CategoryService;
import by.bntu.fitr.service.ProductService;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.IOException;
import java.util.Properties;

public class CategoryServiceImplTest {
    private static Properties properties = new Properties();
    private static CategoryService categoryService;
    private static String url = "C:\\Users\\Artyom\\IdeaProjects\\Ishop\\src\\main\\resources\\fake_properties.properties";

    @BeforeClass
    public static void initialization() {
        try {
            JDBCUtils.loadProperties(url, properties);
            categoryService = new CategoryServiceImpl(properties);
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }

    @Test
    public void getAllCategories_CheckingForGettingAllCategories_ShouldReturnNotNull() {
        Assert.assertNotNull(categoryService.getAllCategories());
    }

    @Test
    public void getCountOfCategories_CheckingForGettingCountOfCategories_ShouldReturnTrue() {
        Assert.assertTrue(categoryService.countOfCategories() == 4);
    }

    @Test
    public void getCountOfCategories_CheckingForGettingCountOfCategories_ShouldReturnFalse() {
        Assert.assertFalse(categoryService.countOfCategories() == 5);
    }

    @Test
    public void getCountProductInCategory_CheckingForGettingCorrectProductInCategory_ShouldReturnTrue(){
        Assert.assertTrue(categoryService.countProductInCategory(4) == 0);
    }

    @Test
    public void getCountProductInCategory_CheckingForGettingUnCorrectProductInCategory_ShouldReturnFalse(){
        Assert.assertFalse(categoryService.countProductInCategory(4) == 1);
    }
}