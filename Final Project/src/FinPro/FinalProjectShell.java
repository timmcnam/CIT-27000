/* Timothy McNamara
 * CIT 27000
 * Final Project
 * 06/14/2024
 */
package FinPro;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.InputMismatchException;

public class FinalProjectShell {
    private Scanner input = new Scanner(System.in); // Scanner object for input
    private final String adminUsername = "shamima"; // Admin username
    private final String adminPassword = "enjoythis"; // Admin password

    public static void main(String[] args) {
        FinalProjectShell foo = new FinalProjectShell();
        foo.mainMenu(); // Start with the main menu
    }

    public void mainMenu() {
        boolean exit = false; // Variable to control the loop
        do {
            try {
                // Display main menu options
                System.out.println("Main Menu Selection"
                                   + "\n 1 <-> Admin Login"
                                   + "\n 2 <-> User Menu"
                                   + "\n 3 <-> Exit");
                int option = input.nextInt();

                switch (option) {
                    case 1:
                        // Verify admin login
                        if (verifyAdminLogin()) {
                            adminMenu(); // Go to admin menu if verifyAdminLogin() returns true
                        } else {
                            System.out.println("Invalid credentials inputted.");
                        }
                        break;
                    case 2:
                        userMenu(); // Go to user menu
                        break;
                    case 3:
                        exit = confirmExit(); // Confirm exit
                        break;
                    default:
                        System.out.println("Invalid option. Please try again.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.");
                input.next(); // Clear the invalid input
            }
        } while (!exit); // Continue the loop until exit is true
    }

    private boolean verifyAdminLogin() {
        // Verify admin login credentials
        System.out.print("Enter username: ");
        String username = input.next();
        System.out.print("Enter password: ");
        String password = input.next();
        // returns true if the inserted username and password is true
        return adminUsername.equals(username) && adminPassword.equals(password);
    }

    private boolean confirmExit() {
        // Confirm exit
        System.out.print("Are you sure you want to exit? \n[yes or no] ");
        String confirm = input.next();
        return confirm.equalsIgnoreCase("yes");
    }

    public void adminMenu() {
        while (true) {
            // Display admin menu options
            System.out.println("Admin Menu"
                               + "\n 1 <-> Add Item"
                               + "\n 2 <-> Update Item"
                               + "\n 3 <-> Delete Item"
                               + "\n 4 <-> Return to Main Menu");
            int option = input.nextInt();

            switch (option) {
                case 1:
                    addItem(); // Add new item to inventory
                    break;
                case 2:
                    // Search and update an item
                    int updateIndex = searchForItem();
                    if (updateIndex != -1) {
                        updateItem(updateIndex);
                    } else {
                        System.out.println("Unable to find Item.");
                    }
                    break;
                case 3:
                    // Search and delete an item
                    int deleteIndex = searchForItem();
                    if (deleteIndex != -1) {
                        deleteItem(deleteIndex);
                    } else {
                        System.out.println("Cannot delete item. Cannot find it.");
                    }
                    break;
                case 4:
                    // Return to main menu
                    return;
                default:
                    System.out.println("Sorry that isn't one of the choices.");
            }
        }
    }

    public void userMenu() {
        while (true) {
            // Display user menu options
            System.out.println("User Menu:"
                               + "\n 1 <-> Display All Items"
                               + "\n 2 <-> Purchase Item"
                               + "\n 3 <-> Return to Main Menu");
            int option = input.nextInt();

            switch (option) {
                case 1:
                    displayAllItems(); // Display all items in inventory
                    break;
                case 2:
                    // Search and purchase an item
                    int purchaseIndex = searchForItem();
                    if (purchaseIndex != -1) {
                        purchaseItem(purchaseIndex);
                    } else {
                        System.out.println("Item not found.");
                    }
                    break;
                case 3:
                    // Return to main menu
                    return;
                default:
                    System.out.println("Enter 1, 2 or 3 please.");
            }
        }
    }

    private void displayAllItems() {
        // Display all items in the inventory
        System.out.println("Item List:");
        try (BufferedReader br = new BufferedReader(new FileReader("items.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("An error attempting to read items from file.");
        }
    }

    public int searchForItem() {
        // Search for an item by name or ID
        System.out.print("Enter item name or ID to search: ");
        String searchKey = input.next();
        try (BufferedReader br = new BufferedReader(new FileReader("items.txt"))) {
            String line;
            int index = 0;
            while ((line = br.readLine()) != null) {
                if (line.contains(searchKey)) {
                    System.out.println("Item found:\n" + line);
                    return index;
                }
                index++;
            }
        } catch (IOException e) {
            System.out.println("Error reading items from file.");
        }
        return -1; // Item not found
    }

    private void deleteItem(int index) {
        // Delete item from the inventory
        List<String> lines = readAllLines();
        if (index >= 0 && index < lines.size()) {
            lines.remove(index);
            writeAllLines(lines);
            System.out.println("Item deleted successfully.");
        } else {
            System.out.println("Invalid index. Item not deleted.");
        }
    }

    private void updateItem(int index) {
        // Update item details
        List<String> lines = readAllLines();
        if (index >= 0 && index < lines.size()) {
            System.out.print("Enter new item ID (0-999): ");
            int id = input.nextInt();
            while (id < 0 || id > 999) {
                System.out.println("ID must be between 0 and 999.");
                System.out.print("Enter new item ID, please: ");
                id = input.nextInt();
            }
            input.nextLine(); // Consume the newline character left by nextInt()
            System.out.print("Enter new item name: ");
            String name = input.nextLine();
            System.out.print("Enter new item price: ");
            double price = input.nextDouble();
            System.out.print("Enter new item quantity: ");
            int quantity = input.nextInt();

            lines.set(index, id + " " + name + "$" + price + " " + quantity);
            writeAllLines(lines);
            System.out.println("Item updated successfully.");
        } else {
            System.out.println("Invalid index. Item not updated.");
        }
    }

    private void addItem() {
        // Add a new item to the inventory
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("items.txt", true))) {
            System.out.print("Enter item ID (0-999): ");
            int id = input.nextInt();
            while (id < 0 || id > 999) {
                System.out.println("ID must be between 0 and 999.");
                System.out.print("Enter item ID (0-999): ");
                id = input.nextInt();
            }
            input.nextLine(); // Consume the newline character left by nextInt()
            System.out.print("Enter item name: ");
            String name = input.nextLine();
            System.out.print("Enter item price: ");
            double price = input.nextDouble();
            System.out.print("Enter item quantity: ");
            int quantity = input.nextInt();

            writer.write(id + " " + name + " $" + price + " " + quantity + System.getProperty("line.separator"));
            System.out.println("Item successfully added :)");
        } catch (IOException e) {
            System.out.println("Error adding item to file.");
        }
    }

    private void purchaseItem(int index) {
        // Purchase an item
        List<String> lines = readAllLines();
        if (index >= 0 && index < lines.size()) {
            String[] itemDetails = lines.get(index).split(",", 4); // Split only into 4 parts
            if (itemDetails.length < 4) {
                System.out.println("Oof. Some details about this item are incomplete.");
                return;
            }
            String id = itemDetails[0];
            String name = itemDetails[1];
            double price = Double.parseDouble(itemDetails[2]);
            int quantity = Integer.parseInt(itemDetails[3]);

            System.out.print("Enter quantity to purchase: ");
            int purchaseQuantity = input.nextInt();

            if (purchaseQuantity > quantity) {
                System.out.println("There aren't enough items to purchase.");
                return;
            }

            double totalCost = price * purchaseQuantity * 1.07; // Including 7% sales tax
            int remainingQuantity = quantity - purchaseQuantity;

            lines.set(index, id + " " + name + " $" + price + " " + remainingQuantity);
            writeAllLines(lines);
            System.out.println("Purchase successful.");
            System.out.printf("Total cost (including 7%% tax) is $%.2f%n", totalCost); // Format to 2 decimal places
        } else {
            System.out.println("Invalid index. Purchase not completed.");
        }
    }

    private List<String> readAllLines() {
        // Read all lines from the items file
        List<String> lines = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader("items.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                lines.add(line);
            }
        } catch (IOException e) {
            System.out.println("Error reading items from file.");
        }
        return lines;
    }

    private void writeAllLines(List<String> lines) {
        // Write all lines to the items file
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("items.txt"))) {
            for (String line : lines) {
                writer.write(line + System.getProperty("line.separator"));
            }
        } catch (IOException e) {
            System.out.println("Error writing items to file.");
        }
    }
}

class Item {
    private String id;
    private String name;
    private double price;
    private int quantity;

    public Item(String id, String name, double price, int quantity) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public String getId() {
        return id;
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

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String toString() {
        return "\nItem "
                + "\nID ->" + id 
                + "\nName=" + name 
                + "\nPrice=" + price 
                + "\nQuantity=" + quantity ;
    }
}


