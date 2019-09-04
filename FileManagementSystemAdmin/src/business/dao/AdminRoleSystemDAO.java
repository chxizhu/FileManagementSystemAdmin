package business.dao;

import java.util.List;

import model.TAdminRole;
import model.TRoleSystemModel;
import model.TSystemModel;
import model.VRoleSystemModel;

public interface AdminRoleSystemDAO {

	/**
	 * 查询所有后台管理员角色权限
	 * 
	 * @param currentPage
	 *            按分页查询的当前页
	 * @param pageSize
	 *            按分页查询的每页数量
	 * @return List<VRoleSystemModel>
	 */
	public List<VRoleSystemModel> getAdminRoleSystem(int currentPage,
			int pageSize);

	/**
	 * 查询所有后台管理员角色权限的数量
	 * 
	 * @param wherecondition
	 *            如："userRole = '超级管理员' and userid = 'zhangjs'"
	 * @return
	 */
	public int getAdminRoleSystemAmount();

	/**
	 * 按条件查询后台管理员角色权限
	 * 
	 * @param wherecondition
	 *            组合查询条件字符串,如："userRole = '超级管理员' and userid = 'zhangjs'"
	 * @param currentPage
	 *            按分页查询的当前页
	 * @param pageSize
	 *            按分页查询的每页数量
	 * @return List<VUser>
	 */
	public List<VRoleSystemModel> getAdminRoleSystemByName(
			String wherecondition, int currentPage, int pageSize);

	/**
	 * 按条件查询后台管理员角色权限总数
	 * 
	 * @param wherecondition
	 *            组合查询条件字符串,如："userRole = '超级管理员' and userid = 'zhangjs'"
	 * @param currentPage
	 *            按分页查询的当前页
	 * @param pageSize
	 *            按分页查询的每页数量
	 * @return List<VUser>
	 */
	public int getAdminRoleSystemByNameAmount(String wherecondition);

	/**
	 * 添加后台管理员角色权限
	 * 
	 * @param TRole
	 *            TRole 对象
	 * @return 成功返回0失败返回1
	 */
	public int addRoleSystemModel(TRoleSystemModel rolesystem);

	/**
	 * 通过id进行删除后台管理员角色权限
	 * 
	 * @param int id
	 * @param
	 * @return 成功返回0 失败返回1
	 */
	public boolean deleteRoleSystemModel(int rolesystemid);

	/**
	 * 获取管理员角色权限的类型，绑定到选择权限下拉框
	 * 
	 * @return
	 */
	public List<TAdminRole> getAdminRoleTypes();

	/**
	 * 获取所有菜单，绑定到选择权限下拉框
	 * 
	 * @return
	 */
	public List<TSystemModel> getAdminSystemTypes();

}
