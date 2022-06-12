package com.bridgelabz;

class Contacts {
    private String firstName, lastName, address, city, state, zipCode, contactNo, email,bookName,type;

    public Contacts(String first_name, String last_name, long phone_number, String email, String address, String city, String state, int zip_code, String book_name, String type) {
        this.firstName=first_name;
        this.lastName=last_name;
        this.address=address;
        this.city=city;
        this.state=state;
        this.zipCode= String.valueOf(zip_code);
        this.contactNo= String.valueOf(phone_number);
        this.email=email;
        this.bookName=book_name;
        this.type=type;
    }

    public Contacts() {

    }

    public String getFirstName() {
        return firstName;
    }
    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getAddress() {
        return address;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public String getContactNo() {
        return contactNo;
    }

    public String getZipCode() {
        return zipCode;
    }
    public String getBookName(){
        return bookName;
    }
    public String getType(){
        return type;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }
    public void setBookName(String bookName) {
        this.bookName = bookName;
    }
    public void setType(String type){
        this.type = type;
    }

    /*public String toString() {
        return ("FirstName IS " + firstName + " \n LastNAme Is " + lastName + " \n Email Is " + email + "\n Contact No Is " + contactNo + "\n Address Is " + address + " \n City Is " + city + "\n State Is " + state + "\n Zip Code Is " + zipCode + " \n ");
    }*/
    public String toString() {
        return (firstName + "," + lastName + "," + email + "," + contactNo + "," + address + "," + city + "," + state + "," + zipCode + ","+bookName+","+type+" \n ");
    }
}