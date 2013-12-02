package ejemplo;
public class Empleados {
	private byte empno;
	private String apellido;
	private String oficio;
	private byte dir;
	private String fecha_alt;
	private byte salario;
	private byte comision;
	private byte depno;
    
	public Empleados() {}
	public Empleados(byte empno,String ap,String ofi,byte dir,String fe,byte s,byte co,byte dep) {
		this.empno = empno;
		this.apellido = ap;
		this.oficio = ofi;
		this.dir = dir;
		this.fecha_alt = fe;
		this.salario = s;
		this.comision = co;
		this.depno = dep;
		
	}
	public byte getEmpno(){return empno;}
	public void setEmpno(byte emp){this.empno = emp;}
	public String getApellido(){return apellido;}
	public void setApellido(String ap){this.apellido = ap;}
	public String getOficio(){return oficio;}
	public void setOficio(String of){this.oficio = of;}
	public byte getDir() {return this.dir;}
	public void setDir(byte d) {this.dir = d;}
	public String getAlta(){return fecha_alt;}
	public void setAlta(String f){this.fecha_alt = f;}
	public byte getSalario() {return this.salario;}
	public void setSalario(byte s) {this.salario = s;}
	public byte getComision() {return this.comision;}
	public void setComision(byte c) {this.comision = c;}
	public byte getDep() {return this.depno;}
	public void setDep(byte d) {this.depno = d;}
	}

