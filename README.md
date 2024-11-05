# gh-api-spring-boot

Custom GH API endpoints with Spring Boot

## Getting Started

Clone this repository!

### Run the following commands

```bash
# generate openapi files
openapi-generator-cli generate -i openapi.yml -g spring -o var/tmp/spring-client 

# clean install
mvn clean install

# run the application
mvn spring-boot:run
```
