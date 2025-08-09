<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Editar Producto</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
</head>
<body>
<div class="container mt-4">
    <h2>Editar Producto</h2>
    <form action="ProductoServlet?action=actualizar" method="post">
        <input type="hidden" name="idProducto" value="${producto.idProducto}"/>

        <div class="form-group">
            <label>Categoría</label>
            <select name="idCategoriaProducto" class="form-control" required>
                <c:forEach var="cat" items="${listaCategorias}">
                    <option value="${cat.idCategoriaProducto}" <c:if test="${cat.idCategoriaProducto == producto.idCategoriaProducto}">selected</c:if>>
                        ${cat.nombreCategoria}
                    </option>
                </c:forEach>
            </select>
        </div>

        <div class="form-group">
            <label>Código de Barras</label>
            <input type="text" name="codigoBarras" value="${producto.codigoBarras != null ? producto.codigoBarras : ''}" class="form-control" required>
        </div>

        <div class="form-group">
            <label>Nombre</label>
            <input type="text" name="nombre" value="${producto.nombre != null ? producto.nombre : ''}" class="form-control" required>
        </div>

        <div class="form-group">
            <label>Precio Unitario</label>
            <input type="text" name="precioUnitario" value="${producto.precioUnitario}" class="form-control" required>
        </div>

        <div class="form-group">
            <label>Unidad de Medida</label>
            <input type="text" name="unidadMedida" value="${producto.unidadMedida != null ? producto.unidadMedida : ''}" class="form-control" required>
        </div>

        <div class="form-group">
            <label>Stock</label>
            <input type="text" name="stock" value="${producto.stock}" class="form-control" required>
        </div>

        <button type="submit" class="btn btn-primary">Actualizar</button>
        <a href="ProductoServlet?action=listar" class="btn btn-secondary">Cancelar</a>
    </form>
</div>
</body>
</html>
