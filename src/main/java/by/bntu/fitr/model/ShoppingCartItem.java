package by.bntu.fitr.model;

import by.bntu.fitr.entity.Product;

public class ShoppingCartItem {
    private Product product;
    private int count;

    public ShoppingCartItem(Product product, int count) {
        this.product = product;
        this.count = count;
    }


    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
