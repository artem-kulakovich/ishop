package by.bntu.fitr.controller.ajax;

import by.bntu.fitr.controller.AbstractController;
import by.bntu.fitr.form.ProductForm;
import by.bntu.fitr.model.ShoppingCart;
import by.bntu.fitr.model.ShoppingCartItem;
import by.bntu.fitr.util.SessionUtils;
import org.apache.catalina.Session;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collection;

@WebServlet(name = "AddProductController", urlPatterns = "/ajax/add-product")
public class AddProductController extends AbstractAjaxController {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ShoppingCart shoppingCart = SessionUtils.getCurrentShoppingCart(request);
        ProductForm productForm = createProductForm(Integer.parseInt(request.getParameter("productId"))
                , Integer.parseInt(request.getParameter("productCount")));
        getOrderService().addProductToShoppingCart(shoppingCart,productForm);
        SessionUtils.setCurrentShoppingCart(shoppingCart,request);
        //ProductForm productForm = createProductForm(request);
        //getOrderService().addProductToShoppingCart(shoppingCart,productForm);

    }

}