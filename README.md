# gh-api-spring-boot

Custom GH API endpoints with Spring Boot

## Getting Started

Clone this repository!

### Prerequisites

Update the `application.properties` file with your GitHub API token.

```properties
server.port=8080
github.token=ghp_xxx
...
```

### Run the following commands

```bash
# generate openapi files
openapi-generator-cli generate -i openapi.yml -g spring -o var/tmp/spring-client 

# clean install
mvn clean install

# run the application
mvn spring-boot:run
```

### Access

access via: http://localhost:8080/swagger-ui.html
