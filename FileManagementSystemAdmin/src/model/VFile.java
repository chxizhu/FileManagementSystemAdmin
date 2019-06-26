package model;

import java.sql.Timestamp;

/**
 * VFileId entity. @author MyEclipse Persistence Tools
 */

public class VFile implements java.io.Serializable {

	// Fields

	private String id;
	private String userid;
	private String username;
	private Integer roleid;
	private String rolename;
	private Integer authorityid;
	private String authorityname;
	private Integer fileid;
	private String filename;
	private Timestamp uptime;
	private Integer typeid;
	private String typename;
	private String dscribe;
	private String lable;
	private String filesize;
	private String filesuffix;
	private String filepath;
	private Integer downloads;

	// Constructors

	/** default constructor */
	public VFile() {
	}

	/** minimal constructor */
	public VFile(String userid, Integer roleid, Integer authorityid,
			Integer fileid, Integer typeid) {
		this.userid = userid;
		this.roleid = roleid;
		this.authorityid = authorityid;
		this.fileid = fileid;
		this.typeid = typeid;
	}

	/** full constructor */
	public VFile(String id, String userid, String username, Integer roleid,
			String rolename, Integer authorityid, String authorityname,
			Integer fileid, String filename, Timestamp uptime, Integer typeid,
			String typename, String dscribe, String lable, String filesize,
			String filesuffix, String filepath, Integer downloads) {
		this.id = id;
		this.userid = userid;
		this.username = username;
		this.roleid = roleid;
		this.rolename = rolename;
		this.authorityid = authorityid;
		this.authorityname = authorityname;
		this.fileid = fileid;
		this.filename = filename;
		this.uptime = uptime;
		this.typeid = typeid;
		this.typename = typename;
		this.dscribe = dscribe;
		this.lable = lable;
		this.filesize = filesize;
		this.filesuffix = filesuffix;
		this.filepath = filepath;
		this.downloads = downloads;
	}

	// Property accessors

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
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

	public Integer getFileid() {
		return this.fileid;
	}

	public void setFileid(Integer fileid) {
		this.fileid = fileid;
	}

	public String getFilename() {
		return this.filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public Timestamp getUptime() {
		return this.uptime;
	}

	public void setUptime(Timestamp uptime) {
		this.uptime = uptime;
	}

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

	public String getDscribe() {
		return this.dscribe;
	}

	public void setDscribe(String dscribe) {
		this.dscribe = dscribe;
	}

	public String getLable() {
		return this.lable;
	}

	public void setLable(String lable) {
		this.lable = lable;
	}

	public String getFilesize() {
		return this.filesize;
	}

	public void setFilesize(String filesize) {
		this.filesize = filesize;
	}

	public String getFilesuffix() {
		return this.filesuffix;
	}

	public void setFilesuffix(String filesuffix) {
		this.filesuffix = filesuffix;
	}

	public String getFilepath() {
		return this.filepath;
	}

	public void setFilepath(String filepath) {
		this.filepath = filepath;
	}

	public Integer getDownloads() {
		return this.downloads;
	}

	public void setDownloads(Integer downloads) {
		this.downloads = downloads;
	}
}