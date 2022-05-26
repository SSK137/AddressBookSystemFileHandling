package com.bridgelabz;

import java.io.IOException;

public class AddressBookSystemMain {
    public static void main(String[] args) throws IOException {
        System.out.println("Welcome to Address Book Program!");

        AddressBooksystem addressbooksystem = new AddressBooksystem();
        System.out.println("-------------------------------");
        addressbooksystem.AddressBook(addressbooksystem);
    }
}