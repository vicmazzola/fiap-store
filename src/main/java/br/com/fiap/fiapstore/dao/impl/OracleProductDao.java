package br.com.fiap.fiapstore.dao.impl;

import br.com.fiap.fiapstore.dao.ConnectionManager;
import br.com.fiap.fiapstore.dao.ProductDao;
import br.com.fiap.fiapstore.exception.DBException;
import br.com.fiap.fiapstore.model.Product;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class OracleProductDao implements ProductDao {

    private Connection connection;

    @Override
    public void register(Product product) throws DBException {

        PreparedStatement stmt = null;

        Connection connection = ConnectionManager.getInstance().getConnection();

        String sql = "INSERT INTO TB_PRODUCT " +
                "(PRODUCT_CODE, PRODUCT_NAME, PRODUCT_QUANTITY, " +
                "PRODUCT_VALUE, MANUFACTURE_DATE) " +
                "VALUES (SQ_TB_PRODUCT.NEXTVAL, ?, ?, ?, ?)";


        try {
            stmt = connection.prepareStatement(sql);
            stmt.setString(1, product.getName());
            stmt.setInt(2, product.getQuantity());
            stmt.setDouble(3, product.getValue());
            stmt.setDate(4, Date.valueOf(product.getManufactureDate()));
            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
            throw new DBException("Error registering product.");
        } finally {
            try {
                if (stmt != null) stmt.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }



    @Override
    public void update(Product product) throws DBException {

    }

    @Override
    public void remove(Product product) throws DBException {

    }

    @Override
    public Product search(int id) {
        return null;
    }

    @Override
    public List<Product> list() {
        return List.of();
    }
}
