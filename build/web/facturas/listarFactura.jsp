<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Listado de Facturas</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
</head>
<body class="container mt-4">
    <nav aria-label="breadcrumb">
        <ol class="breadcrumb">
          <li class="breadcrumb-item"><a href="/ProyectoFinal/index.jsp">Inicio</a></li>
          <li class="breadcrumb-item active" aria-current="page">Facturas</li>
        </ol>
    </nav>
    <h2>Facturas Registradas</h2>
    <a href="FacturaServlet?action=registrar" class="btn btn-success mb-3">+ Nueva Factura</a>
    <table class="table table-bordered">
        <thead>
            <tr>
                <th>ID</th>
                <th>Fecha</th>
                <th>Cliente</th>
                <th>Monto Total</th>
                <th>Acciones</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="f" items="${facturas}">
                <tr>
                    <td>${f.idVentaCabecera}</td>
                    <td>${f.fecha}</td>
                    <td>${f.clienteNombre}</td>
                    <td>${f.montoTotal}</td>
                    <td>
                        <a href="FacturaServlet?action=detalle&id=${f.idVentaCabecera}" class="btn btn-info btn-sm">Ver Detalle</a>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</body>
</html>
