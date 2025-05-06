# MarketFlow

**MarketFlow** es una aplicación de punto de venta diseñada para facilitar la gestión de ventas, inventarios y usuarios en negocios de retail. Este proyecto sigue el patrón de arquitectura **Modelo-Vista-Controlador (MVC)**, separando la lógica de negocio, la interfaz de usuario y el manejo de datos para mejorar la escalabilidad y el mantenimiento.

## Descripción

**MarketFlow** es un sistema de punto de venta que incluye las siguientes funcionalidades:

- **Gestión de usuarios**: Permite registrar y autenticar usuarios con contraseñas seguras.
- **Panel de login/registro**: Ofrece un panel de login y un formulario de registro de usuarios.
- **Interfaz de usuario interactiva**: Utiliza un diseño limpio y moderno con animaciones suaves durante las transiciones entre el registro y el inicio de sesión.

Este proyecto está diseñado usando el patrón **MVC**, lo que significa que la **lógica de negocio** está separada de la **interfaz de usuario**, facilitando la escalabilidad y el mantenimiento del sistema.

## Requisitos

Antes de comenzar, asegúrate de contar con las siguientes herramientas y configuraciones:

- **Java 17**.
- **Maven** para la gestión de dependencias.
- **MySQL** como sistema de gestión de base de datos.

## Instalación

### 1. Clona este repositorio

Para clonar el repositorio, ejecuta el siguiente comando en tu terminal:

```bash
git clone https://github.com/tuusuario/MarketFlow.git


### 2. Compila el proyecto:

Navega a la carpeta raíz del proyecto y ejecuta el siguiente comando para descargar las dependencias y compilar el proyecto:

```bash
mvn clean install
```

### 3. Configuración de la base de datos:

Asegúrate de tener **MySQL** instalado y corriendo en tu máquina local.

- El archivo `create_database.sql` en `resources/` creará la base de datos y las tablas necesarias automáticamente al iniciar la aplicación.
- Configura la conexión a la base de datos en el archivo `application.properties`:

```properties
db.url=jdbc:mysql://localhost:3306
db.user=root
db.password=tucontraseña
```

### 4. Ejecuta la aplicación:

Puedes ejecutar la aplicación directamente desde tu IDE o usando Maven:

```bash
mvn exec:java
```

## Funcionamiento

1. **Conexión a la base de datos**: 
   - Al iniciar la aplicación, se creará automáticamente la base de datos `marketflow` si no existe.
   - El script `create_database.sql` se ejecutará para crear la tabla `user` y agregar un usuario inicial con los siguientes datos:
     - **Nombre**: Guillermo
     - **Teléfono**: 2721623675
     - **Contraseña**: `123456` (no hasheada en este ejemplo, pero puedes cambiar la lógica de hash de contraseñas según se requiera).

2. **Login y Registro**: 
   - La aplicación muestra un panel de login/registro donde los usuarios pueden registrarse o iniciar sesión.
   - Los usuarios registrados podrán ser autenticados utilizando el nombre de usuario y la contraseña.
 ![Captura de pantalla 2025-03-12 101903](https://github.com/user-attachments/assets/a9e8b1e8-bdcc-4b29-bfc8-362a1be1d3bc)
![Captura de pantalla 2025-03-12 101850](https://github.com/user-attachments/assets/ae360e01-a875-4b04-a38a-00d45cf46aa8)


3. **Interfaz**: 
   - El sistema utiliza una interfaz moderna y animada para la transición entre el registro y el login, mejorando la experiencia de usuario.
     ![Captura de pantalla 2025-05-05 180608](https://github.com/user-attachments/assets/9feb604a-c4d7-4307-9e03-643e148b11af)
     ![Captura de pantalla 2025-05-05 180619](https://github.com/user-attachments/assets/73619f6a-1c68-44ec-83b6-950e75b565b5)


## Pruebas

Para ejecutar las pruebas unitarias del proyecto, asegúrate de tener Maven configurado correctamente y ejecuta el siguiente comando:

```bash
mvn test
```

Esto ejecutará todas las pruebas unitarias para verificar que las funcionalidades clave estén trabajando correctamente.

## Contribución

Si deseas contribuir al proyecto, por favor sigue estos pasos:

1. Haz un **fork** del repositorio.
2. Crea una nueva **branch** (`git checkout -b feature-nueva-funcionalidad`).
3. Realiza tus cambios y **commit** (`git commit -am 'Agrega nueva funcionalidad'`).
4. **Push** a la branch (`git push origin feature-nueva-funcionalidad`).
5. Crea un **pull request** explicando los cambios realizados.

## Licencia

Este proyecto está bajo la licencia **MIT**. Consulta el archivo `LICENSE` para más detalles.
```

Este es un archivo `README.md` completamente estructurado y listo para usar. Simplemente cópialo y pégalo en la raíz de tu proyecto y tendrás toda la documentación necesaria para tu repositorio de GitHub. ¡Listo para subir!
