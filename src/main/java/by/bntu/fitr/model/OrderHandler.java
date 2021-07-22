package by.bntu.fitr.model;

import by.bntu.fitr.constants.Constants;
import by.bntu.fitr.entity.Account;
import by.bntu.fitr.entity.Product;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

public class OrderHandler {
    private double cost;
    private Account account;
    private Map<Integer, ShoppingCartItem> shoppingCart;

    public OrderHandler(ShoppingCart shoppingCart, Account account) {
        this.shoppingCart = shoppingCart.getShoppingCart();
        this.account = account;
        this.cost = shoppingCart.getTotalCost();
    }

    public String formingInfoQuery() {
        StringBuilder query = new StringBuilder();
        for (Map.Entry<Integer, ShoppingCartItem> productEntry : shoppingCart.entrySet()) {
            query.append("Название товара: " + productEntry.getValue().getProduct().getName());
            query.append("\nЦена за штуку: " + productEntry.getValue().getProduct().getCost());
            query.append("\nКоличество: " + productEntry.getValue().getCount());
        }
        query.append("\nОбщая цена: " + cost);
        query.append("\nЗаказчик: " + account.getFirsName() + "  " + account.getLastName());
        return query.toString();
    }

    public String getInfo() {
        return formingInfoQuery();
    }

    public int getConsumer() {
        return account.getId();
    }

    public double getCost() {
        return cost;
    }
}
