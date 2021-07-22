package by.bntu.fitr.service;

import by.bntu.fitr.entity.Category;

import java.util.List;

public interface CategoryService {
    public List<Category> getAllCategories();
    public int countOfCategories();
    public int countProductInCategory(int categoryId);

}
