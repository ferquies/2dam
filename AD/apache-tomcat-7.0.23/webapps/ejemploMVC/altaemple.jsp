<html>
<head>
<title>ALTA DE EMPLEADOS</title>
</head>
<!--Formulario de entrada de datos e Inserción en el JavaBean- clase Departamentos-->
<jsp:useBean id="depart" scope="request" class="ejemplo.Departamentos" />
<jsp:setProperty name="depart" property="*"/>
<%
 if(request.getParameter("empno")!= null) {%>
<jsp:forward page="/controlador?accion=insertar"/>
<%}%>

<body>
  <center><h2>ENTRADA DE DATOS DE DEPARTAMENTOS</h2>
  </br>
  <form method="post">
          <p>Número de empleado: <input name="empno" type="text" size="5"> </p>
          <p>Apellido: <input name="apellido" type="text" size="15"> </p>
          <p>Oficio: <input name="oficio" type="text" size="15"> </p>
          <p>Director: <input name="dir" type="text" size="5"> </p>
          <p>Fecha alta: <input name="fecha_alt" type="text" size="15"> </p>
          <p>Salario: <input name="salario" type="text" size="15"> </p>
          <p>Comision: <input name="comision" type="text" size="5"> </p>
          <p>Número departamento: <input name="depno" type="text" size="15"> </p>
          <input type="submit" name="insertar" value="Insertar empleado.">
          <input type="reset" name="cancelar" value="Cancelar entrada.">
  </form>  
  </center>
</body>
</html>
