package business.dao;

import java.util.List;

import model.TFileType;

public interface FileCategoryDAO {

	/**
	 * 查询所有文件类型
	 * @param currentPage 按分页查询的当前页
	 * @param pageSize 按分页查询的每页数量
	 * @return  List<TFileType> 
	 */
	public List<TFileType> getFileType(int currentPage, int pageSize);
	
	/**
	 * 查询所有文件类型的数量
	 * @param wherecondition 如："userRole = '超级管理员' and userid = 'zhangjs'" 
	 * @return
	 */
	public int getFileTypeAmount();
	
	/**
	 * 按文件类型名称查询文件类型
	* @param wherecondition 组合查询条件字符串,如："userRole = '超级管理员' and userid = 'zhangjs'" 
	 * @param currentPage 按分页查询的当前页
	 * @param pageSize 按分页查询的每页数量
	 * @return  List<VUser> 
	 */
	public List<TFileType> getFileTypeByName(String wherecondition, int currentPage, int pageSize);
	
	/**
	 * 按文件类型名称查询文件类型总数
	* @param wherecondition 组合查询条件字符串,如："userRole = '超级管理员' and userid = 'zhangjs'" 
	 * @param currentPage 按分页查询的当前页
	 * @param pageSize 按分页查询的每页数量
	 * @return  List<VUser> 
	 */
	public int getFileTypeByNameAmount(String wherecondition);
	
	/**
	 * 添加文件类型
	 * @param TFileType 对象
	 * @return  成功返回0失败返回1
	 */
	public int addFileType(TFileType filetype);
	
	/**
	 * 通过id进行删除文件类型
	 * @param int id
	 * @param 
	 * @return 成功返回0 失败返回1 
	 */
	public boolean deleteFileType(int filetypeid);
	
}
