

public class MemberVO {
	private String id;
	private String password;
	private String phone_number;
	private int age;

	public MemberVO() {
	} // 디폴트 생성자

	public MemberVO(String id, String password, String phone_number, int number) {
		super();
		this.id = id;
		this.password = password;
		this.phone_number = phone_number;
		this.age = age;
	}

	@Override
	public String toString() {
		return "MemberVO [id=" + id + ", password=" + password + ", phone_number=" + phone_number + ", age=" + age
				+ "]";
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhone_number() {
		return phone_number;
	}

	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

}
