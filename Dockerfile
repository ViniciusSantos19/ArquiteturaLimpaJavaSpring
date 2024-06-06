FROM maven:3.9-eclipse-temurin-21 AS builder
WORKDIR /app
COPY pom.xml .
RUN mvn dependency:go-offline
COPY src src
RUN mvn package 
RUN java -Djarmode=layertools -jar target/spring-boot-docker-1.0.0.jar extract

FROM eclipse-temurin:21-jre-alpine
RUN addgroup -S demo && adduser -S demo -G demo
USER demo
WORKDIR /app
COPY --from=builder app/dependencies/ ./
COPY --from=builder app/spring-boot-loader/ ./
COPY --from=builder app/snapshot-dependencies/ ./
COPY --from=builder app/application/ ./
ENTRYPOINT ["java", "org.springframework.boot.loader.launch.JarLauncher"]
