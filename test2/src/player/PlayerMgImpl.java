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
		System.out.print("�������� �Է� : ");
		String name = in.next();
		System.out.print("�������� �Է� : ");
		String position = in.next();
		System.out.print("������ �Է� : ");
		int salary = in.nextInt();
		System.out.print("���� �Է� : ");
		String team = in.next();
		PlayerDTO dto = new PlayerDTO();
		dto.setName(name);
		dto.setPosition(position);
		dto.setSalary(salary);
		dto.setTeamName(team);
		int res = dao.insertPlayer(dto);
		if (res>0) {
			System.out.println(name+"���� ��� ����!!");
		}else {
			System.out.println(name+"���� ��� ����!!");
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
		System.out.print("������ ������ ��ȣ�� �Է� : ");
		int num = in.nextInt();
		int res = dao.deletePlayer(num);
		if (res>0) {
			System.out.println("���� ���� ����!!");
		}else {
			System.out.println("���� ���� ����!!");
		}
	}

	@Override
	public void edit_salary() {
		System.out.print("������ ������ ��ȣ�� �Է� : ");
		int num = in.nextInt();
		System.out.print("������ ������ �Է� : ");
		int salary = in.nextInt();
		int res = dao.editSalary(num, salary);
		if (res>0) {
			System.out.println("���� ���� ���� ����!!");
		}else {
			System.out.println("���� ���� ���� ����!!");
		}
	}

	@Override
	public void edit_team() {
		System.out.print("������ ������ ��ȣ�� �Է� : ");
		int num = in.nextInt();
		System.out.print("�ű� ���� �Է� : ");
		String teamName = in.next();
		int res = dao.editTeamName(num, teamName);
		if (res>0) {
			System.out.println("���� �� �ű�� ����!!");
		}else {
			System.out.println("���� �� �ű�� ����!!");
		}
	}

	@Override
	public void exit() {
		System.out.println("���α׷��� �����մϴ�.");
		System.exit(0);
		
	}

}
