package business.dao;

import java.util.List;

import model.TAuthority;


public interface RolePermissionManageDAO {
	/**
	 * 用户角色表业务方法
	 * @param 
	 * @param 
	 * @return  List<TAdminRole>  当前登录的用户对象
	 */
	public List<TAuthority> getrolepermission(String str, int currentPage, int pageSize);
	
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
