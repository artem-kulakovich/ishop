package by.bntu.fitr.util;

import by.bntu.fitr.constants.Constants;
import by.bntu.fitr.entity.Account;
import by.bntu.fitr.model.ShoppingCart;

import javax.servlet.http.HttpServletRequest;

public class SessionUtils {
    public static ShoppingCart getCurrentShoppingCart(HttpServletRequest request) {
        return (ShoppingCart) request.getSession().getAttribute(Constants.CURRENT_SHOPPING_CURT);
    }

    public static void setCurrentShoppingCart(ShoppingCart shoppingCart, HttpServletRequest request) {
        request.getSession().setAttribute(Constants.CURRENT_SHOPPING_CURT, shoppingCart);
    }

    public static void updateShoppingCart(ShoppingCart shoppingCart, HttpServletRequest request) {
        shoppingCart = null;
        request.getSession().setAttribute(Constants.CURRENT_SHOPPING_CURT, shoppingCart);
    }

    public static Account getCurrentAccount(HttpServletRequest request){
        return (Account) request.getSession().getAttribute(Constants.USER);
    }

    public static void setCurrentAccount(Account account,HttpServletRequest request){
        request.getSession().setAttribute(Constants.USER,account);
    }
}
