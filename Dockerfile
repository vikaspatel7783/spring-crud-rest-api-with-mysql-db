FROM eclipse-temurin:17

LABEL maintainer="vikaspatel7783@gmail.com"

WORKDIR /mysql-data-app-container

COPY target/mysql-data-app-0.0.1-SNAPSHOT.jar /mysql-data-app-container/mysql-data-app.jar

ENTRYPOINT ["java", "-jar", "mysql-data-app.jar"]