package sec01.ex01;

import java.sql.Date;

public class MemberBean {
	
	private String id;
	private String pwd;
	private String name;
	private String email;
	private Date joinDate;
	public MemberBean() {//인자가 없는 defalt 생성자 만들기  단축키: alt + shift + s
					//(Generate Constructor using Fields)  인자를 해제후클릭 
					

	}
	public MemberBean(String id, String pwd, String name, String email) {
		//인자가 있는 생성자 만들기 위의 단축키와 동일 
		//(Generate(생성하다) Constructor using Fields) 클릭  여기선 인자를 선택 후 확인 
		//Generate Constructor using Fields 해석: 필드를 사용하여 생성자 생성
		 //(생성하다),(생성자),(사용하는) (필드)
		this.id = id;
		this.pwd = pwd;
		this.name = name;
		this.email = email;
		
	
	}
	//geter 와 seter 만들기 //단축키: alt + shift + s
	// Generate Getters and Setters 클릭 후 해당 인자를 체크 후 확인 
	//해석 : Getter 및 Setter 생성 
	//하는 이유: 필드에 접근하고 수정하기 위해서 Getter와 Setter를 생성 
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getJoinDate() {
		return joinDate;
	}
	public void setJoinDate(Date joinDate) {
		this.joinDate = joinDate;
	}
	
	
	
	

}
