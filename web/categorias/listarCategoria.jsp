<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Categorías de Producto</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
</head>
<body class="container mt-4">
    <nav aria-label="breadcrumb">
        <ol class="breadcrumb">
          <li class="breadcrumb-item"><a href="/ProyectoFinal/index.jsp">Inicio</a></li>
          <li class="breadcrumb-item active" aria-current="page">Categorías</li>
        </ol>
    </nav>

    <h2>Listado de Categorías</h2>
    <a href="categorias/registrarCategoria.jsp" class="btn btn-primary mb-3">Agregar Categoría</a>

    <table class="table table-bordered table-striped">
        <thead class="table-dark">
            <tr>
                <th>ID</th>
                <th>Nombre</th>
                <th>Acciones</th>
            </tr>
        </thead>
        <tbody>
        <c:forEach var="c" items="${listaCategorias}">
            <tr>
                <td>${c.idCategoriaProducto}</td>
                <td>${c.nombreCategoria}</td>
                <td>
                    <a href="CategoriaProductoServlet?action=editar&id=${c.idCategoriaProducto}" class="btn btn-warning btn-sm">Editar</a>
                    <a href="CategoriaProductoServlet?action=eliminar&id=${c.idCategoriaProducto}" class="btn btn-danger btn-sm"
                       onclick="return confirm('¿Seguro que deseas eliminar esta categoría?')">Eliminar</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>

</body>
</html>


