FROM openjdk:21-jdk

WORKDIR /app

COPY ./target/orders-0.0.1-SNAPSHOT.jar /app/orders-0.0.1-SNAPSHOT.jar

EXPOSE 8080

CMD ["java", "-jar", "orders-0.0.1-SNAPSHOT.jar"]
