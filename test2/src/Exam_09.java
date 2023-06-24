import java.io.*;

public class Exam_09 {
	public static void main(String[] args) {
		File dir = new File("G:\\javaweb\\study\\test2\\src");
		File file = new File(dir, "ddd.txt");
		try {
			FileInputStream fis = new FileInputStream(file);
			BufferedInputStream bis = new BufferedInputStream(fis);
			ObjectInputStream ois = new ObjectInputStream(bis);
		
			Object obj = ois.readObject();
			System.out.println(obj.toString());
		}catch(IOException e) {
			e.printStackTrace();
		}catch(ClassNotFoundException e) {
			System.out.println("저장된 객체가 없습니다.");
		}
		
	}
}
