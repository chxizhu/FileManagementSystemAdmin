package business.dao;

import java.util.List;

import model.TDepartment;
import model.TsystemLog;
import model.VFile;

public interface userFileDAO {
	
	/**
	 * 查询所有上传文件
	 * @param currentPage 按分页查询的当前页
	 * @param pageSize 按分页查询的每页数量
	 * @return  List<VUser> 
	 */
	public List<VFile> getVFilesList(int currentPage, int pageSize);
	
	/**
	 * 查询所有所有上传文件的数量
	 * @param wherecondition 如："userRole = '超级管理员' and userid = 'zhangjs'" 
	 * @return
	 */
	public int getVFilesListAmount();
	
	/**
	 * 根据条件查询上传文件
	 * @param wherecondittion
	 * @return list
	 */
	public List<VFile> getVFilesListByName(String wherecondition, int currentPage,int pageSize);

	/**
	 * 根据条件查询上传文件总数
	 * 
	 * @param getSystemLog
	 * @return int
	 */
	public int getVFilesListByNameAmount(String wherecondition);
	
	/**
	 * 通过id进行删除
	 * @param int id
	 * @param 
	 * @return 成功返回0 失败返回1 
	 */
	public boolean deleteUserFile(int id);

}
