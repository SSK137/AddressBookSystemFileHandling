package com.bridgelabz;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class AddressBooksystem {
    static ArrayList<String> contactsDetails = new ArrayList();
    static ArrayList<Contacts> contactDetails = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);
    static HashMap<String, ArrayList<Contacts>> hashmap = new HashMap<>();
    /*Execution Of Program Starts from here*/
    public static void AddressBook(AddressBooksystem addressBooksystem) {
        System.out.println("choice");
        int choice;
        do {
            System.out.println("\n1)Add Address Book \n2)Search Contact Details\n3)Sort By Name\n4)Sort by City adn State Name\n5)Read and Write Data From Text File\n6)Read and Write Data From CSV File\n7) Exit");
            choice=scanner.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Enter Name of Address Book");
                    String AddressBookName = scanner.next();
                    contactsDetails.add(AddressBookName);

                    if (hashmap.containsKey(AddressBookName)) {
                        System.out.println("The AddressBook already exist");
                        break;
                    } else {
                        addressBooksystem.MenuOption(addressBooksystem, contactDetails);
                        hashmap.put(AddressBookName, contactDetails);
                    }
                    System.out.println("AddressBook Added" + hashmap + " ");
                    break;
                case 2:
                    System.out.println("Enter name to search ");
                    String name = scanner.next();
                    SearchInMultipleBook(name);
                    break;
                case 3:
                    SortByName(hashmap);
                    break;
                case 4:
                    SortByCityState(hashmap);
                    break;
                case 5:
                    FileOperations.AddtoFile();
                    FileOperations.readFromFile();
                    break;
                case 6:
                    FileOperations.CSVWriters();
                    FileOperations.CSVReaders();
                    break;
                default:
                    System.out.println("Wrong Choice Entered");
                    break;
            }
        }while (choice<7);
    }
    /*----Method For Search Contact in Multiple address Books those who are belongs to Same City----*/
    public static void SearchInMultipleBook(String name){
        int CountFromAllAddressBook=0;
        for (Map.Entry<String, ArrayList<Contacts>> entry : hashmap.entrySet()){
            for (Contacts contacts1:entry.getValue()){
                if (contacts1.getCity().equals(name)|| contacts1.getState().equals(name)){
                    CountFromAllAddressBook+=1;
                    System.out.println("\nAddress Book Name :"+entry.getKey());
                    System.out.println("First Name :"+contacts1.getFirstName());
                    System.out.println("Last Name :"+contacts1.getLastName());
                    System.out.println("Mail-ID :"+contacts1.getEmail());
                    System.out.println("Address :"+contacts1.getAddress());
                    System.out.println("City Name :"+contacts1.getCity());
                    System.out.println("Contact Number :"+contacts1.getContactNo());
                }
            }
        }
        System.out.println("\n Total Count From Same City 0r State in Single Address Book : "+CountFromAllAddressBook);
    }
    /*----Method For Sort Contacts from address Books by Persons Name----*/
    public static void SortByName(HashMap<String, ArrayList<Contacts>> hashmap) {
        for (Map.Entry<String, ArrayList<Contacts>> addressBookMapEntry : hashmap.entrySet()) {
            List<Contacts> sortedContacts = addressBookMapEntry.getValue()
                    .stream()
                    .sorted(Comparator.comparing(contact1 -> contact1.getFirstName()))
                    .collect(Collectors.toList());
            System.out.println("Sorted Contacts By Name : ");
            for (Contacts contact : sortedContacts) {
                System.out.println(contact.toString());
            }
        }
    }
    /*----Method For Sort Contacts from address Books by Persons City and state Name----*/
    public static void SortByCityState(HashMap<String, ArrayList<Contacts>> hashmap) {
        for (Map.Entry<String, ArrayList<Contacts>> addressBookMapEntry : hashmap.entrySet()) {
            List<Contacts> sortedContacts = addressBookMapEntry.getValue()
                    .stream()
                    .sorted(Comparator.comparing(contact1 -> contact1.getCity() + contact1.getState()))
                    .collect(Collectors.toList());
            System.out.println("Sorted Contacts By City,State : ");
            for (Contacts contact : sortedContacts) {
                System.out.println(contact.toString());
            }
        }
    }
    /*----Method For Search Contact in particular address Books those who are belongs to Same City----*/
    public void SearchInSingleBook(ArrayList<Contacts> contactdetails){
        System.out.println("Enter name of city or state to search");
        String name=scanner.next();
        ArrayList<Contacts> contacts=new ArrayList<>();
        for (Contacts contact:contactdetails){
            if(contact.getCity().equals(name)||contact.getState().equals(name))
            {
                System.out.println(contact);
            }
        }
    }
    /*----Method For Add Contact Details in Address Book----*/
    public static ArrayList<Contacts> addDetails(ArrayList<Contacts> contactDetails) {
        Contacts info = new Contacts();
        if(contactDetails.size() == 0) {
            System.out.println("Enter First name: ");
            info.setFirstName(scanner.next());
            System.out.println("Enter last name: ");
            info.setLastName(scanner.next());
            System.out.println("Enter address: ");
            info.setAddress(scanner.next());
            System.out.println("Enter city name: ");
            info.setCity(scanner.next());
            System.out.println("Enter state name: ");
            info.setState(scanner.next());
            System.out.println("Enter zip code: ");
            info.setZipCode(scanner.next());
            System.out.println("Enter contact no.: ");
            info.setContactNo(scanner.next());
            System.out.println("Enter email: ");
            info.setEmail(scanner.next());
            contactDetails.add(info);
        } else {
            System.out.println("Enter First Name");
            String firstname = scanner.next();
            for (Contacts contact : contactDetails) {
                if (contact.getFirstName().equals(firstname)) {
                    System.out.print("Name already present\n");
                    AddressBooksystem.addDetails(contactDetails);
                }
            }
            {
                info.setFirstName(firstname);
                System.out.println("Enter Last Name");
                info.setLastName(scanner.next());
                System.out.println("Enter contact Number:");
                info.setContactNo(scanner.next());
                System.out.println("Enter Email: ");
                info.setEmail(scanner.next());
                System.out.println("Enter Address: ");
                info.setAddress(scanner.next());
                System.out.println("Enter City Name: ");
                info.setCity(scanner.next());
                System.out.println("Enter State: ");
                info.setState(scanner.next());
                System.out.println("Enetr Zip Code:");
                info.setZipCode(scanner.next());
                contactDetails.add(info);
            }
        }
        System.out.println("Contact details added!");
        return contactDetails;
    }
    /*----Method For Display All Contacts available in Address Book----*/
    public static void displayContacts(ArrayList<Contacts> contactsDetails){
        for (Contacts contacts:contactsDetails) {
            System.out.println(contacts);
        }
    }
    /*----Method For Update the contacts stored in Address Book----*/
    public void editDetails(ArrayList<Contacts> contactDetails){
        System.out.println("Enter First Name for which you want to modify info: ");
        String searchFirstName = scanner.next();
        /* Iterate to search for first name */
        for (Contacts contact : contactDetails) {
            if (contact.getFirstName().equals(searchFirstName)){
                System.out.println("Enter the number to edit respective info: ");
                System.out.println("1. First Name \n2. Last Name \n3. Address \n4. City " +
                        "\n5. State \n6. Zip Code \n7. Contact No \n8. Email");
                int index = scanner.nextInt();
                System.out.println("Enter value to update: ");
                switch (index){
                    case 1:
                        String updatedFirstName = scanner.next();
                        contact.setFirstName(updatedFirstName);
                        break;
                    case 2:
                        String updatedLastName = scanner.next();
                        contact.setLastName(updatedLastName);
                        break;
                    case 3:
                        String updatedAddress = scanner.next();
                        contact.setAddress(updatedAddress);
                        break;
                    case 4:
                        String updatedCity = scanner.next();
                        contact.setCity(updatedCity);
                        break;
                    case 5:
                        String updatedState = scanner.next();
                        contact.setState(updatedState);
                        break;
                    case 6:
                        String updatedZipCode = scanner.next();
                        contact.setZipCode(updatedZipCode);
                        break;
                    case 7:
                        String updatedContact = scanner.next();
                        contact.setContactNo(updatedContact);
                        break;
                    case 8:
                        String updatedEmail = scanner.next();
                        contact.setEmail(updatedEmail);
                        break;
                    default:
                        System.out.println("Invalid number!");
                }
                /* Display updated contact */
                System.out.println("Details updated");
            }
            else {
                System.out.println("No record found!");
            }
        }
    }
    /*----Method For Remove Record From Address Books----*/
    public void deleteContact(ArrayList<Contacts> contactDetails){
        System.out.println("Enter email for which you want to delete contact: ");
        String searchEmail = scanner.next();
        Iterator<Contacts> removeContact = contactDetails.iterator();
        while (removeContact.hasNext()){
            /* Move cursor to next element */
            Contacts nextElement = removeContact.next();
            if (nextElement.getEmail().equals(searchEmail)) {
                removeContact.remove();
                System.out.println("Contact is removed!");
                break;
            }
            else {
                System.out.println("Contact not found.");
            }
        }
    }

    /*----Method For Menu Operations to perform----*/
    public void MenuOption(AddressBooksystem addressBooksystem,ArrayList<Contacts> contactDetails ) {
        System.out.println("Enter a number to perform action: ");
        int menu, ans;
        do {
            System.out.println(" \n1. Add details \n2. Edit details \n3. Delete details \n4. Display details \n5.Search Contact in Perticular Book");
            System.out.println("Enter Option");
            menu = scanner.nextInt();
            switch (menu) {
                case 1:
                    /* Add contact details in address book */
                    addressBooksystem.addDetails(contactDetails);
                    break;
                case 2:
                    /* Edit contact details in address book */
                    addressBooksystem.editDetails(contactDetails);
                    break;
                case 3:
                    /* Delete contact details */
                    addressBooksystem.deleteContact(contactDetails);
                    break;
                case 4:
                    /* Display contact details */
                    addressBooksystem.displayContacts(contactDetails);
                    break;
                case 5:
                    SearchInSingleBook(contactDetails);
                    break;
                default:
                    System.out.println("Invalid option selected.");
                    break;
            }
            System.out.println("Do You Want To Perform more opration then Enter 1 else Enter 2");
            ans = scanner.nextInt();
        } while (ans == 1);
    }
}