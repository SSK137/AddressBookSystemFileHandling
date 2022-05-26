package com.bridgelabz;

import com.google.gson.Gson;
import com.google.gson.stream.JsonWriter;
import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Map;

import static java.lang.System.out;

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
                out.println(st);
            }
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }
    /*-----Methods For CSV File Operations-----*/
    //Method for CSV File Writer
    public static void CSVWriters() {
        String Data = "//home//hp//IdeaProjects//AddressBookSystemFileHandling//src//Data.csv";
            try (Writer writer = Files.newBufferedWriter(Paths.get(Data));
                 CSVWriter csvWriter = new CSVWriter(writer);) {
                String[] header = { "First Name", "Last Name", "Address","City","Contact No","Email-id","State","Zip-Code" };
                csvWriter.writeNext(header);
                for (Map.Entry<String, ArrayList<Contacts>> addressBookMapEntry : AddressBooksystem.hashmap.entrySet()) {
                    ArrayList<Contacts> Data1=addressBookMapEntry.getValue();
                    for (Contacts contacts:Data1){
                        String[] strings={contacts.getFirstName(), contacts.getLastName(),contacts.getAddress(),contacts.getCity(),contacts.getContactNo(),contacts.getEmail(),contacts.getState(),contacts.getZipCode()};
                        csvWriter.writeNext(strings);
                    }
                }
            } catch (Exception e) {
                out.println(e);
            }
        }
        //Method to Read Data From CSV File
    public static void CSVReaders(){
        String Data = "//home//hp//IdeaProjects//AddressBookSystemFileHandling//src//Data.csv";
        try (
                Reader reader = Files.newBufferedReader(Paths.get(Data));
                CSVReader csvReader = new CSVReader(reader)
        ) {
            String nextRecord[];
            while ((nextRecord = csvReader.readNext()) != null) {
                out.println("First Name :" + nextRecord[0]);
                out.println("Last Name :" + nextRecord[1]);
                out.println("Address :" + nextRecord[2]);
                out.println("City :" + nextRecord[3]);
                out.println("Contact No :" + nextRecord[4]);
                out.println("Mail-id :" + nextRecord[5]);
                out.println("State :" + nextRecord[6]);
                out.println("Zip Code :" + nextRecord[7]);
                out.println("=============================");
            }
        } catch (Exception e){
            out.println(e);
        }
    }
    public static void JsonWriter(){
        String Data = "/home/hp/IdeaProjects/AddressBookSystemFileHandling/src/Test.json";
        for (Map.Entry<String, ArrayList<Contacts>> addressBookMapEntry : AddressBooksystem.hashmap.entrySet()) {
            ArrayList<Contacts> Data1 = addressBookMapEntry.getValue();
            try (Writer writer = Files.newBufferedWriter(Paths.get(Data));
                 JsonWriter jsonWriter = new JsonWriter(writer);) {
                for (Contacts contacts:Data1) {
                    Gson gson = new Gson();
                    String jsonString = gson.toJson(contacts);
                    jsonWriter.jsonValue(jsonString);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void JsonReader(){
        String Data = "/home/hp/IdeaProjects/AddressBookSystemFileHandling/src/Test.json";
        try {
            BufferedReader reader = new BufferedReader(new FileReader(Data));
            String data;
            while ((data = reader.readLine()) != null) {
                System.out.println(data);
            }
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }
}
