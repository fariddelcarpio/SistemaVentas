<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Listado de Productos</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
</head>
<body class="container mt-4">
    <nav aria-label="breadcrumb">
        <ol class="breadcrumb">
          <li class="breadcrumb-item"><a href="/ProyectoFinal/index.jsp">Inicio</a></li>
          <li class="breadcrumb-item active" aria-current="page">Productos</li>
        </ol>
    </nav>

    <h2>Listado de Productos</h2>
    <a href="ProductoServlet?action=registrar" class="btn btn-primary mb-3">Agregar Producto</a>

    <table class="table table-bordered table-striped">
        <thead class="table-dark">
            <tr>
                <th>ID</th>
                <th>Nombre</th>
                <th>Categoría</th>
                <th>Código de Barras</th>
                <th>Precio</th>
                <th>Unidad</th>
                <th>Stock</th>
                <th>Acciones</th>
            </tr>
        </thead>
        <tbody>
        <c:forEach var="p" items="${listaProductos}">
            <tr>
                <td>${p.idProducto}</td>
                <td>${p.nombre}</td>
                <td>${p.idCategoriaProducto}</td>
                <td>${p.codigoBarras}</td>
                <td>S/. ${p.precioUnitario}</td>
                <td>${p.unidadMedida}</td>
                <td>${p.stock}</td>
                <td>
                    <a href="ProductoServlet?action=editar&id=${p.idProducto}" class="btn btn-sm btn-warning">Editar</a>
                    <a href="ProductoServlet?action=eliminar&id=${p.idProducto}" class="btn btn-sm btn-danger"
                       onclick="return confirm('¿Seguro que deseas eliminar este producto?')">Eliminar</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>

</body>
</html>

