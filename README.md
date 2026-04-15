# API de Gestión de Notas - Prueba Técnica

##  Comandos para ejecutar el proyecto

```bash
# 1. Clonar el repositorio
git clone <url-del-repositorio>
cd prueba-tecnica

# 2. Compilar la aplicación
mvn clean package -DskipTests

# 3. Construir imágenes Docker
docker-compose build

# 4. Levantar los servicios (API + MySQL)
docker-compose up -d

# 5. Verificar que todo funciona
curl http://localhost:8080/api/alumnos