# Odin Project [![Build Status][travis-image]][travis-url]

This project is meant to be a good start point for every well-distributed application, based on my experience in multiple companies, following the best standards I could found, but sticking to the technologies I mostly like. As every piece of art you will find a bit of subjectivity :D

### Building & CI

[**Travis-CI**](https://travis-ci.org/) is being configured through .travis.yml file. Be sure if you fork this repository to configure the GitHub hooks so you keep the CI functions

[travis-url]: https://travis-ci.org/ezefarina/boot-base
[travis-image]: https://travis-ci.org/ezefarina/boot-base.svg

### Handling multiple environments

You can find below a list of the properties used by the different modules:

* **db.properties** (odin-persistence/odin-persistence-datasource): Datasource configuration properties
* **model.properties** (odin-persistence/odin-persistence-model): JPA and Hibernate configuration properties
* **common.properties** (odin-common/odin-common-commons): Spring general configurations or common properties to be used in every module
* **security.properties** (odin-common/odin-common-security-token): Security module properties
* **service.properties** (odin-service/odin-service-service): Any kind of properties needed by the services layer
* **web.properties** (odin-service/odin-service-webapp): Configurations for Spring MVC, Actuator, etc

These properties are read or looked up in the following places, being the last location found the one that overrides the previous ones. More locations could be added if needed but having just two levels is more than enough to handle multiple environments

* **classpath**: This will always be found as it's packed in the jar/war or whatever the package method is. It will contain the default values
* **$HOME**: This would be considered optional, and it may contain environment specific properties such as the DB connection url, production profile, etc.

### Database & Liquibase handling

Liquibase changelogs can be run in two different ways:
* **Gradle Plugin**: By running the liquibase tasks through Gradle
* **On Application Startup**: By changing the following values on db.properties, liquibase can regenerate the database on application startup
`liquibase.enabled=false
liquibase.drop-first=false`

Just like **when** changelogs are executed, you can also switch the liquibase profile by changing the property **liquibase.contexts** in db.properties

### Monitoring

There are two options for monitoring enabled by default:
* **JavaMelody**: Accessible through /odin/monitoring
* **Spring Actuator Endpoints**: See available endpoints [here](http://docs.spring.io/spring-boot/docs/current/reference/html/production-ready-endpoints.html)

### Detailed configuration

For more detailed/specific configuration remember the properties suite available on Spring Boot [here](http://docs.spring.io/spring-boot/docs/current/reference/html/common-application-properties.html)

## Getting Started

Prepare backend app by running Application main class or through Gradle under :odin-service:odin-service-webapp module

```
gradle bootRun
```

Serve frontend app by webpack-dev-server under odin-front

```
npm install webpack-dev-server rimraf webpack -g
npm install
npm start
open http://localhost:8080
```

Front testing under odin-front

```
npm test
```

### TODO's

- [-] Integrate fully stateless front AngularJS 2
- [X] Include JavaMelody as a default in every WebApp
- [X] Add healthchecks and effective properties
- [ ] Add Docker compliant provisioning with Packer and Ansible
- [ ] Add virtualization capabilities with Vagrant
- [ ] Support stateless consumption of API through AWS custom origins
- [X] Add Travis-CI support
- [X] Add EditorConfig support
- [ ] Add CheckStyle support
- [ ] Deb package deliverable for continuous delivery purposes
