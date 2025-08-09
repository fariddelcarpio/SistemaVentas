<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head><title>Agregar Perfil</title></head>
<body>
    <h2>Agregar Nuevo Perfil de Usuario</h2>
    <form action="PerfilUsuarioServlet" method="post">
        <input type="hidden" name="action" value="agregar" />
        <label>Descripción:</label>
        <input type="text" name="descripcion" required />
        <input type="submit" value="Guardar" />
    </form>
    <a href="PerfilUsuarioServlet?action=listar">Volver a la lista</a>
</body>
</html>
