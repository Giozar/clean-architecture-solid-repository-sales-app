/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sales.adapter.inmemory;

import domain.Product;
import java.util.ArrayList;
import java.util.List;
import sales.repository.ProductRepository;

/**
 *
 * @author giova
 */
public class InMemoryProductRepository implements ProductRepository {
    private List<Product> products = new ArrayList<>();
    
    public InMemoryProductRepository() {
        products.add(new Product("Celular", 500));
        products.add(new Product("Computadora", 1500));
        products.add(new Product("Plátanos", 1));
        products.add(new Product("Manzanas", 2));
    }
    
    @Override
    public List<Product> getAllProducts() {
        return products;
    }
}
