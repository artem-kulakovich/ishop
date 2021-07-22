package generator;

import java.sql.*;

public class TestDataGenerator {
    private static final String ROOT_PATH = "/media/";
    private static final String[] PRODUCT_NAME = {"Huawei", "Xiaomi", "Samsung", "Iphone"};
    private static final String DESCRIPTION = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Quisque non fermentum el.";
    private static final int MAX_COUNT_LIMIT = 50;
    private static final int MIN_COUNT_LIMIT = 10;
    private static final double MAX_COST_PER_PRODUCT = 2500;
    private static final double MIN_COST_PER_PRODUCT = 400;
    private static final String[] IMAGE = {"huawei.png", "xiaomi.png", "samsung.png", "iphone.png"};

    private static final String USER_NAME = "postgres";
    private static final String PASSWORD = "artem201320133";
    private static final String URL = "jdbc:postgresql://localhost:5432/ishop";


    public static void main(String[] args) {
        try {
            generateDataForProductTable();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }


    public static void generateDataForProductTable() throws ClassNotFoundException {
        Class.forName("org.postgresql.Driver");

        try (Connection connection = DriverManager.getConnection(URL, USER_NAME, PASSWORD)) {
            Statement statement = connection.createStatement();
            for (int i = 0; i < 20; i++) {
                statement.execute(generateSqlForProductTable());
            }
        } catch (SQLException exception) {
            exception.printStackTrace();
        }

    }

    public static String generateSqlForProductTable() {
        int count = MIN_COUNT_LIMIT + (int) (Math.random() * MAX_COUNT_LIMIT);
        double cost = MIN_COST_PER_PRODUCT + Math.random() * MAX_COST_PER_PRODUCT;
        int mark = (int) (Math.random() * 4);
        String name = PRODUCT_NAME[mark];
        String description = DESCRIPTION;
        String image = ROOT_PATH + IMAGE[mark];
        String sql = "INSERT INTO product (name,description,image,cost,count,category_id) VALUES(" + "'" + name + "','" + description + "','" + image + "'," +  cost + "," + count +","+1+")";
        return sql;
    }
}
