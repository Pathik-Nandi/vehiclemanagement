# VEHICLE MANAGEMENT

Vehicle management system using Java SpringBoot is menu driven program which allows to add,update,get and delete record of vehicles.Vehicle management database consists of five tables such as vehicle,user,uservehicleMapping,vehicleSpec,vehicleModel.

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
spring.datasource.url=jdbc:mysql://localhost:3306/employee_db
spring.datasource.username=root
spring.datasource.password=YOUR_PASSWORD
spring.jpa.database-platform=org.hibernate.dialect.MySQL5InnoDBDialect
spring.jpa.hibernate.ddl-auto=update
```

Reload Maven


# Run
Project runs on port 8080


# Database details

Table: vehicle

```
vehicle_id - PrimaryKey
chassis_number
model_id
vehicle_name
vehicle_type
created_at
updated_at
```
# How it works

```
Vehicle API validates the uniqueness of chassis_number and avoids duplication. It allows for addVehicle,fetchVehicle and deleteVehicle methods.
```

Table: user

```
user_id
user_name
aadhar_id
created_at
updated_at

```

Table: vehicleSpec

```
spec_id
fuel
rpm
mileage
created_at
updated_at

```
Tabe: userVehicleMap

```
map_id
user_id
vehicle_id
created_at
updated_at
```
Tabe: vehicleModel

```
nodel_id
model_name
manufacturer
model_number
year_of_manufacturer
created_at
updated_at
```






