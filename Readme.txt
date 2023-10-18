This is a web application that manages employee information in a company.
The application can do CRUD operations on database (postgresql 13).

Before starting this application, build a database environment.
Firstly, download and install a postgresql driver for postgresql 13 and create database.
Secondly, create employee and login tables as columns of each table can be seen in entity classes under package 'com.ken.empDbManagementSys.database.dao'.
Finally, set values to variables of SERVER, DBNAME, USER, PASSWORD in DatabaseAccesser class.

Context root of this application is 'EmpDbManagementSys', so the url to access this app is below.
'http://IPaddress:port/EmpDbManagementSys'