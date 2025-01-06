
<div align="center">
  <img src="./media/Oracle.png" alt="Logo" height="100">
  <h2>
    🌐 Foro Hub - Backend Challenge
  </h2>
</div>

<p align="center">
    <a href="https://github.com/Dev-Asfix/Foro-Hub/blob/main/LICENSE"><img src="https://img.shields.io/github/license/Dev-Asfix/Foro-Hub?style=for-the-badge" alt="License"></a>
    <a href="https://github.com/Dev-Asfix/Foro-Hub/issues"><img src="https://img.shields.io/github/issues/Dev-Asfix/Foro-Hub?style=for-the-badge" alt="Open Issues"></a>
    <a href="https://github.com/Dev-Asfix/Foro-Hub/graphs/contributors"><img src="https://img.shields.io/github/contributors/Dev-Asfix/Foro-Hub?style=for-the-badge" alt="Contributors"></a>
</p>



## 📜 Descripción

**Foro Hub** es un proyecto de backend desarrollado con **Spring Boot** y **Java** como parte del **Challenge Foro Hub** del curso de **Practicando Spring Framework** de **Alura LaTAM**. Este proyecto ofrece una **API REST** con operaciones CRUD (GET, POST, PUT, DELETE) para gestionar foros de discusión. La seguridad de la aplicación está gestionada utilizando **API Key**, **Spring Security** y **JWT (JSON Web Tokens)**, asegurando la autenticación y autorización de las solicitudes. Además, la persistencia de datos se maneja de manera eficiente utilizando **JPA con Spring Data**.

🔒 **Seguridad avanzada**  
📊 **Persistencia con JPA**  
🚀 **Escalable y fácil de usar**  

## 🛠️ Características

- **API REST** con operaciones CRUD:
  - **GET**: Obtener todos los Topicos / Respuestas / Usuaruios / Perfiles / etc.
  - **POST**: Crear.
  - **PUT**: Actualizar.
  - **DELETE**: Eliminar.
  
- **Seguridad** mediante **API Key**, **Spring Security** y **JWT**.
- **Persistencia de datos** con **JPA** y **Spring Data**.
- **Migraciones de base de datos** con **Flyway**.
- **Documentación automática** de la API con **Springdoc OpenAPI**.


---

<div align="center">
<h2>
**🔧 Tecnologías Usadas**
</h2>
</div>

<div align="center">
  <img src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/spring/spring-original.svg" height="40" alt="Spring Logo" />
  <img width="12" />
  <img src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/intellij/intellij-original.svg" height="40" alt="IntelliJ Logo" />
  <img width="12" />
  <img src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/java/java-original.svg" height="40" alt="Java Logo" />
  <img width="12" />
  <img src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/git/git-original.svg" height="40" alt="Git Logo" />
  <img width="12" />
  <img src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/mysql/mysql-original.svg" height="40" alt="MySQL Logo" />
  <img width="12" />
  <img src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/jpa/jpa-original.svg" height="40" alt="JPA Logo" />
  <img width="12" />
  <img src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/springboot/springboot-original.svg" height="40" alt="Spring Boot Logo" />
  <img width="12" />
  <img src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/github/github-original.svg" height="40" alt="GitHub Logo" />
</div>


- **Java 17** o superior
- **Spring Boot 3.x**
- **Spring Security** (Autenticación y Autorización)
- **Spring Data JPA** (Gestión de base de datos)
- **JWT (Java JWT)** (Tokens de seguridad)
- **Flyway** (Migraciones de base de datos)
- **MySQL** (Base de datos relacional)
- **Springdoc OpenAPI** (Documentación de API)

## 🔧 Requisitos

Antes de ejecutar el proyecto, asegúrate de tener instalados los siguientes programas:

- **JDK 17** o superior
- **MySQL** (con base de datos configurada)
- **Maven** o **Gradle** (según tu preferencia)
- **IDE** como **IntelliJ IDEA** o **Eclipse** (opcional)

## 📥 Instalación

1. Clona el repositorio:

   ```bash
   git clone https://github.com/Dev-Asfix/Foro-Hub.git
   
2. **Configura tu base de datos MySQL**:
   - Crea una base de datos para el proyecto.
   - Actualiza las credenciales de la base de datos en el archivo `application.properties` o `application.yml`.

3. **Ejecuta las migraciones de Flyway** (si es necesario).

4. **Ejecuta la aplicación desde tu IDE o utilizando Maven/Gradle**:

   **Con Maven**:

   ```bash
   mvn spring-boot:run
   
  **Con Gradle:**
  
  ```bash
  gradle bootRun
```

## 📜 Licencia

Este proyecto está bajo la **Licencia MIT**. Consulta el archivo [LICENSE](LICENSE) para más detalles.

---

## 📬 Contacto

Si tienes alguna pregunta o deseas saber más sobre el proyecto, no dudes en contactarme a través de:

- **Correo electrónico**: [rosasramirez753@gmail.com](Email:rosasramirez753@gmail.com)
