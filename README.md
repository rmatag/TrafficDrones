# TrafficDrones
## Frameworks and tools used:
- IntelliJ IDEA
- Maven
- Spring Boot
- Spring Integration JMS
- Log4j
- Testing: JUnit4, Mockito&PowerMock, Hamcrest

## Running the app:
- By using Spring Boot Maven plugin: mvn spring-boot:run

## Checking the result of the execution:
- Check the log file generated with name traffic-drones-report.log at project level

## Possible improvements:
- Database connection in order to store the reports
- Create an API REST server to access to the reports
- Send error to an error queue to be able to check them
- Integration tests
- Dockerize app
- Use RabbitMQ (in example) instead of using SI
  

