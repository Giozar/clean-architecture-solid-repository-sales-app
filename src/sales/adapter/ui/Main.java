/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package sales.adapter.ui;

import java.util.Scanner;
import java.util.List;
import sales.adapter.inmemory.InMemoryProductRepository;
import sales.repository.ProductRepository;
import sales.usecase.ListProductsUseCase;
import sales.usecase.MakeSaleUseCase;
import domain.Product;
import java.util.ArrayList;
import java.util.InputMismatchException;

/**
 *
 * @author giova
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        ProductRepository productRepository = new InMemoryProductRepository();
        ListProductsUseCase listProductUseCase = new ListProductsUseCase(productRepository);
        MakeSaleUseCase makeSaleUseCase = new MakeSaleUseCase();
        
        Scanner scanner = new Scanner(System.in);
        List<Product> selectedProducts = new ArrayList<>();
        while (true) {
            System.out.println("Productos disponibles");
            List<Product> products = listProductUseCase.listProducts();
            for (int i = 0; i < products.size(); i++) {
                System.out.println((i + 1) + ". " + products.get(i));
            }
            
            System.out.println("Seleccione el número del producto para añadir al carrito o 0 para pagar:");
            try {
                int choice = scanner.nextInt();
                if (choice == 0) {
                    break;
                } else if (choice > 0 && choice <= products.size()) {
                    selectedProducts.add(products.get(choice - 1));
                } else {
                    System.out.println("Opción no válida.");
                }
            } catch( InputMismatchException e ) {
                System.out.println("No se ingresó una opción válida. Por favor, ingrese un número.");
                scanner.next(); // Limpiar el buffer del scanner
            }
            
        }
        
        double total = makeSaleUseCase.calculateTotal(selectedProducts);
        System.out.println("Total a pagar: $" + total);
    }
    
}
