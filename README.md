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


create a resource file called **src/main/resources/application.properties** with the following content
```
spring.jpa.hibernate.ddl-auto=update
spring.datasource.url=jdbc:mysql://${MYSQL_HOST:localhost}:3306/db_enoca
spring.datasource.username=root
spring.datasource.password=
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
```
set password field to your mysql root password.

<br>

cd into case folder then you can run the application using 
```
./mvnw spring-boot:run
```
