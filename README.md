# CRUD-JDBC-Oracle

This project implements a simple CRUD (Create, Read, Update, Delete) application that interacts with a `Person` table in an Oracle database using JDBC. The application is built with Java and demonstrates basic database operations through a console interface.

## Technologies Used

- **Java**: Version 21
- **Oracle Database**: Version 11g
- **JDBC**: Java Database Connectivity for Oracle integration
- **Maven**: For dependency management and project building

## Commands

Upon running the application, you'll be prompted with options to perform CRUD operations on the `Person` entity:

- **1. Add Person**
- **2. Update Person**
- **3. Delete Person**
- **4. List All Persons**
- **5. Find Person by ID**
- **6. Find Person by Name and Family**
- **7. Find Person by Phone Number**

## Database Setup

Here is the SQL script for creating the table:

```sql
create table PERSON
(
    ID         NUMBER not null
        constraint PERSON_PK
            primary key,
    NAME       VARCHAR2(100),
    FAMILY     VARCHAR2(100),
    BIRTH_DATE DATE,
    EMAIL      VARCHAR2(100),
    PHONE      VARCHAR2(100),
    ADDRESS    VARCHAR2(100)
);

 CREATE SEQUENCE "PERSON_SEQ2"
 MINVALUE 1 MAXVALUE 999
 INCREMENT BY 1 START WITH 1
 CACHE 20 NOORDER  NOCYCLE;
```

## Configuration

The application expects the following properties for connecting to the Oracle database. You can configure these directly in the code of `DBConnect` class:

```Java
    private static final String url = "jdbc:oracle:thin:@localhost:1521:xe";
    private static final String user = "myjava";
    private static final String pass = "myjava123";
```

Ensure that you have the Oracle JDBC driver (e.g., `ojdbc11.jar`) available and correctly referenced in your `pom.xml`.
