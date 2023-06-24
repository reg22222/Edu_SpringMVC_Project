package member;

public class Member {
	//멤버필드
	private String name;
	private String tel;
	private String email;
	//생성자
	public Member(String name, String tel, String email) {
		this.name = name;
		this.tel = tel;
		this.email = email;
	}
	//setter메소드
	public void setTel(String tel) {
		this.tel = tel;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	//getter메소드
	public String getName() {
		return name;
	}
	public String getTel() {
		return tel;
	}
	public String getEmail() {
		return email;
	}
	//일반메소드
	public void disp() {
		System.out.println("이름 : " + name + 
			" , 전화번호 : " + tel + " , 이메일주소 : "+ email);
	}
}	









