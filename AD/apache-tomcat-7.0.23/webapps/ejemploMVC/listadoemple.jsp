<%@ page import="ejemplo.*,java.util.*"%>
<html><head><title>LISTADO DE EMPLEADOS</title></head>
<body>
<center> 
<h2>LISTADO DE EMPLEADOS</h2>
<table border='1'>
<tr><th>Empleado</th><th>Apellido</th><th>Oficio</th></tr>
<%
ArrayList listaemp=(ArrayList)request.getAttribute("empleados");
if(listaemp!=null)
  for(int i=0;i<listadep.size();i++){
   Empleados e=(Empleados)listaemp.get(i);%>
   <tr><td><%=e.getEmpno()%></td>
   <td><%=e.getApellido()%></td>
   <td><%=e.getOficio()%></td>
   </tr>
<%}%>
</table><br/><br/>
<a href="index.html">Inicio</a>
</center>
</body>
</html>
