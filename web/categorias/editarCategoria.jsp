<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Editar Categoría</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
</head>
<body class="container mt-4">

    <h2>Editar Categoría</h2>
    <form action="${pageContext.request.contextPath}/CategoriaProductoServlet?action=actualizar" method="post">
        <input type="hidden" name="idCategoriaProducto" value="${categoria.idCategoriaProducto}">
        <div class="mb-3">
            <label>Nombre de Categoría</label>
            <input type="text" name="nombreCategoria" value="${categoria.nombreCategoria}" class="form-control" required>
        </div>
        <button type="submit" class="btn btn-warning">Actualizar</button>
        <a href="${pageContext.request.contextPath}/CategoriaProductoServlet?action=listar" class="btn btn-secondary">Cancelar</a>
    </form>

</body>
</html>
