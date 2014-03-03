import org.neodatis.odb.ODB;
import org.neodatis.odb.ODBFactory; 
import org.neodatis.odb.OID;
import org.neodatis.odb.core.oid.OIDFactory;

public class ejemploOid {
  public static void main(String[] args) {		
	  ODB odb = ODBFactory.open("neodatis.test");// Abrir BD     
	  OID oid = OIDFactory.buildObjectOID(3); //obtener objeto con OID 3
	   
	  Jugadores jug  = (Jugadores) odb.getObjectFromId(oid);
	  System.out.println( jug.getNombre() + "*" +  jug.getDeporte()+ "*" + 
               jug.getCiudad()+ "*" + jug.getEdad());
	  odb.close(); // Cerrar BD	   		
  }
}
