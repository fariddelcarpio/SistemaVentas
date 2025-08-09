<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Detalle de Factura</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
</head>
<body class="container mt-4">
    <h2>Detalle de Factura</h2>
    <a href="FacturaServlet?action=listar" class="btn btn-secondary mb-3">← Volver</a>

    <table class="table table-bordered">
        <thead>
            <tr>
                <th>Producto</th>
                <th>Cantidad</th>
                <th>Precio Unitario</th>
                <th>Subtotal</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="d" items="${detalles}">
                <tr>
                    <td>${d.nombreProducto}</td>
                    <td>${d.cantidad}</td>
                    <td>${d.precioUnitario}</td>
                    <td>${d.subtotal}</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</body>
</html>
