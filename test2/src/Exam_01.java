import java.io.*;

public class Exam_01 {
	public static void main(String[] args) throws IOException {
		File file = new File
				("G:\\javaweb\\study\\test2\\src\\aaa.txt");
		
		FileOutputStream fos = new FileOutputStream(file, true);
		//rewrite, ������ 2��° ���ڷ� true�� ������ append
		
		//fos.write('A');
		//fos.write(66);
		
		String msg = "Hello, Java!!";
		fos.write(msg.getBytes());	//byte�迭 ���� ����
		
		//fos.write(msg.getBytes(), 7, 4);//byte�迭, ����Index, ����
	}
}
