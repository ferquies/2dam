import org.neodatis.odb.ODBFactory;
import org.neodatis.odb.ODBServer;

public class EjemploServer{	
  public static void main(String[] args) {
	ODBServer server = null;   
      server = ODBFactory.openServer(8000); //Crea el servidor en el puerto 8000
      server.addBase("base1", "D:/uni4/server/neodatis.test");// Abrir BD
      // Se inicia el servidor ejecutándose en segundo plano
      server.startServer(true);	
   }
}
