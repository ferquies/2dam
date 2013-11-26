package ejemplo;
public class Departamentos {
	private int deptno;
	private String dnombre;
	private String loc;
    
	public Departamentos() {}
	public Departamentos(int deptno, final String dnombre, final String loc) {
		this.deptno = deptno;
		this.dnombre = dnombre;
		this.loc = loc;
	}
	public int getDeptno() {return this.deptno;}
	public void setDeptno(int deptno) {this.deptno = deptno;}
	public String getDnombre() {return this.dnombre;}
	public void setDnombre(String dnombre) {this.dnombre = dnombre;}
	public String getLoc() {return this.loc;}
	public void setLoc(String loc) {this.loc = loc;	}
}
