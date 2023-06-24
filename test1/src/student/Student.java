package student;

import java.io.Serializable;

public class Student implements Serializable{
	private String name;
	private int kor;
	private int eng;
	private int tot;
	private int rank;
	public Student(String name, int kor, int eng) {
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		setTot();
	}
	
	//setter�޼ҵ�
	public void setKor(int kor) {
		this.kor = kor;
	}
	public void setEng(int eng) {
		this.eng = eng;
	}
	public void setTot() {
		tot = kor + eng;
	}
	//getter�޼ҵ�
	public String getName() {
		return name;
	}
	public int getKor() {
		return kor;
	}
	public int getEng() {
		return eng;
	}
	public int getTot() {
		return tot;
	}
	public int getRank() {
		return rank;
	}	
	//����Ͻ� �޼ҵ�(�Ϲݸ޼ҵ�)
	public void disp() {
		System.out.println(name+"���� ������ " + tot 
				+"���̰�, ������ " + rank+"�� �Դϴ�.");
	}
	public void clearRank() {
		rank = 1;
	}
	public void plusRank() {
		rank++;
	}
}











