package room;
import java.io.*;

public class RoomMain {
	public static void main(String[] args) throws IOException {
		Room room = new RoomMg();
		room.roomSetting();
		while(true) {
			System.out.print("1.�Խ� 2.��� 3.���� 4.���� : ");
			int select = System.in.read() - 48;
			System.in.skip(5);
			switch(select) {
			case 1 : room.input(); break;
			case 2 : room.output(); break;
			case 3 : room.view(); break;
			case 4 : room.exit(); break;
			default : System.out.println("�߸��Է��ϼ̽��ϴ�.");
			}
		}
	}
}
