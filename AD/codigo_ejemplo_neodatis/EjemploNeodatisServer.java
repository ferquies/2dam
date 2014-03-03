
import org.neodatis.odb.ODBFactory;
import org.neodatis.odb.ODBServer;

public class EjemploNeodatisServer{	
	public static void main(String[] args) {
	  ODBServer server = null;
     // Creates the server on port 8000
     server = ODBFactory.openServer(8000);
// Tells the server to manage base 'base1' that points to the physical
// file /users/neodatis/db/base1.neodatis
  //ODB odb = ODBFactory.open("neodatis.test");// Abrir BD
server.addBase("base1", "neodatis.test");
// Then starts the server to run in background
server.startServer(true);	
server.close();		
   }
}

