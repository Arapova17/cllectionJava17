package task_lms.task_map.service;

import task_lms.task_map.enums.KeyCharacter;
import task_lms.task_map.models.Product;

import java.util.List;

public interface ProductService {
    void saveProduct(Product product);
    void updateProduct(Long id, Product updatedProduct);
    Product getByIdProduct(Long id);
    List<Product> searchByProductName(String name);
    List<Product> filterByCharacter(KeyCharacter key, String value);
    List<Product> sortByCharacter(KeyCharacter key);
    void deleteByProduct(Long id);
    List<Product> getAllProduct();
    void deleteCharacterByKeyName(Long productId, KeyCharacter key);
    void deleteAllCharacters(Long productId);
}
