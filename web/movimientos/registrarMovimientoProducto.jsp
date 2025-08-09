<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Registrar Movimiento</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
</head>
<body class="container mt-4">
    <h2>Registrar Movimiento de Producto</h2>
    <form action="MovimientosProductoServlet?action=guardar" method="post" class="mt-4">
        <div class="mb-3">
            <label for="idProducto" class="form-label">Producto</label>
            <select name="idProducto" id="idProducto" class="form-control" required>
                <option value="">-- Seleccione --</option>
                <c:forEach var="p" items="${listaProductos}">
                    <option value="${p.idProducto}">${p.nombre}</option>
                </c:forEach>
            </select>
        </div>

        <div class="mb-3">
            <label for="idTipoMovimiento" class="form-label">Tipo de Movimiento</label>
            <select name="idTipoMovimiento" id="idTipoMovimiento" class="form-control" required>
                <option value="">-- Seleccione --</option>
                <c:forEach var="t" items="${listaTipoMovimientos}">
                    <option value="${t.idTipoMovimiento}">${t.detalle}</option>
                </c:forEach>
            </select>
        </div>

        <div class="mb-3">
            <label for="cantidad" class="form-label">Cantidad</label>
            <input type="number" name="cantidad" id="cantidad" class="form-control" min="1" required>
        </div>

        <button type="submit" class="btn btn-primary">Guardar Movimiento</button>
        <a href="MovimientosProductoServlet?action=listar" class="btn btn-secondary">Cancelar</a>
    </form>
</body>
</html>
