package business.dao;

import java.util.List;
import model.VAdminUser;


public interface AdminLoginDAO {
	
	/**
	 * 用户登录业务方法
	 * @param userid   用户登录名
	 * @param password   登录密码
	 * @return  TAdminUser  当前登录的用户对象
	 */
	public VAdminUser AdminLogin(String userid,String password);

}
