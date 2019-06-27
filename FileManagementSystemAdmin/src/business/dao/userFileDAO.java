package business.dao;

import java.util.List;

import model.TsystemLog;
import model.VFile;

public interface userFileDAO {
	
	/**
	 * 根据条件获取系统日志列表
	 * @param wherecondittion
	 * @return list
	 */
	public List<VFile> getVFilesList(String str, int currentPage,int pageSize);

	/**
	 * 根据条件获取日志总数
	 * 
	 * @param getSystemLog
	 * @return int
	 */
	public int getVFile();
	
	/**
	 * 通过id进行删除
	 * @param int id
	 * @param 
	 * @return 成功返回0 失败返回1 
	 */
	public boolean deleteUserFile(int id);

}
