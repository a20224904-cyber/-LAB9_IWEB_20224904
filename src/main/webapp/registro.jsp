<%@ page contentType="text/html;charset=UTF-8" %>

<!DOCTYPE html>

<html lang="es">
<head>
<meta charset="UTF-8"><title>Registro - Biblioteca</title>
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/estilos.css">
</head>

<body>

<main>

<h1>Crear cuenta</h1>

<% if (request.getAttribute("error") != null) { %>

<p class="error"><%=request.getAttribute("error")%></p><% } %>

<form method="post" action="<%=request.getContextPath()%>/registro">

<label>Nombres</label><input type="text" name="nombres" required>

<label>Apellidos</label><input type="text" name="apellidos" required>

<label>Correo</label><input type="email" name="email" required>

<label>Contraseña</label><input type="password" name="clave" required>

<button type="submit">Registrarme</button>

</form>

<a href="<%=request.getContextPath()%>/login">Volver al login</a>

</main>
</body>

</html>
