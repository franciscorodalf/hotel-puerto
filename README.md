<div align="justify">

## 1. Descripción del Proyecto

Este proyecto implementa un sistema de gestión hotelera utilizando **Spring Boot** con una arquitectura hexagonal (puertos y adaptadores) simplificada. Se caracteriza por el uso de **persistencia políglota**, combinando una base de datos relacional (H2) para datos estructurados y una base de datos documental (MongoDB) para preferencias de huéspedes.

### Características Principales

- **Arquitectura en Capas**: Desacoplamiento claro entre Web, Dominio, Servicio y Persistencia.
- **Persistencia Políglota**:
  - **H2 (JPA)**: Gestión de Hoteles, Habitaciones, Reservas y datos básicos de Huéspedes.
  - **MongoDB**: Almacenamiento de preferencias de huéspedes (`GuestPreferences`).
- **APIs**:
  - **REST**: Controladores documentados con OpenAPI/Swagger.
  - **SOAP**: Servicios web implementados con Apache CXF (JAX-WS).
- **Mappers**: Uso de **MapStruct** para la transformación eficiente entre modelos de dominio y entidades de persistencia.
- **Calidad de Código**: Tests unitarios y análisis de cobertura con **JaCoCo**.

---

## 2. Arquitectura

El proyecto sigue estrictas reglas de arquitectura para asegurar mantenibilidad y escalabilidad:

1. **Dominio**: Punto de entrada agnóstico. Los controladores REST y endpoints SOAP interactúan únicamente con las interfaces de dominio.
2. **Servicios**: Implementan la lógica de negocio y orquestan la persistencia. Trabajan exclusivamente con modelos de dominio.
3. **Persistencia**: Encapsulada en repositorios JPA y Mongo.
4. **Mappers**: Transforman objetos de dominio a entidades/documentos y viceversa, utilizados únicamente en la capa de servicio.

---

## 3. Requisitos Previos

Para ejecutar este proyecto necesitarás:

- **Java 17** o superior.
- **Maven 3.8** o superior.
- **Docker** y **Docker Compose** (para MongoDB).

---

## 4. Guía de Instalación y Ejecución

Sigue estos pasos para arrancar el proyecto en tu entorno local:

### Paso 1: Clonar el repositorio
(Si aplica)
```bash
git clone <url-del-repositorio>
cd hotel-puerto
```

### Paso 2: Levantar la infraestructura (MongoDB)
Utilizamos Docker Compose para iniciar MongoDB y Mongo Express (interfaz web).

```bash
docker compose up -d
```
Verifica que los contenedores estén corriendo:
```bash
docker compose ps
```

### Paso 3: Compilar y ejecutar la aplicación
Usa Maven para limpiar, compilar y arrancar la aplicación Spring Boot.

```bash
mvn clean spring-boot:run
```

La aplicación iniciará en el puerto **8080**.

---

## 5. Acceso a la Aplicación y Herramientas

Una vez iniciada la aplicación, puedes acceder a los siguientes recursos:

