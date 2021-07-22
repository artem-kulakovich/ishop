package by.bntu.fitr.model;

import by.bntu.fitr.constants.Constants;
import by.bntu.fitr.entity.Product;

import java.util.HashMap;
import java.util.Map;

public class ShoppingCart {
    private Map<Integer, ShoppingCartItem> shoppingCart = new HashMap<>();
    private int totalCost = 0;



    public void addProductToCart(Product product, int count) {
        ShoppingCartItem shoppingCartItem = shoppingCart.get(product.getId());
        if (shoppingCartItem == null) {
            shoppingCartItem = new ShoppingCartItem(product, count);
            shoppingCart.put(product.getId(), shoppingCartItem);
        }
        if (shoppingCartItem.getCount() < Constants.MAX_PRODUCT_PER_SHOPPING_CART) {
            shoppingCartItem.setCount(count);
            shoppingCart.put(product.getId(), shoppingCartItem);
        }
        refreshStatistics();
    }


    public void removeProductFromCart(int productId, int count) {
        ShoppingCartItem shoppingCartItem = shoppingCart.get(productId);
        if (shoppingCartItem != null) {
            shoppingCartItem.setCount(count);
            if (shoppingCartItem.getCount() > 0) {
                shoppingCart.put(productId, shoppingCartItem);
            } else if (shoppingCartItem.getCount() == 0) {
                shoppingCart.remove(productId);
            }
        }
        refreshStatistics();
    }



    public Map<Integer, ShoppingCartItem> getShoppingCart() {
        return shoppingCart;
    }

    public void refreshStatistics() {
        totalCost = 0;
        for (Map.Entry<Integer, ShoppingCartItem> entry : shoppingCart.entrySet()) {
            totalCost += entry.getValue().getCount() * entry.getValue().getProduct().getCost();
        }
    }

    public boolean isVoid(){
        return shoppingCart.isEmpty();
    }


    public int getTotalCost() {
        return totalCost;
    }
}
