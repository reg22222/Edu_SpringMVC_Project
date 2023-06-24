import java.io.*;

public class Exam_04 {
	public static void main(String[] args) throws IOException {
		File dir = new File("G:\\javaweb\\study\\test2\\src");
		File file = new File(dir, "bbb.txt");
		
		FileInputStream fis = new FileInputStream(file);
		BufferedInputStream bis = new BufferedInputStream(fis);
		DataInputStream dis = new DataInputStream(bis);
		
		int a = dis.readInt();
		String str = dis.readUTF();
		double b = dis.readDouble();
		System.out.println(a);
		System.out.println(str);
		System.out.println(b);
	}
}
