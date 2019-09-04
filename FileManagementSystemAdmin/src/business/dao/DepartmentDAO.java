package business.dao;

import java.util.List;

import model.TDepartment;
import model.TUser;

public interface DepartmentDAO {

	/**
	 * 查询所有部门
	 * 
	 * @param currentPage
	 *            按分页查询的当前页
	 * @param pageSize
	 *            按分页查询的每页数量
	 * @return List<VUser>
	 */
	public List<TDepartment> getDepartment(int currentPage, int pageSize);

	/**
	 * 查询所有部门 的数量
	 * 
	 * @param wherecondition
	 *            如："userRole = '超级管理员' and userid = 'zhangjs'"
	 * @return
	 */
	public int getDepartmentAmount();

	/**
	 * 按部门名称查询部门
	 * 
	 * @param wherecondition
	 *            组合查询条件字符串,如："userRole = '超级管理员' and userid = 'zhangjs'"
	 * @param currentPage
	 *            按分页查询的当前页
	 * @param pageSize
	 *            按分页查询的每页数量
	 * @return List<VUser>
	 */
	public List<TDepartment> getDepartmentByName(String wherecondition,
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
	public int getDepartmentByNameAmount(String wherecondition);

	/**
	 * 添加部门
	 * 
	 * @param TRole
	 *            TRole 对象
	 * @return 成功返回0失败返回1
	 */
	public int addDepartment(TDepartment department);

	/**
	 * 通过id进行删除部门
	 * 
	 * @param int id
	 * @param
	 * @return 成功返回0 失败返回1
	 */
	public boolean deleteDepartment(int departmentid);
}
