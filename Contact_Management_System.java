/* A Contact Management System built in Java for managing personal contact information such as names, phone numbers, and email addresses. The program allows users to:
Add new contacts
View all stored contacts
Delete contacts
Save and load contacts from a file 
Contact Management System in Java   */

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

class Contact {
    private String name;
    private String phoneNumber;
    private String emailAddress;

    public Contact(String name, String phoneNumber, String emailAddress) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.emailAddress = emailAddress;
    }

    @Override
    public String toString() {
        return "Name: " + name + "\nPhone Number: " + phoneNumber + "\nEmail Address: " + emailAddress + "\n";
    }
}

public class Contact_Management_System {
    private static ArrayList<Contact> contacts = new ArrayList<>(); // Added semicolon here
    private static final String FILE_NAME = "contacts.txt";

    public static void main(String[] args) {
        loadContactsFromFile();

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nContact Management System");
            System.out.println("1. Add a new contact");
            System.out.println("2. View contacts");
            System.out.println("3. Delete a contact");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    addContact(scanner);
                    break;
                case 2:
                    viewContacts();
                    break;
                case 3:
                    deleteContact(scanner);
                    break;
                case 4:
                    saveContactsToFile();
                    System.out.println("Exiting the Contact Management System. Goodbye!");
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        }
    }

    private static void addContact(Scanner scanner) {
        System.out.print("Enter name: ");
        String name = scanner.nextLine();

        System.out.print("Enter phone number: ");
        String phoneNumber = scanner.nextLine();

        System.out.print("Enter email address: ");
        String emailAddress = scanner.nextLine();

        Contact newContact = new Contact(name, phoneNumber, emailAddress);
        contacts.add(newContact);

        System.out.println("Contact added successfully!");
    }

    private static void viewContacts() {
        if (contacts.isEmpty()) {
            System.out.println("No contacts available.");
        } else {
            System.out.println("Contact List:");
            for (Contact contact : contacts) {
                System.out.println(contact);
            }
        }
    }

    private static void deleteContact(Scanner scanner) {
        viewContacts();

        if (contacts.isEmpty()) {
            System.out.println("No contacts available to delete.");
            return;
        }

        System.out.print("Enter the index of the contact to delete: ");
        int index = scanner.nextInt();

        if (index >= 0 && index < contacts.size()) {
            Contact deletedContact = contacts.remove(index);
            System.out.println("Contact deleted successfully:\n" + deletedContact);
        } else {
            System.out.println("Invalid index. No contact deleted.");
        }
    }

    private static void loadContactsFromFile() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            Object obj = ois.readObject();
            if (obj instanceof ArrayList<?>) {
                ArrayList<Contact> loadedContacts = (ArrayList<Contact>) obj;
                contacts.addAll(loadedContacts);
                System.out.println("Contacts loaded successfully from file.");
            } else {
                System.out.println("Invalid format in the file. Unable to load contacts.");
            }
        } catch (FileNotFoundException e) {
            System.out.println("No previous contacts found. Starting fresh.");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error loading contacts from file: " + e.getMessage());
        }
    }
    
    

    private static void saveContactsToFile() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            oos.writeObject(contacts);
            System.out.println("Contacts saved successfully to file.");
        } catch (IOException e) {
            System.out.println("Error saving contacts to file: " + e.getMessage());
        }
    }
}
