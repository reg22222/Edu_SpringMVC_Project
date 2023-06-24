import java.io.*;

class A08 implements Serializable{
	//�ڹٿ����� Serializable�� ��ӹ����� ����ȭ, ������ȭ�� ó���� �ش�
	int a = 10;
	int b = 20;
	transient int c = 30;	//�̸���� �������� �ʴ´�.
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
