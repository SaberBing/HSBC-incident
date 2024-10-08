# Incident Management Api
[![Codacy Badge](https://app.codacy.com/project/badge/Grade/4b32d23b9244482e9043fb652ca9658b)](https://www.codacy.com/gh/T-W-O-SJ/restaraunt_selection/dashboard?utm_source=github.com&amp;utm_medium=referral&amp;utm_content=T-W-O-SJ/restaraunt_selection&amp;utm_campaign=Badge_Grade)

RESTful web-service  REST API with the voting system on stack: Maven, Spring Boot, Spring Security, REST
(Jackson), JDK17, Stream API, H2DB (in memory), JPA (Hibernate), JUnit5, Swagger (API).
### Software requirements specification
The task is:

Build an incident system

## Installation
* Make sure you are using JDK 17 and Maven 3.x
* Clone this repository
```bash
$ git clone https://github.com/SaberBing/HSBC-incident.git
```

* Run IncidentManagementApplication using the IDE
* Or you can run without IDE using for example :
```bash
$ mvn spring-boot:run
```
* You can connect to H2 database in the IDE to see changes with parameters :
```bash
jdbc:h2:tcp://localhost:9092/mem:selection
```
## Usage
### REST API documentation
The application supports OpenAPI 3.0 Swagger UI.  
After starting APP you need to go to url :
http://localhost:8080/swagger-ui/index.html#/

## Dependency
### Database
Use h2 as an in memory database
Use JPA as the ORM framework
```yml
<dependency>
  <groupId>com.h2database</groupId>
  <artifactId>h2</artifactId>
  <version>1.4.200</version>
</dependency>
<dependency>
  <groupId>org.springframework.boot</groupId>
  <artifactId>spring-boot-starter-data-jpa</artifactId>
  <version>2.6.2</version>
</dependency>
```
### Cache
Use caffeine as cache
```yml
<dependency>
  <groupId>com.github.ben-manes.caffeine</groupId>
  <artifactId>caffeine</artifactId>
  <version>2.9.3</version>
</dependency>
```
### Swagger
Use openapi to display the api
```yml
<dependency>
  <groupId>org.springdoc</groupId>
  <artifactId>springdoc-openapi-ui</artifactId>
  <version>1.6.2</version>
</dependency>
```





