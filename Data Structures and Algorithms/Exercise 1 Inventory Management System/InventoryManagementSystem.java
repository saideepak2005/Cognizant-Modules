package exercise1;

import java.util.HashMap;
import java.util.Map;

class Product {
    private String productId;
    private String productName;
    private int quantity;
    private double price;

    public Product(String productId, String productName, int quantity, double price) {
        this.productId = productId;
        this.productName = productName;
        this.quantity = quantity;
        this.price = price;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
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
                "ID='" + productId + '\'' +
                ", Name='" + productName + '\'' +
                ", Quantity=" + quantity +
                ", Price=$" + price +
                '}';
    }
}

public class InventoryManagementSystem {
    private Map<String, Product> inventory;

    public InventoryManagementSystem() {
        this.inventory = new HashMap<>();
    }

    public void addProduct(Product product) {
        if (inventory.containsKey(product.getProductId())) {
            System.out.println("Product with ID " + product.getProductId() + " already exists. Updating instead.");
            updateProduct(product.getProductId(), product.getQuantity(), product.getPrice());
        } else {
            inventory.put(product.getProductId(), product);
            System.out.println("Added: " + product);
        }
    }

    public void updateProduct(String productId, int newQuantity, double newPrice) {
        Product product = inventory.get(productId);
        if (product != null) {
            product.setQuantity(newQuantity);
            product.setPrice(newPrice);
            System.out.println("Updated: " + product);
        } else {
            System.out.println("Error: Product with ID " + productId + " not found.");
        }
    }

    public void deleteProduct(String productId) {
        Product removed = inventory.remove(productId);
        if (removed != null) {
            System.out.println("Deleted: " + removed);
        } else {
            System.out.println("Error: Product with ID " + productId + " not found.");
        }
    }

    public void displayInventory() {
        System.out.println("\n--- Current Inventory Status ---");
        if (inventory.isEmpty()) {
            System.out.println("Inventory is empty.");
        } else {
            for (Product product : inventory.values()) {
                System.out.println(product);
            }
        }
        System.out.println("--------------------------------\n");
    }

    public static void main(String[] args) {
        InventoryManagementSystem ims = new InventoryManagementSystem();

        Product p1 = new Product("P001", "Laptop", 10, 999.99);
        Product p2 = new Product("P002", "Smartphone", 25, 499.99);
        Product p3 = new Product("P003", "Headphones", 50, 79.99);

        System.out.println("--- Adding Products ---");
        ims.addProduct(p1);
        ims.addProduct(p2);
        ims.addProduct(p3);

        ims.displayInventory();

        System.out.println("--- Updating Product P002 ---");
        ims.updateProduct("P002", 30, 479.99);
        ims.displayInventory();

        System.out.println("--- Deleting Product P003 ---");
        ims.deleteProduct("P003");
        ims.displayInventory();

        System.out.println("--- Trying to update non-existing product P099 ---");
        ims.updateProduct("P099", 5, 10.00);
    }
}
