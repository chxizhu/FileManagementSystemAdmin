package controller.server;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;








import model.TAuthority;
import model.TDepartment;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import util.ReturnData;



import business.dao.DepartmentDAO;
import business.dao.RolePermissionManageDAO;
import business.impl.DepartmentDAOImpl;
import business.impl.RolePermissionManageimpl;

import com.alibaba.fastjson.JSON;

@Controller
@RequestMapping(value = "/RolePermission")
public class RolePermissionController {
	
	//加载表格
	@RequestMapping(value = "/authoritylist")
	public void getauthoritylist(
			int limit,// 总页数
			int page,// 每页条目				
			HttpServletRequest request,
			HttpServletResponse response,
			Model model) throws IOException {
		
		RolePermissionManageDAO smdao = new RolePermissionManageimpl();
		List<TAuthority> list = smdao.getAuthority(page,limit);
		
		int size = smdao.getAuthorityAmount();
		
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
	
	@RequestMapping(value = "/RolePermission")
	public void getuserrolemanagerlist(String str, int page, int limit,
			HttpServletRequest request, HttpServletResponse response,
			Model model) throws IOException {
		RolePermissionManageDAO smdao = new RolePermissionManageimpl();
		util.Expression exp = new util.Expression();
		//根据条件获取模糊查询
		if(str!=null && !str.equals("")){
			exp.andLike("authorityname", str, String.class);
		}
		
		List<TAuthority> list = smdao.getrolepermission(exp.toString(), page, limit);
		
		int size = smdao.getrolepermissionAmount(exp.toString());
		
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

	@RequestMapping(value = "/deleterolepernisssion")
	public void deleteuserrolemanage(int authorityid, HttpServletRequest request,
			HttpServletResponse response, Model model) throws IOException {

		RolePermissionManageDAO smdao = new RolePermissionManageimpl();

		 boolean num= smdao.deleterolepermission(authorityid); 

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

	@RequestMapping(value = "/addrolepermission")
	public void addrole(int authorityid, String authorityname, int includeid,
			HttpServletRequest request, HttpServletResponse response,
			Model model) throws IOException {
		RolePermissionManageDAO smdao = new RolePermissionManageimpl();
		
		TAuthority tAuthority = new TAuthority();
		
		tAuthority.setAuthorityid(authorityid);
		tAuthority.setAuthorityname(authorityname);
		tAuthority.setIncludeid(includeid);
		//添加角色信息
		int num =smdao.addrolepermission(tAuthority);
		
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


}
