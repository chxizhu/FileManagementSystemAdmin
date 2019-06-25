package business.impl;

import java.util.List;

import model.TsystemLog;
import business.basic.HibernateDAO;
import business.basic.HibernateDAOimpl;
import business.dao.SystemLogDAO;
/**
 * 获取相关的系统日志
 * @param 
 * @return 
 */
public class SystemLogDAOimpl implements SystemLogDAO {

	private HibernateDAO bado = null;

	public SystemLogDAOimpl() {
		this.bado = new HibernateDAOimpl();
	}

	@Override
	public List<TsystemLog> getLogList(String log, int currentPage, int pageSize) {
		// TODO Auto-generated method stub
		String hql = "from TsystemLog";
		if (log != null && !log.equals("")) {
			hql += log+")";
			System.out.println(hql);
		}
		List<TsystemLog> list = bado.selectByPage(hql, currentPage, pageSize);

		return list;
	}

	@Override
	public int getSystemLog() {
		// TODO Auto-generated method stub
		String hql = "SELECT COUNT(*) FROM TsystemLog";
		int num = bado.selectValue(hql);
		return num;
	}

}
