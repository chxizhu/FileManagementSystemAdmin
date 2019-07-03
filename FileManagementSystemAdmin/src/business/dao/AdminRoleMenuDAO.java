package business.dao;

import java.util.List;

import model.TSystemModel;
import model.VRoleSystemModel;

public interface AdminRoleMenuDAO {
	/**
	 * 查询所有管理员角色菜单
	 * @param currentPage 按分页查询的当前页
	 * @param pageSize 按分页查询的每页数量
	 * @return  List<VUser> 
	 */
	public List<TSystemModel> geVRoleSystemModelMenu(int currentPage, int pageSize);
	
	/**
	 * 查询所有管理员角色菜单的数量
	 * @param wherecondition 如："userRole = '超级管理员' and userid = 'zhangjs'" 
	 * @return
	 */
	public int geVRoleSystemModelMenu();
	
	/**
	 * 按角色名称查询角色菜单
	* @param wherecondition 组合查询条件字符串,如："userRole = '超级管理员' and userid = 'zhangjs'" 
	 * @param currentPage 按分页查询的当前页
	 * @param pageSize 按分页查询的每页数量
	 * @return  List<VUser> 
	 */
	public List<TSystemModel> geVRoleSystemModelMenuByName(String wherecondition, int currentPage, int pageSize);
	
	/**
	 * 按管理员角色名称查询管理员角色菜单总数
	* @param wherecondition 组合查询条件字符串,如："userRole = '超级管理员' and userid = 'zhangjs'" 
	 * @param currentPage 按分页查询的当前页
	 * @param pageSize 按分页查询的每页数量
	 * @return  List<VUser> 
	 */
	public int geVRoleSystemModelMenuByNameAmount(String wherecondition);
	
	/**
	 * 添加管理员角色菜单
	 * @param TRole TRole 对象
	 * @return  成功返回0失败返回1
	 */
	public int addAdminRoleMenu(VRoleSystemModel adminrole);
	
	/**
	 * 通过id进行删除管理员角色菜单
	 * @param int id
	 * @param 
	 * @return 成功返回0 失败返回1 
	 */
	public boolean deleteAdminRoleMenu(int adminroleid);

}
