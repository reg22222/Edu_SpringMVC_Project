package member;

import java.util.*;

public class MemberProImpl2 implements MemberPro{

	private Map<String, Member> map = new Hashtable<>();
	//key - �̸�, value - Member 
	private Scanner in = new Scanner(System.in);
	
	protected String inputStr(String title) {
		String str = null;
		System.out.print(title+"�� �Է� : ");
		str = in.next();
		return str;
	}
	
	@Override
	public void insert() {
		String name = inputStr("�̸�");
		if (map.containsKey(name)) {
			System.out.println("�̹� �����ϴ� ȸ���̽ʴϴ�. �ٽ� �Է��� �ּ���");
			insert();
		}else {
			String tel = inputStr("��ȭ��ȣ");
			String email = inputStr("�̸����ּ�");
			Member insert = new Member(name, tel, email);
			map.put(name, insert);
		}
	}

	@Override
	public void view() {
		Set<String> set = map.keySet();
		Iterator<String> it = set.iterator();
		while(it.hasNext()) {
			String name = it.next();
			Member view = map.get(name);
			view.disp();
		}
	}
	
	@Override
	public void delete() {
		String name = inputStr("������ ȸ��");
		if (map.containsKey(name)){
			map.remove(name);
			System.out.println(name+"ȸ������ �����Ͽ����ϴ�.");
		}else {
			System.out.println(name+"ȸ������ �������� �ʽ��ϴ�.");
		}
	}

	@Override
	public void edit() {
		String name = inputStr("������ ȸ���̸�");
		if (!map.containsKey(name)) {
			System.out.println(name+"ȸ������ �������� �ʽ��ϴ�.");
			//edit(); -- ���ȣ��
			return;	// void �޼ҵ��� ����� return �̴�
		}else {
			Member edit = map.get(name);
			System.out.println(name+"���� ��ȭ��ȣ : "+ edit.getTel());
			String tel = inputStr("������ ȸ����ȭ��ȣ");
			edit.setTel(tel);
			System.out.println(name+"���� �̸��� �ּ� : "+ edit.getEmail());
			edit.setEmail(inputStr("������ ȸ���̸����ּ�"));
		}
	}

	@Override
	public void exit() {
		System.out.println("���α׷��� �����մϴ�.");
		System.exit(0);
	}

	@Override
	public void save() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void load() {
		// TODO Auto-generated method stub
		
	}

}








