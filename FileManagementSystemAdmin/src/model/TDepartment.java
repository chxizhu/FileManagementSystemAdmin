package model;

/**
 * TDepartment entity. @author MyEclipse Persistence Tools
 */

public class TDepartment implements java.io.Serializable {

	// Fields

	private Integer departmentid;
	private String departmentname;
	private Integer updepartmentid;

	// Constructors

	/** default constructor */
	public TDepartment() {
	}

	/** minimal constructor */
	public TDepartment(Integer departmentid) {
		this.departmentid = departmentid;
	}

	/** full constructor */
	public TDepartment(Integer departmentid, String departmentname,
			Integer updepartmentid) {
		this.departmentid = departmentid;
		this.departmentname = departmentname;
		this.updepartmentid = updepartmentid;
	}

	// Property accessors

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

}