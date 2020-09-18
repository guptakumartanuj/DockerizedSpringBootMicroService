#Fetch the base Jav8 image
FROM java:8
#Expose the local application port
EXPOSE 8080
#Place the jar file to the docker location
ADD /target/microservicedemo-1.0-SNAPSHOT.jar microservicedemo-1.0-SNAPSHOT.jar
#Place the config file as a part of application
ADD src/main/resources/application.properties application.properties
#execute the application
ENTRYPOINT ["java","-jar","microservicedemo-1.0-SNAPSHOT.jar"]
