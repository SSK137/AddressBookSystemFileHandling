package com.bridgelabz;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AddressBookDBService {

    public static List<Contacts> readData() {
        String sql="SELECT * FROM AddressBook";

        List<Contacts> contactsList=new ArrayList<>();
        try{
            Connection connection=DBConnection.getConnection();
            Statement statement=connection.createStatement();
            ResultSet resultSet=statement.executeQuery(sql);
            while (resultSet.next()){
                String First_Name=resultSet.getString("First_Name");
                String Last_Name=resultSet.getString("Last_Name");
                long Phone_Number=resultSet.getLong("Phone_Number");
                String Email=resultSet.getString("Email");
                String Address=resultSet.getString("Address");
                String City=resultSet.getString("City");
                String State=resultSet.getString("State");
                int Zip_Code=resultSet.getInt("Zip_Code");
                String Book_Name=resultSet.getString("Book_Name");
                String Type=resultSet.getString("Type");
                contactsList.add(new Contacts(First_Name,Last_Name,Phone_Number,Email,Address,City,State,Zip_Code,Book_Name,Type));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return contactsList;
    }

    public boolean UpdateRecordInTable() {
        try(Connection conn = DBConnection.getConnection();
            Statement statement = conn.createStatement();
        ) {
            String sql = "UPDATE AddressBook SET First_Name='SSK' WHERE First_Name='Saurabh'";
            statement.executeUpdate(sql);
            System.out.println("Record Updated Successfully...");
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
