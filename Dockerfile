FROM openjdk:21-jdk

WORKDIR /app

COPY target/restful-web-services-0.0.1-SNAPSHOT.jar /app/restful-web-services-0.0.1-SNAPSHOT.jar

EXPOSE 8080

CMD [ "java", "-jar", "restful-web-services-0.0.1-SNAPSHOT.jar" ]