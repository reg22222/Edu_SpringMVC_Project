package player;
import java.util.*;

public class PlayerMain {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		PlayerMg player = new PlayerMgImpl();
		while(true) {
			System.out.print
			("1.������� 2.�������� 3.�������� 4.�������� 5.���ű�� 6.���� : ");
			int select = in.nextInt();
			switch(select) {
			case 1 : player.insert(); break;
			case 2 : player.view(); break;	
			case 3 : player.delete(); break;
			case 4 : player.edit_salary(); break;
			case 5 : player.edit_team(); break;
			case 6 : player.exit();
			default : System.out.println
					("�߸��Է��ϼ̽��ϴ�. �ٽ� �Է��� �ּ���!!");
			}
		}
	}
}
