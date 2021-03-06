import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;


class Empleados{
	private int emp_no;
	private String apellido;
	private String oficio;
	private int dir;
	private String fecha_alta;
	private float salario;
	private float comision;
	private int dep_no;
	
	public Empleados(int em, String ap, String of, int di, String fech, float sal, float com, int dep) {
		this.emp_no = em;
		this.apellido = ap;
		this.oficio = of;
		this.dir = di;
		this.fecha_alta = fech;
		this.salario = sal; 
		this.comision = com;
		this.dep_no = dep;
	}
	
	public int getEmple() {
		return this.emp_no;
	}
	
	public String getApellido() {
		return this.apellido;
	}
	
	public String getOficio() {
		return this.oficio;
	}
	
	public int getDir() {
		return this.dir;
	}
	
	public String getFecha() {
		return this.fecha_alta;
	}
	
	public float getSalario() {
		return this.salario;
	}
	
	public float getComision() {
		return this.comision;
	}
	
	public void setEmple(int em) {
		this.emp_no = em;
	}
	
	public void setApellido(String ap) {
		this.apellido = ap;
	}
	
	public void setOficio(String of) {
		this.oficio = of;
	}
	
	public void setDir(int di) {
		this.dir = di;
	}
	
	public void setFecha(String fec) {
		this.fecha_alta = fec;
	}
	
	public void setSalario(float sal) {
		this.salario = sal;
	}
	
	public void setComision(float co) {
		this.comision = co;
	}
	
	public void setDep(int de) {
		this.dep_no = de;
	}
}

class Departamentos{
	private int dep_no;
	private String dnombre;
	private String loc;
	
	public Departamentos(int dp,String dno,String lo) {
		this.dep_no = dp;
		this.dnombre = dno;
		this.loc = lo;
	}
	
	public int getDep() {
		return this.dep_no;
	}
	
	public String getDnombre() {
		return this.dnombre;
	}
	
	public String getLoc() {
		return this.loc;
	}
	
	public void setDep(int dp) {
		this.dep_no = dp;
	}
	
	public void setDnombre(String dno) {
		this.dnombre = dno;
	}
}

public class db4o {
	public static void main(String args[]) {
		String BDEmp = "dbEmpresa.yap";
		ObjectContainer db = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(),BDEmp);
		
		Empleados emp1 = new Empleados(1,"Fernandez","Vendedor",7888,"12-12-12",1234,450,20);
		Empleados emp2 = new Empleados(2,"Esteban","Productor",7881,"12-12-12",1600,450,10);
		Empleados emp3 = new Empleados(3,"Gil","Investigador",7882,"12-12-12",660,450,30);
		Empleados emp4 = new Empleados(4,"Sanchez","Vendedor",7888,"12-12-12",1250,450,20);
		Empleados emp5 = new Empleados(5,"Curcusilla","Productor",7881,"12-12-12",1700,450,10);
		Empleados emp6 = new Empleados(6,"Murillo","Investigador",7882,"12-12-12",645,450,30);
		
		Departamentos dep1 = new Departamentos(10,"Produccion","Sevilla");
		Departamentos dep2 = new Departamentos(20,"Ventas","Bilbao");
		Departamentos dep3 = new Departamentos(30,"Investigacion","Madrid");
				
		db.store(emp1);
		db.store(emp2);
		db.store(emp3);
		db.store(emp4);
		db.store(emp5);
		db.store(emp6);
		
		db.store(dep1);
		db.store(dep2);
		db.store(dep3);
		
		db.close();
		
		System.out.println("Terminado.");
	}
}
