package business.impl;

import java.util.List;

import model.TAdminUser;
import model.VAdminUser;
import business.basic.HibernateDAO;
import business.basic.HibernateDAOimpl;
import business.dao.AdminLoginDAO;

public class AdminLoginDAOimpl implements AdminLoginDAO {

	private HibernateDAO bado = null;

	public AdminLoginDAOimpl() {
		this.bado = new HibernateDAOimpl();
	}

	/**
	 * 用户登录业务方法 
	 * Parameters: 
	 * userid 用户登录名 
	 * password 登录密码
	 *  Returns:TAdminUser当前登录的用户对象
	 */

	@Override
	public VAdminUser AdminLogin(String userid, String password) {
		String hql = " from VAdminUser where userid = ? and pwd = ?";
		Object[] para = { userid, password };
		List list = bado.select(hql, para);
		if (list.size() > 0) {
			return (VAdminUser) list.get(0);
		}

		else {
			return null;
		}
	}
}

