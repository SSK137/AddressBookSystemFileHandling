************************** UC1 *********************************
//UC-Ability to create a Address Book Service DB
mysql> create database AddressBookService
    -> ;
Query OK, 1 row affected (0.02 sec)

mysql> show databases
    -> ;
+--------------------+
| Database           |
+--------------------+
| AddressBookService |
| Payroll_Service    |
| information_schema |
| mysql              |
| performance_schema |
| sys                |
+--------------------+
mysql> use AddressBookService
Database changed
mysql> select database();
+--------------------+
| database()         |
+--------------------+
| AddressBookService |
+--------------------+
1 row in set (0.00 sec)

***************************** UC2 ******************************
// UC-Ability to create a Address Book Table with first and last names, address, city, state, zip, phone number and email as its attributes.

mysql> CREATE TABLE AddressBook(First_Name VARCHAR(50) NOT NULL,Last_Name VARCHAR(50) NOT NULL,Address VARCHAR(50) NOT NULL,City VARCHAR(50) NOT NULL,State VARCHAR(50) NOT NULL,Zip_Code INT NOT NULL,Phone_Number BIGINT NOT NULL,Email VARCHAR(50) NOT NULL);
Query OK, 0 rows affected (0.07 sec)

mysql> desc AddressBook
    -> ;
+--------------+-------------+------+-----+---------+-------+
| Field        | Type        | Null | Key | Default | Extra |
+--------------+-------------+------+-----+---------+-------+
| First_Name   | varchar(50) | NO   |     | NULL    |       |
| Last_Name    | varchar(50) | NO   |     | NULL    |       |
| Address      | varchar(50) | NO   |     | NULL    |       |
| City         | varchar(50) | NO   |     | NULL    |       |
| State        | varchar(50) | NO   |     | NULL    |       |
| Zip_Code     | int         | NO   |     | NULL    |       |
| Phone_Number | bigint      | NO   |     | NULL    |       |
| Email        | varchar(50) | NO   |     | NULL    |       |
+--------------+-------------+------+-----+---------+-------+
8 rows in set (0.01 sec)

********************************* UC3 ***********************************
//UC-Ability to insert new Contacts to Address Book
mysql> INSERT INTO AddressBook(First_Name,Last_Name,Address,City,State,Zip_Code,Phone_Number,Email) VALUES
    -> ('Saurabh','Kodam','Savedi','Ahmednagar','Maharashtra',444333,9890333349,'sau@gmail.com'),
    -> ('Sneha','Bhokare','Sangvi','Pune','Maharashtra',444222,9890333350,'sneha@gmail.com'),
    -> ('Adesh','Maske','Katraj','Solapur','Maharashtra',444111,9890333351,'adum@gmail.com');
Query OK, 3 rows affected (0.01 sec)

mysql> select * from AddressBook;
+------------+-----------+---------+------------+-------------+----------+--------------+-----------------+
| First_Name | Last_Name | Address | City       | State       | Zip_Code | Phone_Number | Email           |
+------------+-----------+---------+------------+-------------+----------+--------------+-----------------+
| Saurabh    | Kodam     | Savedi  | Ahmednagar | Maharashtra |   444333 |   9890333349 | sau@gmail.com   |
| Sneha      | Bhokare   | Sangvi  | Pune       | Maharashtra |   444222 |   9890333350 | sneha@gmail.com |
| Adesh      | Maske     | Katraj  | Solapur    | Maharashtra |   444111 |   9890333351 | adum@gmail.com  |
+------------+-----------+---------+------------+-------------+----------+--------------+-----------------+
3 rows in set (0.00 sec)

*********************************** UC4 ************************************
//UC -Ability to edit existing contact person using their name.
mysql> UPDATE AddressBook
    -> SET Address='Gharkul',Zip_Code=444000
    -> WHERE First_Name='Adesh';
Query OK, 1 row affected (0.02 sec)
Rows matched: 1  Changed: 1  Warnings: 0
mysql> select * from AddressBook;
+------------+-----------+---------+------------+-------------+----------+--------------+-----------------+
| First_Name | Last_Name | Address | City       | State       | Zip_Code | Phone_Number | Email           |
+------------+-----------+---------+------------+-------------+----------+--------------+-----------------+
| Saurabh    | Kodam     | Savedi  | Ahmednagar | Maharashtra |   444333 |   9890333349 | sau@gmail.com   |
| Sneha      | Bhokare   | Sangvi  | Pune       | Maharashtra |   444222 |   9890333350 | sneha@gmail.com |
| Adesh      | Maske     | Gharkul | Solapur    | Maharashtra |   444000 |   9890333351 | adum@gmail.com  |
+------------+-----------+---------+------------+-------------+----------+--------------+-----------------+
3 rows in set (0.00 sec)

****************************** UC5 ******************************
//UC-   Ability to delete a person using person's name
mysql> DELETE FROM AddressBook WHERE First_Name='Adesh';
Query OK, 1 row affected (0.02 sec)
mysql> select * from AddressBook;
+------------+-----------+---------+------------+-------------+----------+--------------+-----------------+
| First_Name | Last_Name | Address | City       | State       | Zip_Code | Phone_Number | Email           |
+------------+-----------+---------+------------+-------------+----------+--------------+-----------------+
| Saurabh    | Kodam     | Savedi  | Ahmednagar | Maharashtra |   444333 |   9890333349 | sau@gmail.com   |
| Sneha      | Bhokare   | Sangvi  | Pune       | Maharashtra |   444222 |   9890333350 | sneha@gmail.com |
+------------+-----------+---------+------------+-------------+----------+--------------+-----------------+
2 rows in set (0.00 sec)

