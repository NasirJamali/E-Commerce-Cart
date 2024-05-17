import java.util.*;

public class HelloWorld {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Double> cart = new HashMap<>();

        while (true) {
            System.out.println("1. Add item to Cart");
            System.out.println("2. View items in Cart");
            System.out.println("3. Remove item from Cart");
            System.out.println("4. Calculate total cost");
            System.out.println("0. Exit");
            System.out.println("Enter your choice: ");
            System.out.flush(); // Flush the output buffer
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Enter item name: ");
                    System.out.flush(); // Flush the output buffer
                    String itemName = scanner.next();
                    System.out.println("Enter item price: ");
                    System.out.flush(); // Flush the output buffer
                    double itemPrice = scanner.nextDouble();
                    cart.put(itemName, itemPrice);
                    break;
                case 2:
                    System.out.println("Items in your Cart:");
                    cart.forEach((name, price) -> System.out.println(name + " - $" + price));
                    break;
                case 3:
                    System.out.println("Enter item name to remove: ");
                    System.out.flush(); // Flush the output buffer
                    String itemToRemove = scanner.next();
                    if (cart.containsKey(itemToRemove)) {
                        cart.remove(itemToRemove);
                        System.out.println(itemToRemove + " removed from the Cart.");
                    } else {
                        System.out.println("Item not found in the Cart.");
                    }
                    break;
                case 4:
                    double totalCost = cart.values().stream().mapToDouble(Double::doubleValue).sum();
                    System.out.println("Total cost of items in Cart: $" + totalCost);
                    break;
                case 0:
                    System.out.println("Thank you for using the Shopping Cart Program!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        }
    }
}
