import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class VehicleRegistrationApp {

    private static ArrayList<String> vehicleNumbers = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\nVehicle Registration Portal");
            System.out.println("1. Add Vehicle Number");
            System.out.println("2. Delete Vehicle Number");
            System.out.println("3. Search Vehicle Number");
            System.out.println("4. List Vehicle Numbers");
            System.out.println("5. Return to Main Menu");
            System.out.println("6. Exit Application");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    addVehicleNumber(scanner);
                    break;
                case 2:
                    deleteVehicleNumber(scanner);
                    break;
                case 3:
                    searchVehicleNumber(scanner);
                    break;
                case 4:
                    listVehicleNumbers();
                    break;
                case 5:
                    System.out.println("Returning to the main menu...");
                    break;
                case 6:
                    running = false;
                    System.out.println("Exiting application...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
        scanner.close();
    }

    private static void addVehicleNumber(Scanner scanner) {
        System.out.print("Enter vehicle number (uppercase only): ");
        String vehicleNumber = scanner.nextLine().toUpperCase();
        if (!vehicleNumbers.contains(vehicleNumber)) {
            vehicleNumbers.add(vehicleNumber);
            System.out.println("Vehicle number added successfully.");
        } else {
            System.out.println("Vehicle number already exists.");
        }
    }

    private static void deleteVehicleNumber(Scanner scanner) {
        System.out.print("Enter vehicle number to delete: ");
        String vehicleNumber = scanner.nextLine().toUpperCase();
        if (vehicleNumbers.remove(vehicleNumber)) {
            System.out.println("Vehicle number deleted successfully.");
        } else {
            System.out.println("Vehicle number not found.");
        }
    }

    private static void searchVehicleNumber(Scanner scanner) {
        System.out.print("Enter vehicle number to search: ");
        String vehicleNumber = scanner.nextLine().toUpperCase();
        if (vehicleNumbers.contains(vehicleNumber)) {
            System.out.println("Vehicle number found.");
        } else {
            System.out.println("Vehicle number not found.");
        }
    }

    private static void listVehicleNumbers() {
        if (vehicleNumbers.isEmpty()) {
            System.out.println("No vehicle numbers registered.");
        } else {
            Collections.sort(vehicleNumbers);
            System.out.println("Vehicle Numbers in Ascending Order:");
            for (String vehicleNumber : vehicleNumbers) {
                System.out.println(vehicleNumber);
            }
        }
    }
}