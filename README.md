# MarketFlow 
**MarketFlow** es una aplicación de punto de venta diseñada para facilitar la gestión de ventas, inventarios y usuarios en negocios de retail. Este proyecto utiliza una arquitectura de tipo **Modelo-Vista-Controlador (MVC)**, separando la lógica de negocio, la interfaz de usuario y el manejo de datos.

## Descripción

MarketFlow es un sistema de punto de venta que incluye funcionalidades como:

- **Gestión de usuarios**: Permite registrar y autenticar usuarios con contraseñas seguras.
- **Panel de login/registro**: Ofrece un panel de login y un formulario de registro.
- **Interfaz de usuario interactiva**: Utiliza un diseño limpio y moderno con animaciones suaves durante la transición entre el registro y el inicio de sesión.

Este proyecto está diseñado usando el patrón **MVC**, lo que significa que la **lógica de negocio** está separada de la **interfaz de usuario**. Esto facilita la escalabilidad y el mantenimiento del sistema.

## Requisitos

- **Java 17**.
- **Maven** para la gestión de dependencias (si es necesario).
- **MySQL** como sistema de gestión de base de datos.

## Instalación

### 1. Clona este repositorio:

```bash
git clone https://github.com/tuusuario/MarketFlow.git
```

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

3. **Interfaz**: 
   - El sistema utiliza una interfaz moderna y animada para la transición entre el registro y el login, mejorando la experiencia de usuario.

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
