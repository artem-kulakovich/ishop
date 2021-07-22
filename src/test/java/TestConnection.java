import by.bntu.fitr.constants.Constants;
import by.bntu.fitr.entity.Product;
import by.bntu.fitr.jdbc.JDBCUtils;
import by.bntu.fitr.service.ProductService;
import by.bntu.fitr.service.impl.ProductServiceImpl;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

public class TestConnection {
    private static String name;
    private static String url;
    private static String password;

    @BeforeClass
    public static void loadProperties() throws IOException {
        name = "postgres";
        url = "jdbc:postgresql://localhost:5432/ishop";
        password = "artem201320133";
    }

    @Test()
    public void productCountShouldntReturnNull() throws SQLException, ClassNotFoundException {
        int size = selectFromProduct("SELECT *FROM product");
        Assert.assertNotEquals(0, size);
    }

    @Test(expected = SQLException.class)
    public void productRequestSholdntThrowSQLException() throws SQLException, ClassNotFoundException {

        selectFromProduct("SELECT *FROM pfdf");
    }

    private static int selectFromProduct(String sql) throws ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver");
        Connection connection = DriverManager.getConnection(url,name,password);

        int size = 0;
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                resultSet.getString("name");
                size++;
            }
        }
        return size;
    }
}
