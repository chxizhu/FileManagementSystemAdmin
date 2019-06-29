package controller.server;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.TDepartment;
import model.TFileType;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import util.ReturnData;
import business.dao.DepartmentDAO;
import business.dao.FileCategoryDAO;
import business.dao.SystemUserDAO;
import business.impl.DepartmentDAOImpl;
import business.impl.FileCategoryDAOImpl;
import business.impl.SystemUserDAOImpl;

import com.alibaba.fastjson.JSON;

@Controller
@RequestMapping(value = "/filetype")
public class FileCategoryController {

	//加载表格
	@RequestMapping(value = "/filetypelist")
	public void getfiletypelist(
			int limit,// 总页数
			int page,// 每页条目				
			HttpServletRequest request,
			HttpServletResponse response,
			Model model) throws IOException {
		
		FileCategoryDAO fcdao = new FileCategoryDAOImpl();
		List<TFileType> list = fcdao.getFileType(page,limit);
		
		int size = fcdao.getFileTypeAmount();
		
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
	@RequestMapping(value = "filetypelistByName")
	public void getfiletypelistByName(
			String filetypeName,//输入框查询条件
			int limit,// 总页数
			int page,// 每页条目
			HttpServletRequest request,
			HttpServletResponse response, 
			Model model) throws IOException {
		
		  util.Expression exp = new util.Expression();
		//根据条件获取模糊查询
		  if(filetypeName!=null && !filetypeName.equals("")){
		   exp.andLike("typename", filetypeName, String.class);
		  }
		
		  FileCategoryDAO fcdao = new FileCategoryDAOImpl();
		  List<TFileType> list = fcdao.getFileTypeByName(exp.toString(),page,limit);
			
		 int size = fcdao.getFileTypeByNameAmount(exp.toString());
		
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
	@RequestMapping(value = "/addFileType")
	public void addFileType(
			int typeid, //文件类型ID
			String typename, //文件类型名称	
			HttpServletRequest request,
			HttpServletResponse response,
			Model model) throws IOException {

		 	FileCategoryDAO fcdao = new FileCategoryDAOImpl();
		
			TFileType filetype = new TFileType();
			filetype.setTypeid(typeid);
			filetype.setTypename(typename);
			
		
			//添加角色信息
			int num = fcdao.addFileType(filetype);
			
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
	@RequestMapping(value = "/deleteFileType")
	public void deleteFileType(
			int filetypeid,//文件类型ID
			HttpServletRequest request,
			HttpServletResponse response,
			Model model) throws IOException {

			FileCategoryDAO fcdao = new FileCategoryDAOImpl();
	
			 boolean num= fcdao.deleteFileType(filetypeid);
					 
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
