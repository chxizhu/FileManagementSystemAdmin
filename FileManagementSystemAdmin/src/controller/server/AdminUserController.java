package controller.server;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.TAdminUser;
import model.TUser;
import model.VAdminUser;
import model.VUser;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import util.ResponseJSON;
import util.ReturnData;
import business.dao.AdminUserDAO;
import business.dao.SystemUserDAO;
import business.impl.AdminUserDAOImpl;
import business.impl.SystemUserDAOImpl;

import com.alibaba.fastjson.JSON;

@Controller
@RequestMapping(value = "/adminuser")
public class AdminUserController {

	//加载表格
			@RequestMapping(value = "/adminuserlist")
			public void getadminuserlist(
					int limit,// 总页数
					int page,// 每页条目				
					HttpServletRequest request,
					HttpServletResponse response,
					Model model) throws IOException {
				
				AdminUserDAO adao = new AdminUserDAOImpl();
				List<VAdminUser> list = adao.getAdminUser(page,limit);
				
				int size = adao.getAdminUserAmount();
				
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
		@RequestMapping(value = "getadminUserByID")
		public void getadminUserByID(
				String userName,//输入框查询条件
				int limit,// 总页数
				int page,// 每页条目
				HttpServletRequest request,
				HttpServletResponse response, 
				Model model) throws IOException {
			
			AdminUserDAO adao = new AdminUserDAOImpl();
			List<VAdminUser> list = adao.getAdminUserByID(userName, page,limit);
			
			int size = adao.getAdminUserByIDAmount(userName);
			
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
		@RequestMapping(value = "/adduser")
		public void addUser(
				String userid, //用户ID
				String mobile, //电话号码
				String pwd, //密码
				int roleId, //用户角色
				int userstatus, //userstatus,默认1
				String realname, //用户名								
				HttpServletRequest request,
				HttpServletResponse response,
				Model model) throws IOException {
			
			AdminUserDAO adao = new AdminUserDAOImpl();			
			TAdminUser user = new TAdminUser();
			
			user.setUserid(userid);
			user.setMobile(mobile);
			user.setPwd(pwd);
			user.setRoleId(roleId);
			user.setRealname(realname);
			user.setUserstatus(userstatus);
			
			//添加角色信息
			int num =adao.addAdminUser(user);
			
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
		@RequestMapping(value = "/deleteadminuser")
		public void deleteadminuser(
				String userid,
				HttpServletRequest request,
				HttpServletResponse response,
				Model model) throws IOException {
	
			AdminUserDAO adao = new AdminUserDAOImpl();			
	
			 boolean num= adao.deleteAdminUser(userid);
	
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
			
			AdminUserDAO adao = new AdminUserDAOImpl();
			List list = adao.getRoleTypes();
			
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
