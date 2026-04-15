API de Gestión de Notas - Backend

## Variables de Entorno

Crear archivo .env en la raíz del proyecto:

# ------------------------------------
# Configuración de Base de Datos
DB_NAME=alumnos
DB_USER=tecnico_user
DB_PASSWORD=TeCniCo2026
DB_ROOT_PASSWORD=TeCniCo2026
DB_PORT=3307
DB_DRIVER=com.mysql.cj.jdbc.Driver

# API
API_PORT=8080

# Docker Compose
COMPOSE_PROJECT_NAME=prueba_tecnica

# ------------------------------------


## Cómo ejecutar

# 1. Compilar
mvn clean package -DskipTests

# 2. Levantar servicios con Docker
docker-compose up -d

# 3. url ejemplo
http://localhost:8080/api/alumnos


## Entidades

# Estructura de las Entidades
# Alumno

Campo	        Tipo	Requerido	
id	            Long	No (No se envia)
nombre	        String	Sí	
apellido	    String	Sí	
email	        String	Sí (único)	"
fechaNacimiento	Date	Sí	"2000-05-15"

# Materia

Campo	    Tipo	Requerido	
id	        Long	No (No se envia)	
nombre	    String	Sí	
codigo	    String	Sí (único)	
creditos	int	    Sí	
# Nota

Campo	        Tipo	Requerido	
id	            Long	No (se genera solo)	
valor	        Double	Sí	4.5
fechaRegistro	Date	No "2026-04-15"
alumno.id	    Long	Sí	
materia.id	    Long	Sí	

## Endpoints

### Alumnos


| GET | /api/alumnos | Lista todos los alumnos |
| GET | /api/alumnos/{id} | Busca un alumno por su ID |
| POST | /api/alumnos | Crea un nuevo alumno |
| PUT | /api/alumnos/{id} | Actualiza los datos de un alumno |
| DELETE | /api/alumnos/{id} | Elimina un alumno |

### Materias

| GET | /api/materias | Lista todas las materias |
| GET | /api/materias/{id} | Busca una materia por su ID |
| POST | /api/materias | Crea una nueva materia |
| PUT | /api/materias/{id} | Actualiza los datos de una materia |
| DELETE | /api/materias/{id} | Elimina una materia |

### Nota
| GET | /api/notas/alumno/{alumnoId} | Lista las notas de un alumno |
| GET | /api/notas/alumno/{alumnoId}/materia/{materiaId} | Busca la nota de un alumno en una materia específica |
