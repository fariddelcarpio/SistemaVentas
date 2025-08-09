<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Registrar Factura</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css">
</head>
<body class="container mt-4">

<h2>Registrar Factura</h2>

<form action="/ProyectoFinal/FacturaServlet?action=guardar" method="post">
    <div class="form-group">
        <label>Cliente</label>
        <select name="idCliente" class="form-control" required>
            <option value="">-- Seleccione Cliente --</option>
            <c:forEach var="c" items="${listaClientes}">
                <option value="${c.idCliente}">${c.nombres}</option>
            </c:forEach>
        </select>
    </div>

    <h4>Detalle de Productos</h4>
    <table class="table table-bordered" id="tablaProductos">
        <thead>
            <tr>
                <th>Producto</th>
                <th>Cantidad</th>
                <th>Precio (S/)</th>
                <th>Subtotal (S/)</th>
                <th></th>
            </tr>
        </thead>
        <tbody>
            <tr>
                <td>
                    <select name="idProducto[]" class="form-control producto-select" required>
                        <option value="">-- Producto --</option>
                        <c:forEach var="p" items="${listaProductos}">
                            <option value="${p.idProducto}" data-precio="${p.precioUnitario}">${p.nombre}</option>
                        </c:forEach>
                    </select>
                </td>
                <td><input type="number" name="cantidad[]" class="form-control cantidad-input" min="1" required></td>
                <td><input type="text" name="precioUnitario[]" class="form-control precio-input" readonly></td>
                <td><input type="text" name="subtotal[]" class="form-control subtotal-input" readonly></td>
                <td><button type="button" class="btn btn-danger btn-sm eliminar-fila">X</button></td>
            </tr>
        </tbody>
    </table>

    <button type="button" class="btn btn-secondary mb-2" id="agregarFila">+ Agregar Producto</button>

    <div class="form-group">
        <label>Total (S/)</label>
        <input type="text" name="montoTotal" id="montoTotal" class="form-control" readonly>
    </div>

    <button type="submit" class="btn btn-primary">Registrar Factura</button>
    <a href="/ProyectoFinal/FacturaServlet?action=listar" class="btn btn-secondary">Cancelar</a>
</form>

<script>
document.addEventListener('DOMContentLoaded', function () {
    function actualizarSubtotales() {
        let total = 0;
        document.querySelectorAll('#tablaProductos tbody tr').forEach(function (fila) {
            const select = fila.querySelector('.producto-select');
            const cantidadInput = fila.querySelector('.cantidad-input');
            const precioInput = fila.querySelector('.precio-input');
            const subtotalInput = fila.querySelector('.subtotal-input');

            const precio = parseFloat(select.selectedOptions[0]?.dataset.precio || 0);
            const cantidad = parseInt(cantidadInput.value || 0);

            if (!isNaN(precio)) precioInput.value = precio.toFixed(2);
            const subtotal = precio * cantidad;
            subtotalInput.value = isNaN(subtotal) ? '' : subtotal.toFixed(2);

            if (!isNaN(subtotal)) total += subtotal;
        });
        document.getElementById('montoTotal').value = total.toFixed(2);
    }

    document.getElementById('tablaProductos').addEventListener('input', actualizarSubtotales);
    document.getElementById('tablaProductos').addEventListener('change', actualizarSubtotales);

    document.getElementById('agregarFila').addEventListener('click', function () {
        const fila = document.querySelector('#tablaProductos tbody tr');
        const nuevaFila = fila.cloneNode(true);

        nuevaFila.querySelectorAll('input').forEach(input => input.value = '');
        nuevaFila.querySelector('select').selectedIndex = 0;
        document.querySelector('#tablaProductos tbody').appendChild(nuevaFila);
    });

    document.getElementById('tablaProductos').addEventListener('click', function (e) {
        if (e.target.classList.contains('eliminar-fila')) {
            const filas = document.querySelectorAll('#tablaProductos tbody tr');
            if (filas.length > 1) e.target.closest('tr').remove();
            actualizarSubtotales();
        }
    });
});
</script>

</body>
</html>