package model;

/**
 * VUserId entity. @author MyEclipse Persistence Tools
 */

public class VUser implements java.io.Serializable {

	// Fields

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
	public VUser(Integer departmentid, String departmentname,
			Integer updepartmentid, String userid, String username, String pwd,
			String agend, String phone, Integer roleName, Integer departmentId,
			Integer roleid, String rolename, Integer uproleid,
			Integer authorityId, Integer authorityid, String authorityname,
			Integer includeid) {
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
}