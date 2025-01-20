
# Online Course Platform

## Dependencies
- **Spring Boot Starter Web**
- **Spring Boot Starter JPA**
- **Spring Boot DevTools**
- **MariaDB Driver**
- **Spring Boot Actuator**
- **Swagger (SpringDoc)**

### Swagger Dependency
```xml
<dependency>
    <groupId>org.springdoc</groupId>
    <artifactId>springdoc-openapi-starter-webmvc-ui</artifactId>
    <version>2.7.0</version>
</dependency>
```

## Classes/Interfaces
- `Instructor`
- `Course`
- `Lesson`
- `InstructorRepository`
- `CourseRepository`
- `LessonRepository`
- `InstructorDTO`
- `InstructorDTO2`
- `InstructorController`

## Configuration
### application.properties
```
spring.datasource.url=jdbc:mariadb://localhost:3306/online_course
spring.datasource.username=root
spring.datasource.password=priyanka
spring.datasource.driver-class-name=org.mariadb.jdbc.Driver
spring.jpa.hibernate.ddl-auto=update
```

## Controller Endpoints
- **/test**
- **/test2**
- **/save**
- **/all**
- **/id/{id}**
- **/course/{cid}**
- **/name/course/{id}**
- **/update/{id}**
- **/delete/{id}**

## API Testing
- APIs have been tested using **Swagger UI** and **Postman**.

## Performance Testing
- Conducted performance and load testing using **JMeter**.

## GitHub Repository
- **Repository URL**: [https://github.com/priyankakushwaha89/Online-Course-platform](https://github.com/priyankakushwaha89/Online-Course-platform)

### Clone the Repository
```bash
git clone https://github.com/priyankakushwaha89/Online-Course-platform.git
```
