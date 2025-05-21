# 🎬 Sistema de Gestión de Películas - Sakila

Este proyecto es un sistema de gestión de alquiler de películas basado en la base de datos **Sakila**, desarrollado en **Java** utilizando arquitectura en capas (DAO/Repository, BLL, UI), y conexión a base de datos **MySQL** mediante JDBC.

---

## 🧩 Funcionalidades

- CRUD completo para:
  - Rentas
  - Pagos
  - Películas
  - Clientes
- Exportaciones:
  - CSV y JSON de pagos y rentas
- Reportes:
  - Total de pagos por cliente
  - Agrupaciones y filtros
- Diagrama UML y documentación

---

## ⚙️ Requisitos

- Java JDK 8 o superior
- MySQL Server (con la base de datos `sakila` modificada en español)
- JDBC Driver (`mysql-connector-java`)
- IDE: IntelliJ IDEA (recomendado)

---

## 🚀 Ejecución del JAR

```bash
java -jar PeliculasDeCine.jar
```

💡 Al iniciar, se muestra un menú por consola con las opciones de gestión.

---

## 🗃 Estructura del proyecto

```
PeliculasDeCine/
├── src/
│   ├── com.sakila.models
│   ├── com.sakila.repository
│   ├── com.sakila.bll
│   ├── com.sakila.db
│   └── com.sakila.app
├── resources/
├── SistemaSakila.jar
└── README.md
```

---

## 👨‍💻 Créditos

- **Autor:** [Jose Luis Peña]
- **Institución:** UASD
- **Asignatura:** Programación II
- **Profesor:** Silverio De Lorbe
- **Fecha:** Mayo 2025

---

¡Gracias por revisar este repositorio! Puedes dejar un ⭐ si te fue útil.
