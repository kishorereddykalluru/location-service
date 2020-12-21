Address Service

This service provides endpoint for Address service to retrieve addresses of particular country eg: US, CA

## Prerequisites for Development

## Building
Use maven to build the service from command line by running the following command at the root of the directory
of the project: 
`mvn clean package`

Once build is complete, the runtime application is available in target directory
 
 ## Running
 ### As Spring boot jar
 If you want to run the service locally, simply run the following at the command line from root directory
 of the project
 
 `mvn spring-boot:run -Dspring-boot.run.profiles=h2`
 
 Once the service is running, you may access the swagger UI API [documentation](http://localhost:8080/swagger-ui.html)
 you can submit requests from postman, or even command line using curl
 
 If you'd like to interact with data of the service running over top of embedded h2 database contains a web based url
 [console](http://localhost:8080/h2) that you can use:
 - JDBC URL: jdbc:h2:mem:test;DB_CLOSE_ON_EXIT=FALSE;DB_CLOSE_DELAY=-1
 - User / Password: sa / sa
 
 you can also view health and metrics through actuator sidecar functionality:
 - [Health](http://localhost:8080/actuator/health)
 - [Info](http://localhost:8080/actuator/info)