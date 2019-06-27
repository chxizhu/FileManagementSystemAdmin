package business.impl;

import java.util.List;

import model.TDepartment;
import model.TUser;
import business.basic.HibernateDAO;
import business.basic.HibernateDAOimpl;
import business.dao.DepartmentDAO;

public class DepartmentDAOImpl implements DepartmentDAO {

	private HibernateDAO bdao = null;

	public DepartmentDAOImpl() {
		this.bdao = new HibernateDAOimpl();
	}
	
	@Override
	public List<TDepartment> getDepartment(int currentPage, int pageSize) {
		String hql = "from TDepartment";
		List<TDepartment> list = bdao.selectByPage(hql, currentPage, pageSize);
		return list;
	}

	@Override
	public int getDepartmentAmount() {
		String hql = "select count(*) from TDepartment ";
		return bdao.selectValue(hql);
	}

	@Override
	public List<TDepartment> getDepartmentByName(String wherecondition,
			int currentPage, int pageSize) {
		String hql = "from TDepartment";
		  if (wherecondition != null && !wherecondition.equals("")) {
		   hql += wherecondition+")";
		  
		  }
		  List<TDepartment> list = bdao.selectByPage(hql, currentPage, pageSize);

		  return list;
	}

	@Override
	public int getDepartmentByNameAmount(String wherecondition) {
		String hql = "from TDepartment";
		  if (wherecondition != null && !wherecondition.equals("")) {
		   hql += wherecondition+")";
		  
		  }
		  return bdao.selectValue(hql);
	}
	
	@Override
	public int addDepartment(TDepartment department) {
		Object obj = bdao.insert(department);
		if (obj != null)
			return 0;
		else
			return 1;	
	}
	
	@Override
	public boolean deleteDepartment(int departmentid) {
		return bdao.delete(TDepartment.class, departmentid);
		
	}

}
