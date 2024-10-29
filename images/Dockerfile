# Usa una imagen base de Java
FROM openjdk:21-jdk-slim

# Establece el directorio de trabajo en el contenedor
WORKDIR /app

# Copia el JAR compilado desde tu máquina local al contenedor
COPY build/libs/FoodSpringApp-0.0.1-SNAPSHOT.jar /app/

# Exponer el puerto de la aplicación (8080 es el puerto por defecto en Spring Boot)
EXPOSE 8080

# Comando para ejecutar la aplicación
ENTRYPOINT ["java", "-jar", "/app/FoodSpringApp-0.0.1-SNAPSHOT.jar"]
