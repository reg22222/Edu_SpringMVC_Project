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
	
	//setter메소드
	public void setKor(int kor) {
		this.kor = kor;
	}
	public void setEng(int eng) {
		this.eng = eng;
	}
	public void setTot() {
		tot = kor + eng;
	}
	//getter메소드
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
	//비즈니스 메소드(일반메소드)
	public void disp() {
		System.out.println(name+"님의 총점은 " + tot 
				+"점이고, 순위는 " + rank+"등 입니다.");
	}
	public void clearRank() {
		rank = 1;
	}
	public void plusRank() {
		rank++;
	}
}











