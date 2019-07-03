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
	public List<TSystemModel> geVRoleSystemModelMenuByName(String wherecondition, int currentPage, int pageSize) {
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
		  System.out.println(hql);
		  List<VRoleSystemModel> list = bdao.select(hql);	
		  return list.size();
	}

	@Override
	public int addAdminRoleMenu(VRoleSystemModel adminrole) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean deleteAdminRoleMenu(int adminroleid) {
		// TODO Auto-generated method stub
		return false;
	}

}
