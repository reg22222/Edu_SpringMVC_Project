package member;

public class Member {
	//����ʵ�
	private String name;
	private String tel;
	private String email;
	//������
	public Member(String name, String tel, String email) {
		this.name = name;
		this.tel = tel;
		this.email = email;
	}
	//setter�޼ҵ�
	public void setTel(String tel) {
		this.tel = tel;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	//getter�޼ҵ�
	public String getName() {
		return name;
	}
	public String getTel() {
		return tel;
	}
	public String getEmail() {
		return email;
	}
	//�Ϲݸ޼ҵ�
	public void disp() {
		System.out.println("�̸� : " + name + 
			" , ��ȭ��ȣ : " + tel + " , �̸����ּ� : "+ email);
	}
}	









