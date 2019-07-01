package business.dao;

import java.util.List;

import model.TAuthority;
import model.TDepartment;


public interface RolePermissionManageDAO {
	
	/**
	 * 查询所有角色权限
	 * @param currentPage 按分页查询的当前页
	 * @param pageSize 按分页查询的每页数量
	 * @return  List<VUser> 
	 */
	public List<TAuthority> getAuthority(int currentPage, int pageSize);
	
	/**
	 * 查询所有角色权限的数量
	 * @param wherecondition 如："userRole = '超级管理员' and userid = 'zhangjs'" 
	 * @return
	 */
	public int getAuthorityAmount();
	
	/**
	 * 用户角色表业务方法
	 * @param 
	 * @param 
	 * @return  List<TAdminRole>  当前登录的用户对象
	 */
	public List<TAuthority> getrolepermission(String str, int currentPage, int pageSize);
	
	/**
	 * 按条件查询角色权限的数量
	 * @param wherecondition 如："userRole = '超级管理员' and userid = 'zhangjs'" 
	 * @return
	 */
	public int getrolepermissionAmount(String str);
	
	/**
	 * 用户角色表业务方法
	 * @param 
	 * @param 
	 * @return  List<TAdminRole>  当前登录的用户对象
	 */
	public boolean deleterolepermission(int id);
	
	/**
	 * 用户角色添加
	 * @param TRole TRole 对象
	 * @return  成功返回0失败返回1
	 */
	public int addrolepermission(TAuthority TAuthority);
}
