FROM amazoncorretto:22-alpine3.20
WORKDIR /app
COPY target/*.jar /app/app.jar
EXPOSE 8000
ENTRYPOINT ["java","-jar","/app/app.jar"]