import java.io.*;

public class Exam_07 {
	public static void main(String[] args) throws IOException {
		File dir = new File("G:\\javaweb\\study\\test2\\src");
		File file = new File(dir, "ccc.txt");
		
		FileReader fr = new FileReader(file);
		BufferedReader br = new BufferedReader(fr);
		
		while(true) {
			String str = br.readLine();
			if (str == null) break;
			System.out.println(str);
		}
	}
}
