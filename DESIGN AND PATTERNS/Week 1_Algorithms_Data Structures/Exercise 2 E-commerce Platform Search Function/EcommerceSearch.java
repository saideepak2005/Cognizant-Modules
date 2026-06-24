package exercise2;

import java.util.Arrays;
import java.util.Comparator;

class Product {
    private String productId;
    private String productName;
    private String category;

    public Product(String productId, String productName, String category) {
        this.productId = productId;
        this.productName = productName;
        this.category = category;
    }

    public String getProductId() {
        return productId;
    }

    public String getProductName() {
        return productName;
    }

    public String getCategory() {
        return category;
    }

    @Override
    public String toString() {
        return "Product{" +
                "ID='" + productId + '\'' +
                ", Name='" + productName + '\'' +
                ", Category='" + category + '\'' +
                '}';
    }
}

public class EcommerceSearch {

    public static Product linearSearch(Product[] products, String targetName) {
        for (Product product : products) {
            if (product.getProductName().equalsIgnoreCase(targetName)) {
                return product;
            }
        }
        return null;
    }

    public static Product binarySearch(Product[] products, String targetName) {
        int left = 0;
        int right = products.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int comparison = products[mid].getProductName().compareToIgnoreCase(targetName);

            if (comparison == 0) {
                return products[mid];
            } else if (comparison < 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        Product[] products = {
            new Product("P105", "Wireless Mouse", "Electronics"),
            new Product("P101", "Mechanical Keyboard", "Electronics"),
            new Product("P103", "Gaming Monitor", "Electronics"),
            new Product("P102", "USB-C Cable", "Accessories"),
            new Product("P104", "Bluetooth Speaker", "Electronics")
        };

        System.out.println("--- Unsorted Products ---");
        for (Product p : products) {
            System.out.println(p);
        }

        System.out.println("\n--- Testing Linear Search ---");
        String searchTarget = "Gaming Monitor";
        Product foundLinear = linearSearch(products, searchTarget);
        System.out.println("Searching for '" + searchTarget + "': " + (foundLinear != null ? foundLinear : "Not Found"));

        Product notFoundLinear = linearSearch(products, "Smart Fridge");
        System.out.println("Searching for 'Smart Fridge': " + (notFoundLinear != null ? notFoundLinear : "Not Found"));

        Arrays.sort(products, Comparator.comparing(Product::getProductName, String.CASE_INSENSITIVE_ORDER));

        System.out.println("\n--- Sorted Products ---");
        for (Product p : products) {
            System.out.println(p);
        }

        System.out.println("\n--- Testing Binary Search ---");
        Product foundBinary = binarySearch(products, searchTarget);
        System.out.println("Searching for '" + searchTarget + "': " + (foundBinary != null ? foundBinary : "Not Found"));

        Product notFoundBinary = binarySearch(products, "Smart Fridge");
        System.out.println("Searching for 'Smart Fridge': " + (notFoundBinary != null ? notFoundBinary : "Not Found"));
    }
}
