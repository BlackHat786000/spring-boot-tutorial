Spring Boot Tutorial
---------------------

Time saving note - application.yml file didn't work in eclipse while application.yaml file worked.


Perform a maven clean install from eclipse (embedded maven runtime) - 

1. click on run as -> run configurations -> maven build -> new configuration

2. set a base directory from workspace -> project

3. enter in Goals: clean install

4. apply -> run


Run spring boot app with a specific profile from command line - (jdk version should match maven's jdk version)

java -jar <path-to-jar-file> --spring.profiles.active=prod


Content
--------

Spring Initializr  
Spring Boot Starters  
Creating REST APIs with Spring Boot  
Spring Boot DevTools  
Hibernate validations  
Exception handling  
Logging in Spring Boot  
Database Migration  
Creating Different Layers of the Application  
Implementing Unit Testing  
Implementing JUnit and Mockito for all layers  
Managing Configuration  
Managing Profiles  
Spring Boot Actuator  
Custom Actuator Endpoints and managing endpoints