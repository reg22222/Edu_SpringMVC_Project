package room;

public class RoomMg extends Room{

	@Override
	public void input() {
		System.out.print("입실하실 방의 번호 : ");
		int roomNum = in.nextInt();
		if (roomNum<1 || roomNum>room.length) {
			System.out.println("방번호는 1호실부터 " + room.length+"호실 까지 입니다.");
			System.out.println("다시 입력해 주세요!!");
			input();
		}else {
			if (room[roomNum-1]) {
				System.out.println(roomNum+"호실은 사용중");
			}else {
				room[roomNum-1] = true;
				System.out.println(roomNum+"호실에 입실");
			}
		}		
	}

	@Override
	public void output() {
		System.out.print("퇴실하실 방의 번호 : ");
		int roomNum = in.nextInt();
		if (roomNum<1 || roomNum>room.length) {
			System.out.println("방번호는 1호실부터 " + room.length+"호실 까지 입니다.");
			System.out.println("다시 입력해 주세요!!");
			input();
		}else {
			if (!room[roomNum-1]) {
				System.out.println(roomNum+"호실은 빈방");
			}else {
				room[roomNum-1] = false;
				System.out.println(roomNum+"호실에서 퇴실");
			}
		}			
	}

	@Override
	public void view() {
		for(int i=0; i<room.length; ++i) {
			if (room[i]) {
				System.out.println(i+1+"호실은 사용중");
			}else {
				System.out.println(i+1+"호실은 빈방");
			}
		}
	
		
	}

	@Override
	public void exit() {
		System.out.println("프로그램을 종료합니다.");
		System.exit(0);
	}

}
