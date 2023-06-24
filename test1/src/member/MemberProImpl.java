package member;

import java.io.*;
import java.util.*;

public class MemberProImpl implements MemberPro{

	private List<Member> list = new ArrayList<>();
	private Scanner in = new Scanner(System.in);
	private File dir = new File("G:\\javaweb\\study\\test1\\src\\member");
	private File file = new File(dir, "data.txt");
	
	protected String inputStr(String title) {
		String str = null;
		System.out.print(title+"을 입력 : ");
		str = in.next();
		return str;
	}
	
	@Override
	public void insert() {
		String name = null;
		do{
			name = inputStr("이름");
		}while(isName(name) != null);		
		String tel = inputStr("전화번호");
		String email = inputStr("이메일주소");
		Member insert = new Member(name, tel, email);
		list.add(insert);		
	}

	@Override
	public void view() {
		for(Member view : list) {
			view.disp();
		}
	}
	
	protected Object isName(String name) {
		for(Member mb : list) {
			if (mb.getName().trim().equals(name)) {
				return mb;
			}
		}
		return null;
	}	

	@Override
	public void delete() {
		String name = inputStr("삭제할 회원");
		Member delete = (Member)isName(name);
		if (delete != null) {
			list.remove(delete);
			System.out.println(name+"회원님을 삭제하였습니다.");
		}else {
			System.out.println(name+"회원님은 존재하지 않습니다.");
		}
	}

	@Override
	public void edit() {
		String name = inputStr("수정할 회원이름");
		Member edit = (Member)isName(name);
		if (edit == null) {
			System.out.println(name+"회원님은 존재하지 않습니다.");
			//edit(); -- 재귀호출
			return;	// void 메소드의 종료는 return 이다
		}else {
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
		try {
			FileOutputStream fos = new FileOutputStream(file);
			BufferedOutputStream bos = new BufferedOutputStream(fos);
			DataOutputStream dos = new DataOutputStream(bos);

			for(Member save : list) {
				dos.writeUTF(save.getName());
				dos.writeUTF(save.getTel());
				dos.writeUTF(save.getEmail());
				dos.flush();
			}
			dos.close();
		}catch(IOException e) {
			System.err.println(e.getMessage());
		}
	}

	@Override
	public void load() {
		try {
			FileInputStream fis = new FileInputStream(file);
			BufferedInputStream bis = new BufferedInputStream(fis);
			DataInputStream dis = new DataInputStream(bis);
			
			list.clear();
			
			while(true) {
				String name = dis.readUTF();
				String tel = dis.readUTF();
				String email = dis.readUTF();
				Member load = new Member(name, tel, email);
				list.add(load);
			}
		}catch(EOFException e) {//파일을 끝났는데 readUTF로 계속 읽을때 발생하는 예외
			System.out.println("파일 업로드 끝!!");
		}catch(IOException e) {
			System.err.println(e.getMessage());
		}
		
	}

}








