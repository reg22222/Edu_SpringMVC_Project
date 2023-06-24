package student;

import java.util.Scanner;

public class StudentMain {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		StudentPro pro = new StudentProImpl();
		while(true) {
			System.out.print("1.학생등록 2.학생보기 3.학생삭제 4.학생수정 5.저장하기 6.꺼내기 7.종료 : ");
			int select = in.nextInt();
			switch(select) {
			case 1 : pro.insert(); break;
			case 2 : pro.view(); break;
			case 3 : pro.delete(); break;
			case 4 : pro.edit(); break;
			case 7 : pro.exit(); break;
			case 5 : pro.save(); break;
			case 6 : pro.load(); break;
			default: System.out.println("잘못입력하셨습니다. 다시 입력해 주세요!!");
			}
		}
	}
}
