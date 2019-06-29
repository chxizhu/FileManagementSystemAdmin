package business.impl;

import java.util.List;

import model.TAuthority;
import model.TDepartment;
import model.TRole;
import model.VUser;
import business.basic.HibernateDAO;
import business.basic.HibernateDAOimpl;
import business.dao.UserRoleManageDAO;

public class UserRoleManageDAOimpl implements UserRoleManageDAO {
	
	private HibernateDAO bado = null;
	public UserRoleManageDAOimpl() {
		this.bado = new HibernateDAOimpl();
	}
	
	@Override
	public List<TRole> getRole(int currentPage, int pageSize){
		String hql = "from TRole";
		List<TRole> list = bado.selectByPage(hql, currentPage, pageSize);
		return list;
	}
	
	@Override
	public int getRoleAmount() {
		String hql = "select count(*) from TRole ";
		return bado.selectValue(hql);
	}
	
	@Override
	public List<TRole> getRoleByName(String wherecondition, int currentPage,int pageSize) {
		String hql = "from TRole";
		  if (wherecondition != null && !wherecondition.equals("")) {
		   hql += wherecondition;
		  
		  }
		  List<TRole> list = bado.selectByPage(hql, currentPage, pageSize);

		  return list;
	}
	
	@Override
	public int getRoleByNameAmount(String wherecondition) {
		String hql = "select count(*)from TRole";
		  if (wherecondition != null && !wherecondition.equals("")) {
		   hql += wherecondition;
		  
		  }
		  System.out.println(hql);
		  return  bado.selectValue(hql);		   
	}

	@Override
	public boolean deleteUserRole(int id) {
		return bado.delete(TRole.class, id);
		
	}

	@Override
	public int addUserRole(TRole TRole) {
		Object obj = bado.insert(TRole);
		if (obj != null)
			return 0;
		else
			return 1;		
	}
	
	@Override
	public List<TAuthority> getAuthorityTypes() {
		String hql = "from TAuthority";
		List<TAuthority> list =  bado.select(hql);
		return list;
	}


}
