# Sistema de Ventas

Aplicación web desarrollada en **Java EE 8** utilizando **JSP, Servlets, JDBC** y desplegada en **GlassFish**.  
Permite la gestión de productos, clientes, ventas, facturas, movimientos de inventario, empleados, categorías y usuarios del sistema.

## 📌 Características principales
- **Gestión de Productos**: Registro, edición, eliminación y consulta de productos.
- **Ventas y Facturación**: Registro de ventas con múltiples productos y generación de comprobantes.
- **Gestión de Usuarios**: Administración de empleados y usuarios del sistema con diferentes perfiles.
- **Inventario**: Control de ingresos y salidas de productos.
- **Categorías de Productos**: Clasificación de inventario.

## 🖥️ Tecnologías utilizadas
- **Java EE 8** (JSP, Servlets)
- **GlassFish**
- **JDBC** para conexión a base de datos
- **MySQL** como base de datos
- **Bootstrap 5** para interfaz

## 📂 Estructura del proyecto
- `controller/` → Servlets que gestionan la lógica de cada módulo.
- `dao/` → Clases DAO para acceso a datos.
- `model/` → Entidades y modelos del sistema.
- `web/` → Páginas JSP y recursos estáticos.
- `config/` → Clase de conexión a la base de datos.
