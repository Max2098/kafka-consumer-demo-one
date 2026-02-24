FROM gradle:8-jdk21 AS build

WORKDIR /app

# Копируем build.gradle и gradle wrapper
COPY ./kafka-consumer-demo-one/build.gradle ./
COPY ./kafka-consumer-demo-one/gradlew ./
COPY ./kafka-consumer-demo-one/gradle ./gradle/
COPY ./kafka-consumer-demo-one/lombok.config ./

# Кэшируем зависимости
RUN --mount=type=cache,id=gradle-cache-kafka-consumer-demo-one,target=/home/gradle/.gradle \
    chmod +x ./gradlew && \
    ./gradlew dependencies --no-daemon -Dorg.gradle.vfs.watch=false

# Копируем исходники
COPY ./kafka-consumer-demo-one/src ./src/

# Собираем JAR
RUN --mount=type=cache,id=gradle-cache-kafka-consumer-demo-one,target=/home/gradle/.gradle \
    ./gradlew build -x test --no-daemon -Dorg.gradle.vfs.watch=false

FROM eclipse-temurin:21-jre-alpine

WORKDIR /app

COPY --from=build /app/build/libs/*.jar app.jar

EXPOSE 8081

ENTRYPOINT ["java", "-jar", "app.jar"]