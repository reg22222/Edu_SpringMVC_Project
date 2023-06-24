package player;
import java.util.*;

public class PlayerMgImpl implements PlayerMg{
	private Scanner in;
	private PlayerDAO dao;
	
	public PlayerMgImpl() {
		in = new Scanner(System.in);
		dao = new PlayerDAO();
	}
	
	@Override
	public void insert() {
		System.out.print("선수명을 입력 : ");
		String name = in.next();
		System.out.print("포지션을 입력 : ");
		String position = in.next();
		System.out.print("연봉을 입력 : ");
		int salary = in.nextInt();
		System.out.print("팀을 입력 : ");
		String team = in.next();
		PlayerDTO dto = new PlayerDTO();
		dto.setName(name);
		dto.setPosition(position);
		dto.setSalary(salary);
		dto.setTeamName(team);
		int res = dao.insertPlayer(dto);
		if (res>0) {
			System.out.println(name+"선수 등록 성공!!");
		}else {
			System.out.println(name+"선수 등록 실패!!");
		}
	}

	@Override
	public void view() {
		List<PlayerDTO> list = dao.listPlayer();
		for(PlayerDTO dto : list) {
			System.out.print(dto.getNum() + "\t");
			System.out.print(dto.getName() + "\t");
			System.out.print(dto.getPosition() + "\t");
			System.out.print(dto.getSalary() + "\t");
			System.out.print(dto.getTeamName() + "\n");
		}
	}

	@Override
	public void delete() {
		System.out.print("삭제할 선수의 번호를 입력 : ");
		int num = in.nextInt();
		int res = dao.deletePlayer(num);
		if (res>0) {
			System.out.println("선수 삭제 성공!!");
		}else {
			System.out.println("선수 삭제 실패!!");
		}
	}

	@Override
	public void edit_salary() {
		System.out.print("수정할 선수의 번호를 입력 : ");
		int num = in.nextInt();
		System.out.print("수정할 연봉을 입력 : ");
		int salary = in.nextInt();
		int res = dao.editSalary(num, salary);
		if (res>0) {
			System.out.println("선수 연봉 수정 성공!!");
		}else {
			System.out.println("선수 연봉 수정 실패!!");
		}
	}

	@Override
	public void edit_team() {
		System.out.print("수정할 선수의 번호를 입력 : ");
		int num = in.nextInt();
		System.out.print("옮길 팀을 입력 : ");
		String teamName = in.next();
		int res = dao.editTeamName(num, teamName);
		if (res>0) {
			System.out.println("선수 팀 옮기기 성공!!");
		}else {
			System.out.println("선수 팀 옮기기 실패!!");
		}
	}

	@Override
	public void exit() {
		System.out.println("프로그램을 종료합니다.");
		System.exit(0);
		
	}

}
