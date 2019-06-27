package controller.server;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.TDepartment;
import model.TUser;
import model.VUser;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import util.ReturnData;
import business.dao.DepartmentDAO;
import business.dao.SystemUserDAO;
import business.impl.DepartmentDAOImpl;
import business.impl.SystemUserDAOImpl;

import com.alibaba.fastjson.JSON;

@Controller
@RequestMapping(value = "/deparment")
public class DepartmentController {
	
	        //加载表格
			@RequestMapping(value = "/deparmentlist")
			public void getdeparmentlist(
					int limit,// 总页数
					int page,// 每页条目				
					HttpServletRequest request,
					HttpServletResponse response,
					Model model) throws IOException {
				
				DepartmentDAO ddao = new DepartmentDAOImpl();
				List<TDepartment> List = ddao.getDepartment(page,limit);
				
				int size = ddao.getDepartmentAmount();
				
				// 回传json字符串
				response.setCharacterEncoding("utf-8");
				response.setContentType("application/json");
				PrintWriter out = response.getWriter();
				ReturnData td = new ReturnData();
				if (List != null) {
					td.code = ReturnData.SUCCESS;
					td.count = size;
					td.msg = "查询成功";
					td.data = List;
				} else {
					td.code = ReturnData.ERROR;
					td.msg = "查询失败";
				}
				out.write(JSON.toJSONString(td));
				out.flush();
				out.close();
			}
			
			//按条件查询后加载表格
			@RequestMapping(value = "deparmentlistByName")
			public void getdeparmentlistByName(
					String departmentName,//输入框查询条件
					int limit,// 总页数
					int page,// 每页条目
					HttpServletRequest request,
					HttpServletResponse response, 
					Model model) throws IOException {
				
				DepartmentDAO ddao = new DepartmentDAOImpl();
				
				  util.Expression exp = new util.Expression();
				//根据条件获取模糊查询
				  if(departmentName!=null && !departmentName.equals("")){
				   exp.andLike("departmentname", departmentName, String.class);
				  }
				
				List<TDepartment> List = ddao.getDepartmentByName(exp.toString(),page,limit);
				
				int size = ddao.getDepartmentByNameAmount(exp.toString());
				
				// 传回json字符串
				response.setCharacterEncoding("utf-8");
				response.setContentType("application/json");
				PrintWriter out = response.getWriter();
				ReturnData td = new ReturnData();
				if (List != null) {
					td.code = ReturnData.SUCCESS;
					td.count = size;
					td.msg = "查询成功";
					td.data = List;
				} else {
					td.code = ReturnData.ERROR;
					td.msg = "查询失败";
				}
				out.write(JSON.toJSONString(td));
				out.flush();
				out.close();

			}
			
			//添加用户
			@RequestMapping(value = "/addDeparment")
			public void addDeparment(
					int departmentid, //部门ID
					String departmentname, //部门名称
					int updepartmentid, //所属父级部门ID			
					HttpServletRequest request,
					HttpServletResponse response,
					Model model) throws IOException {

				DepartmentDAO ddao = new DepartmentDAOImpl();
				
				TDepartment deparment = new TDepartment();
				
				deparment.setDepartmentid(departmentid);
				deparment.setDepartmentname(departmentname);
				deparment.setUpdepartmentid(updepartmentid);
				
				//添加角色信息
				int num =ddao.addDepartment(deparment);
				
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
			@RequestMapping(value = "/deletedeparment")
			public void deletedeparment(
					int departmentid,
					HttpServletRequest request,
					HttpServletResponse response,
					Model model) throws IOException {

				SystemUserDAO sudao = new SystemUserDAOImpl();
				DepartmentDAO ddao = new DepartmentDAOImpl();

				 boolean num= ddao.deleteDepartment(departmentid);

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
