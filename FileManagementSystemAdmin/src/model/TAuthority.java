package model;

/**
 * TAuthority entity. @author MyEclipse Persistence Tools
 */

public class TAuthority implements java.io.Serializable {

	// Fields

	private Integer authorityid;
	private String authorityname;
	private Integer includeid;

	// Constructors

	/** default constructor */
	public TAuthority() {
	}

	/** minimal constructor */
	public TAuthority(Integer authorityid) {
		this.authorityid = authorityid;
	}

	/** full constructor */
	public TAuthority(Integer authorityid, String authorityname,
			Integer includeid) {
		this.authorityid = authorityid;
		this.authorityname = authorityname;
		this.includeid = includeid;
	}

	// Property accessors

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