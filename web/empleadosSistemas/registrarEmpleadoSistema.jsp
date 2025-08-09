<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<html>
<head>
    <title>Registrar Usuario</title>
    <style>
        form {
            max-width: 400px;
            margin: auto;
            padding: 1em;
            background: #f4f4f4;
            border-radius: 5px;
        }
        label, input, select {
            display: block;
            width: 100%;
            margin-bottom: 10px;
        }
    </style>
</head>
<body>
    <h2 style="text-align:center;">Registrar Usuario del Sistema</h2>
    
    <form action="EmpleadoSistemaServlet" method="post">
        <input type="hidden" name="action" value="registrar" />
        
        <label for="idEmpleado">ID del Empleado:</label>
        <input type="number" name="idEmpleado" required />
        
        <label for="usuario">Usuario:</label>
        <input type="text" name="usuario" required />
        
        <label for="password">Contraseña:</label>
        <input type="password" name="password" required />
        
        <label for="idPerfilUsuario">ID del Perfil de Usuario:</label>
        <input type="number" name="idPerfilUsuario" required />
        
        <input type="submit" value="Registrar" />
    </form>
</body>
</html>