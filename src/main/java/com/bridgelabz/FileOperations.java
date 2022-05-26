package com.bridgelabz;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Map;

public class FileOperations {
    /*-----Methods For Text File Operations-----*/
    //Method for Add Data to the File
    public static void AddtoFile() {
        File file=new File("//home//hp//IdeaProjects//AddressBookSystemFileHandling//src//test.txt");
            try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file, true))) {
                for (Map.Entry<String, ArrayList<Contacts>> hash:AddressBooksystem.hashmap.entrySet())
                {
                    bufferedWriter.write(hash.getKey()+"\n"+hash.getValue());
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
    }
    //Method For Read Data From File
    public static void readFromFile() {
        File file=new File("//home//hp//IdeaProjects//AddressBookSystemFileHandling//src//test.txt");
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String st;
            while ((st = reader.readLine()) != null) {
                System.out.println(st);
            }
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }
    /*-----Methods For CSV File Operations-----*/
    public static void CSVWriters() {
        String Data = "//home//hp//IdeaProjects//AddressBookSystemFileHandling//src//Data.csv";
            try (Writer writer = Files.newBufferedWriter(Paths.get(Data));
                 CSVWriter csvWriter = new CSVWriter(writer);) {
                String[] header = { "First Name", "Last Name", "Address","City","Contact No","Email-id","State","Zip-Code" };
                csvWriter.writeNext(header);
                for (Map.Entry<String, ArrayList<Contacts>> addressBookMapEntry : AddressBooksystem.hashmap.entrySet()) {
                    ArrayList<Contacts> aa=addressBookMapEntry.getValue();
                    for (Contacts c:aa){
                        String[] s={c.getFirstName(), c.getLastName(),c.getAddress(),c.getCity(),c.getContactNo(),c.getEmail(),c.getState(),c.getZipCode()};
                        csvWriter.writeNext(s);
                    }
                }
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    public static void CSVReaders(){
        String Data = "//home//hp//IdeaProjects//AddressBookSystemFileHandling//src//Data.csv";
        try (
                Reader reader = Files.newBufferedReader(Paths.get(Data));
                CSVReader csvReader = new CSVReader(reader)
        ) {
            String nextRecord[];
            while ((nextRecord = csvReader.readNext()) != null) {
                System.out.println("First Name :" + nextRecord[0]);
                System.out.println("Last Name :" + nextRecord[1]);
                System.out.println("Address :" + nextRecord[2]);
                System.out.println("City :" + nextRecord[3]);
                System.out.println("Contact No :" + nextRecord[4]);
                System.out.println("Mail-id :" + nextRecord[5]);
                System.out.println("State :" + nextRecord[6]);
                System.out.println("Zip Code :" + nextRecord[7]);
                System.out.println("=============================");
            }
        } catch (Exception e){
            System.out.println(e);
        }
    }
}
