package business.dao;

import java.util.List;

import model.TAdminRole;
import model.TAdminUser;
import model.VAdminUser;

public interface AdminUserDAO {
	
	/**
	 * 查询后台所有登用户 
	 * @param currentPage 按分页查询的当前页
	 * @param pageSize 按分页查询的每页数量
	 * @return  List<VUser> 
	 */
	public List<VAdminUser> getAdminUser(int currentPage, int pageSize);
	
	/**
	 * 查询后台所有登用户 的数量
	 * @param wherecondition 如："userRole = '超级管理员' and userid = 'zhangjs'" 
	 * @return
	 */
	public int getAdminUserAmount();
	
	/**
	 * 按用户ID,角色等查询前端登用户
	* @param wherecondition 组合查询条件字符串,如："userRole = '超级管理员' and userid = 'zhangjs'" 
	 * @param currentPage 按分页查询的当前页
	 * @param pageSize 按分页查询的每页数量
	 * @return  List<VUser> 
	 */
	public List<VAdminUser> getAdminUserByID(String wherecondition, int currentPage, int pageSize);
	
	/**
	 * 按用户ID查询前端登用户总数
	* @param wherecondition 组合查询条件字符串,如："userRole = '超级管理员' and userid = 'zhangjs'" 
	 * @param currentPage 按分页查询的当前页
	 * @param pageSize 按分页查询的每页数量
	 * @return  List<VUser> 
	 */
	public int getAdminUserByIDAmount(String wherecondition);
	
	/**
	 * 获取角色权限的类型，绑定到选择权限下拉框
	 * @return
	 */
	public List<TAdminRole> getRoleTypes();
	
	
	/**
	 * 前端用户添加
	 * @param TAdminUser 对象
	 * @return  成功返回0失败返回1
	 */
	public int addAdminUser(TAdminUser user);
	
	/**
	 * 通过id进行删除
	 * @param int id
	 * @param 
	 * @return 成功返回0 失败返回1 
	 */
	public boolean deleteAdminUser(String id);

}
