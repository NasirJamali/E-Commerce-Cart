import java.util.*; // Import the java.util package

public class HelloWorld {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // Create a Scanner object to read user input
        Map<String, Double> cart = new HashMap<>(); // Create a HashMap to store the items in the cart

        while (true) { // Start an infinite loop to keep the program running
            // Display menu options to the user
            System.out.println("1. Add item to Cart");
            System.out.println("2. View items in Cart");
            System.out.println("3. Remove item from Cart");
            System.out.println("4. Calculate total cost");
            System.out.println("0. Exit");
            System.out.println("Enter your choice: ");
            System.out.flush(); // Flush the output buffer

            int choice = scanner.nextInt(); // Read the user's choice

            switch (choice) { // Switch statement to handle different user choices
                case 1:
                    // Add item to cart
                    System.out.println("Enter item name: ");
                    System.out.flush(); // Flush the output buffer
                    String itemName = scanner.next();
                    System.out.println("Enter item price: ");
                    System.out.flush(); // Flush the output buffer
                    double itemPrice = scanner.nextDouble();
                    cart.put(itemName, itemPrice); // Add the item and its price to the cart
                    break;
                case 2:
                    // View items in cart
                    System.out.println("Items in your Cart:");
                    cart.forEach((name, price) -> System.out.println(name + " - $" + price)); // Display each item in the cart
                    break;
                case 3:
                    // Remove item from cart
                    System.out.println("Enter item name to remove: ");
                    System.out.flush(); // Flush the output buffer
                    String itemToRemove = scanner.next();
                    if (cart.containsKey(itemToRemove)) { // Check if the item exists in the cart
                        cart.remove(itemToRemove); // Remove the item from the cart
                        System.out.println(itemToRemove + " removed from the Cart.");
                    } else {
                        System.out.println("Item not found in the Cart."); // Notify the user if the item is not found
                    }
                    break;
                case 4:
                    // Calculate total cost
                    double totalCost = cart.values().stream().mapToDouble(Double::doubleValue).sum(); // Calculate the total cost of items
                    System.out.println("Total cost of items in Cart: $" + totalCost); // Display the total cost
                    break;
                case 0:
                    // Exit the program
                    System.out.println("Thank you for using the Shopping Cart Program!");
                    scanner.close(); // Close the scanner
                    return; // Exit the loop and terminate the program
                default:
                    // Handle invalid choices
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        }
    }
}
