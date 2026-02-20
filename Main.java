import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Inventory inventory = new Inventory();
        int choice;

        do {
            System.out.println("\n===== INVENTORY MANAGEMENT SYSTEM =====");
            System.out.println("1. Add Product");
            System.out.println("2. View Products");
            System.out.println("3. Search Product");
            System.out.println("4. Delete Product");
            System.out.println("5. Sell Product");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    System.out.print("Enter Product ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter Product Name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter Price: ");
                    double price = sc.nextDouble();

                    System.out.print("Enter Quantity: ");
                    int qty = sc.nextInt();

                    Product product = new Product(id, name, price, qty);
                    inventory.addProduct(product);
                    break;

                case 2:
                    inventory.displayProducts();
                    break;

                case 3:
                    System.out.print("Enter Product ID to search: ");
                    int searchId = sc.nextInt();
                    Product found = inventory.searchProduct(searchId);

                    if (found != null) {
                        System.out.println(found);
                    } else {
                        System.out.println("Product not found.");
                    }
                    break;

                case 4:
                    System.out.print("Enter Product ID to delete: ");
                    int deleteId = sc.nextInt();
                    inventory.deleteProduct(deleteId);
                    break;

                case 5:
                    System.out.print("Enter Product ID to sell: ");
                    int sellId = sc.nextInt();

                    System.out.print("Enter Quantity to sell: ");
                    int sellQty = sc.nextInt();

                    inventory.sellProduct(sellId, sellQty);
                    break;

                case 6:
                    System.out.println("Exiting system...");
                    break;

                default:
                    System.out.println("Invalid choice.");
            }

        } while (choice != 6);

        sc.close();
    }
}