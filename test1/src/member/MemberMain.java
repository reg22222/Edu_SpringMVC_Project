package member;
import java.util.*;

public class MemberMain {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		MemberPro pro = new MemberProImpl();
		while(true) {
			System.out.print("1.회원등록 2.회원보기 3.회원삭제 4.회원수정 5.저장하기 6.꺼내기 7.종료 : ");
								//저장하기는 data.txt파일로 저장, 꺼내기는 기존데이터삭제 후 data.txt에 
			                    //있는 자료로 초기화시켜준다
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
