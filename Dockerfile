FROM eclipse-temurin:21

# Устанавливаем рабочую директорию внутри контейнера
WORKDIR /app

# Копируем JAR-файл, собранный Gradle
COPY build/libs/*.jar app.jar

# Открываем порт, на котором работает Spring Boot (по умолчанию 8080)
EXPOSE 8082

# Запускаем приложение
ENTRYPOINT ["java", "-jar", "app.jar"]