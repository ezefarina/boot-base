# Odin Project

This project is meant to be a good start point for every well-distributed application, based on my experience in multiple companies, following the best standards I could found, but sticking to the technologies I mostly like. As every piece of art you will find a bit of subjectivity :D

### Building

[**Travis-CI**](https://travis-ci.org/) is being configured through .travis.yml file. Be sure if you fork this repository to configure the GitHub hooks so you keep the CI functions

### Handling multiple environments

You can find below a list of the properties used by the different modules:

* **db.properties** (loan-persistence/loan-persistence-datasource): Datasource configuration properties
* **model.properties** (loan-persistence/loan-persistence-model): JPA and Hibernate configuration properties
* **service.properties** (loan-service/loan-service-service): Any kind of properties needed by the services layer

These properties are read or looked up in the following places, being the last location found the one that overrides the previous ones. More locations could be added if needed but having just two levels is more than enough to handle multiple environments

* **classpath**: This will always be found as it's packed in the jar/war or whatever the package method is. It will contain the default values
* **$HOME**: This would be considered optional, and it may contain environment specific properties such as the DB connection url, production profile, etc.

### TODO's

* Integrate fully stateless front in ReactJS or AngularJS 2
* Include JavaMelody as a default in every WebApp
* Add healthchecks and effective properties
* Add provisioning package with Packer, Puppet
* Add virtualization capabilities with Vagrant
* Support stateless consumption of API through AWS custom origins
* Add EditorConfig and CheckStyle support
* Deb package deliverable for continuous delivery purposes
