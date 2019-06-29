package business.impl;

import java.util.List;

import model.TAdminRole;
import model.TAdminUser;
import model.TDepartment;
import model.TUser;
import model.VAdminUser;
import model.VUser;
import business.basic.HibernateDAO;
import business.basic.HibernateDAOimpl;
import business.dao.AdminUserDAO;

public class AdminUserDAOImpl implements AdminUserDAO {

	private HibernateDAO bdao = null;

	public AdminUserDAOImpl() {
		this.bdao = new HibernateDAOimpl();
	}
	
	@Override
	public List<VAdminUser> getAdminUser(int currentPage, int pageSize) {
		String hql = "from VAdminUser";
		List<VAdminUser> list = bdao.selectByPage(hql, currentPage, pageSize);
		return list;
	}

	@Override
	public int getAdminUserAmount() {
		String hql = "select count(*) from VAdminUser ";
		return bdao.selectValue(hql);
	}

	@Override
	public List<VAdminUser> getAdminUserByID(String wherecondition,
			int currentPage, int pageSize) {
		String hql =  "from VAdminUser o where concat(o.userid,o.mobile,o.realname,o.name) like ? ";
		Object[] para = {"%" + wherecondition + "%"};
		return bdao.selectByPage(hql, para, currentPage, pageSize);
	}

	@Override
	public int getAdminUserByIDAmount(String wherecondition) {
		String hql =  "select count(*) from VAdminUser o where concat(o.userid,o.mobile,o.realname,o.name) like ? ";
		Object[] para = {"%" + wherecondition + "%"};
		return bdao.selectValue(hql,para);
	}

	@Override
	public List<TAdminRole> getRoleTypes() {
		String hql = "from TAdminRole";
		List<TAdminRole> list =  bdao.select(hql);
		return list;
	}

	@Override
	public int addAdminUser(TAdminUser user) {
		Object obj = bdao.insert(user);
		if (obj != null)
			return 0;
		else
			return 1;	
	}

	@Override
	public boolean deleteAdminUser(String id) {
		return bdao.delete(TAdminUser.class, id);
	}

}
