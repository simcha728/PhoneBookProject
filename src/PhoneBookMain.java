import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PhoneBookMain {
    public static void main(String[] args) {
        PhoneBook phoneBook = new PhoneBook();
        Scanner scanner = new Scanner(System.in);

        while(true) {
            printMenu();
            String choice = scanner.nextLine();

            switch(choice) {
                case "1": // הוספת איש קשר
                    System.out.println("Enter first name:");
                    String firstName = scanner.nextLine();
                    System.out.println("Enter last name:");
                    String lastName = scanner.nextLine();
                    System.out.println("Enter primary phone:");
                    String primaryPhone = scanner.nextLine();

                    System.out.println("Enter secondary phone (press Enter to skip):");
                    String secondaryPhone = scanner.nextLine();
                    if (secondaryPhone.isEmpty()) secondaryPhone = null;

                    System.out.println("Enter address (press Enter to skip):");
                    String address = scanner.nextLine();
                    if (address.isEmpty()) address = null;

                    System.out.println("Enter job title (press Enter to skip):");
                    String jobTitle = scanner.nextLine();
                    if (jobTitle.isEmpty()) jobTitle = null;

                    Contact newContact = new Contact(
                        firstName, lastName, primaryPhone,
                        secondaryPhone, address, jobTitle
                    );
                    phoneBook.addContact(newContact);
                    System.out.println("Contact added successfully.");
                    break;

                case "2": // מחיקת איש קשר
                    System.out.println("Enter first name to delete:");
                    String delFName = scanner.nextLine();
                    System.out.println("Enter last name to delete:");
                    String delLName = scanner.nextLine();

                    boolean removed = phoneBook.removeContact(delFName, delLName);
                    if (removed) {
                        System.out.println("Contact removed successfully.");
                    } else {
                        System.out.println("Contact not found.");
                    }
                    break;

                case "3": // הוספת רשימה של אנשי קשר
                    System.out.println("How many contacts would you like to add?");
                    int count = Integer.parseInt(scanner.nextLine());

                    List<Contact> contactList = new ArrayList<>();
                    for (int i = 0; i < count; i++) {
                        System.out.println("Enter details for contact #" + (i+1));

                        System.out.println("First name:");
                        String cFirstName = scanner.nextLine();
                        System.out.println("Last name:");
                        String cLastName = scanner.nextLine();
                        System.out.println("Primary phone:");
                        String cPrimaryPhone = scanner.nextLine();

                        System.out.println("Secondary phone (press Enter to skip):");
                        String cSecondaryPhone = scanner.nextLine();
                        if (cSecondaryPhone.isEmpty()) cSecondaryPhone = null;

                        System.out.println("Address (press Enter to skip):");
                        String cAddress = scanner.nextLine();
                        if (cAddress.isEmpty()) cAddress = null;

                        System.out.println("Job title (press Enter to skip):");
                        String cJobTitle = scanner.nextLine();
                        if (cJobTitle.isEmpty()) cJobTitle = null;

                        Contact contact = new Contact(
                            cFirstName, cLastName, cPrimaryPhone,
                            cSecondaryPhone, cAddress, cJobTitle
                        );
                        contactList.add(contact);
                    }
                    phoneBook.addContacts(contactList);
                    System.out.println(count + " contacts added.");
                    break;

                case "4": // הדפסה לפי שם פרטי
                    phoneBook.printSortedByFirstName();
                    break;

                case "5": // הדפסה לפי שם משפחה
                    phoneBook.printSortedByLastName();
                    break;

                case "6": // מחיקת כל אנשי הקשר
                    phoneBook.removeAllContacts();
                    System.out.println("All contacts removed.");
                    break;

                case "7": // מחיקת כל הטלפונים
                    phoneBook.removeAllPhones();
                    System.out.println("All phone numbers cleared.");
                    break;

                case "8": // שמירת אנשי קשר לקובץ
                    System.out.println("Enter file name to save (e.g. contacts.txt):");
                    String saveFileName = scanner.nextLine();
                    phoneBook.saveToFile(saveFileName);
                    break;

                case "9": // טעינת אנשי קשר מקובץ ( לא קיימים עדיין)
                    System.out.println("Enter file name to load (e.g. contacts.txt):");
                    String loadFileName = scanner.nextLine();
                    phoneBook.loadFromFile(loadFileName);
                    break;

                case "10": // שמירה ויציאה
                    System.out.println("Enter file name to save before exit (e.g. contacts.txt):");
                    String exitFileName = scanner.nextLine();
                    phoneBook.saveToFile(exitFileName);
                    System.out.println("Exiting...");
                    scanner.close();
                    System.exit(0);

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void printMenu() {
        System.out.println("\n--- Phone Book Menu ---");
        System.out.println("1. Add a contact");
        System.out.println("2. Remove a contact");
        System.out.println("3. Add a list of contacts");
        System.out.println("4. Print all contacts sorted by first name");
        System.out.println("5. Print all contacts sorted by last name");
        System.out.println("6. Remove all contacts");
        System.out.println("7. Remove all phones from all contacts");
        System.out.println("8. Save contacts to file");
        System.out.println("9. Load contacts from file");
        System.out.println("10. Save and exit");
        System.out.print("Choose an option: ");
    }
}
