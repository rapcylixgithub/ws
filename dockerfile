# Usa una imagen base de OpenJDK para Java 17
FROM openjdk:17-jdk-alpine AS builder

# Copia el código fuente del proyecto al contenedor
COPY . /app

# Establece el directorio de trabajo dentro del contenedor
WORKDIR /app

# Empaqueta la aplicación Spring Boot en un archivo JAR
RUN ./mvnw clean package -DskipTests

# Etapa final: Ejecutar la aplicación Spring Boot
FROM openjdk:17-jdk-alpine

# Copia el archivo JAR de la aplicación Spring Boot al contenedor
COPY --from=builder /app/target/Angular_sprint-0.0.1-SNAPSHOT.jar /app/Angular_sprint.jar

# Expone el puerto 8080 en el contenedor
EXPOSE 8080

# Inicia la aplicación Spring Boot al ejecutar el contenedor
CMD ["java", "-jar", "/app/Angular_sprint.jar"]