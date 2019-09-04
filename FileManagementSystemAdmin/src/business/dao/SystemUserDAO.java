package business.dao;

import java.util.List;

import model.TDepartment;
import model.TRole;
import model.TUser;
import model.VUser;

public interface SystemUserDAO {

	/**
	 * 查询前端所有登用户
	 * 
	 * @param currentPage
	 *            按分页查询的当前页
	 * @param pageSize
	 *            按分页查询的每页数量
	 * @return List<VUser>
	 */
	public List<VUser> getCommonUserUser(int currentPage, int pageSize);

	/**
	 * 根据条件获取符合条件的用户的数量
	 * 
	 * @param wherecondition
	 *            如："userRole = '超级管理员' and userid = 'zhangjs'"
	 * @return
	 */
	public int getCommonUserUserAmount();

	/**
	 * 按用户ID查询前端登用户
	 * 
	 * @param wherecondition
	 *            组合查询条件字符串,如："userRole = '超级管理员' and userid = 'zhangjs'"
	 * @param currentPage
	 *            按分页查询的当前页
	 * @param pageSize
	 *            按分页查询的每页数量
	 * @return List<VUser>
	 */
	public List<VUser> getCommonUserUserByID(String wherecondition,
			int currentPage, int pageSize);

	/**
	 * 按用户ID查询前端登用户总数
	 * 
	 * @param wherecondition
	 *            组合查询条件字符串,如："userRole = '超级管理员' and userid = 'zhangjs'"
	 * @param currentPage
	 *            按分页查询的当前页
	 * @param pageSize
	 *            按分页查询的每页数量
	 * @return List<VUser>
	 */
	public int getCommonUserUserByIDAmount(String wherecondition);

	/**
	 * 获取角色权限的类型，绑定到选择权限下拉框
	 * 
	 * @return
	 */
	public List<TRole> getRoleTypes();

	/**
	 * 获取所有部门，绑定到选择权限下拉框
	 * 
	 * @return
	 */
	public List<TDepartment> getDepartmentTypes();

	/**
	 * 前端用户添加
	 * 
	 * @param TRole
	 *            TRole 对象
	 * @return 成功返回0失败返回1
	 */
	public int addUser(TUser user);

	/**
	 * 通过id进行删除
	 * 
	 * @param int id
	 * @param
	 * @return 成功返回0 失败返回1
	 */
	public boolean deleteUser(String id);

}
