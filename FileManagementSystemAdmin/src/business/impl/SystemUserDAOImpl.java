package business.impl;

import java.util.ArrayList;
import java.util.List;

import model.TRole;
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
	public List<String> getRoleTypes() {
		List<String> list = new ArrayList<String>();
		for(int i=0;i<OperType.OPERTYPES.length;i++){
			list.add(OperType.OPERTYPES[i]);
		}
		return list;
	}

}
