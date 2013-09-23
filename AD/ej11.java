import java.io.*;

class ej11 {
	public static void main(String args[]) {
		int i;
		try {
			File f = new File("f_ej10.dat");
			FileOutputStream fos = new FileOutputStream(f, true);
			for(i = 101; i <= 200; i++) {
				fos.write(i);
			}
			fos.close();
			
			FileInputStream fis = new FileInputStream(f);
			while((i = fis.read()) != -1) {
				System.out.println(i);
			}
			fis.close();
		} catch(IOException e) { e.printStackTrace(); }
	}
}
