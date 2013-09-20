import java.io.*;

class ej6 {
	public static void main(String args[]) {
		String s;
		try {
			File f = new File(args[0]);
			FileReader fr = new FileReader(f);
			BufferedReader br = new BufferedReader(fr);
			while((s = br.readLine()) != null) {
				System.out.println(s);
			}
		} catch(IOException e) { e.printStackTrace(); }
	}
}
