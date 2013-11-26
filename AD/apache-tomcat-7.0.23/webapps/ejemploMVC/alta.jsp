<html>
<head>
<title>ALTA DE DEPARTAMENTOS</title>
</head>
<!--Formulario de entrada de datos e Inserción en el JavaBean- clase Departamentos-->
<jsp:useBean id="depart" scope="request" class="ejemplo.Departamentos" />
<jsp:setProperty name="depart" property="*"/>
<%
 if(request.getParameter("deptno")!= null) {%>
<jsp:forward page="/controlador?accion=insertar"/>
<%}%>

<body>
  <center><h2>ENTRADA DE DATOS DE DEPARTAMENTOS</h2>
  </br>
  <form method="post">
          <p>Número de departamento: <input name="deptno" type="text" size="5"> </p>
          <p>Nombre: <input name="dnombre" type="text" size="15"> </p>
          <p>Localidad: <input name="loc" type="text" size="15"> </p>          
          <input type="submit" name="insertar" value="Insertar departamento.">
          <input type="reset" name="cancelar" value="Cancelar entrada.">
  </form>  
  </center>
</body>
</html>


