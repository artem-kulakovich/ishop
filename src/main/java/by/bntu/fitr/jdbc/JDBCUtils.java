package by.bntu.fitr.jdbc;

import by.bntu.fitr.jdbc.ResultSetHandler;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.Collections;
import java.util.List;
import java.util.Properties;

public class JDBCUtils {
    public static void loadProperties(String url, Properties properties) throws IOException {
        FileInputStream fileInputStream = new FileInputStream(url);
        properties.load(fileInputStream);
    }


    public static Connection getConnection(Properties properties) throws SQLException {
        Connection connection = null;
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(properties.getProperty("db.url")
                    , properties.getProperty("db.username")
                    , properties.getProperty("db.password"));
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return connection;
    }


    public static <T> T select(Connection connection, ResultSetHandler<T> resultSetHandler, String sql, Object... parameters) throws SQLException {
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            setParameters(preparedStatement, parameters);
            ResultSet resultSet = preparedStatement.executeQuery();
            return resultSetHandler.handle(resultSet);
        }
    }

    public static void insert(Connection connection, String sql, Object... parameters) throws SQLException {
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            setParameters(preparedStatement, parameters);
            preparedStatement.execute();
        }
    }

    public static void update(Connection connection, String sql, Object... parameters) throws SQLException {
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            setParameters(preparedStatement, parameters);
            preparedStatement.executeUpdate();
        }
    }

    public static void delete(Connection connection, String sql, Object... parameters) throws SQLException {
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            setParameters(preparedStatement, parameters);
            preparedStatement.execute();
        }
    }

    /*

    private static void setParameters(PreparedStatement preparedStatement, Object... parameters) throws SQLException {
        if (parameters != null) {
            if (parameters.length > 0 && parameters[0] instanceof List<?>) {
                setParametersFromList(preparedStatement, (List<?>) parameters[0]);
            } else {
                for (int i = 0; i < parameters.length; i++) {
                    preparedStatement.setObject(i + 1, parameters[i]);
                }
            }
        }
    }

    private static void setParametersFromList(PreparedStatement preparedStatement, List<?> list) throws SQLException {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) instanceof Integer) {
                preparedStatement.setInt(i + 1, (Integer)list.get(i));
            }
            else if(list.get(i) instanceof String){
                preparedStatement.setString(i+1, (String) list.get(i));
            }
            else if(list.get(i) instanceof Number){
                preparedStatement.setDouble(i+1,(Double) list.get(i));
            }
        }
    }

     */


    private static void setParameters(PreparedStatement preparedStatement, Object... parameters) throws SQLException {
        if (parameters != null) {
            int index = 1;
            for (int i = 0; i < parameters.length; i++, index++) {
                if (parameters.length > 0 && parameters[i] instanceof List<?>) {
                    setParametersFromList(preparedStatement, (List<?>) parameters[0], index);
                    index *= ((List<?>) parameters[i]).size();
                } else {
                    preparedStatement.setObject(index, parameters[i]);
                }
            }
        }
    }

    private static void setParametersFromList(PreparedStatement preparedStatement, List<?> list, int index) throws SQLException {
        for (int i = 0; i < list.size(); i++, index++) {
            if (list.get(i) instanceof Integer) {
                preparedStatement.setInt(index, (Integer) list.get(i));
            } else if (list.get(i) instanceof String) {
                preparedStatement.setString(index, (String) list.get(i));
            } else if (list.get(i) instanceof Number) {
                preparedStatement.setDouble(index, (Double) list.get(i));
            }
        }
    }
}
