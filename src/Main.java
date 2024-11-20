import main.java.com.souza.stock.List;
import main.java.com.souza.stock.Product;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        List<Product> list = new List<Product>(20);

        int option;

        do {
            System.out.println("\nMenu:");
            System.out.println("1. Add product");
            System.out.println("2. Remove Product");
            System.out.println("3. Consult Product");
            System.out.println("4. Product list");
            System.out.println("0. Exit");
            System.out.print("Choose an option: ");
            option = scan.nextInt();

            switch (option) {
                case 1:
                    System.out.print("Cod: ");
                    int cod = scan.nextInt();
                    System.out.print("Name: ");
                    scan.nextLine();
                    String name = scan.nextLine();
                    System.out.print("Quantity: ");
                    int quantity = scan.nextInt();
                    System.out.print("Price: ");
                    double price = scan.nextDouble();

                    Product product = new Product(cod, name, quantity, price);
                    addProduct(list, product);
                    break;
                case 2:
                    System.out.print("Enter the code of the product to remove: ");
                    int codRemove = scan.nextInt();
                    removeProduct(list, codRemove);
                    break;
                case 3:
                    System.out.print("Enter the code of the product to search: ");
                    int codConsult = scan.nextInt();
                    consultProduct(list, codConsult);
                    break;
                case 4:
                    productList(list);
                    break;
                case 0:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        } while (option != 0);

        scan.close();

    }


    public static void addProduct(List<Product> list, Product product) {
        // update the list
        for (int i = 0; i < list.size(); i++) {

            Product p = list.searchBy(i);

            if (p.getCod() == product.getCod()) {
                p.setQuantity(p.getQuantity() + product.getQuantity());
                System.out.println("Existing product found. quantity updated!");
                return;
            }
        }

        //add
        if (list.add(product)) {
            System.out.println("Product successfully added!");
        } else {
            System.out.println("Failed to add product.");
        }
    }

    public static void removeProduct(List<Product> list, int cod) {
        try {
            list.removeBy(cod);
            System.out.println("Product removed successfully!");
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }

    }

    public static void consultProduct(List<Product> list, int cod) {
        for (int i = 0; i < list.size(); i++) {
            Product p = list.searchBy(i);
            if (p.getCod() == cod) {
                System.out.println("Product found: " + p);
                return;
            }
        }
        System.out.println("Product not found.");
    }

    public static void productList(List<Product> list) {
        if (list.size() == 0) {
            System.out.println("No products registered.");
            return;
        }

        System.out.println("Registered products:");
        System.out.println(list);
    }

}