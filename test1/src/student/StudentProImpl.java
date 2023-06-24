package student;

import java.io.*;
import java.util.*;

public class StudentProImpl implements StudentPro {
	private List<Student> list = new ArrayList<>();
	private Scanner in = new Scanner(System.in);
	private File dir = new File("G:\\javaweb\\study\\test1\\src\\student");
	private File file = new File(dir, "data.txt");
	protected String inputStr(String title) {
		System.out.print(title+"을 입력 : ");
		String str = in.next();
		return str;
	}
	protected int inputSub(String title) {
		System.out.print(title+"점수를 입력 : ");
		int sub = in.nextInt();
		if (sub < 0 || sub > 100) {
			System.out.println(title+"과목의 점수는 0~100점만 입력 가능");
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
		String name = inputStr("학생이름");
		if (isName(name) == null) {
			int kor = inputSub("국어");
			int eng = inputSub("영어");
			Student insert = new Student(name, kor, eng);
			list.add(insert);
		}else {
			System.out.println(name+"학생은 이미 존재하는 학생입니다.");
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
		String name = inputStr("삭제할 학생이름");
		Student delete = isName(name);
		if (delete != null) {
			list.remove(delete);
		}else {
			System.out.println(name+"님은 저희 학생이 아닙니다.");
		}

	}

	@Override
	public void edit() {
		String name = inputStr("수정할 학생이름");
		Student edit = isName(name);
		if (edit == null) {
			System.out.println(name+"님은 저희 학생이 아닙니다.");
			return;
		}
		System.out.println("현재 " + edit.getName()
					+ "님의 국어점수는 " + edit.getKor()+"점 입니다.");
		int kor = inputSub("수정할 국어");
		edit.setKor(kor);
		System.out.println("현재 " + edit.getName()
					+ "님의 영어점수는 " + edit.getEng()+"점 입니다.");
		int eng = inputSub("수정할 영어");
		edit.setEng(eng);
		edit.setTot();
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
			System.out.println("파일 업로드 끝!!");
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








