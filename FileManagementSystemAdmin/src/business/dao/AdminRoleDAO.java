package business.dao;

import java.util.List;

import model.TAdminRole;

public interface AdminRoleDAO {

	/**
	 * 查询所有管理员角色
	 * @param currentPage 按分页查询的当前页
	 * @param pageSize 按分页查询的每页数量
	 * @return  List<VUser> 
	 */
	public List<TAdminRole> getAdminRole(int currentPage, int pageSize);
	
	/**
	 * 查询所有管理员角色的数量
	 * @param wherecondition 如："userRole = '超级管理员' and userid = 'zhangjs'" 
	 * @return
	 */
	public int getAdminRoleAmount();
	
	/**
	 * 按角色名称查询角色
	* @param wherecondition 组合查询条件字符串,如："userRole = '超级管理员' and userid = 'zhangjs'" 
	 * @param currentPage 按分页查询的当前页
	 * @param pageSize 按分页查询的每页数量
	 * @return  List<VUser> 
	 */
	public List<TAdminRole> getAdminRoleByName(String wherecondition, int currentPage, int pageSize);
	
	/**
	 * 按管理员角色名称查询管理员角色总数
	* @param wherecondition 组合查询条件字符串,如："userRole = '超级管理员' and userid = 'zhangjs'" 
	 * @param currentPage 按分页查询的当前页
	 * @param pageSize 按分页查询的每页数量
	 * @return  List<VUser> 
	 */
	public int getAdminRoleByNameAmount(String wherecondition);
	
	/**
	 * 添加管理员角色
	 * @param TRole TRole 对象
	 * @return  成功返回0失败返回1
	 */
	public int addAdminRole(TAdminRole adminrole);
	
	/**
	 * 通过id进行删除管理员角色
	 * @param int id
	 * @param 
	 * @return 成功返回0 失败返回1 
	 */
	public boolean deleteAdminRole(int adminroleid);
	
	/**
	 * 修改启用状态
	 * @param TRole TRole 对象
	 * @return  成功返回0失败返回1
	 */
	public int mAdminRoleMenu(int id, Boolean isdelete);
	
}
