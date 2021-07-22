package by.bntu.fitr.model;

import by.bntu.fitr.constants.Constants;

import java.util.HashMap;
import java.util.Map;

public class Pagination {
    private String url;
    private String categories[];
    private String search;

    public Pagination(String url, String[] categories, String search) {
        this.categories = categories;
        this.url = url;
        this.search = search;
    }


    public Map<Integer, String> getPages(int countOfProducts) {
        String newUrl = formingURL();
        Map<Integer, String> pages = new HashMap<>();
        int size = (int) (Math.ceil((double) countOfProducts / Constants.LIMIT_PRODUCT_PER_PAGE));
        for (int i = 0; i < size; i++) {
            pages.put(i + 1, newUrl + (isProductUrl() ? "page=" : "&page=") + (i + 1));
        }
        return pages;
    }

    private String formingURL() {
        StringBuilder newURL = new StringBuilder(url + "?");
        if (categories != null) {
            for (int i = 0; i < categories.length; i++) {
                newURL.append("category=" + categories[i] + "&");
            }
        }
        if (isProductSearchUrl()) {
            newURL.append("search=" + (search = search == null ? "" : search));
        }
        return newURL.toString();
    }

    private boolean isProductUrl() {
        return url.equals("/product");
    }

    private boolean isProductSearchUrl() {
        return url.equals("/product/search");
    }
}
