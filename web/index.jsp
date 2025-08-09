<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Sistema de Ventas - Inicio</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="bg-light">

<div class="container mt-5">
    <h2 class="text-center mb-4">Bienvenido al Sistema de Ventas</h2>

    <div class="row row-cols-1 row-cols-md-3 g-4 justify-content-center">

        <!-- Productos -->
        <div class="col">
            <div class="card h-100 text-center shadow">
                <div class="card-body">
                    <h5 class="card-title">Productos</h5>
                    <p class="card-text">Gestiona los productos de tu tienda.</p>
                    <a href="ProductoServlet?action=listar" class="btn btn-primary">Ir a Productos</a>
                </div>
            </div>
        </div>

        <!-- Clientes -->
        <div class="col">
            <div class="card h-100 text-center shadow">
                <div class="card-body">
                    <h5 class="card-title">Clientes</h5>
                    <p class="card-text">Administra tus clientes registrados.</p>
                    <a href="ClienteServlet?action=listar" class="btn btn-primary">Ir a Clientes</a>
                </div>
            </div>
        </div>

        <!-- Facturas -->
        <div class="col">
            <div class="card h-100 text-center shadow">
                <div class="card-body">
                    <h5 class="card-title">Facturas</h5>
                    <p class="card-text">Consulta y registra nuevas ventas.</p>
                    <a href="FacturaServlet?action=listar" class="btn btn-primary">Ir a Facturas</a>
                </div>
            </div>
        </div>

        <!-- Movimientos -->
        <div class="col">
            <div class="card h-100 text-center shadow">
                <div class="card-body">
                    <h5 class="card-title">Movimientos</h5>
                    <p class="card-text">Control de entradas y salidas de stock.</p>
                    <a href="MovimientosProductoServlet?action=listar" class="btn btn-primary">Ir a Movimientos</a>
                </div>
            </div>
        </div>

        <!-- Empleados -->
        <div class="col">
            <div class="card h-100 text-center shadow">
                <div class="card-body">
                    <h5 class="card-title">Empleados</h5>
                    <p class="card-text">Visualiza y registra nuevos empleados.</p>
                    <a href="EmpleadoServlet?action=listar" class="btn btn-primary">Ir a Empleados</a>
                </div>
            </div>
        </div>

        <!-- Categorías -->
        <div class="col">
            <div class="card h-100 text-center shadow">
                <div class="card-body">
                    <h5 class="card-title">Categorías</h5>
                    <p class="card-text">Clasifica tus productos por categoría.</p>
                    <a href="CategoriaProductoServlet?action=listar" class="btn btn-primary">Ir a Categorías</a>
                </div>
            </div>
        </div>

        <!-- Usuarios del Sistema -->
        <div class="col">
            <div class="card h-100 text-center shadow">
                <div class="card-body">
                    <h5 class="card-title">Usuarios</h5>
                    <p class="card-text">Administración de accesos y perfiles.</p>
                    <a href="EmpleadoSistemaServlet?action=listar" class="btn btn-primary">Ir a Usuarios</a>
                </div>
            </div>
        </div>

    </div>
</div>

</body>
</html>
