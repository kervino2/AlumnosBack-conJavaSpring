@echo off
REM Cargar variables de entorno
setlocal enabledelayedexpansion

REM Levantar MySQL con Docker
docker-compose up -d

REM Esperar a que MySQL esté listo
echo Esperando a que MySQL esté listo...
timeout /t 10

REM Ejecutar la aplicación
mvn clean spring-boot:run