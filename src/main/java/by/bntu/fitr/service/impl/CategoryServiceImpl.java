package by.bntu.fitr.service.impl;

import by.bntu.fitr.entity.Category;
import by.bntu.fitr.exception.InternalServerErrorException;
import by.bntu.fitr.jdbc.JDBCUtils;
import by.bntu.fitr.jdbc.ResultSetHandler;
import by.bntu.fitr.jdbc.ResultSetHandlerFactory;
import by.bntu.fitr.service.CategoryService;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Properties;

public class CategoryServiceImpl implements CategoryService {
    private Properties properties;
    private ResultSetHandler<List<Category>> categoryList = ResultSetHandlerFactory
            .getListResultSetHandler(ResultSetHandlerFactory.categoryResultSetHandler);


    public CategoryServiceImpl(Properties properties) {
        this.properties = properties;
    }

    @Override
    public List<Category> getAllCategories() {
        try (Connection connection = JDBCUtils.getConnection(properties)) {
            return JDBCUtils.select(connection, categoryList, "SELECT *FROM category");
        } catch (SQLException e) {
            throw new InternalServerErrorException("Can't execute SQL request: " + e.getMessage(), e);
        }
    }

    @Override
    public int countOfCategories() {
        return getAllCategories().size();
    }


    @Override
    public int countProductInCategory(int categoryId) {
        try(Connection connection = JDBCUtils.getConnection(properties)){
            return JDBCUtils.select(connection,categoryList,"select * FROM category JOIN product ON category.id = product.category_id WHERE category.id = ?"
                    ,categoryId).size();
        } catch (SQLException e) {
            throw new InternalServerErrorException("Can't execute SQL request: " + e.getMessage(), e);
        }
    }
}
