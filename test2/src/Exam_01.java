import java.io.*;

public class Exam_01 {
	public static void main(String[] args) throws IOException {
		File file = new File
				("G:\\javaweb\\study\\test2\\src\\aaa.txt");
		
		FileOutputStream fos = new FileOutputStream(file, true);
		//rewrite, 생성자 2번째 인자로 true를 넣으면 append
		
		//fos.write('A');
		//fos.write(66);
		
		String msg = "Hello, Java!!";
		fos.write(msg.getBytes());	//byte배열 저장 가능
		
		//fos.write(msg.getBytes(), 7, 4);//byte배열, 시작Index, 범위
	}
}
