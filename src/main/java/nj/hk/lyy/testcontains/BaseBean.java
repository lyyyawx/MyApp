package nj.hk.lyy.testcontains;

public class BaseBean {
	private String name;
	private String age;
	
	public BaseBean(String name, String age) {
		super();
		this.name = name;
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	
	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		return name.equals(((BaseBean)obj).getName());
	}
	
}
