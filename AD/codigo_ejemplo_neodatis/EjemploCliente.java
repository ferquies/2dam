import org.neodatis.odb.ODB;
import org.neodatis.odb.ODBFactory;
import org.neodatis.odb.Objects;

public class EjemploCliente {	
  public static void main(String[] args) {
     ODB odb = null;     
     try {
       odb = ODBFactory.openClient("localhost",8000,"base1");
	   Jugadores j4 = new Jugadores("Andrea","padel","Guadalajara",14);	 
	   odb.store(j4); 	 	 
	 } finally {
        if (odb != null) {odb.close();}       
	}	
  }//--main
}
