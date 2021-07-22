package by.bntu.fitr.util;

import by.bntu.fitr.constants.Constants;
import by.bntu.fitr.entity.Product;
import by.bntu.fitr.form.SearchForm;
import by.bntu.fitr.service.ProductService;
import by.bntu.fitr.service.impl.ServiceManager;

import java.rmi.server.ServerCloneException;
import java.util.ArrayList;
import java.util.List;

public class SearchingUtils {


    public static List<Product> SearchOption(ProductService productService, SearchForm searchForm, int limit, int offset) {
        List<Product> productList = new ArrayList<>();
        if (searchForm.getCategories().size() == 0
                && (searchForm.getSearchingProduct() == null || searchForm.getSearchingProduct().isEmpty())) {
            productList = productService.getAllProducts(limit, offset);
        } else if (searchForm.getCategories().size() == 0 && searchForm.getSearchingProduct() != null) {
            productList = productService.getProductsByName(searchForm.getSearchingProduct()
                    , limit, offset);
        } else if (searchForm.getCategories().size() != 0 && (searchForm.getSearchingProduct() == null || searchForm.getSearchingProduct().isEmpty())) {
            productList = productService.getProductsByCategories(searchForm.getCategories()
                    , limit, offset);
        } else {
            productList = productService.getProductsBySearchingRequest(searchForm
                    , limit, offset);
        }
        return productList;
    }
}
