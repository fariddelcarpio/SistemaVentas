<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Registrar Categoría</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
</head>
<body class="container mt-4">

    <h2>Registrar Categoría</h2>
    <form action="../CategoriaProductoServlet?action=agregar" method="post">
        <div class="mb-3">
            <label>Nombre de Categoría</label>
            <input type="text" name="nombreCategoria" class="form-control" required>
        </div>
        <button type="submit" class="btn btn-success">Guardar</button>
        <a href="../CategoriaProductoServlet?action=listar" class="btn btn-secondary">Cancelar</a>
    </form>

</body>
</html>


