package by.bntu.fitr.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;

@FunctionalInterface
public interface ResultSetHandler<T> {
    public T handle(ResultSet resultSet) throws SQLException;
}
