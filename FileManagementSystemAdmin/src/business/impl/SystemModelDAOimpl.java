package business.impl;

import java.util.List;
import model.TSystemModel;
import model.VRoleSystemModel;
import business.basic.HibernateDAO;
import business.basic.HibernateDAOimpl;
import business.dao.SystemModelDAO;

/**
 * 
* @Title: SystemModelDAOimpl.java
* @Package business.impl
* @Description: TODO(系统菜单业务操作)
* @author 成锡柱
* @date 2019年6月24日 下午2:22:05
* @version V1.0
 */
public class SystemModelDAOimpl implements SystemModelDAO {

	private HibernateDAO bado = null;

	public SystemModelDAOimpl() {
		this.bado = new HibernateDAOimpl();
	}

	
	@Override
	public List<TSystemModel> getTSystemModelList() {
		// TODO Auto-generated method stub
		String hql="from TSystemModel ORDER BY displayorder,deepth asc";
		List<TSystemModel> List =bado.select(hql);
		return List;
	}


	@Override
	public List<VRoleSystemModel> getSystemModelByRole(int roleid) {
		// TODO Auto-generated method stub
		String hql="from VRoleSystemModel where roleid=? ORDER BY displayorder,deepth asc";
		Object para[]={roleid};
		List<VRoleSystemModel> List =bado.select(hql, para);
		return List;
	}

}
