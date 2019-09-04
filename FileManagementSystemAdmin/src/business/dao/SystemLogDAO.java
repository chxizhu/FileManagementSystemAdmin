package business.dao;

import java.util.List;

import model.TsystemLog;

public interface SystemLogDAO {

	/**
	 * 根据条件获取系统日志列表
	 * 
	 * @param wherecondittion
	 * @return list
	 */
	public List<TsystemLog> getLogList(String log, int currentPage, int pageSize);

	/**
	 * 根据条件获取日志总数
	 * 
	 * @param getSystemLog
	 * @return int
	 */
	public int getSystemLog();
}
