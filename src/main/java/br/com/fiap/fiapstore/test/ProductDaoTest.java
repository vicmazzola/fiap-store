package br.com.fiap.fiapstore.test;

import br.com.fiap.fiapstore.dao.ProductDao;
import br.com.fiap.fiapstore.exception.DBException;
import br.com.fiap.fiapstore.factory.DaoFactory;
import br.com.fiap.fiapstore.model.Product;

import java.time.LocalDate;
import java.util.List;

public class ProductDaoTest {

    public static void main(String[] args) {

        ProductDao dao = DaoFactory.getProductDAO();

        // Register a product
        Product product = new Product(
                0,
                "Wireless Mouse",
                77.49,
                100,
                LocalDate.of(2024,11,5)
        );

        try {
            dao.register(product);
        } catch (DBException e) {
            throw new RuntimeException(e);
        }

        // Search for a product by ID and update it
        product = dao.search(1);
        product.setName("LED Monitor 24\"");
        product.setValue(891.99);
        try {
            dao.update(product);
            System.out.println("Product updated.");
        } catch (DBException e) {
            e.printStackTrace();
        }

        // List the products
        List<Product> list = dao.list();
        for (Product item : list) {
            System.out.println(
                    item.getName() + " " +
                            item.getQuantity() + " " +
                            item.getValue());
        }

        // Remove a product
        try {
            dao.remove(1);
            System.out.println("Product removed.");
        } catch (DBException e) {
            e.printStackTrace();
        }

    }




}
