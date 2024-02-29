FROM openjdk:21-jdk

WORKDIR /app

COPY target/restfulwebservices-1.0.0.jar /app/restfulwebservices.jar

EXPOSE 8080

CMD [ "java", "-jar", "restfulwebservices.jar" ]