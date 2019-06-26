package model;

/**
 * VUserId entity. @author MyEclipse Persistence Tools
 */

public class VUser implements java.io.Serializable {

	// Fields

	private String id;
	private Integer departmentid;
	private String departmentname;
	private Integer updepartmentid;
	private String userid;
	private String username;
	private String pwd;
	private String agend;
	private String phone;
	private Integer roleName;
	private Integer departmentId;
	private Integer roleid;
	private String rolename;
	private Integer uproleid;
	private Integer authorityId;
	private Integer authorityid;
	private String authorityname;
	private Integer includeid;

	// Constructors

	/** default constructor */
	public VUser() {
	}

	/** minimal constructor */
	public VUser(Integer departmentid, String userid, Integer roleName,
			Integer roleid, Integer authorityid) {
		this.departmentid = departmentid;
		this.userid = userid;
		this.roleName = roleName;
		this.roleid = roleid;
		this.authorityid = authorityid;
	}

	/** full constructor */
	public VUser(String id, Integer departmentid, String departmentname,
			Integer updepartmentid, String userid, String username, String pwd,
			String agend, String phone, Integer roleName, Integer departmentId,
			Integer roleid, String rolename, Integer uproleid,
			Integer authorityId, Integer authorityid, String authorityname,
			Integer includeid) {
		this.id = id;
		this.departmentid = departmentid;
		this.departmentname = departmentname;
		this.updepartmentid = updepartmentid;
		this.userid = userid;
		this.username = username;
		this.pwd = pwd;
		this.agend = agend;
		this.phone = phone;
		this.roleName = roleName;
		this.departmentId = departmentId;
		this.roleid = roleid;
		this.rolename = rolename;
		this.uproleid = uproleid;
		this.authorityId = authorityId;
		this.authorityid = authorityid;
		this.authorityname = authorityname;
		this.includeid = includeid;
	}

	// Property accessors

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Integer getDepartmentid() {
		return this.departmentid;
	}

	public void setDepartmentid(Integer departmentid) {
		this.departmentid = departmentid;
	}

	public String getDepartmentname() {
		return this.departmentname;
	}

	public void setDepartmentname(String departmentname) {
		this.departmentname = departmentname;
	}

	public Integer getUpdepartmentid() {
		return this.updepartmentid;
	}

	public void setUpdepartmentid(Integer updepartmentid) {
		this.updepartmentid = updepartmentid;
	}

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

	public Integer getRoleid() {
		return this.roleid;
	}

	public void setRoleid(Integer roleid) {
		this.roleid = roleid;
	}

	public String getRolename() {
		return this.rolename;
	}

	public void setRolename(String rolename) {
		this.rolename = rolename;
	}

	public Integer getUproleid() {
		return this.uproleid;
	}

	public void setUproleid(Integer uproleid) {
		this.uproleid = uproleid;
	}

	public Integer getAuthorityId() {
		return this.authorityId;
	}

	public void setAuthorityId(Integer authorityId) {
		this.authorityId = authorityId;
	}

	public Integer getAuthorityid() {
		return this.authorityid;
	}

	public void setAuthorityid(Integer authorityid) {
		this.authorityid = authorityid;
	}

	public String getAuthorityname() {
		return this.authorityname;
	}

	public void setAuthorityname(String authorityname) {
		this.authorityname = authorityname;
	}

	public Integer getIncludeid() {
		return this.includeid;
	}

	public void setIncludeid(Integer includeid) {
		this.includeid = includeid;
	}
}