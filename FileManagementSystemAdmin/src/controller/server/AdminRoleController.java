package controller.server;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.TAdminRole;
import model.TDepartment;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import util.ReturnData;
import business.dao.AdminRoleDAO;
import business.dao.DepartmentDAO;
import business.impl.AdminRoleDAOImpl;
import business.impl.DepartmentDAOImpl;

import com.alibaba.fastjson.JSON;

@Controller
@RequestMapping(value = "/adminRole")
public class AdminRoleController {

	 //加载表格
	@RequestMapping(value = "/adminrolelist")
	public void getdadminrolelist(
			int limit,// 总页数
			int page,// 每页条目				
			HttpServletRequest request,
			HttpServletResponse response,
			Model model) throws IOException {
		
		AdminRoleDAO ardao = new AdminRoleDAOImpl();
		List<TAdminRole> list = ardao.getAdminRole(page,limit);
		int size = ardao.getAdminRoleAmount();
		
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
	@RequestMapping(value = "adminrolelistByName")
	public void getdeparmentlistByName(
			String adminRoleName,//输入框查询条件
			int limit,// 总页数
			int page,// 每页条目
			HttpServletRequest request,
			HttpServletResponse response, 
			Model model) throws IOException {		
		

		AdminRoleDAO ardao = new AdminRoleDAOImpl();
		List<TAdminRole> list = ardao.getAdminRoleByName(adminRoleName, page,limit);
		int size = ardao.getAdminRoleByNameAmount(adminRoleName);
		
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
	
	//添加管理员角色
	@RequestMapping(value = "/addAdminRole")
	public void addDeparment(
			int id, //角色ID
			String name, //角色名称
			String description, //角色说明	
			int deepth, //deepth
			int parentid, //parentid
			HttpServletRequest request,
			HttpServletResponse response,
			Model model) throws IOException {

		AdminRoleDAO ardao = new AdminRoleDAOImpl();
		
		TAdminRole role = new TAdminRole();
		role.setId(id);
		role.setName(name);
		role.setDescription(description);
		role.setDeepth(deepth);
		role.setParentid(parentid);
				
		
		//添加角色信息
		int num =ardao.addAdminRole(role);
		
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

	//删除管理员角色
	@RequestMapping(value = "/deleteAdminRole")
	public void deletedeparment(
			int id,
			HttpServletRequest request,
			HttpServletResponse response,
			Model model) throws IOException {

		AdminRoleDAO ardao = new AdminRoleDAOImpl();

		 boolean num= ardao.deleteAdminRole(id);

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
