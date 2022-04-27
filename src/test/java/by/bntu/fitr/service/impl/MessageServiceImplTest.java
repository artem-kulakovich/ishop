package by.bntu.fitr.service.impl;

import by.bntu.fitr.jdbc.JDBCUtils;
import by.bntu.fitr.service.MessageService;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.IOException;
import java.util.Properties;

public class MessageServiceImplTest {

    private static Properties properties = new Properties();
    private static MessageService messageService;
    private static String url = "C:\\Users\\Artyom\\IdeaProjects\\Ishop\\src\\main\\resources\\fake_properties.properties";

    @BeforeClass
    public static void initialization() {
        try {
            JDBCUtils.loadProperties(url, properties);
            messageService = new MessageServiceImpl(properties);
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }

    @Deprecated
    @Test
    public void getAllMessage_CheckingForGettingAllMessages_ShouldReturnNotNull() {
        Assert.assertNotNull(messageService.getAllMessage());
    }

    @Deprecated
    @Test
    public void addMessage_CheckingForCorrectAddingMessage_ShouldReturnOneMore() {
        int size = messageService.getAllMessage().size();
        messageService.addMessage(1, "dkdklfkldfjkj", "artemka228-1@mail.ru", "admin");
        Assert.assertTrue(size + 1 == messageService.getAllMessage().size());
    }

    @Deprecated
    @Test
    public void getMessagesByAccountId_CheckingForGettingMessageByAccountId_ShouldReturnNull() {
        Assert.assertTrue(messageService.getMessagesByAccountId(111).size() == 0);
    }

    @Deprecated
    @Test
    public void getMessagesByAccountId_CheckingForGettingMessageByAccountId_ShouldReturnNotNull() {
        Assert.assertFalse(messageService.getMessagesByAccountId(1).size() == 0);
    }

    @Deprecated
    @Test
    public void deleteMessageById_CheckingForCorrectDeletingMessage_ShouldReturnTrue() {
        int size = messageService.getAllMessage().size();
        messageService.deleteMessageById(1);
        Assert.assertTrue(messageService.getAllMessage().size() == (size - 1));
    }
}