package by.bntu.fitr.service.impl;

import by.bntu.fitr.service.*;

import javax.servlet.ServletContext;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ServiceManager {
    private ProductService productService;
    private CategoryService categoryService;
    private OrderService orderService;
    private AccountService accountService;
    private MessageService messageService;
    private CommentService commentService;
    private Properties conProperties = new Properties();


    private ServiceManager() {
        try {
            loadApplicationProperties();
            productService = new ProductServiceImpl(conProperties);
            categoryService = new CategoryServiceImpl(conProperties);
            orderService = new OrderServiceImpl(conProperties);
            accountService = new AccountServiceImpl(conProperties);
            messageService = new MessageServiceImpl(conProperties);
            commentService = new CommentServiceImpl(conProperties);
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }

    public static ServiceManager getInstance(ServletContext context) {
        ServiceManager serviceManager = (ServiceManager) context.getAttribute("SERVICE_MANAGER");
        if (serviceManager == null) {
            serviceManager = new ServiceManager();
            context.setAttribute("SERVICE_MANAGER", serviceManager);
        }

        return serviceManager;
    }

    public void loadApplicationProperties() throws IOException {
        FileInputStream fileInputStream = new FileInputStream("C:\\Users\\Artyom\\IdeaProjects\\Ishop\\src\\main\\resources\\application.properties");
        conProperties.load(fileInputStream);
    }

    public ProductService getProductService() {
        return productService;
    }

    public Properties getConProperties(){
        return conProperties;
    }

    public CategoryService getCategoryService() {
        return categoryService;
    }

    public OrderService getOrderService() {
        return orderService;
    }

    public AccountService getAccountService() {
        return accountService;
    }

    public MessageService getMessageService() {
        return messageService;
    }

    public CommentService getCommentService() {
        return commentService;
    }
}
