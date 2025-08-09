<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Registrar Empleado</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="bg-light">
    <div class="container mt-5">
        <h2 class="text-center mb-4">Registrar Empleado</h2>
        <form action="EmpleadoServlet" method="post" class="bg-white p-4 rounded shadow-sm">
            <div class="mb-3">
                <label class="form-label">Nombres:</label>
                <input type="text" name="nombres" class="form-control" required/>
            </div>
            <div class="mb-3">
                <label class="form-label">Apellido Paterno:</label>
                <input type="text" name="apellidoPaterno" class="form-control" required/>
            </div>
            <div class="mb-3">
                <label class="form-label">Fecha Nacimiento:</label>
                <input type="date" name="fechaNacimiento" class="form-control" required/>
            </div>
            <div class="mb-3">
                <label class="form-label">Correo Electrónico:</label>
                <input type="email" name="correoelectronico" class="form-control" required/>
            </div>
            <div class="mb-3">
                <label class="form-label">Dirección:</label>
                <input type="text" name="direccion" class="form-control" required/>
            </div>
            <div class="text-center">
                <input type="submit" value="Registrar" class="btn btn-primary"/>
                <a href="EmpleadoServlet?action=listar" class="btn btn-secondary">Cancelar</a>
            </div>
        </form>
    </div>
</body>
</html>
