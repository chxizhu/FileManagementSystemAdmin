package business.impl;

import java.util.List;

import model.TRole;
import business.basic.HibernateDAO;
import business.basic.HibernateDAOimpl;
import business.dao.UserRoleManageDAO;

public class UserRoleManageDAOimpl implements UserRoleManageDAO {
	
	private HibernateDAO bado = null;
	public UserRoleManageDAOimpl() {
		this.bado = new HibernateDAOimpl();
	}
	@Override
	public List<TRole> getUserRole(String wherecondition, int currentPage,int pageSize) {
		String hql = "from TRole";
		  if (wherecondition != null && !wherecondition.equals("")) {
		   hql += wherecondition+")";
		  
		  }
		  List<TRole> list = bado.selectByPage(hql, currentPage, pageSize);

		  return list;
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

}
