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
		System.out.print(title+"�� �Է� : ");
		str = in.next();
		return str;
	}
	
	@Override
	public void insert() {
		String name = null;
		do{
			name = inputStr("�̸�");
		}while(isName(name) != null);		
		String tel = inputStr("��ȭ��ȣ");
		String email = inputStr("�̸����ּ�");
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
		String name = inputStr("������ ȸ��");
		Member delete = (Member)isName(name);
		if (delete != null) {
			list.remove(delete);
			System.out.println(name+"ȸ������ �����Ͽ����ϴ�.");
		}else {
			System.out.println(name+"ȸ������ �������� �ʽ��ϴ�.");
		}
	}

	@Override
	public void edit() {
		String name = inputStr("������ ȸ���̸�");
		Member edit = (Member)isName(name);
		if (edit == null) {
			System.out.println(name+"ȸ������ �������� �ʽ��ϴ�.");
			//edit(); -- ���ȣ��
			return;	// void �޼ҵ��� ����� return �̴�
		}else {
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
		}catch(EOFException e) {//������ �����µ� readUTF�� ��� ������ �߻��ϴ� ����
			System.out.println("���� ���ε� ��!!");
		}catch(IOException e) {
			System.err.println(e.getMessage());
		}
		
	}

}








