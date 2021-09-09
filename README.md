# RESTful Forum-API
This Forum-API came to life so I could demonstrate part of my programming knowledge so far.
For its development I employed several technologies such as the following:
- Java and Spring Frameworks - Spring Boot, Spring Boot DevTools, Spring Data, Spring Cache, Spring Security, Spring Boot Actuator;
- SQL: Both H2 and MySQL databases;
- Deploy: Docker;
- Automated Tests: Unit, Integration and E2E tests;

To set up this project I started using Spring Boot and implemented all basic endpoints. For its development and further test scenarios I opted for the use of H2 database. The connection between these services was done through the use of Spring Data, JPA and Hibernate. Once all basic endpoints and initial validations was implemented I also added some error treatment. This was the first release.

The next step was increase the project's complexity. Fisrt i added pagination and ordering to the available requests. Then was the moment to implement a cache feature to increase data retrieval performance. After that was time for the security layer. Using Spring Security I added the first basic authentication methods, but it wasn't enough since I was still breaking the RESTful principles because I was forcing the server to save an id of every logged user. To surpass this problem I enhanced the security and did it via a token authentication. Then I needed to monitor the API operation. For that purpose, I used the Spring Boot Actuator which did the job and Spring Boot Admin which allowed me to access the data throgh an user-friendly interface. The last step of this stage was to make some sort of documentation. This was done via SpringFox Swagger.

The last stage of the project was finally ahead. First I increaded the security adding roles for the users. Next, was time to think about sending the API into production. My first step in this direction was to add diferent profiles so I could work in diferent scenarios. But before production comes tests, and that was the case. Since this is only a demo project my purpose was not to cover all test scenarios but instead regard about the main test types so implemented some unit, integration and end2end test cases. Then we were done, now production. The next step was to deploy the API and was done using Docker.

I thank you for your attention and, if there is still any doubt or suggestion, please contact me at my LinkedIn profile: https://www.linkedin.com/in/guilherme-aires-de-fran%C3%A7a-78317b20b
