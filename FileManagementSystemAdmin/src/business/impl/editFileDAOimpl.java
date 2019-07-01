package business.impl;

import java.util.List;

import model.TFile;
import model.VFile;
import business.basic.HibernateDAO;
import business.basic.HibernateDAOimpl;
import business.dao.editFileDAO;

/**
 * 
* @Title: editFileDAOimpl.java
* @Package business.impl
* @Description: TODO(在线编辑文档业务类)
* @author 成锡柱
* @date 2019年7月1日 上午10:34:16
* @version V1.0
 */
public class editFileDAOimpl implements editFileDAO {

	private HibernateDAO bado = null;

	public editFileDAOimpl() {
		this.bado = new HibernateDAOimpl();
	}
	@Override
	public List<VFile> getVFilesList(String str, int currentPage, int pageSize) {
		// TODO Auto-generated method stub
		String sql="from VFile ";
		String hql = "from VFile where typeid =7";
		if (str != null && !str.equals("")) {
			hql = sql+str + ")";
			
		}
		List<VFile> list = bado.selectByPage(hql, currentPage, pageSize);

		return list;
	}

	@Override
	public int getVFile() {
		String hql = "SELECT COUNT(*) FROM VFile where typeid =7";
		int num = bado.selectValue(hql);
		return num;
	}

	@Override
	public boolean deleteUserFile(int id) {
		return bado.delete(TFile.class, id);
	}

}
