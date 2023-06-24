import java.io.*;

public class Exam_02 {
	public static void main(String[] args) throws IOException {
		File dir = new File("G:\\javaweb\\study\\test2\\src");
		File file = new File(dir, "aaa.txt");
				
		FileInputStream fis = new FileInputStream(file);
		while(true) {
			int x = fis.read();
			if (x == -1) break;
			System.out.print((char)x);
		}
	}
}
