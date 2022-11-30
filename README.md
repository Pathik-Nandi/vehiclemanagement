# vehiclemanagement
Vehicle management system using Java SpringBoot is menu driven program which allows to add,update,get and delete record of vehicles.

# Getting Started
* MySQL Workbench
* Postman/ Swagger-UI
* IntelliJ IDEA Community Edition

# Prerequisites
Download and add following requirement in project buiLd path
* Spring Initialization using [Spring initilizr](https://start.spring.io/)

# Installation and setting Up MySql

*  [Install MySql](https://dev.mysql.com/doc/en/installing.html)


# Connecting MySql and databases

## Steps

Install MySql and Setup Schema(employee_db)
```
<dependency>
	<groupId>mysql</groupId>
	<artifactId>mysql-connector-java</artifactId>
	<version>8.0.31</version>
	<scope>runtime</scope>
</dependency>
```

# Configure appication.properties
```
spring.datasource.url=jdbc:mysql://localhost:3306/vehiclemanagement
spring.datasource.username=root
spring.datasource.password=YOUR_PASSWORD
spring.jpa.database-platform=org.hibernate.dialect.MySQL5InnoDBDialect
spring.jpa.hibernate.ddl-auto=update
```

Reload Maven


# Run
Project runs on port 8080


# Database details
Table: vehicleSpec

```
spec_id
fuel
rpm
mileage
created_at
updated_at

```
