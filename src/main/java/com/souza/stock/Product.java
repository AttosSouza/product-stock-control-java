package main.java.com.souza.stock;

public class Product {
    private int cod;
    private String name;
    private int quantity;
    private double price;

    public Product(int cod, String name, int quantity, double price) {
        this.cod = cod;
        this.name = name;
        this.quantity = quantity;
        this.price = price;
    }

    public int getCod() {
        return cod;
    }

    public void setCod(int cod) {
        this.cod = cod;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "cod=" + cod +
                ", name='" + name + '\'' +
                ", quantity=" + quantity +
                ", price=" + price +
                '}';
    }
}
