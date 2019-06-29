package controller.server;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.TRole;
import model.VUser;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import util.ResponseJSON;
import util.ReturnData;
import business.dao.SystemUserDAO;
import business.dao.UserRoleManageDAO;
import business.impl.SystemUserDAOImpl;
import business.impl.UserRoleManageDAOimpl;

import com.alibaba.fastjson.JSON;

@Controller
@RequestMapping(value = "/systemmodel")
public class UserRoleManageController {

	//加载表格
			@RequestMapping(value = "/rolelist")
			public void getrolelist(
					int limit,// 总页数
					int page,// 每页条目				
					HttpServletRequest request,
					HttpServletResponse response,
					Model model) throws IOException {
				
				 UserRoleManageDAO smdao = new UserRoleManageDAOimpl();
				 List<TRole> list = smdao.getRole(page,limit);
				
				int size = smdao.getRoleAmount();
				
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
	
	@RequestMapping(value = "/roleListByName")
	public void getroleListByName(
			String userName,//输入框查询条件
			int page, 
			int limit,
			HttpServletRequest request, HttpServletResponse response,
			Model model) throws IOException {
		
		  UserRoleManageDAO smdao = new UserRoleManageDAOimpl();
		  util.Expression exp = new util.Expression();
		  
		  //根据条件获取模糊查询
		  if(userName!=null && !userName.equals("")){
		   exp.andLike("rolename", userName, String.class);
		  }
		  List<TRole> list = smdao.getRoleByName(exp.toString(), page, limit);
		  int size = smdao.getRoleByNameAmount(exp.toString());
		  
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

	@RequestMapping(value = "/deleterole")
	public void deleteuserrolemanage(int roleid, HttpServletRequest request,
			HttpServletResponse response, Model model) throws IOException {

		UserRoleManageDAO smdao = new UserRoleManageDAOimpl();

		 boolean num= smdao.deleteUserRole(roleid); 

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

	@RequestMapping(value = "/addrole")
	public void addrole(int roleid, String rolename, int authorityId,
			HttpServletRequest request, HttpServletResponse response,
			Model model) throws IOException {
		UserRoleManageDAO smdao = new UserRoleManageDAOimpl();
		
		TRole TRole = new TRole();
		
		TRole.setRoleid(roleid);
		TRole.setRolename(rolename);
		TRole.setAuthorityId(authorityId);
		//添加角色信息
		int num =smdao.addUserRole(TRole);
		
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
	
	//加载用户角色
		@RequestMapping(value = "/getAuthoritylist")
		public void getSystemLogList(
				HttpServletRequest request,
				HttpServletResponse response,
				Model model) throws IOException{
			
			UserRoleManageDAO smdao = new UserRoleManageDAOimpl();
			List list = smdao.getAuthorityTypes();
			
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
