import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AddressBook {
    private List<Contact> contacts;

    public AddressBook() {
        contacts = new ArrayList<>();
    }

    public void addContact(Contact contact) {
        contacts.add(contact);
    }

    public void removeContact(String name) {
        contacts.removeIf(contact -> contact.getName().equalsIgnoreCase(name));
    }

    public Contact searchContact(String name) {
        for (Contact contact : contacts) {
            if (contact.getName().equalsIgnoreCase(name)) {
                return contact;
            }
        }
        return null;
    }

    public void displayAllContacts() {
        for (Contact contact : contacts) {
            System.out.println(contact);
        }
    }

    public void saveContactData(String fileName) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
            oos.writeObject(contacts);
            System.out.println("Contact data saved successfully!");
        } catch (IOException e) {
            System.out.println("Error while saving contact data: " + e.getMessage());
        }
    }

    public void loadContactData(String fileName) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {
            contacts = (List<Contact>) ois.readObject();
            System.out.println("Contact data loaded successfully!");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error while loading contact data: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        AddressBook addressBook = new AddressBook();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Address Book System");
            System.out.println("1. Add a contact");
            System.out.println("2. Remove a contact");
            System.out.println("3. Search for a contact");
            System.out.println("4. Display all contacts");
            System.out.println("5. Save contact data to a file");
            System.out.println("6. Load contact data from a file");
            System.out.println("7. Exit");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline left by nextInt()

            switch (choice) {
                case 1:
                    System.out.println("Enter contact name:");
                    String name = scanner.nextLine();
                    System.out.println("Enter phone number:");
                    String phoneNumber = scanner.nextLine();
                    System.out.println("Enter email address:");
                    String emailAddress = scanner.nextLine();
                    Contact newContact = new Contact(name, phoneNumber, emailAddress);
                    addressBook.addContact(newContact);
                    break;
                case 2:
                    System.out.println("Enter the name of the contact to remove:");
                    String nameToRemove = scanner.nextLine();
                    addressBook.removeContact(nameToRemove);
                    break;
                case 3:
                    System.out.println("Enter the name of the contact to search:");
                    String nameToSearch = scanner.nextLine();
                    Contact searchedContact = addressBook.searchContact(nameToSearch);
                    if (searchedContact != null) {
                        System.out.println("Contact found:");
                        System.out.println(searchedContact);
                    } else {
                        System.out.println("Contact not found.");
                    }
                    break;
                case 4:
                    addressBook.displayAllContacts();
                    break;
                case 5:
                    System.out.println("Enter the file name to save contact data:");
                    String saveFileName = scanner.nextLine();
                    addressBook.saveContactData(saveFileName);
                    break;
                case 6:
                    System.out.println("Enter the file name to load contact data:");
                    String loadFileName = scanner.nextLine();
                    addressBook.loadContactData(loadFileName);
                    break;
                case 7:
                    System.out.println("Exiting...");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
