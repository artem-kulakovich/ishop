package by.bntu.fitr.service;

import by.bntu.fitr.entity.Account;

import java.util.List;

public interface AccountService {
    public List<Account> getAllAccounts();
    public Account getAccountByUserName(String userName);
    public void addAccount(String userName,String firstName,String lastName,String email,String password);
    public void changePassword(int id,String newPassword);
    public Account getAccountById(int id);
}
