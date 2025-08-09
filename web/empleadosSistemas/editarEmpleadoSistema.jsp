<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import="model.EmpleadoSistema" %>
<jsp:useBean id="empleadoSistema" type="model.EmpleadoSistema" scope="request" />
<html>
<head><title>Editar Usuario</title></head>
<body>
<h2>Editar Usuario del Sistema</h2>
<form action="EmpleadoSistemaServlet" method="post">
    <input type="hidden" name="action" value="actualizar">
    <input type="hidden" name="idEmpleadoSistema" value="${empleadoSistema.idEmpleadoSistema}">
    ID Empleado: <input type="number" name="idEmpleado" value="${empleadoSistema.idEmpleado}"><br>
    Usuario: <input type="text" name="usuario" value="${empleadoSistema.usuario}"><br>
    Contraseña: <input type="password" name="password" value="${empleadoSistema.password}"><br>
    ID Perfil: <input type="number" name="idPerfilUsuario" value="${empleadoSistema.idPerfilUsuario}"><br>
    <input type="submit" value="Actualizar">
</form>
</body>
</html>
