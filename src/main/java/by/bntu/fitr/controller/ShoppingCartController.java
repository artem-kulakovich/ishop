package by.bntu.fitr.controller;

import by.bntu.fitr.entity.Product;
import by.bntu.fitr.form.ProductForm;
import by.bntu.fitr.model.ShoppingCart;
import by.bntu.fitr.model.ShoppingCartItem;
import by.bntu.fitr.util.SessionUtils;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collection;


@WebServlet(name = "ShoppingCartController", urlPatterns = "/add-to-shopping-cart")
public class ShoppingCartController extends AbstractController {


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ProductForm productForm = createProductForm(request);
        ShoppingCart shoppingCart = SessionUtils.getCurrentShoppingCart(request);
        getOrderService().addProductToShoppingCart(shoppingCart,productForm);
        forwardToPage(request, response, "shopping-cart.jsp");
    }



}