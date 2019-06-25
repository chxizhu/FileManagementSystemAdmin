package controller.server;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.TAdminUser;
import model.VAdminUser;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import util.ReturnData;
import business.dao.AdminLoginDAO;
import business.impl.AdminLoginDAOimpl;

import com.alibaba.fastjson.JSON;

@Controller
@RequestMapping(value = "/Admin")
public class AdminLogincontroller {

	/**
	 * 系统登录操作业务控制类
	 * @author xizhu
	 *
	 */
	@RequestMapping(value = "/AdminLogin")
	public void getGetSystemModelList1(String userid, String pwd,
			HttpServletRequest request, HttpServletResponse response,
			Model model) throws IOException {

		AdminLoginDAO smdao = new AdminLoginDAOimpl();
		VAdminUser user=   smdao.AdminLogin(userid, pwd);
		
		
		// 回传json字符串
		response.setCharacterEncoding("utf-8");
		response.setContentType("application/json");
		PrintWriter out = response.getWriter();
		ReturnData td = new ReturnData();
		if (user!= null) {
			// 使用request对象的getSession()获取session，如果session不存在则创建一个
			HttpSession session = request.getSession();
			// 将数据存储到session中
			session.setAttribute("user",user);
			td.code = ReturnData.SUCCESS;
			td.msg = "查询成功";
			td.data = null;
		} else {
			td.code = ReturnData.ERROR;
			td.msg = "查询失败";
		}
		out.write(JSON.toJSONString(td));
		// {"code":10001,"msg":"执行成功","result1":"......."}
		out.flush();
		out.close();

	}
}
