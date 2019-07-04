package business.impl;

import java.util.List;

import model.TAdminRole;
import model.TRole;
import model.TSystemModel;
import model.VRoleSystemModel;
import business.basic.HibernateDAO;
import business.basic.HibernateDAOimpl;
import business.dao.AdminRoleMenuDAO;

/**
 * 
 * @Title: AdminRoleMenuDAOimpl.java
 * @Package business.impl
 * @Description: TODO(角色菜单业务类)
 * @author 成锡柱
 * @date 2019年7月3日 下午2:38:31
 * @version V1.0
 */
public class AdminRoleMenuDAOimpl implements AdminRoleMenuDAO {
	private HibernateDAO bdao = null;

	public AdminRoleMenuDAOimpl() {
		this.bdao = new HibernateDAOimpl();
	}

	@Override
	public List<TSystemModel> geVRoleSystemModelMenu(int currentPage,
			int pageSize) {
		String hql = "from TSystemModel";
		List<TSystemModel> list = bdao.selectByPage(hql, currentPage, pageSize);
		return list;
	}

	@Override
	public int geVRoleSystemModelMenu() {
		String hql = "select count(*) from TSystemModel ";
		return bdao.selectValue(hql);
	}

	@Override
	public List<TSystemModel> geVRoleSystemModelMenuByName(
			String wherecondition, int currentPage, int pageSize) {
		String hql = "from TSystemModel";
		if (wherecondition != null && !wherecondition.equals("")) {
			hql += wherecondition;
		}
		List<TSystemModel> list = bdao.selectByPage(hql, currentPage, pageSize);
		return list;
	}

	@Override
	public int geVRoleSystemModelMenuByNameAmount(String wherecondition) {
		String hql = "from TSystemModel";
		if (wherecondition != null && !wherecondition.equals("")) {
			hql += wherecondition;
		}
		List<VRoleSystemModel> list = bdao.select(hql);
		return list.size();
	}

	@Override
	public int addAdminRoleMenu(TSystemModel TSystemModel) {
		Object obj = bdao.insert(TSystemModel);
		if (obj != null)
			return 0;
		else
			return 1;
	}

	@Override
	public boolean deleteAdminRoleMenu(int adminroleid) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int addAdminRoleMenu(VRoleSystemModel adminrole) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int mAdminRoleMenu(int id, Boolean isdelete) {
		String hql = "UPDATE T_SystemModel SET isdelete = ? WHERE id = ? ";
		int is = 0;
		if (isdelete == true) {
			is = 1;
		} else {
			is = 0;
		}
		Object para[] = { is, id };
		Object num = bdao.update(hql, para);
		System.out.println();
		if (num != null)
			return 0;
		else
			return 1;
	}

}
