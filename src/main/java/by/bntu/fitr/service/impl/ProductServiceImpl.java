package by.bntu.fitr.service.impl;

import by.bntu.fitr.entity.Product;
import by.bntu.fitr.exception.InternalServerErrorException;
import by.bntu.fitr.form.SearchForm;
import by.bntu.fitr.jdbc.ResultSetHandler;
import by.bntu.fitr.jdbc.ResultSetHandlerFactory;
import by.bntu.fitr.service.ProductService;
import by.bntu.fitr.jdbc.JDBCUtils;


import java.sql.*;
import java.util.List;
import java.util.Properties;

public class ProductServiceImpl implements ProductService {
    private Properties properties;
    private ResultSetHandler<Product> productResultSetHandler = ResultSetHandlerFactory
            .getSingleResultSetHandler(ResultSetHandlerFactory.productResultSetHandler);
    private ResultSetHandler<List<Product>> productsResultSetHandler = ResultSetHandlerFactory
            .getListResultSetHandler(ResultSetHandlerFactory.productResultSetHandler);


    public ProductServiceImpl(Properties properties) {
        this.properties = properties;
    }

    @Override
    public List<Product> getAllProducts(int limit, int offset) {
        try (Connection connection = JDBCUtils.getConnection(properties)) {
            return JDBCUtils.select(connection, productsResultSetHandler, "SELECT *FROM product LIMIT ? OFFSET ? ROWS", limit, offset);
        } catch (SQLException e) {
            throw new InternalServerErrorException("Can't execute SQL request: " + e.getMessage(), e);
        }
    }

    @Override
    public List<Product> getProductsByName(String searchingProduct, int limit, int offset) {
        try (Connection connection = JDBCUtils.getConnection(properties)) {
            return JDBCUtils.select(connection, productsResultSetHandler, "SELECT *FROM product WHERE name LIKE ? LIMIT ? OFFSET ? ROWS"
                    , "%" + searchingProduct + "%", limit, offset);
        } catch (SQLException e) {
            throw new InternalServerErrorException("Can't execute SQL request: " + e.getMessage(), e);
        }
    }


    @Override
    public List<Product> getProductsByCategories(List<Integer> categoriesId, int limit, int offset) {
        try (Connection connection = JDBCUtils.getConnection(properties)) {
            return JDBCUtils.select(connection, productsResultSetHandler
                    , SearchForm.formingSql("SELECT *FROM product JOIN category ON product.category_id = category.id Where "
                            , "category_id", "or", categoriesId.size()) + " LIMIT ? OFFSET ? ROWS", categoriesId, limit, offset);
        } catch (SQLException e) {
            throw new InternalServerErrorException("Can't execute SQL request: " + e.getMessage(), e);
        }
    }

    @Override
    public List<Product> getProductsBySearchingRequest(SearchForm searchForm, int limit, int offset) {
        try (Connection connection = JDBCUtils.getConnection(properties)) {
            String subQuery = SearchForm.formingSql("SELECT *FROM product JOIN category ON product.category_id = category.id Where "
                    , "category_id", "or"
                    , searchForm.getParameters().size() - 1);
            return JDBCUtils.select(connection, productsResultSetHandler, subQuery + " and product.name LIKE ? LIMIT ? OFFSET ? ROWS", searchForm.getCategories(),"%"+searchForm.getSearchingProduct()+"%", limit, offset);
        } catch (SQLException e) {
            throw new InternalServerErrorException("Can't execute SQL request: " + e.getMessage(), e);
        }
    }

    @Override
    public Product getProductById(int productId) {
        try (Connection connection = JDBCUtils.getConnection(properties)) {
            return JDBCUtils.select(connection, productResultSetHandler, "SELECT *FROM product WHERE id = ?", productId);
        } catch (SQLException e) {
            throw new InternalServerErrorException("Can't execute SQL request: " + e.getMessage(), e);
        }
    }

    @Override
    public int getCountOfProduct(String sql, Object... parameters) {
        try (Connection connection = JDBCUtils.getConnection(properties)) {
            return JDBCUtils.select(connection, productsResultSetHandler, sql, parameters).size();
        } catch (SQLException e) {
            throw new InternalServerErrorException("Can't execute SQL request: " + e.getMessage(), e);
        }
    }

}
