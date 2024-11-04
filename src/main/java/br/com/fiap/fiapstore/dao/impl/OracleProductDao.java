package br.com.fiap.fiapstore.dao.impl;

import br.com.fiap.fiapstore.dao.ConnectionManager;
import br.com.fiap.fiapstore.dao.ProductDao;
import br.com.fiap.fiapstore.exception.DBException;
import br.com.fiap.fiapstore.model.Product;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class OracleProductDao implements ProductDao {

    private Connection connection;

    @Override
    public void register(Product product) throws DBException {

        PreparedStatement stmt = null;

        connection = ConnectionManager.getInstance().getConnection();

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
            throw new DBException("Error registering product.");
        } finally {
            try {
                stmt.close();
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }



    @Override
    public void update(Product product) throws DBException {

        PreparedStatement stmt = null;

        try {
            connection = ConnectionManager.getInstance().getConnection();

            String sql = "UPDATE TB_PRODUCT SET " +
                    "PRODUCT_NAME = ?, " +
                    "PRODUCT_QUANTITY = ?, " +
                    "PRODUCT_VALUE = ?, " +
                    "MANUFACTURE_DATE = ? " +
                    "WHERE PRODUCT_CODE = ?";

            stmt = connection.prepareStatement(sql);
            stmt.setString(1, product.getName());
            stmt.setInt(2, product.getQuantity());
            stmt.setDouble(3, product.getValue());
            stmt.setDate(4, Date.valueOf(product.getManufacturingDate()));
            stmt.setInt(5, product.getCode());

            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
            throw new DBException("Error updating record.");
        } finally {
            try {
                stmt.close();
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }


    @Override
    public void remove(int code) throws DBException {

        PreparedStatement stmt = null;

        try {
            connection = ConnectionManager.getInstance().getConnection();
            String sql = "DELETE FROM TB_PRODUCT WHERE PRODUCT_CODE = ?";
            stmt = connection.prepareStatement(sql);
            stmt.setInt(1, code);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new DBException("Error removing record.");
        } finally {
            try {
                stmt.close();
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }


    @Override
    public Product search(int code) {

        Product product = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            connection = ConnectionManager.getInstance().getConnection();
            String sql = "SELECT * FROM TB_PRODUCT WHERE PRODUCT_CODE = ?";
            stmt = connection.prepareStatement(sql);
            stmt.setInt(1, code);
            rs = stmt.executeQuery();

            if (rs.next()) {
                int codeReturned = rs.getInt("PRODUCT_CODE");
                String name = rs.getString("PRODUCT_NAME");
                int quantity = rs.getInt("PRODUCT_QUANTITY");
                double value = rs.getDouble("PRODUCT_VALUE");
                LocalDate manufacturingDate = rs.getDate("MANUFACTURE_DATE").toLocalDate();

                product = new Product(code, name, value, quantity, manufacturingDate);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                stmt.close();
                rs.close();
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return product;
    }


    @Override
    public List<Product> list() {

        List<Product> list = new ArrayList<>();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            connection = ConnectionManager.getInstance().getConnection();
            String sql = "SELECT * FROM TB_PRODUCT";
            stmt = connection.prepareStatement(sql);
            rs = stmt.executeQuery();

            // Iterate through all the found records
            while (rs.next()) {
                int code = rs.getInt("PRODUCT_CODE");
                String name = rs.getString("PRODUCT_NAME");
                int quantity = rs.getInt("PRODUCT_QUANTITY");
                double value = rs.getDouble("PRODUCT_VALUE");
                java.sql.Date date = rs.getDate("MANUFACTURE_DATE");
                LocalDate manufacturingDate = rs.getDate("MANUFACTURE_DATE").toLocalDate();

                Product product = new Product(code, name, value, quantity, manufacturingDate);
                list.add(product);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                stmt.close();
                rs.close();
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return list;
    }

}
