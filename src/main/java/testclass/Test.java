package testclass;

import java.sql.*;

public class Test {
    private static final String USER_NAME = "postgres";
    private static final String PASSWORD = "artem201320133";
    private static final String URL = "jdbc:postgresql://localhost:5432/ishop";

    public static void main(String[] args) throws ClassNotFoundException {
        Class.forName("org.postgresql.Driver");
        String sql = "SELECT *FROM product WHERE name LIKE"+"?";

        try {
            Connection connection = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            //preparedStatement.setString(1,);

            System.out.println(sql);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                System.out.println(resultSet.getString("name"));
            }
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }
}
