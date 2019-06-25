package business.dao;

import java.util.List;

import model.TAdminRole;


public interface UserRoleManageDAO {
	
	/**
	 * 用户角色表业务方法
	 * @param 
	 * @param 
	 * @return  List<TAdminRole>  当前登录的用户对象
	 */
	public List<TAdminRole> getUserRole();

}
