package by.bntu.fitr.form;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SearchForm {
    private List<Object> parameters;
    private String searchingProduct;
    private List<Integer> categories;
    private int page;

    public SearchForm(String[] categoriesInStr, String searchingProduct) {
        this.categories = convertToInt(categoriesInStr);
        this.searchingProduct = searchingProduct;

    }

    public List<Object> getParameters() {
        parameters = new ArrayList<>();
        for (int i = 0; i < categories.size(); i++) {
            parameters.add(categories.get(i));
        }
        parameters.add(searchingProduct);
        return parameters;
    }

    public List<Integer> convertToInt(String[] categoriesInStr) {
        categories = new ArrayList<>();
        if (categoriesInStr != null) {
            for (int i = 0; i < categoriesInStr.length; i++) {
                categories.add(Integer.parseInt(categoriesInStr[i]));
            }
        }
        return categories;
    }

    public Map<Integer, Boolean> getCategoriesMap() {
        Map<Integer, Boolean> categories = new HashMap<>();
        for (int i = 0; i < this.categories.size(); i++) {
            categories.put(this.categories.get(i), true);
        }
        return categories;
    }

    public static String formingSql(String sql, String field, String separator, int countOfParameters) {
        StringBuilder stringBuilder = new StringBuilder(sql);
        stringBuilder.append("(");
        for (int i = 0; i < countOfParameters; i++) {
            stringBuilder.append(" " + field + " ");
            stringBuilder.append(" = ");
            stringBuilder.append(" ? ");
            if (countOfParameters > 1 && i != countOfParameters - 1) {
                stringBuilder.append(separator);
            }
        }
        stringBuilder.append(")");
        return stringBuilder.toString();
    }


    public String getSearchingProduct() {
        return searchingProduct;
    }

    public List<Integer> getCategories() {
        return categories;
    }

    public int getPage() {
        return page;
    }
}
