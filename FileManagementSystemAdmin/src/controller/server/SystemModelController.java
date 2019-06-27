package controller.server;

import util.Expression;
import util.ReturnData;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.TAdminUser;
import model.VAdminUser;
import model.VRoleSystemModel;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import business.dao.SystemModelDAO;
import business.impl.SystemModelDAOimpl;

import com.alibaba.fastjson.JSON;

/**
 * 系统管理菜单业务控制类
 * 
 * @author Administrator
 *
 */
@Controller
@RequestMapping(value = "/systemmodel")
public class SystemModelController {

	@RequestMapping(value = "/getsystemmodellist")
	public void getGetSystemModelList(Integer roleid,
			HttpServletRequest request, HttpServletResponse response,
			Model model) throws IOException {

		// 使用request获取session，如果session不存在则创建一个
		HttpSession session = request.getSession();
		 
		VAdminUser user=(VAdminUser) session.getAttribute("user");
		
		
		 roleid=user.getRoleId();
		// System.out.println(wherecondition);
		SystemModelDAO smdao = new SystemModelDAOimpl();
		// 查询所有用户菜单
		/* List list = smdao.getTSystemModelList(); */
		// 查询角色菜单
		List list = smdao.getSystemModelByRole(roleid);

		// 回传json字符串
		response.setCharacterEncoding("utf-8");
		response.setContentType("application/json");
		PrintWriter out = response.getWriter();
		ReturnData td = new ReturnData();
		if (list != null) {
			td.code = ReturnData.SUCCESS;
			td.count = list.size();
			td.msg = "查询成功，共查出" + td.count + "条记录";
			td.data = list;
		} else {
			td.code = ReturnData.ERROR;
			td.msg = "查询失败";
		}
		out.write(JSON.toJSONString(td));
	
		// {"code":10001,"msg":"执行成功","result1":"......."}
		out.flush();
		out.close();

	}

	/**
	 * 实现一个管理员用户的添加
	 * 
	 * @param user
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	/*
	 * @RequestMapping(value="/getsystemmodelbyrole") public void
	 * getRoleSystemModelList( int roleid, HttpServletRequest request,
	 * HttpServletResponse response, Model model) throws IOException{
	 * System.out.println(roleid);
	 * 
	 * SystemModelDAO smdao = new SystemModelDAOImpl(); List list =
	 * smdao.getSystemModelByRole(roleid); ResponseJSON rj = new ResponseJSON();
	 * 
	 * //回传json字符串 response.setCharacterEncoding("utf-8");
	 * response.setContentType("application/json"); PrintWriter out =
	 * response.getWriter(); LayuiTableData td = new LayuiTableData();
	 * if(list!=null){ td.code = LayuiTableData.FLAG_SUCC; td.count =
	 * list.size(); td.msg = "查询成功，共查出" + td.count + "条记录"; td.data = list;
	 * }else{ td.code = LayuiTableData.FLAG_FAIL; td.msg = "查询失败"; }
	 * out.write(JSON.toJSONString(td));
	 * //{"code":10001,"msg":"执行成功","result1":"......."} out.flush();
	 * out.close(); }
	 */
}
