package business.impl;

import java.util.List;

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
	public List<VFile> getVFilesList(String str, int currentPage, int pageSize) {
		// TODO Auto-generated method stub
				String hql = "from VFile";
				if (str != null && !str.equals("")) {
					hql += str+")";
					System.out.println(hql);
				}
				List<VFile> list = bado.selectByPage(hql, currentPage, pageSize);

				return list;
	}

	@Override
	public int getVFile() {
		String hql = "SELECT COUNT(*) FROM VFile";
		int num = bado.selectValue(hql);
		return num;
	}

	@Override
	public boolean deleteUserFile(int id) {
		return bado.delete(TFile.class, id);
	}

}
