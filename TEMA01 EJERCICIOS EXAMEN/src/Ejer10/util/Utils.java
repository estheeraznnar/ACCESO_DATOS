package Ejer10.util;

import Ejer10.model.Product;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Utils {
    public  static List<Product> cargarProductos() throws IOException {
        //cargamos csv
        String DATA_FILE = "products.csv";
        String WORKING_DIRECTORY = System.getProperty("user.dir");
        Path path = Paths.get(WORKING_DIRECTORY + File.separator + DATA_FILE);
        final List<String> lines = Files.readAllLines(path, StandardCharsets.UTF_8);
        System.out.println(lines);

        List<Product> productList = new ArrayList<>();
        for (int i = 1; i < lines.size(); i++) {
            StringTokenizer tokenizer = new StringTokenizer(lines.get(i), ",");
            Product product = new Product();
            product.setProductID(Integer.parseInt(tokenizer.nextToken()));
            product.setProductName(tokenizer.nextToken());
            product.setSupplierID(Integer.parseInt(tokenizer.nextToken()));
            product.setCategoryID(Integer.parseInt(tokenizer.nextToken()));
            product.setQuantityPerUnit(tokenizer.nextToken());
            product.setUnitPrice(Double.parseDouble(tokenizer.nextToken()));
            product.setUnitsInStock(Integer.parseInt(tokenizer.nextToken()));
            product.setUnitsOnOrder(Integer.parseInt(tokenizer.nextToken()));
            product.setReorderLevel(Integer.parseInt(tokenizer.nextToken()));
            product.setDiscontinued(Integer.parseInt(tokenizer.nextToken()));

            System.out.println(product);
        }
        return productList;
    }
}
