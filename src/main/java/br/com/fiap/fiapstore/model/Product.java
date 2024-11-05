package br.com.fiap.fiapstore.model;

import java.time.LocalDate;

public class Product {

    private int code;
    private String name;
    private double value;
    private int quantity;
    private LocalDate manufacturingDate;

    public Product() {}

    public Product(int code, String name, double value,
                   int quantity, LocalDate manufacturingDate) {
        this.code = code;
        this.name = name;
        this.value = value;
        this.quantity = quantity;
        this.manufacturingDate = manufacturingDate;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public LocalDate getManufacturingDate() {
        return manufacturingDate;
    }

    public void setManufacturingDate(LocalDate manufacturingDate) {
        this.manufacturingDate = manufacturingDate;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
