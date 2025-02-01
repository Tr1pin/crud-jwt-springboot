## CRUD con JWT en Spring Boot

Este repositorio contiene una aplicación básica de CRUD (Create, Read, Update, Delete) desarrollada en Spring Boot, con autenticación y autorización basada en JWT (JSON Web Tokens). 

Características principales
- Operaciones CRUD: Crear, leer, actualizar y eliminar entidades.

- Autenticación JWT: Seguridad basada en tokens para proteger los endpoints.

- Base de datos: Uso de una base de datos relacional MySQL.

- Manejo de excepciones: Control centralizado de excepciones y respuestas de error.


## Estructura del Repositorio

crud-jwt-springboot/
│
├── ProyectoConSeguridad/
│   ├── src/
│   │   ├── main/
│   │   │   └── java/
│   │   │       ├── config/                                # Configuraciones de la aplicación y configuración de seguridad JWT                                
│   │   │       ├── controller/                            # Controladores (endpoints)                                                                      
│   │   │       ├── dto/                                   # Objetos de transferencia de datos (DTOs)                                                                                            
│   │   │       ├── model/                                 # Entidades (modelos de la base de datos)                                                                                      
│   │   │       ├── repository/                            # Repositorios (acceso a la base de datos)                                               
│   │   │       ├── service/                               # Lógica de negocio (servicios)                   
│   │   │       ├── validation/                            # Validaciones personalizadas
│   │   │       └── ProyectoConSeguridadApplication.java   # Clase principal de la aplicación
│   │   └── resources/
│   │       ├── application.properties                     # Configuración de la aplicación
│
├── .gitignore                                             # Archivos y carpetas ignorados por Git
├── pom.xml                                                # Configuración de Maven (dependencias)
└── README.md                                              # Este archivo
