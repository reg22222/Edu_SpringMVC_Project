package player;
import java.util.*;

public class PlayerMain {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		PlayerMg player = new PlayerMgImpl();
		while(true) {
			System.out.print
			("1.선수등록 2.선수보기 3.선수삭제 4.연봉수정 5.팀옮기기 6.종료 : ");
			int select = in.nextInt();
			switch(select) {
			case 1 : player.insert(); break;
			case 2 : player.view(); break;	
			case 3 : player.delete(); break;
			case 4 : player.edit_salary(); break;
			case 5 : player.edit_team(); break;
			case 6 : player.exit();
			default : System.out.println
					("잘못입력하셨습니다. 다시 입력해 주세요!!");
			}
		}
	}
}
