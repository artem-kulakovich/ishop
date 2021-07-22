package by.bntu.fitr.listener;


import by.bntu.fitr.service.impl.ServiceManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;


@WebListener
public class ApplicationListener implements ServletContextListener {
    private static final Logger LOGGER = LoggerFactory.getLogger(ApplicationListener.class);

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        LOGGER.info("application is started");
        ServiceManager serviceManager = ServiceManager.getInstance(servletContextEvent.getServletContext());
        servletContextEvent.getServletContext().setAttribute("categoryList",serviceManager.getCategoryService()
                .getAllCategories());
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        LOGGER.info("application is closed");
    }
}
