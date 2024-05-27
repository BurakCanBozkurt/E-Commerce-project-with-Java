# Base image
FROM openjdk:17-oracle

# Çalışma dizini tanımla
WORKDIR /app

# Jar dosyasını kopyala
COPY target/person-0.0.1-SNAPSHOT.jar app.jar

# Uygulama başlatma komutu
CMD  ["java", "-jar", "app.jar"]