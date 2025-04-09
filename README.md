# 📞 PhoneBook Project – Java Console App

This is a simple **Phone Book** project implemented in **Java**.

The app allows you to manage contacts via a console menu: add, remove, sort, save to file, and load from file.

---

## 📚 Features

The phone book supports the following actions through a console-based menu:

1. **Add** a single contact  
2. **Remove** a contact by first name + last name (removes one match only)  
3. **Add** a list of contacts  
4. **Print all contacts** sorted by **first name**  
5. **Print all contacts** sorted by **last name**  
6. **Remove all** contacts  
7. **Clear phone numbers** of all contacts  
8. **Save** current contact list to a file  
9. **Load** contacts from a file (only if not already existing)  
10. **Save & Exit** the application

---

## 🧱 Data Model

Each contact includes the following fields:

- `firstName` *(required)*  
- `lastName` *(required)*  
- `primaryPhone` *(required)*  
- `secondaryPhone` *(optional)*  
- `address` *(optional)*  
- `jobTitle` *(optional)*

---

## ▶️ How to Run

1. **Compile the program** (from `src` folder):
   ```bash
   javac PhoneBookMain.java
