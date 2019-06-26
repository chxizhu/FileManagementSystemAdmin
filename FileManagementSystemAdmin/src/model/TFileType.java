package model;

/**
 * TFileType entity. @author MyEclipse Persistence Tools
 */

public class TFileType implements java.io.Serializable {

	// Fields

	private Integer typeid;
	private String typename;

	// Constructors

	/** default constructor */
	public TFileType() {
	}

	/** minimal constructor */
	public TFileType(Integer typeid) {
		this.typeid = typeid;
	}

	/** full constructor */
	public TFileType(Integer typeid, String typename) {
		this.typeid = typeid;
		this.typename = typename;
	}

	// Property accessors

	public Integer getTypeid() {
		return this.typeid;
	}

	public void setTypeid(Integer typeid) {
		this.typeid = typeid;
	}

	public String getTypename() {
		return this.typename;
	}

	public void setTypename(String typename) {
		this.typename = typename;
	}

}