package business.impl;

import java.util.List;

import model.TDepartment;
import model.TFile;
import model.TRole;
import model.TsystemLog;
import model.VFile;
import business.basic.HibernateDAO;
import business.basic.HibernateDAOimpl;
import business.dao.userFileDAO;

public class userFileDAOimpl implements userFileDAO {

	private HibernateDAO bado = null;

	public userFileDAOimpl() {
		this.bado = new HibernateDAOimpl();
	}
	
	@Override
	public List<VFile> getVFilesList(int currentPage, int pageSize) {
		String hql = "from VFile";
		List<VFile> list = bado.selectByPage(hql, currentPage, pageSize);
		return list;
	}

	@Override
	public int getVFilesListAmount() {
		String hql = "select count(*) from VFile ";
		return bado.selectValue(hql);
	}
	
	@Override
	public List<VFile> getVFilesListByName(String wherecondition, int currentPage, int pageSize) {
		// TODO Auto-generated method stub
				String hql = "from VFile";
				if (wherecondition != null && !wherecondition.equals("")) {
					hql += wherecondition;
					System.out.println(hql);
				}
				List<VFile> list = bado.selectByPage(hql, currentPage, pageSize);

				return list;
	}

	@Override
	public int getVFilesListByNameAmount(String wherecondition) {		
		String hql = "Select count(*) from VFile";
		  if (wherecondition != null && !wherecondition.equals("")) {
		   hql += wherecondition;
		  
		  }
		  return  bado.selectValue(hql);
		
	}

	@Override
	public boolean deleteUserFile(int id) {
		return bado.delete(TFile.class, id);
	}

}
