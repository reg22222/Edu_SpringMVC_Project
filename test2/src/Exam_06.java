import java.io.*;

public class Exam_06 {
	public static void main(String[] args) throws IOException {
		File dir = new File("G:\\javaweb\\study\\test2\\src");
		File file = new File(dir, "ccc.txt");
		
		FileWriter fw = new FileWriter(file);
		BufferedWriter bw = new BufferedWriter(fw);
		PrintWriter pw = new PrintWriter(bw);
		
		pw.println("æ»≥Á«œººø‰");
		pw.println(10+20);
		pw.close();
	}
}
