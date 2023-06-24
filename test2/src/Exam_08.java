import java.io.*;

class A08 implements Serializable{
	//자바에서는 Serializable을 상속받으면 직렬화, 역직렬화를 처리해 준다
	int a = 10;
	int b = 20;
	transient int c = 30;	//이멤버는 전송하지 않는다.
	public String toString() {
		return "a = " + a + ", b = " + b +", c = " + c;
	}
}
public class Exam_08 {
	public static void main(String[] args) throws IOException {
		File dir = new File("G:\\javaweb\\study\\test2\\src");
		File file = new File(dir, "ddd.txt");

		FileOutputStream fos = new FileOutputStream(file);
		BufferedOutputStream bos = new BufferedOutputStream(fos);
		ObjectOutputStream oos = new ObjectOutputStream(bos);
		
		A08 ap = new A08();
		oos.writeObject(ap);
		oos.close();
	}
}
