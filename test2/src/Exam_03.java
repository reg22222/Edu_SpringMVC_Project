import java.io.*;

public class Exam_03 {
	public static void main(String[] args) throws IOException {
		File dir = new File("G:\\javaweb\\study\\test2\\src");
		File file = new File(dir, "bbb.txt");
		
		FileOutputStream fos = new FileOutputStream(file);
		BufferedOutputStream bos = new BufferedOutputStream(fos);
		DataOutputStream dos = new DataOutputStream(bos);
		
		int a = 10;
		String str = "ȫ�浿";
		double b = 20.22;
		
		dos.writeInt(a);
		dos.writeUTF(str);
		dos.writeDouble(b);
		
		//dos.flush();
		dos.close(); // flush() + close()
	}
}







