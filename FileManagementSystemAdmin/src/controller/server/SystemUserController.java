package controller.server;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.TAdminRole;
import model.TUser;
import model.VUser;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import util.ResponseJSON;
import util.ReturnData;
import business.dao.SystemLogDAO;
import business.dao.SystemUserDAO;
import business.dao.UserRoleManageDAO;
import business.impl.SystemUserDAOImpl;
import business.impl.UserRoleManageDAOimpl;

import com.alibaba.fastjson.JSON;

@Controller
@RequestMapping(value = "/systemuser")
public class SystemUserController {
	
		//加载表格
		@RequestMapping(value = "/commonuser")
		public void getuserrolemanagerlist(
				int limit,// 总页数
				int page,// 每页条目				
				HttpServletRequest request,
				HttpServletResponse response,
				Model model) throws IOException {
			
			SystemUserDAO sudao = new SystemUserDAOImpl();
			List<VUser> list = sudao.getCommonUserUser(page,limit);
			
			int size = sudao.getCommonUserUserAmount();
			
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
	@RequestMapping(value = "getcommonuserUserByID")
	public void getCommonUserUserByID(
			String userName,//输入框查询条件
			int limit,// 总页数
			int page,// 每页条目
			HttpServletRequest request,
			HttpServletResponse response, Model model) throws IOException {
		
		SystemUserDAO sudao = new SystemUserDAOImpl();
		List list = sudao.getCommonUserUserByID(userName, page,limit);
		
		int size = sudao.getCommonUserUserByIDAmount(userName);
		
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
	
	//加载用户角色
	@RequestMapping(value = "/getadminrolelist")
	public void getSystemLogList(
			HttpServletRequest request,
			HttpServletResponse response,
			Model model) throws IOException{
		
		SystemUserDAO sudao = new SystemUserDAOImpl();
		List list = sudao.getRoleTypes();
		
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
	
		//加载所有部门
		@RequestMapping(value = "/getDepartmentlist")
		public void getDepartmentList(
				HttpServletRequest request,
				HttpServletResponse response,
				Model model) throws IOException{
			
			SystemUserDAO sudao = new SystemUserDAOImpl();
			List list = sudao.getDepartmentTypes();
			
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
		
		//添加用户
		@RequestMapping(value = "/adduser")
		public void addUser(
				String userid, //用户ID
				String username, //用户名
				String pwd, //密码
				String agend, //性别
				String phone, //电话号码
				int role_name, //用户角色
				int department_id,//用户所属部门
				HttpServletRequest request,
				HttpServletResponse response,
				Model model) throws IOException {
			SystemUserDAO sudao = new SystemUserDAOImpl();
			
			TUser user = new TUser();
			
			user.setUserid(userid);
			user.setUsername(username);
			user.setPwd(pwd);
			user.setAgend(agend);
			user.setPhone(phone);
			user.setRoleName(role_name);
			user.setDepartmentId(department_id);
			//添加角色信息
			int num =sudao.addUser(user);
			
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
		@RequestMapping(value = "/deleteuser")
		public void deleteuser(
				String userid,
				HttpServletRequest request,
				HttpServletResponse response,
				Model model) throws IOException {

			SystemUserDAO sudao = new SystemUserDAOImpl();

			 boolean num= sudao.deleteUser(userid);

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

		
}
