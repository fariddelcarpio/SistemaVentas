<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Registrar Producto</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
</head>
<body>
<div class="container mt-4">
    <h2>Registrar Producto</h2>
    <form action="ProductoServlet?action=agregar" method="post">
        <div class="form-group">
            <label>Categoría</label>
            <select name="idCategoriaProducto" class="form-control" required>
                <option value="">Seleccione una categoría</option>
                <c:forEach var="cat" items="${listaCategorias}">
                    <option value="${cat.idCategoriaProducto}">${cat.nombreCategoria}</option>
                </c:forEach>
            </select>
        </div>

        <div class="form-group">
            <label>Código de Barras</label>
            <input type="text" name="codigoBarras" class="form-control" required>
        </div>

        <div class="form-group">
            <label>Nombre</label>
            <input type="text" name="nombre" class="form-control" required>
        </div>

        <div class="form-group">
            <label>Precio Unitario</label>
            <input type="number" name="precioUnitario" class="form-control" step="0.01" min="0" required>
        </div>

        <div class="form-group">
            <label>Unidad de Medida</label>
            <input type="text" name="unidadMedida" class="form-control" required>
        </div>

        <div class="form-group">
            <label>Stock</label>
            <input type="number" name="stock" class="form-control" min="0" required>
        </div>

        <button type="submit" class="btn btn-success">Registrar</button>
        <a href="ProductoServlet?action=listar" class="btn btn-secondary">Cancelar</a>
    </form>
</div>
</body>
</html>
