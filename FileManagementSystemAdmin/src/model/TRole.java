package model;

/**
 * TRole entity. @author MyEclipse Persistence Tools
 */

public class TRole implements java.io.Serializable {

	// Fields

	private Integer roleid;
	private String rolename;
	private Integer uproleid;
	private Integer authorityId;

	// Constructors

	/** default constructor */
	public TRole() {
	}

	/** minimal constructor */
	public TRole(Integer roleid) {
		this.roleid = roleid;
	}

	/** full constructor */
	public TRole(Integer roleid, String rolename, Integer uproleid,
			Integer authorityId) {
		this.roleid = roleid;
		this.rolename = rolename;
		this.uproleid = uproleid;
		this.authorityId = authorityId;
	}

	// Property accessors

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

}