### APIs y Documentación
- **Swagger UI (REST)**: [http://localhost:8080/swagger-ui/index.html](http://localhost:8080/swagger-ui/index.html)
- **OpenAPI JSON**: [http://localhost:8080/v3/api-docs](http://localhost:8080/v3/api-docs)
- **WSDL (SOAP Guest Service)**: [http://localhost:8080/services/guest?wsdl](http://localhost:8080/services/guest?wsdl)

### Consolas de Base de Datos
- **H2 Console (Relacional)**: [http://localhost:8080/h2-console](http://localhost:8080/h2-console)
  - **JDBC URL**: `jdbc:h2:mem:hotel_puerto`
  - **User**: `sa`
  - **Password**: (dejar vacío)
- **Mongo Express (NoSQL UI)**: [http://localhost:8081](http://localhost:8081)
  - **User**: `root`
  - **Password**: `root`

---

## 6. Tests y Cobertura

Para ejecutar los tests unitarios y generar el informe de cobertura de código:

```bash
mvn clean test
```

El informe de **JaCoCo** estará disponible en:
`target/site/jacoco/index.html`

---

## 7. Estructura del Proyecto

```
org.docencia.hotel
├── HotelApplication
├── config
│   └── CxfConfig
├── domain
│   ├── api
│   │   ├── BookingDomain
│   │   ├── GuestDomain
│   │   ├── HotelDomain
│   │   └── RoomDomain
│   ├── impl
│   │   ├── BookingDomainImpl
│   │   ├── GuestDomainImpl
│   │   ├── HotelDomainImpl
│   │   └── RoomDomainImpl
│   └── model
│       ├── Booking
│       ├── Guest
│       ├── GuestPreferences
│       ├── Hotel
│       └── Room
├── mapper
│   ├── jpa
│   │   ├── BookingMapper
│   │   ├── GuestMapper
│   │   ├── HotelMapper
│   │   └── RoomMapper
│   └── nosql
│       └── GuestPreferencesMapper
├── persistence
│   ├── jpa
│   │   ├── entity
│   │   │   ├── BookingEntity
│   │   │   ├── GuestEntity
│   │   │   ├── HotelEntity
│   │   │   └── RoomEntity
│   ├── nosql
│   │   └── document
│   │       └── GuestPreferencesDocument
│   └── repository
│       ├── jpa
│       │   ├── BookingRepository
│       │   ├── GuestJpaRepository
│       │   ├── HotelRepository
│       │   ├── RoomRepository
│       └── nosql
│           └── GuestPreferencesRepository
├── service
│   ├── api
│   │   ├── BookingService
│   │   ├── GuestService
│   │   ├── HotelService
│   │   └── RoomService
│   └── impl
│       ├── BookingServiceImpl
│       ├── GuestServiceImpl
│       ├── HotelServiceImpl
│       ├── RoomServiceImpl
└── web
    ├── rest
    │   └── GuestController
    └── soap
        ├── GuestSoapService
        └── GuestSoapServiceImpl
```

</div>

---

## 4. Anotaciones REST

En `org.docencia.hotel.web.rest`:

- `@RestController`
- `@RequestMapping("/api/...")`
- `@GetMapping`, `@PostMapping`, `@PutMapping`, `@DeleteMapping`
- `@PathVariable`, `@RequestBody`, `@RequestParam`
- `@Valid`
- `ResponseEntity<T>`

Swagger/OpenAPI (springdoc):

- `@Tag`, `@Operation`, `@ApiResponse(s)`

---

## 5. Anotaciones SOAP (CXF / JAX-WS) y targetNamespace

Convención:

- `targetNamespace`: **`http://hotel.docencia.org/ws`**
- `serviceName`: `{Entidad}SoapService`
- `portName`: `{Entidad}SoapPort`

Anotaciones:

- `@WebService(name=..., targetNamespace=...)` (en el interface)
- `@WebService(endpointInterface=..., targetNamespace=..., serviceName=..., portName=...)` (en la implementación)
- `@WebMethod`, `@WebParam`, `@WebResult`

---

## 6. Consolas de BBDD (H2 y Mongo Express)

### 6.1 Consola H2 (incluida en Spring Boot)

En este proyecto se habilita:

- URL: `http://localhost:8080/h2-console`
- JDBC URL: `jdbc:h2:mem:hotel_puerto`
- User: `sa`
- Password: *(vacío)*

> Nota: H2 en memoria se reinicia al parar la aplicación.

### 6.2 MongoDB + Mongo Express (Docker Compose)

Se incluye `docker-compose.yml` para levantar:

- MongoDB: `localhost:27017`
- Mongo Express (UI): `http://localhost:8081`

Credenciales (según compose):

- Usuario: `root`
- Password: `root`

---

## 7. Arranque del proyecto

### 7.1 Levantar MongoDB + Mongo Express

```bash
docker compose up -d
docker compose ps
```

### 7.2 Arrancar la app

```bash
mvn clean spring-boot:run
```

---

## 8. Endpoints útiles

### REST

- Swagger UI: `http://localhost:8080/swagger-ui/index.html`
- OpenAPI JSON: `http://localhost:8080/v3/api-docs`

### SOAP (CXF)

Se configura `cxf.path=/services`.

- Endpoint guest: `http://localhost:8080/services/guest`
- WSDL guest: `http://localhost:8080/services/guest?wsdl`

---

## 9. Tests y cobertura (JaCoCo)

Ejecutar tests:

```bash
mvn test
```

Informe de cobertura JaCoCo (Maven):

- `target/site/jacoco/index.html`

---

## 10. Librerías incluidas (pom.xml)

- Spring Web (REST)
- Spring Data JPA + H2
- Spring Data MongoDB
- Apache CXF (SOAP/JAX-WS)
- MapStruct (mappers)
- springdoc-openapi (Swagger UI)
- JUnit 5 / Mockito (tests)
- JaCoCo (cobertura)

Referencias:

- MapStruct: https://mapstruct.org/
- JaCoCo: https://www.jacoco.org/jacoco/
- Springdoc OpenAPI: https://springdoc.org/
- Apache CXF: https://cxf.apache.org/

---

## Licencia 📄

Apache 2.0

</div>