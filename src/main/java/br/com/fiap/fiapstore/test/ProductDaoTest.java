package br.com.fiap.fiapstore.test;

import br.com.fiap.fiapstore.dao.ProductDao;
import br.com.fiap.fiapstore.exception.DBException;
import br.com.fiap.fiapstore.factory.DaoFactory;
import br.com.fiap.fiapstore.model.Product;

import java.sql.SQLOutput;
import java.time.LocalDate;
import java.util.List;

public class ProductDaoTest {

    public static void main(String[] args) {

        ProductDao dao = DaoFactory.getProductDAO();

        // Register a product
        Product product = new Product(
                0,
                "GameBoy Color",
                225.49,
                3,
                LocalDate.of(2011,10,2)
        );

        try {
            dao.register(product);
        } catch (DBException e) {
            throw new RuntimeException(e);
        }

        // Search for a product by ID and update it
        product = dao.search(2);
        product.setName("LED Monitor");
        product.setValue(891.99);
        try {
            dao.update(product);
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
            dao.remove(4);
        } catch (DBException e) {
            e.printStackTrace();
        }

    }




}
