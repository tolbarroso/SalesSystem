import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SalesSystem {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Item> items = new ArrayList<>();

        System.out.println("Welcome to the Sales System!");

        while (true) {
            System.out.println("Select an option:");
            System.out.println("1. Add item");
            System.out.println("2. Calculate total");
            System.out.println("3. Exit");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Item name: ");
                    String name = scanner.nextLine();
                    System.out.print("Item price: ");
                    double price = scanner.nextDouble();
                    System.out.print("Quantity: ");
                    int quantity = scanner.nextInt();
                    items.add(new Item(name, price, quantity));
                    break;
                case 2:
                    double total = calculateTotal(items);
                    System.out.println("Total: R$" + total);
                    generateReceipt(items, total);
                    break;
                case 3:
                    System.out.println("Thank you for using our Sales System!");
                    return;
                default:
                    System.out.println("Invalid option! Please try again.");
            }
        }
    }

    private static double calculateTotal(List<Item> items) {
        double total = 0;
        for (Item item : items) {
            total += item.getPrice() * item.getQuantity();
        }
        return total;
    }

    private static void generateReceipt(List<Item> items, double total) {
        System.out.println("\nReceipt:");
        for (Item item : items) {
            System.out.println(item.getName() + " - R$" + item.getPrice() + " x " + item.getQuantity());
        }
        System.out.println("Total: R$" + total);
    }

    static class Item {
        private String name;
        private double price;
        private int quantity;

        public Item(String name, double price, int quantity) {
            this.name = name;
            this.price = price;
            this.quantity = quantity;
        }

        public String getName() {
            return name;
        }

        public double getPrice() {
            return price;
        }

        public int getQuantity() {
            return quantity;
        }
    }
}