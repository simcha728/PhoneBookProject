import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class PhoneBook {
    private List<Contact> contacts;

    public PhoneBook() {
        this.contacts = new ArrayList<>();
    }

    // 1. הוספת איש קשר (ללא ולידציה)
    public void addContact(Contact contact) {
        contacts.add(contact);
    }

    // 2. מחיקת איש קשר לפי שם פרטי + שם משפחה (רק מופע אחד)
    public boolean removeContact(String firstName, String lastName) {
        for (int i = 0; i < contacts.size(); i++) {
            Contact c = contacts.get(i);
            if (c.getFirstName().equals(firstName) && c.getLastName().equals(lastName)) {
                contacts.remove(i);
                return true;
            }
        }
        return false;
    }

    // 3. הוספת רשימה של אנשי קשר
    public void addContacts(List<Contact> newContacts) {
        contacts.addAll(newContacts);
    }

    // 4. הדפסה לפי שם פרטי
    public void printSortedByFirstName() {
        List<Contact> sortedList = new ArrayList<>(contacts);
        sortedList.sort(Comparator.comparing(Contact::getFirstName));
        
        for (Contact contact : sortedList) {
            System.out.println(contact);
        }
    }

    // 5. הדפסה לפי שם משפחה
    public void printSortedByLastName() {
        List<Contact> sortedList = new ArrayList<>(contacts);
        sortedList.sort(Comparator.comparing(Contact::getLastName));
        for (Contact contact : sortedList) {
            System.out.println(contact);
        }
    }

    // 6. מחיקת כל אנשי הקשר
    public void removeAllContacts() {
        contacts.clear();
    }

    // 7. מחיקת כל הטלפונים של כל אנשי הקשר
    public void removeAllPhones() {
        for (Contact c : contacts) {
            c.setPrimaryPhone("");
            c.setSecondaryPhone("");
        }
    }

    // 8. שמירת אנשי קשר לקובץ
    public void saveToFile(String fileName) {
        try (FileWriter writer = new FileWriter(fileName)) {
            // נשמור בפורמט CSV (ראשי תיבות מופרדים ב-;)
            for (Contact c : contacts) {
                writer.write(c.getFirstName() + ";" +
                             c.getLastName() + ";" +
                             (c.getPrimaryPhone() == null ? "" : c.getPrimaryPhone()) + ";" +
                             (c.getSecondaryPhone() == null ? "" : c.getSecondaryPhone()) + ";" +
                             (c.getAddress() == null ? "" : c.getAddress()) + ";" +
                             (c.getJobTitle() == null ? "" : c.getJobTitle()) + "\n");
            }
            System.out.println("Contacts saved successfully to " + fileName);
        } catch (IOException e) {
            System.out.println("Error while saving to file: " + e.getMessage());
        }
    }

    // 9. טעינת אנשי קשר מקובץ (בהנחה ואותם לקוחות אינם קיימים)
    public void loadFromFile(String fileName) {
        File file = new File(fileName);
        if (!file.exists()) {
            System.out.println("File does not exist: " + fileName);
            return;
        }
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(";");
                // גם כאן אנחנו לא "בולמים" אם parts.length<3 – רק ממשיכים
                // אך כדי לא לקרוס נבדוק שיש לפחות 3 שדות (אפשר גם להשמיט את הבדיקה לגמרי)
                if (parts.length < 3) {
                    continue;
                }

                String fName    = parts[0];
                String lName    = parts[1];
                String pPhone   = parts[2];
                String sPhone   = (parts.length > 3) ? parts[3] : "";
                String address  = (parts.length > 4) ? parts[4] : "";
                String jobTitle = (parts.length > 5) ? parts[5] : "";

                // בודקים אם איש קשר זה כבר קיים
                if (!isContactExist(fName, lName, pPhone)) {
                    Contact newContact = new Contact(
                        fName, lName, pPhone, sPhone, address, jobTitle
                    );
                    contacts.add(newContact);
                }
            }
            System.out.println("Contacts loaded successfully from " + fileName);
        } catch (IOException e) {
            System.out.println("Error while loading from file: " + e.getMessage());
        }
    }

    // פונקציית עזר לבדיקת קיום איש קשר (FirstName + LastName + PrimaryPhone)
    private boolean isContactExist(String firstName, String lastName, String primaryPhone) {
        for (Contact c : contacts) {
            if (c.getFirstName().equals(firstName) &&
                c.getLastName().equals(lastName) &&
                c.getPrimaryPhone().equals(primaryPhone)) {
                return true;
            }
        }
        return false;
    }
}
