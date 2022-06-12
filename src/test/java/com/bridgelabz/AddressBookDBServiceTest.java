package com.bridgelabz;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class AddressBookDBServiceTest {
    @Test
    public void givenAddressBookInDB_WhenRetrieved_ShouldMatchContactCount()  {
        List<Contacts> employeeData=AddressBookDBService.readData();
        for(Contacts data:employeeData){
            System.out.println(data);
        }
        Assertions.assertEquals(8,employeeData.size());
    }

    @Test
    public void givenNewContactDetail_WhenUpdated_ShouldSync() {
        AddressBookDBService addressBookDBService=new AddressBookDBService();
        Assertions.assertTrue(addressBookDBService.UpdateRecordInTable());
    }
}
