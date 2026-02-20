import java.util.ArrayList;

public class Inventory {

    private ArrayList<Product> productList = new ArrayList<>();

    public void addProduct(Product product) {
        productList.add(product);
        System.out.println("Product added successfully!");
    }

    public void displayProducts() {
        if (productList.isEmpty()) {
            System.out.println("No products available.");
            return;
        }

        for (Product p : productList) {
            System.out.println(p);
        }
    }

    public Product searchProduct(int id) {
        for (Product p : productList) {
            if (p.getProductId() == id) {
                return p;
            }
        }
        return null;
    }

    public void deleteProduct(int id) {
        Product p = searchProduct(id);
        if (p != null) {
            productList.remove(p);
            System.out.println("Product deleted successfully!");
        } else {
            System.out.println("Product not found.");
        }
    }

    public void sellProduct(int id, int quantity) {
        Product p = searchProduct(id);
        if (p != null) {
            if (p.getQuantity() >= quantity) {
                p.setQuantity(p.getQuantity() - quantity);
                System.out.println("Product sold successfully!");
            } else {
                System.out.println("Not enough stock available.");
            }
        } else {
            System.out.println("Product not found.");
        }
    }
}