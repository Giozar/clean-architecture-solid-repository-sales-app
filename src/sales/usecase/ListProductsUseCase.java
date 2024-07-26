/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sales.usecase;

import java.util.List;
import domain.Product;
import sales.repository.ProductRepository;

/**
 *
 * @author giova
 */
public class ListProductsUseCase {
    
    private ProductRepository productRepository;
    
    public ListProductsUseCase(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }
    public List<Product> listProducts() {
        return productRepository.getAllProducts();
    }
}
