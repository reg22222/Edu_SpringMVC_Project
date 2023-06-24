package room;

public class RoomMg extends Room{

	@Override
	public void input() {
		System.out.print("�Խ��Ͻ� ���� ��ȣ : ");
		int roomNum = in.nextInt();
		if (roomNum<1 || roomNum>room.length) {
			System.out.println("���ȣ�� 1ȣ�Ǻ��� " + room.length+"ȣ�� ���� �Դϴ�.");
			System.out.println("�ٽ� �Է��� �ּ���!!");
			input();
		}else {
			if (room[roomNum-1]) {
				System.out.println(roomNum+"ȣ���� �����");
			}else {
				room[roomNum-1] = true;
				System.out.println(roomNum+"ȣ�ǿ� �Խ�");
			}
		}		
	}

	@Override
	public void output() {
		System.out.print("����Ͻ� ���� ��ȣ : ");
		int roomNum = in.nextInt();
		if (roomNum<1 || roomNum>room.length) {
			System.out.println("���ȣ�� 1ȣ�Ǻ��� " + room.length+"ȣ�� ���� �Դϴ�.");
			System.out.println("�ٽ� �Է��� �ּ���!!");
			input();
		}else {
			if (!room[roomNum-1]) {
				System.out.println(roomNum+"ȣ���� ���");
			}else {
				room[roomNum-1] = false;
				System.out.println(roomNum+"ȣ�ǿ��� ���");
			}
		}			
	}

	@Override
	public void view() {
		for(int i=0; i<room.length; ++i) {
			if (room[i]) {
				System.out.println(i+1+"ȣ���� �����");
			}else {
				System.out.println(i+1+"ȣ���� ���");
			}
		}
	
		
	}

	@Override
	public void exit() {
		System.out.println("���α׷��� �����մϴ�.");
		System.exit(0);
	}

}
