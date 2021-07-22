package by.bntu.fitr.service.impl;

import by.bntu.fitr.constants.Constants;
import by.bntu.fitr.entity.Account;
import by.bntu.fitr.exception.InternalServerErrorException;
import by.bntu.fitr.jdbc.JDBCUtils;
import by.bntu.fitr.jdbc.ResultSetHandler;
import by.bntu.fitr.jdbc.ResultSetHandlerFactory;
import by.bntu.fitr.service.AccountService;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Properties;

public class AccountServiceImpl implements AccountService {
    private Properties properties;
    private static ResultSetHandler<List<Account>> accountsResultSetHandler =
            ResultSetHandlerFactory.getListResultSetHandler(ResultSetHandlerFactory.accountResultSetHandler);
    private static ResultSetHandler<Account> accountResultSetHandler =
            ResultSetHandlerFactory.getSingleResultSetHandler(ResultSetHandlerFactory.accountResultSetHandler);

    public AccountServiceImpl(Properties properties) {
        this.properties = properties;
    }

    @Override
    public List<Account> getAllAccounts() {
        try (Connection connection = JDBCUtils.getConnection(properties)) {
            return JDBCUtils.select(connection, accountsResultSetHandler, "SELECT *FROM account");
        } catch (SQLException e) {
            throw new InternalServerErrorException("Can't execute SQL request: " + e.getMessage(), e);
        }
    }

    @Override
    public Account getAccountByUserName(String userName) {
        try (Connection connection = JDBCUtils.getConnection(properties)) {
            return JDBCUtils.select(connection, accountResultSetHandler, "SELECT *FROM account WHERE user_name = ?", userName);
        } catch (SQLException e) {
            throw new InternalServerErrorException("Can't execute SQL request: " + e.getMessage(), e);
        }
    }

    @Override
    public void addAccount(String userName, String firstName, String lastName, String email, String password) {
        try (Connection connection = JDBCUtils.getConnection(properties)) {
            JDBCUtils.insert(connection, "INSERT INTO account(user_name,first_name,last_name,role,password,email) VALUES(?,?,?,?,?,?)"
                    , userName, firstName, lastName, Constants.USER_ROLE, password, email);
        } catch (SQLException e) {
            throw new InternalServerErrorException("Can't execute SQL request: " + e.getMessage(), e);
        }
    }

    @Override
    public void changePassword(int id, String newPassword) {
        try (Connection connection = JDBCUtils.getConnection(properties)) {
            JDBCUtils.update(connection, "UPDATE account SET password = ? WHERE id = ?", newPassword, id);
        } catch (SQLException e) {
            throw new InternalServerErrorException("Can't execute SQL request: " + e.getMessage(), e);
        }
    }

    @Override
    public Account getAccountById(int id) {
        try (Connection connection = JDBCUtils.getConnection(properties)) {
            return JDBCUtils.select(connection, accountResultSetHandler, "SELECT *FROM account WHERE id = ?", id);
        } catch (SQLException e) {
            throw new InternalServerErrorException("Can't execute SQL request: " + e.getMessage(), e);
        }

    }
}
