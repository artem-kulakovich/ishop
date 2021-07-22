package by.bntu.fitr.service;

import by.bntu.fitr.entity.Message;

import java.util.List;

public interface MessageService {
    public List<Message> getAllMessage();
    public void addMessage(int accountId,String msg,String email,String userName);
    public List<Message> getMessagesByAccountId(int accountId);
    public void deleteMessageById(int id);
}
