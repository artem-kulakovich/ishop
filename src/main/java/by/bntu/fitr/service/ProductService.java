package by.bntu.fitr.service;

import by.bntu.fitr.entity.Product;
import by.bntu.fitr.form.SearchForm;

import java.util.List;

public interface ProductService {
    public List<Product> getAllProducts(int limit,int offset);
    public List<Product> getProductsByName(String searchingProduct,int limit,int offset);
    public List<Product> getProductsByCategories(List<Integer> categoriesId,int limit,int offset);
    public List<Product> getProductsBySearchingRequest(SearchForm searchForm,int limit,int offset);
    public Product getProductById(int productId);
    public int getCountOfProduct(String sql,Object...parameters);

}
