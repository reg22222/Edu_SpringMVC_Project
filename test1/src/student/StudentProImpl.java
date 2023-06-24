package student;

import java.io.*;
import java.util.*;

public class StudentProImpl implements StudentPro {
	private List<Student> list = new ArrayList<>();
	private Scanner in = new Scanner(System.in);
	private File dir = new File("G:\\javaweb\\study\\test1\\src\\student");
	private File file = new File(dir, "data.txt");
	protected String inputStr(String title) {
		System.out.print(title+"�� �Է� : ");
		String str = in.next();
		return str;
	}
	protected int inputSub(String title) {
		System.out.print(title+"������ �Է� : ");
		int sub = in.nextInt();
		if (sub < 0 || sub > 100) {
			System.out.println(title+"������ ������ 0~100���� �Է� ����");
			return inputSub(title);
		}else {
			return sub;
		}
	}
	protected Student isName(String name) {
		for(Student st : list) {
			if (st.getName().equals(name.trim())){
				return st;
			}
		}
		return null;
	}
	protected void rank() {
		for(Student i : list) {
			i.clearRank();
			for(Student j : list) {
				if (i.getTot() < j.getTot()) {
					i.plusRank();
				}
			}
		}
	}
	
	@Override
	public void insert() {
		String name = inputStr("�л��̸�");
		if (isName(name) == null) {
			int kor = inputSub("����");
			int eng = inputSub("����");
			Student insert = new Student(name, kor, eng);
			list.add(insert);
		}else {
			System.out.println(name+"�л��� �̹� �����ϴ� �л��Դϴ�.");
			insert();
			//return;
		}
	}

	@Override
	public void view() {
		rank();
		for(Student view : list) {
			view.disp();
		}
	}

	@Override
	public void delete() {
		String name = inputStr("������ �л��̸�");
		Student delete = isName(name);
		if (delete != null) {
			list.remove(delete);
		}else {
			System.out.println(name+"���� ���� �л��� �ƴմϴ�.");
		}

	}

	@Override
	public void edit() {
		String name = inputStr("������ �л��̸�");
		Student edit = isName(name);
		if (edit == null) {
			System.out.println(name+"���� ���� �л��� �ƴմϴ�.");
			return;
		}
		System.out.println("���� " + edit.getName()
					+ "���� ���������� " + edit.getKor()+"�� �Դϴ�.");
		int kor = inputSub("������ ����");
		edit.setKor(kor);
		System.out.println("���� " + edit.getName()
					+ "���� ���������� " + edit.getEng()+"�� �Դϴ�.");
		int eng = inputSub("������ ����");
		edit.setEng(eng);
		edit.setTot();
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
			ObjectOutputStream oos = new ObjectOutputStream(bos);
			
			oos.writeObject(list);
			oos.close();
		}catch(IOException e) {
			e.printStackTrace();
		}
		/*
		try {
			FileWriter fw = new FileWriter(file);
			BufferedWriter bw = new BufferedWriter(fw);
			PrintWriter pw = new PrintWriter(bw);
			
			for(Student save : list) {
				pw.println(save.getName()+"@"
							+save.getKor()+"@"+save.getEng());
				pw.flush();
			}
			pw.close();
		}catch(IOException e) {
			System.err.println(e.getMessage());
		}
		*/
	}
	@Override
	public void load() {
		try {
			FileInputStream fis = new FileInputStream(file);
			BufferedInputStream bis = new BufferedInputStream(fis);
			ObjectInputStream ois = new ObjectInputStream(bis);
			
			list = (List)ois.readObject();
			System.out.println("���� ���ε� ��!!");
		}catch(IOException e) {
			e.printStackTrace();
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		/*
		try {
			FileReader fr = new FileReader(file);
			BufferedReader br = new BufferedReader(fr);
			list.clear();
			
			while(true) {
				String data = br.readLine();
				Scanner sc = new Scanner(data).useDelimiter("\\s*@\\s*");
				String name = sc.next();
				int kor = sc.nextInt();
				int eng = sc.nextInt();
				Student st = new Student(name, kor, eng);
				list.add(st);
			}
		}catch(IOException e) {
			e.printStackTrace();
		}
		*/
	}
}








