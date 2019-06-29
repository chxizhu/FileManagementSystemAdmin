package business.impl;

import java.util.List;

import model.TDepartment;
import model.TFileType;
import business.basic.HibernateDAO;
import business.basic.HibernateDAOimpl;
import business.dao.FileCategoryDAO;

public class FileCategoryDAOImpl implements FileCategoryDAO {

	private HibernateDAO bdao = null;

	public FileCategoryDAOImpl() {
		this.bdao = new HibernateDAOimpl();
	}
	
	@Override
	public List<TFileType> getFileType(int currentPage, int pageSize) {
		String hql = "from TFileType";
		List<TFileType> list = bdao.selectByPage(hql, currentPage, pageSize);
		return list;
	}

	@Override
	public int getFileTypeAmount() {
		String hql = "select count(*) from TFileType ";
		return bdao.selectValue(hql);
	}

	@Override
	public List<TFileType> getFileTypeByName(String wherecondition,
			int currentPage, int pageSize) {
		String hql = "from TFileType";
		  if (wherecondition != null && !wherecondition.equals("")) {
		   hql += wherecondition+")";
		  
		  }
		  List<TFileType> list = bdao.selectByPage(hql, currentPage, pageSize);

		  return list;
	}

	@Override
	public int getFileTypeByNameAmount(String wherecondition) {
		String hql = "Select count(*) from TFileType";
		  if (wherecondition != null && !wherecondition.equals("")) {
		   hql += wherecondition+")";
		  
		  }
		  return bdao.selectValue(hql);
	}

	@Override
	public int addFileType(TFileType filetype) {
		Object obj = bdao.insert(filetype);
		if (obj != null)
			return 0;
		else
			return 1;	
	}

	@Override
	public boolean deleteFileType(int filetypeid) {
		return bdao.delete(TFileType.class, filetypeid);
	}

}
