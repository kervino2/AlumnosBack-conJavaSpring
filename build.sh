#!/bin/bash

# Compilar la aplicación
echo "Compilando aplicación Spring Boot..."
mvn clean package -DskipTests

# Construir y levantar con Docker
echo "Construyendo imágenes Docker..."
docker-compose build

echo "Levantando servicios..."
docker-compose up -d

echo "Esperando a que la base de datos esté lista..."
sleep 15

echo "Aplicación desplegada correctamente"
echo "API disponible en: http://localhost:8080"
