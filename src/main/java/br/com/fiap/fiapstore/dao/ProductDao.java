package br.com.fiap.fiapstore.dao;

import br.com.fiap.fiapstore.exception.DBException;
import br.com.fiap.fiapstore.model.Product;

import java.util.List;


public class ProductDao {

    void register(Product product) throws DBException;
    void update(Product product) throws DBException;
    void remove(int code) throws DBException;
    Product search(int id);
    List<Product> list();



}

