package by.bntu.fitr.controller.ajax;

import by.bntu.fitr.form.ProductForm;
import by.bntu.fitr.model.ShoppingCart;
import by.bntu.fitr.util.SessionUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "RemoveProductController",urlPatterns = "/ajax/remove-product")
public class RemoveProductController extends AbstractAjaxController {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ShoppingCart shoppingCart = SessionUtils.getCurrentShoppingCart(request);
        ProductForm productForm = createProductForm(Integer.parseInt(request.getParameter("productId"))
                , Integer.parseInt(request.getParameter("productCount")));
        getOrderService().removeProductFromShoppingCart(shoppingCart,productForm);
        SessionUtils.setCurrentShoppingCart(shoppingCart,request);
    }

}