****************************** UC6 *******************************
// UC-Ability to Retrieve Person belonging to a City or State from the Address Book.
mysql> SELECT * FROM AddressBook WHERE City='Solapur' or State='Maharashtra';
+------------+-----------+---------+---------+-------------+----------+--------------+-----------------+
| First_Name | Last_Name | Address | City    | State       | Zip_Code | Phone_Number | Email           |
+------------+-----------+---------+---------+-------------+----------+--------------+-----------------+
| Adesh      | Maske     | Katraj  | Solapur | Maharashtra |   444111 |   9890333351 | adum@gmail.com  |
| Sohan      | Kamble    | Katraj  | Solapur | Maharashtra |   445511 |   9890333352 | sohan@gmail.com |
+------------+-----------+---------+---------+-------------+----------+--------------+-----------------+
2 rows in set (0.00 sec)

******************************* UC7 ***********************************
//UC- Ability to understand the size of address book by City and State
mysql> SELECT COUNT(City)
    -> FROM AddressBook
    -> WHERE City='Solapur';
+-------------+
| COUNT(City) |
+-------------+
|           2 |
+-------------+
1 row in set (0.01 sec)

***************************** UC8 *************************************
//UC- Ability to retrieve entries sorted alphabetically by Person’s name for a given city
mysql> SELECT First_Name FROM AddressBook ORDER BY City ASC;
+------------+
| First_Name |
+------------+
| Saurabh    |
| Sneha      |
| Adesh      |
| Sohan      |
+------------+
4 rows in set (0.00 sec)

***************************** UC9 **************************************
//UC-Ability to identify each Address Book with name and Type.
- Here the type could Family, Friends,Profession, etc
- Alter Address Book to add name and type
mysql> ALTER TABLE AddressBook
    -> ADD(Book_Name VARCHAR(50) NOT NULL,Type VARCHAR(50) NOT NULL);
Query OK, 0 rows affected (0.06 sec)
mysql> SELECT * FROM AddressBook;
+------------+-----------+---------+------------+-------------+----------+--------------+-----------------+-----------+------+
| First_Name | Last_Name | Address | City       | State       | Zip_Code | Phone_Number | Email           | Book_Name | Type |
+------------+-----------+---------+------------+-------------+----------+--------------+-----------------+-----------+------+
| Saurabh    | Kodam     | Savedi  | Ahmednagar | Maharashtra |   444333 |   9890333349 | sau@gmail.com   |           |      |
| Sneha      | Bhokare   | Sangvi  | Pune       | Maharashtra |   444222 |   9890333350 | sneha@gmail.com |           |      |
| Adesh      | Maske     | Katraj  | Solapur    | Maharashtra |   444111 |   9890333351 | adum@gmail.com  |           |      |
| Sohan      | Kamble    | Katraj  | Solapur    | Maharashtra |   445511 |   9890333352 | sohan@gmail.com |           |      |
+------------+-----------+---------+------------+-------------+----------+--------------+-----------------+-----------+------+
4 rows in set (0.00 sec)

******************************* UC10 ***********************************
//Ability to get number of contact persons
-count by type
mysql> SELECT COUNT(Type) FROM AddressBook GROUP BY Type;
+-------------+
| COUNT(Type) |
+-------------+
|           1 |
|           3 |
|           2 |
+-------------+
3 rows in set (0.00 sec)

****************************** UC11 *************************************
//UC-Ability to add person to both Friend and Family
mysql> INSERT INTO AddressBook(First_Name,Last_Name,Address,City,State,Zip_Code,Phone_Number,Email,Book_Name,Type) VALUES
    -> ('Soham','Bidave','Saras_Nagar','Pune','Maharashtra',447711,9890333354,'soham@gmail.com','FamilyBook','Family'),
    -> ('Rohit','Patil','Nagar','Ahmednagar','Maharashtra',448811,9890333355,'rohit@gmail.com','FriendsBook','Friends');
Query OK, 2 rows affected (0.02 sec)

mysql> select * from AddressBook;
+------------+-----------+-------------+------------+-------------+----------+--------------+-----------------+------------------+------------+
| First_Name | Last_Name | Address     | City       | State       | Zip_Code | Phone_Number | Email           | Book_Name        | Type       |
+------------+-----------+-------------+------------+-------------+----------+--------------+-----------------+------------------+------------+
| Saurabh    | Kodam     | Savedi      | Ahmednagar | Maharashtra |   444333 |   9890333349 | sau@gmail.com   | FriendsBook      | Friends    |
| Sneha      | Bhokare   | Sangvi      | Pune       | Maharashtra |   444222 |   9890333350 | sneha@gmail.com | FamilyBook       | Family     |
| Adesh      | Maske     | Katraj      | Solapur    | Maharashtra |   444111 |   9890333351 | adum@gmail.com  | FamilyBook       | Family     |
| Sohan      | Kamble    | Katraj      | Solapur    | Maharashtra |   445511 |   9890333352 | sohan@gmail.com | FamilyBook       | Family     |
| Saiket     | Joshi     | MG Road     | Pune       | Maharashtra |   443311 |   9890333353 | saij@gmail.com  | ProfessionalBook | Profession |
| Viraj      | Patil     | Wagholi     | Pune       | Maharashtra |   442211 |   9890333354 | viraj@gmail.com | ProfessionalBook | Profession |
| Soham      | Bidave    | Saras_Nagar | Pune       | Maharashtra |   447711 |   9890333354 | soham@gmail.com | FamilyBook       | Family     |
| Rohit      | Patil     | Nagar       | Ahmednagar | Maharashtra |   448811 |   9890333355 | rohit@gmail.com | FriendsBook      | Friends    |
+------------+-----------+-------------+------------+-------------+----------+--------------+-----------------+------------------+------------+
8 rows in set (0.00 sec)
