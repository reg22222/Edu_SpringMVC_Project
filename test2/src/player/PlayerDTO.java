package player;
//DTO : Data Transfer Object
//���̺��� �÷����� ����ʵ�� �ϴ� Ŭ����, �� ����� ��� setter, getter�޼ҵ带 ������
public class PlayerDTO {
	private int num;
	private String name;
	private String position;
	private int salary;
	private String teamName;
	
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public String getTeamName() {
		return teamName;
	}
	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}
}
