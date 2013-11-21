import java.util.*;

import com.db4o.Db4o;
import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;
import com.db4o.query.*;


class Empleados{
	private int emp_no;
	private String apellido;
	private String oficio;
	private int dir;
	private String fecha_alta;
	private float salario;
	private float comision;
	protected Departamentos depart;
	
	public Empleados(int emp, String ap, String of, int di, String fech, float sal, float com) {
		this.emp_no = emp;
		this.apellido = ap;
		this.oficio = of;
		this.dir = di;
		this.fecha_alta = fech;
		this.salario = sal; 
		this.comision = com;
	}
	
	public Departamentos getDepart() {
		return depart;
	}

	public void setDepart(Departamentos depart) {
		this.depart = depart;
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
}

class Departamentos{
	private int dep_no;
	private String dnombre;
	private String loc;
	protected List empleados;
	
	public Departamentos(int dp,String dno,String lo) {
		this.dep_no = dp;
		this.dnombre = dno;
		this.loc = lo;
		this.empleados = new ArrayList();
	}
		
	public List getEmpleados() {
		return empleados;
	}


	public void setEmpleados(List empleados) {
		this.empleados = empleados;
	}


	public void addEmpleados(Empleados emp) {
		empleados.add(emp);
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

public class tarea1t2 {
	public static void main(String args[]) {
		String BDEmp = "dbEmpresa.yap";
		ObjectContainer db = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(),BDEmp);
		
		Empleados emp1 = new Empleados(1,"Fernandez","Vendedor",7888,"12-12-12",1234,450);
		Empleados emp2 = new Empleados(2,"Esteban","Productor",7881,"12-12-12",1600,450);
		Empleados emp3 = new Empleados(3,"Gil","Investigador",7882,"12-12-12",660,450);
		Empleados emp4 = new Empleados(4,"Sanchez","Vendedor",7888,"12-12-12",1250,450);
		Empleados emp5 = new Empleados(5,"Curcusilla","Productor",7881,"12-12-12",1700,450);
		Empleados emp6 = new Empleados(6,"Murillo","Investigador",7882,"12-12-12",645,450);
		
		Departamentos dep1 = new Departamentos(10,"Produccion","Sevilla");
		Departamentos dep2 = new Departamentos(20,"Ventas","Bilbao");
		Departamentos dep3 = new Departamentos(30,"Investigacion","Madrid");
		
		emp1.setDepart(dep2); dep2.addEmpleados(emp1);
		emp2.setDepart(dep1); dep1.addEmpleados(emp2);
		emp3.setDepart(dep3); dep3.addEmpleados(emp3);
		emp4.setDepart(dep2); dep2.addEmpleados(emp4);
		emp5.setDepart(dep1); dep1.addEmpleados(emp5);
		emp6.setDepart(dep3); dep3.addEmpleados(emp6);
		
		db.store(dep1);
		db.store(dep2);
		db.store(dep3);
		db.store(emp1);
		db.store(emp2);
		db.store(emp3);
		db.store(emp4);
		db.store(emp5);
		db.store(emp6);
		
		System.out.println("Base de datos dbEmpresa.yap creada.");
		
		Query query = db.query();
		query.constrain(Empleados.class);
		query.descend("salario").constrain(new Float(650f)).greater();
		ObjectSet result = query.execute();
		System.out.println(result.size());
		
		while(result.hasNext()) {
		    Empleados e = (Empleados) result.next();
		    System.out.println("Apellido: " + e.getApellido() + "\nSalario: " + e.getSalario());
		    Departamentos d = e.getDepart();
		    System.out.println("Departamento: " + d.getDnombre());
		}
		
		db.close();
	}
}
