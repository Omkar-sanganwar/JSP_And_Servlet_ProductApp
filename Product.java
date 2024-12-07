package com.tka.product;

public class Product {
    private int pid;
    private String name;
    private int price;
    private int qty;
    private String category;

    public Product(int pid, String name, int price, int qty, String category) {
        this.pid = pid;
        this.name = name;
        this.price = price;
        this.qty = qty;
        this.category = category;
    }

    // Getters and Setters
    public int getPid() { return pid; }
    public void setPid(int pid) { this.pid = pid; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public int getPrice() { return price; }
    public void setPrice(int price) { this.price = price; }
    public int getQty() { return qty; }
    public void setQty(int qty) { this.qty = qty; }
    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }
}
