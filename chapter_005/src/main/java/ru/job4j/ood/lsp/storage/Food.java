package ru.job4j.ood.lsp.storage;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Food {
    private String name;
    private LocalDate expiryDate;
    private LocalDate createDate;
    private double price;
    private int discount;

    public Food(String name, LocalDate expiryDate, LocalDate createDate, double price) {
        this.name = name;
        this.expiryDate = expiryDate;
        this.createDate = createDate;
        this.price = price;
    }

    public double expirationPercentage() {
        long lifeTime = ChronoUnit.DAYS.between(createDate, expiryDate);
        long remain = ChronoUnit.DAYS.between(LocalDate.now(), expiryDate);
        return (double) remain / lifeTime * 100;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    @Override
    public String toString() {
        return "Food{"
                + "name='" + name + '\''
                + ", expiryDate=" + expiryDate
                + ", createDate=" + createDate
                + ", price=" + price
                + ", discount=" + discount
                + '}';
    }
}
