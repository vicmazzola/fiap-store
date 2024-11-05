package br.com.fiap.fiapstore.controller;

import br.com.fiap.fiapstore.dao.ProductDao;
import br.com.fiap.fiapstore.exception.DBException;
import br.com.fiap.fiapstore.factory.DaoFactory;
import br.com.fiap.fiapstore.model.Product;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.time.LocalDate;


@WebServlet("/products")
public class ProductServlet extends HttpServlet {

    private ProductDao dao;

    @Override
    public void init(ServletConfig config) throws ServletException {
        dao = DaoFactory.getProductDAO();

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String name = req.getParameter("name");
        int quantity = Integer.parseInt(req.getParameter("quantity"));
        double value = Double.parseDouble(req.getParameter("value"));
        LocalDate manufactureDate = LocalDate.parse(req.getParameter("manufacturing"));

        Product product = new Product(
                0,
                name,
                value,
                quantity,
                manufactureDate
        );

        try {
            dao.register(product);
            req.setAttribute("product", "Product added successfully");
        } catch (DBException e) {
            e.printStackTrace();
            req.setAttribute("error", "Failed to register product");
        }

        req.getRequestDispatcher("product-registration.jsp").forward(req, resp);

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
