package Ejer10;

import Ejer10.model.Product;

import java.io.IOException;
import java.util.Comparator;
import java.util.List;
import Ejer10.util.Utils;

public class Main {
    public static void main(String[] args) {
        List<Product> products;

        try {
            products = Utils.cargarProductos();


        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        System.out.println("--------------- 1");
        products.stream().forEach(System.out::println);

        System.out.println("--------------- 2");
        products.stream().map(Product::getProductName).forEach(System.out::println);

        System.out.println("---------------- 3");
        products.stream().filter(product -> product.getUnitsInStock()<10)
                .map(Product::getProductName)
                .forEach(System.out::println);

        System.out.println("---------------- 4");
        products.stream().filter(product -> product.getUnitsInStock()<10)
                .sorted(Comparator.comparingInt(Product::getUnitsInStock))
                .map(Product::getProductName)
                .forEach(System.out::println);
        System.out.println("---------------- 5");
        products.stream().filter(product -> product.getUnitsInStock()<10)
                .sorted(Comparator.comparingInt(Product::getUnitsInStock).reversed())
                .map(Product::getProductName)
                .forEach(System.out::println);

        System.out.println("------------- 6");
    }
}
