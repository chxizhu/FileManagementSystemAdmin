package controller.server;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.TAdminRole;
import model.TRole;
import model.TSystemModel;
import model.VRoleSystemModel;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import util.ReturnData;
import business.dao.AdminRoleDAO;
import business.dao.AdminRoleMenuDAO;
import business.impl.AdminRoleDAOImpl;
import business.impl.AdminRoleMenuDAOimpl;

import com.alibaba.fastjson.JSON;

@Controller
@RequestMapping(value = "/AdminRoleMenu")
public class AdminRoleMenuController {
	
	 //加载表格(未使用)
		@RequestMapping(value = "/Menulist")
		public void getdadminrolelist(
				int limit,// 总页数
				int page,// 每页条目				
				HttpServletRequest request,
				HttpServletResponse response,
				Model model) throws IOException {
			
			AdminRoleMenuDAOimpl ardao = new AdminRoleMenuDAOimpl();
			List<TSystemModel> list = ardao.geVRoleSystemModelMenu(page,limit);
			int size = ardao.geVRoleSystemModelMenu();
			
			// 回传json字符串
			response.setCharacterEncoding("utf-8");
			response.setContentType("application/json");
			PrintWriter out = response.getWriter();
			ReturnData td = new ReturnData();
			if (list != null) {
				td.code = ReturnData.SUCCESS;
				td.count = size;
				td.msg = "查询成功";
				td.data = list;
			} else {
				td.code = ReturnData.ERROR;
				td.msg = "查询失败";
			}
			out.write(JSON.toJSONString(td));
			out.flush();
			out.close();
		}
		
		//查询后加载表格
		@RequestMapping(value = "adminrolelistByName")
		public void getdeparmentlistByName(
				String adminRoleName,//输入框查询条件
				String addRoleid,
				int limit,// 总页数
				int page,// 每页条目
				HttpServletRequest request,
				HttpServletResponse response, 
				Model model) throws IOException {		
			
			AdminRoleMenuDAOimpl ardao = new AdminRoleMenuDAOimpl();
			  util.Expression exp = new util.Expression();
			//根据条件获取模糊查询
			  
			  if(adminRoleName!=null && !adminRoleName.equals("")){
				   exp.andLike("name", adminRoleName, String.class);
				  }
			  List<TSystemModel> list = ardao.geVRoleSystemModelMenuByName(exp.toString(), page, limit);
			  int size = ardao.geVRoleSystemModelMenuByNameAmount(exp.toString());
			
			// 传回json字符串
			response.setCharacterEncoding("utf-8");
			response.setContentType("application/json");
			PrintWriter out = response.getWriter();
			ReturnData td = new ReturnData();
			if (list != null) {
				td.code = ReturnData.SUCCESS;
				td.count = size;
				td.msg = "查询成功";
				td.data = list;
			} else {
				td.code = ReturnData.ERROR;
				td.msg = "查询失败";
			}
			out.write(JSON.toJSONString(td));
			out.flush();
			out.close();
		}

}
