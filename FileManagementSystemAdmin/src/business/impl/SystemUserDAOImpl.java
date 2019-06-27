package business.impl;

import java.util.ArrayList;
import java.util.List;

import model.TAdminRole;
import model.TDepartment;
import model.TRole;
import model.TUser;
import model.VUser;
import common.properties.OperType;
import business.basic.HibernateDAO;
import business.basic.HibernateDAOimpl;
import business.dao.SystemUserDAO;

public class SystemUserDAOImpl implements SystemUserDAO {
	
	private HibernateDAO bdao = null;

	public SystemUserDAOImpl() {
		this.bdao = new HibernateDAOimpl();
	}
	
	@Override
	public List<VUser> getCommonUserUser(int currentPage, int pageSize){
		String hql = "from VUser";
		List<VUser> list = bdao.selectByPage(hql, currentPage, pageSize);
		return list;
	}
	
	@Override
	public int getCommonUserUserAmount() {
		String hql = "select count(*) from VUser ";
		return bdao.selectValue(hql);
	}
	
	@Override
	public List<VUser> getCommonUserUserByID(String wherecondition, int currentPage, int pageSize){
		String hql =  "from VUser o where concat(o.userid,o.username,o.agend,o.phone,o.rolename,o.departmentname) like ? ";
		Object[] para = {"%" + wherecondition + "%"};
		return bdao.selectByPage(hql, para, currentPage, pageSize);
	}
	
	@Override
	public int getCommonUserUserByIDAmount(String wherecondition) {
		String hql = "select count(*) from VUser o where concat(o.userid,o.username,o.agend,o.phone,o.rolename,o.departmentname) like ? ";
		Object[] para = {"%" + wherecondition + "%"};
		return bdao.selectValue(hql,para);
	}
	
	@Override
	public List<TRole> getRoleTypes() {
		String hql = "from TRole";
		List<TRole> list =  bdao.select(hql);
		return list;
	}
	
	@Override
	public List<TDepartment> getDepartmentTypes() {
		String hql = "from TDepartment";
		List<TDepartment> list =  bdao.select(hql);
		return list;
	}
	
	@Override
	public int addUser(TUser user) {
		Object obj = bdao.insert(user);
		if (obj != null)
			return 0;
		else
			return 1;	
	}
	
	@Override
	public boolean deleteUser(String id) {
		return bdao.delete(TUser.class, id);
		
	}

}
