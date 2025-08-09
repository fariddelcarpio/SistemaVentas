<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Movimientos de Producto</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="container mt-4">
    <nav aria-label="breadcrumb">
        <ol class="breadcrumb">
          <li class="breadcrumb-item"><a href="/ProyectoFinal/index.jsp">Inicio</a></li>
          <li class="breadcrumb-item active" aria-current="page">Movimientos Producto</li>
        </ol>
    </nav>
    <h2>Movimientos de Productos</h2>
    <a href="MovimientosProductoServlet?action=registrar" class="btn btn-success mb-3">+ Nuevo Movimiento</a>

    <table class="table table-bordered">
        <thead>
            <tr>
                <th>ID</th>
                <th>Producto</th>
                <th>Tipo de Movimiento</th>
                <th>Cantidad</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="m" items="${listaMovimientos}">
                <tr>
                    <td>${m.idMovimientoProducto}</td>
                    <td>${m.nombreProducto}</td>
                    <td>${m.tipoMovimientoNombre}</td>
                    <td>${m.cantidad}</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</body>
</html>
