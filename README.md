Backend challenge of Enoca
<br>
# Setup

### Create Database
  make sure you have [MySQL installed](https://dev.mysql.com/downloads/installer/)
  
  open mysql client as a root user and create database "db_enoca"
  ```
  cd C:\Program Files\MySQL\MySQL Server 8.0\bin
  mysql -u root -p
  create database db_enoca
  ``` 
 
 ### Run Application
download and unzip the repository or 
```
git clone https://github.com/hamza-aloglu/case.git
```

<br>

install dependencies in **pom.xml** file


<br>



create a resource file called **src/main/resources/application.properties** with following content
```
spring.jpa.hibernate.ddl-auto=create
spring.datasource.url=jdbc:mysql://${MYSQL_HOST:localhost}:3306/db_enoca
spring.datasource.username=root
spring.datasource.password=
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
```
set password field to your mysql root password.

<br>

cd into project folder then run the application using 
```
./mvnw spring-boot:run
```

# API Reference
CRUD operations on "Employee" and "Company" models.

This case includes: Repository Pattern, Exception handling, Validation, request/response DTOs

### Employee
Get request on ```localhost:8080/employee/{id}``` will return instance of [EmployeeResponse](https://github.com/hamza-aloglu/case/blob/master/src/main/java/com/example/demo/dto/employee/EmployeeResponse.java)

Get request on ```localhost:8080/employee``` will return all of the employees

Post request on ```localhost:8080/employee``` with json body in the format of [EmployeeRequest](https://github.com/hamza-aloglu/case/blob/master/src/main/java/com/example/demo/dto/employee/EmployeeRequest.java) will create employee and returns that employee

Put request on ```localhost:8080/employee/{id}``` will update employee according to the json body which is in the form of [EmployeeRequest](https://github.com/hamza-aloglu/case/blob/master/src/main/java/com/example/demo/dto/employee/EmployeeRequest.java) and returns that employee

Delete request on ```localhost:8080/employee/{id}``` will delete the employee which its id is equal to given id in the path.


### Company
Get request on ```localhost:8080/company/{id}``` will return instance of [CompanyResponse](https://github.com/hamza-aloglu/case/blob/master/src/main/java/com/example/demo/dto/company/CompanyResponse.java) 

Get request on ```localhost:8080/company``` will return all of the companies

Post request on ```localhost:8080/company``` with json body in the format of [CompanyRequest](https://github.com/hamza-aloglu/case/blob/master/src/main/java/com/example/demo/dto/company/CompanyRequest.java) will create company and returns that company

Put request on ```localhost:8080/company/{id}``` will update company according to the json body which is in the form of [CompanyRequest](https://github.com/hamza-aloglu/case/blob/master/src/main/java/com/example/demo/dto/company/CompanyRequest.java) and returns that company

Delete request on ```localhost:8080/company/{id}``` will delete the company which its id is equal to given id in the path.

