package business.impl;

import java.util.List;

import model.TAdminRole;
import model.TRole;
import model.TRoleSystemModel;
import model.TSystemModel;
import model.TUser;
import model.VRoleSystemModel;
import model.VUser;
import business.basic.HibernateDAO;
import business.basic.HibernateDAOimpl;
import business.dao.AdminRoleSystemDAO;

public class AdminRoleSystemDAOImpl implements AdminRoleSystemDAO {

	private HibernateDAO bdao = null;

	public AdminRoleSystemDAOImpl() {
		this.bdao = new HibernateDAOimpl();
	}
	
	@Override
	public List<VRoleSystemModel> getAdminRoleSystem(int currentPage,
			int pageSize) {
		String hql = "from VRoleSystemModel";
		List<VRoleSystemModel> list = bdao.selectByPage(hql, currentPage, pageSize);
		return list;
	}

	@Override
	public int getAdminRoleSystemAmount() {
		// TODO Auto-generated method stub
		String hql = "select count(*) from VRoleSystemModel ";
		return bdao.selectValue(hql);
	}

	@Override
	public List<VRoleSystemModel> getAdminRoleSystemByName(
			String wherecondition, int currentPage, int pageSize) {
		String hql =  "from VRoleSystemModel o where concat(o.rolename,o.chinesename) like ? ";
		Object[] para = {"%" + wherecondition + "%"};
		return bdao.selectByPage(hql, para, currentPage, pageSize);
	}

	@Override
	public int getAdminRoleSystemByNameAmount(String wherecondition) {
		String hql =  "select count(*) from VRoleSystemModel o where concat(o.rolename,o.chinesename) like ? ";
		Object[] para = {"%" + wherecondition + "%"};
		return bdao.selectValue(hql, para);
	}

	@Override
	public int addRoleSystemModel(TRoleSystemModel rolesystem) {
		Object obj = bdao.insert(rolesystem);
		if (obj != null)
			return 0;
		else
			return 1;	
	}

	@Override
	public boolean deleteRoleSystemModel(int rolesystemid) {
		return bdao.delete(TRoleSystemModel.class, rolesystemid);
	}

	@Override
	public List<TAdminRole> getAdminRoleTypes() {
		String hql = "from TAdminRole";
		List<TAdminRole> list =  bdao.select(hql);
		return list;
	}

	@Override
	public List<TSystemModel> getAdminSystemTypes() {
		String hql = "from TSystemModel";
		List<TSystemModel> list =  bdao.select(hql);
		return list;
	}

}
