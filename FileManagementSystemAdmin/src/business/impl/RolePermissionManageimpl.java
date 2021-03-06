package business.impl;

import java.util.List;

import model.TAuthority;
import model.TDepartment;
import business.basic.HibernateDAO;
import business.basic.HibernateDAOimpl;
import business.dao.RolePermissionManageDAO;

public class RolePermissionManageimpl implements RolePermissionManageDAO {
	
	private HibernateDAO bado = null;

	public RolePermissionManageimpl() {
		this.bado = new HibernateDAOimpl();
	}
	
	@Override
	public List<TAuthority> getAuthority(int currentPage, int pageSize) {
		String hql = "from TAuthority";
		List<TAuthority> list = bado.selectByPage(hql, currentPage, pageSize);
		return list;
	}

	@Override
	public int getAuthorityAmount() {
		String hql = "select count(*) from TAuthority ";
		return bado.selectValue(hql);
	}

	@Override
	public List<TAuthority> getrolepermission(String str, int currentPage,
			int pageSize) {
		String hql = "from TAuthority";
		if (str != null && !str.equals("")) {
			hql += str+")";
			
		}
		List<TAuthority> list = bado.selectByPage(hql, currentPage, pageSize);

		return list;	
		}
	
	@Override
	public int getrolepermissionAmount(String str) {
		String hql = "select count(*) from TAuthority";
		if (str != null && !str.equals("")) {
			hql += str+")";
			
		}
		return bado.selectValue(hql);	
				
	}

	@Override
	public boolean deleterolepermission(int id) {
		return bado.delete(TAuthority.class, id);
	}

	@Override
	public int addrolepermission(TAuthority TAuthority) {
		Object obj = bado.insert(TAuthority);
		if (obj != null)
			return 0;
		else
			return 1;
	}

}
