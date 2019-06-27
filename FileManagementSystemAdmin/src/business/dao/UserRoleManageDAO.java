package business.dao;

import java.util.List;

import model.TAdminRole;
import model.TRole;


public interface UserRoleManageDAO {
	
	/**
	 * 用户角色表业务方法
	 * @param 
	 * @param 
	 * @return  List<TAdminRole>  当前登录的用户对象
	 */
	public List<TRole> getUserRole(String str, int currentPage, int pageSize);
	
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

}
