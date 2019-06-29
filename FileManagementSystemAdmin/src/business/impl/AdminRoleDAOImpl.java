package business.impl;

import java.util.List;

import model.TAdminRole;
import model.TDepartment;
import business.basic.HibernateDAO;
import business.basic.HibernateDAOimpl;
import business.dao.AdminRoleDAO;

public class AdminRoleDAOImpl implements AdminRoleDAO {

	private HibernateDAO bdao = null;

	public AdminRoleDAOImpl() {
		this.bdao = new HibernateDAOimpl();
	}
	
	@Override
	public List<TAdminRole> getAdminRole(int currentPage, int pageSize) {
		String hql = "from TAdminRole";
		List<TAdminRole> list = bdao.selectByPage(hql, currentPage, pageSize);
		return list;
	}

	@Override
	public int getAdminRoleAmount() {
		String hql = "select count(*) from TAdminRole ";
		return bdao.selectValue(hql);
	}

	@Override
	public List<TAdminRole> getAdminRoleByName(String wherecondition,
			int currentPage, int pageSize) {
		String hql =  "from TAdminRole o where concat(o.name,o.description) like ? ";
		Object[] para = {"%" + wherecondition + "%"};
		return bdao.selectByPage(hql, para, currentPage, pageSize);
	}

	@Override
	public int getAdminRoleByNameAmount(String wherecondition) {
		String hql = "select count(*) from TAdminRole o where concat(o.name,o.description) like ? ";
		Object[] para = {"%" + wherecondition + "%"};
		return bdao.selectValue(hql,para);
	}

	@Override
	public int addAdminRole(TAdminRole adminrole) {
		Object obj = bdao.insert(adminrole);
		if (obj != null)
			return 0;
		else
			return 1;	
	}

	@Override
	public boolean deleteAdminRole(int adminroleid) {
		return bdao.delete(TAdminRole.class, adminroleid);
	}

}
