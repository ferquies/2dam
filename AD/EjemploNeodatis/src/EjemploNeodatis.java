import org.neodatis.odb.ODB;

class Jugadores {
	private String nombre, deporte, ciudad;
	private int edad;
	
	public Jugadores() {}
	
	public Jugadores(String nombre, String deporte, String ciudad, int edad) {
		this.nombre = nombre;
		this.deporte = deporte;
		this.ciudad = ciudad;
		this.edad = edad;
	}
	
	public void setNombre(String nombre) { this.nombre = nombre; }
	public String getNombre() { return this.nombre; }
	public void setDeporte(String deporte) { this.deporte = deporte; }
	public String getDeporte() { return this.deporte; }
	public void setCiudad(String ciudad) { this.ciudad = ciudad; }
}

public class EjemploNeodatis {
	
}
