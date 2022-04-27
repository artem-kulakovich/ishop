package by.bntu.fitr.service.impl;

import by.bntu.fitr.entity.Account;
import by.bntu.fitr.jdbc.JDBCUtils;
import by.bntu.fitr.service.AccountService;
import by.bntu.fitr.service.ProductService;
import org.checkerframework.checker.units.qual.A;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.IOException;
import java.util.Date;
import java.util.Properties;

public class AccountServiceImplTest {
    private static Properties properties = new Properties();
    private static AccountService accountService;
    private static String url = "C:\\Users\\Artyom\\IdeaProjects\\Ishop\\src\\main\\resources\\fake_properties.properties";


    @BeforeClass
    public static void initialization() {
        try {
            JDBCUtils.loadProperties(url, properties);
            accountService = new AccountServiceImpl(properties);
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }

    @Test
    public void getAllAccounts_CheckingForGettingAllAccounts_ShouldReturnNotNull() {
        Assert.assertNotNull(accountService.getAllAccounts());
    }

    @Test
    public void getAccountByUserName_CheckingForGettingAccountByUsernameThatExist_ShouldReturnOneAccount() {
        Assert.assertNotNull(accountService.getAccountByUserName("test1"));
    }

    @Test
    public void getAccountByUserName_CheckingForGettingAccountByUsernameThatDoesntExist_ShouldReturnOneAccount() {
        Assert.assertNull(accountService.getAccountByUserName("test1fdjfkjd"));
    }

    @Test
    public void addAccount_CheckingForCorrectAddingAccount_ShouldReturnTrue() {
        Account account = new Account();
        account.setUserName("sgksklgskjjkl");
        account.setEmail("artemka228-1@mail.ru");
        account.setPassword("123567");
        account.setRole("user");
        account.setFirsName("tefs");
        account.setLastName("gkfklgkdl");
        account.setDate(String.valueOf(new Date()));
        int size1 = accountService.getAllAccounts().size();

        accountService.addAccount(account.getUserName(), account.getFirsName(),
                account.getLastName(), account.getEmail(), account.getPassword());

        int size2 = accountService.getAllAccounts().size();
        Assert.assertTrue(size1 == (size2 - 1));
    }


    @Test
    public void getAccountById_CheckingForGettingAccountById_ShouldReturnTrue() {
        Assert.assertNotNull(accountService.getAccountById(1));
    }

    @Test
    public void getAccountById_CheckingForGettingAccountById_ShouldReturnFalse() {
        Assert.assertNull(accountService.getAccountById(3443));
    }
}