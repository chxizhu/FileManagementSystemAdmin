package controller.server;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.TRoleSystemModel;
import model.TUser;
import model.VUser;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import util.ResponseJSON;
import util.ReturnData;
import business.dao.AdminRoleSystemDAO;
import business.dao.SystemUserDAO;
import business.impl.AdminRoleSystemDAOImpl;
import business.impl.SystemUserDAOImpl;

import com.alibaba.fastjson.JSON;

@Controller
@RequestMapping(value = "/adiminrolesystem")
public class AdminRoleSystemController {

	   //加载表格
		@RequestMapping(value = "/adiminrolesystemlist")
		public void getadiminrolesystemlist(
				int limit,// 总页数
				int page,// 每页条目				
				HttpServletRequest request,
				HttpServletResponse response,
				Model model) throws IOException {
			
			AdminRoleSystemDAO ardao = new AdminRoleSystemDAOImpl();
			List list = ardao.getAdminRoleSystem(page,limit);
			
			int size = ardao.getAdminRoleSystemAmount();
			
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
	
		//按条件查询后加载表格
		@RequestMapping(value = "adiminrolesystemlistByName")
		public void getadiminrolesystemlistByName(
				String userName,//输入框查询条件
				int limit,// 总页数
				int page,// 每页条目
				HttpServletRequest request,
				HttpServletResponse response, Model model) throws IOException {
			
			AdminRoleSystemDAO ardao = new AdminRoleSystemDAOImpl();
			List list = ardao.getAdminRoleSystemByName(userName, page, limit);
			
			int size = ardao.getAdminRoleSystemByNameAmount(userName);
			
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
	
		//添加用户
		@RequestMapping(value = "/addrolesystem")
		public void addUser(
				int roleid, //角色ID
				int sysid, //菜单ID
				Boolean isedit, //是否可用			
				HttpServletRequest request,
				HttpServletResponse response,
				Model model) throws IOException {
			
			AdminRoleSystemDAO ardao = new AdminRoleSystemDAOImpl();
			
			TRoleSystemModel rolesystem = new TRoleSystemModel();
			rolesystem.setRoleid(roleid);
			rolesystem.setSysid(sysid);
			rolesystem.setIsedit(isedit);
			
			//添加角色信息
			int num =ardao.addRoleSystemModel(rolesystem);
			
			response.setCharacterEncoding("utf-8");
			response.setContentType("application/json");
			PrintWriter out = response.getWriter();
			ReturnData td = new ReturnData();
			if (num == 0) {
				td.code = ReturnData.SUCCESS;
				td.msg = "添加成功";
			} else {
				td.code = ReturnData.ERROR;
				td.msg = "添加失败";
			}
			out.write(JSON.toJSONString(td));
			out.flush();
			out.close();
		}
	
		//删除用户
		@RequestMapping(value = "/deleterolesystem")
		public void deleteuser(
				int rolesystemid,
				HttpServletRequest request,
				HttpServletResponse response,
				Model model) throws IOException {

			AdminRoleSystemDAO ardao = new AdminRoleSystemDAOImpl();

			 boolean num= ardao.deleteRoleSystemModel(rolesystemid);

			response.setCharacterEncoding("utf-8");
			response.setContentType("application/json");
			PrintWriter out = response.getWriter();
			ReturnData td = new ReturnData();
			if (num == true) {
				td.code = ReturnData.SUCCESS;
				td.msg = "删除成功";

			} else {
				td.code = ReturnData.ERROR;
				td.msg = "删除失败，请重试";
			}
			out.write(JSON.toJSONString(td));
			out.flush();
			out.close();
		}

		
	   //加载管理员角色
		@RequestMapping(value = "/getadminrolelist")
		public void getSystemLogList(
				HttpServletRequest request,
				HttpServletResponse response,
				Model model) throws IOException{
			
			AdminRoleSystemDAO ardao = new AdminRoleSystemDAOImpl();
			List list = ardao.getAdminRoleTypes();
			
			//回传json字符串
			response.setCharacterEncoding("utf-8");
			response.setContentType("application/json");
			PrintWriter out = response.getWriter();
			ResponseJSON rj = new ResponseJSON();
			if(list != null){
				rj.code = ResponseJSON.FLAG_SUCC;
				rj.msg = "查询成功，共查出" + list.size() + "条记录";
				//rj.resultString = JSON.toJSONString(list);
				rj.resultObject = list;
			}else{
				rj.code = ResponseJSON.FLAG_FAIL;
				rj.msg = "查询失败";
			}
			out.write(JSON.toJSONString(rj));
			//{"code":10001,"msg":"执行成功","result1":"......."}
			out.flush();
			out.close();
			
		}
		
			//加载所有菜单
			@RequestMapping(value = "/getadminsystemlist")
			public void getDepartmentList(
					HttpServletRequest request,
					HttpServletResponse response,
					Model model) throws IOException{
				
				AdminRoleSystemDAO ardao = new AdminRoleSystemDAOImpl();
				List list = ardao.getAdminSystemTypes();
				
				//回传json字符串
				response.setCharacterEncoding("utf-8");
				response.setContentType("application/json");
				PrintWriter out = response.getWriter();
				ResponseJSON rj = new ResponseJSON();
				if(list != null){
					rj.code = ResponseJSON.FLAG_SUCC;
					rj.msg = "查询成功，共查出" + list.size() + "条记录";
					//rj.resultString = JSON.toJSONString(list);
					rj.resultObject = list;
				}else{
					rj.code = ResponseJSON.FLAG_FAIL;
					rj.msg = "查询失败";
				}
				out.write(JSON.toJSONString(rj));
				//{"code":10001,"msg":"执行成功","result1":"......."}
				out.flush();
				out.close();
				
			}
	
}
