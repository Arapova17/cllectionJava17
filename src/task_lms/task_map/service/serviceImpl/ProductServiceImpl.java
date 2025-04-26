package task_lms.task_map.service.serviceImpl;

import linkedlist.service.PackageService;
import task_lms.task_map.Main;
import task_lms.task_map.database.Database;
import task_lms.task_map.enums.KeyCharacter;
import task_lms.task_map.models.Product;
import task_lms.task_map.service.ProductService;

import javax.xml.crypto.Data;
import java.util.*;

import static task_lms.task_map.database.Database.products;

public class ProductServiceImpl implements ProductService {
    @Override
    public void saveProduct(Product product) {
        products.add(product);
    }

    @Override
    public void updateProduct(Long id, Product updatedProduct) {
        for (Product product : products){
            if (product.id().equals(id)) {
                product.setName(updatedProduct.name());
                product.setCategory(updatedProduct.category());
                product.setCharacters(updatedProduct.characters());
                product.setPrice(updatedProduct.price());
            }
        }
    }

    @Override
    public Product getByIdProduct(Long id) {
        for (Product product : products){
            if (product.id().equals(id)){
                return product;
            }
        }
        return null;
    }

    @Override
    public List<Product> searchByProductName(String name) {
        for (Product product : products){
            if (product.name().toLowerCase().contains(name.toLowerCase())){
                return products;
            }
        }
        return null;
    }

    @Override
    public List<Product> filterByCharacter(KeyCharacter key, String value) {
        for (Product product : products){
            for (Map<KeyCharacter, String> map : product.characters()){
                if (map.containsKey(key) && map.get(key).equalsIgnoreCase(value)){
                    products.add(product);
                    break;
                }
            }

        }
        return products;
    }

    @Override
    public List<Product> sortByCharacter(KeyCharacter key) {
        for (int i = 0; i < products.size() - 1; i++) {
            for (int j = i + 1; j < products.size(); j++) {
                Product p1 = products.get(i);
                Product p2 = products.get(j);

                String value1 = null;
                String value2 = null;

                List<Map<KeyCharacter, String>> characters1 = p1.characters();
                if (characters1 != null) {
                    for (int k = 0; k < characters1.size(); k++) {
                        Map<KeyCharacter, String> map = characters1.get(k);
                        if (map.containsKey(key)) {
                            value1 = map.get(key);
                            break;
                        }
                    }
                }

                List<Map<KeyCharacter, String>> characters2 = p2.characters();
                if (characters2 != null) {
                    for (int k = 0; k < characters2.size(); k++) {
                        Map<KeyCharacter, String> map = characters2.get(k);
                        if (map.containsKey(key)) {
                            value2 = map.get(key);
                            break;
                        }
                    }
                }

                if (value1 != null && value2 != null && value1.compareTo(value2) > 0) {
                    products.set(i, p2);
                    products.set(j, p1);
                }
            }
        }
        return products;
    }

    @Override
    public void deleteByProduct(Long id) {
        for (Product product : products){
            if (product.id().equals(id)){
                System.out.println(products.remove(product));
            }
        }
    }

    @Override
    public List<Product> getAllProduct() {
        return products;
    }

    @Override
    public void deleteCharacterByKeyName(Long productId, KeyCharacter key) {
        Product product = getByIdProduct(productId);
        if (product != null) {
            List<Map<KeyCharacter, String>> characters = product.characters();
            for (Iterator<Map<KeyCharacter, String>> iterator = characters.iterator(); iterator.hasNext(); ) {
                Map<KeyCharacter, String> map = iterator.next();
                if (map.containsKey(key)) {
                    iterator.remove();
                    System.out.println("Character removed.");
                    break;
                }
            }
        }
    }

    @Override
    public void deleteAllCharacters(Long productId) {
        Product product = getByIdProduct(productId);
        if (product != null){
            List<Map<KeyCharacter, String>> characters = product.characters();
            for (int i = 0; i < characters.size(); i++) {
                characters.remove(i);
                i--;
            }
        }
    }
}
