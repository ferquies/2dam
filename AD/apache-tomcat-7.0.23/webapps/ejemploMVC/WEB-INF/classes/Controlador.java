import ejemplo.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;

public class Controlador extends HttpServlet { 
public void service(HttpServletRequest request, HttpServletResponse response) 
                    throws ServletException, IOException {
 
 //se obtiene la acción a realizar
 String op=request.getParameter("accion");
 
 //pantalla de alta de departamento
 if(op.equals("alta"))
     response.sendRedirect("alta.jsp");
  //se inserta departamento en la tabla 
 if(op.equals("insertar")){
    ejemplo.Departamentos dep=(ejemplo.Departamentos)request.getAttribute("depart");//obtenerlos
    OperacionesBD operBD=new OperacionesBD();
    operBD.insertaDepartamento(dep); //se insertan en tabla	
    response.sendRedirect("index.html"); 
  }
  //se obtienen los datos de los departamentos para visualizarlos
  if(op.equals("listado")){
    OperacionesBD operBD=new OperacionesBD();
    ArrayList lista=operBD.listarDep(); //se obtienen los datos de los dep
    request.setAttribute("departamentos",lista); //se preparan para enviar al jsp
    RequestDispatcher rd=request.getRequestDispatcher("/listado.jsp");
    rd.forward(request,response);
  }
} 
}//fin de la clase Controlador
