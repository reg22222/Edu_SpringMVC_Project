package student;

import java.util.Scanner;

public class StudentMain {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		StudentPro pro = new StudentProImpl();
		while(true) {
			System.out.print("1.�л���� 2.�л����� 3.�л����� 4.�л����� 5.�����ϱ� 6.������ 7.���� : ");
			int select = in.nextInt();
			switch(select) {
			case 1 : pro.insert(); break;
			case 2 : pro.view(); break;
			case 3 : pro.delete(); break;
			case 4 : pro.edit(); break;
			case 7 : pro.exit(); break;
			case 5 : pro.save(); break;
			case 6 : pro.load(); break;
			default: System.out.println("�߸��Է��ϼ̽��ϴ�. �ٽ� �Է��� �ּ���!!");
			}
		}
	}
}
