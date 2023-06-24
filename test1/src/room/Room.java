package room;
import java.util.*;

public abstract class Room {
	Scanner in = new Scanner(System.in);
	boolean room[];	//ÀÔ½Ç : true, Åð½Ç : false
	public void roomSetting() {
		System.out.println("¹æÀÇ °¹¼ö : ");
		int su = in.nextInt();
		room = new boolean[su];
	}
	
	public abstract void input();
	public abstract void output();
	public abstract void view();
	public abstract void exit();
}
