package business.dao;

import java.util.List;

import model.TAdminRole;
import model.TAuthority;
import model.TRole;
import model.VUser;


public interface UserRoleManageDAO {
	
	/**
	 * 查询所有用户角色
	 * @param currentPage 按分页查询的当前页
	 * @param pageSize 按分页查询的每页数量
	 * @return  List<VUser> 
	 */
	public List<TRole> getRole(int currentPage, int pageSize);
	
	/**
	 * 查询所有用户角色的数量
	 * @param wherecondition 如："userRole = '超级管理员' and userid = 'zhangjs'" 
	 * @return
	 */
	public int getRoleAmount();
	
	/**
	 * 按条件（角色名）查询用户角色
	 * @param 
	 * @param 
	 * @return  List<TAdminRole>  当前登录的用户对象
	 */
	public List<TRole> getRoleByName(String wherecondition, int currentPage, int pageSize);
	
	/**
	 * 条件（角色名）查询用户角色的数量
	 * @param wherecondition 如："userRole = '超级管理员' and userid = 'zhangjs'" 
	 * @return
	 */
	public int getRoleByNameAmount(String wherecondition);
	
	/**
	 * 通过id进行删除
	 * @param int id
	 * @param 
	 * @return 成功返回0 失败返回1 
	 */
	public boolean deleteUserRole(int id);
	
	/**
	 * 用户角色添加
	 * @param TRole TRole 对象
	 * @return  成功返回0失败返回1
	 */
	public int addUserRole(TRole TRole);
	
	/**
	 * 获取角色权限的类型，绑定到选择权限下拉框
	 * @return
	 */
	public List<TAuthority> getAuthorityTypes();
	

}
