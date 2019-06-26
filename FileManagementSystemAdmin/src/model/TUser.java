package model;

/**
 * TUser entity. @author MyEclipse Persistence Tools
 */

public class TUser implements java.io.Serializable {

	// Fields

	private String userid;
	private String username;
	private String pwd;
	private String agend;
	private String phone;
	private Integer roleName;
	private Integer departmentId;

	// Constructors

	/** default constructor */
	public TUser() {
	}

	/** minimal constructor */
	public TUser(String userid, Integer roleName) {
		this.userid = userid;
		this.roleName = roleName;
	}

	/** full constructor */
	public TUser(String userid, String username, String pwd, String agend,
			String phone, Integer roleName, Integer departmentId) {
		this.userid = userid;
		this.username = username;
		this.pwd = pwd;
		this.agend = agend;
		this.phone = phone;
		this.roleName = roleName;
		this.departmentId = departmentId;
	}

	// Property accessors

	public String getUserid() {
		return this.userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPwd() {
		return this.pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getAgend() {
		return this.agend;
	}

	public void setAgend(String agend) {
		this.agend = agend;
	}

	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Integer getRoleName() {
		return this.roleName;
	}

	public void setRoleName(Integer roleName) {
		this.roleName = roleName;
	}

	public Integer getDepartmentId() {
		return this.departmentId;
	}

	public void setDepartmentId(Integer departmentId) {
		this.departmentId = departmentId;
	}

}