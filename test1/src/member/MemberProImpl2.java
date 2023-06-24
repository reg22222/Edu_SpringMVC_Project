package member;

import java.util.*;

public class MemberProImpl2 implements MemberPro{

	private Map<String, Member> map = new Hashtable<>();
	//key - 이름, value - Member 
	private Scanner in = new Scanner(System.in);
	
	protected String inputStr(String title) {
		String str = null;
		System.out.print(title+"을 입력 : ");
		str = in.next();
		return str;
	}
	
	@Override
	public void insert() {
		String name = inputStr("이름");
		if (map.containsKey(name)) {
			System.out.println("이미 존재하는 회원이십니다. 다시 입력해 주세요");
			insert();
		}else {
			String tel = inputStr("전화번호");
			String email = inputStr("이메일주소");
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
		String name = inputStr("삭제할 회원");
		if (map.containsKey(name)){
			map.remove(name);
			System.out.println(name+"회원님을 삭제하였습니다.");
		}else {
			System.out.println(name+"회원님은 존재하지 않습니다.");
		}
	}

	@Override
	public void edit() {
		String name = inputStr("수정할 회원이름");
		if (!map.containsKey(name)) {
			System.out.println(name+"회원님은 존재하지 않습니다.");
			//edit(); -- 재귀호출
			return;	// void 메소드의 종료는 return 이다
		}else {
			Member edit = map.get(name);
			System.out.println(name+"님의 전화번호 : "+ edit.getTel());
			String tel = inputStr("수정할 회원전화번호");
			edit.setTel(tel);
			System.out.println(name+"님의 이메일 주소 : "+ edit.getEmail());
			edit.setEmail(inputStr("수정할 회원이메일주소"));
		}
	}

	@Override
	public void exit() {
		System.out.println("프로그램을 종료합니다.");
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








