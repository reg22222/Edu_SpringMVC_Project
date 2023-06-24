package room;
import java.util.*;

public abstract class Room {
	Scanner in = new Scanner(System.in);
	boolean room[];	//�Խ� : true, ��� : false
	public void roomSetting() {
		System.out.println("���� ���� : ");
		int su = in.nextInt();
		room = new boolean[su];
	}
	
	public abstract void input();
	public abstract void output();
	public abstract void view();
	public abstract void exit();
}
