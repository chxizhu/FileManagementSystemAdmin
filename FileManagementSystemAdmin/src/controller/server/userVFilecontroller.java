package controller.server;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.TDepartment;
import model.TsystemLog;
import model.VAdminUser;
import model.VFile;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import util.ReturnData;
import business.dao.DepartmentDAO;
import business.dao.SystemModelDAO;
import business.dao.UserRoleManageDAO;
import business.dao.userFileDAO;
import business.impl.DepartmentDAOImpl;
import business.impl.SystemLogDAOimpl;
import business.impl.SystemModelDAOimpl;
import business.impl.UserRoleManageDAOimpl;
import business.impl.userFileDAOimpl;

import com.alibaba.fastjson.JSON;

@Controller
@RequestMapping(value = "/systemmodel")
public class userVFilecontroller {
	
	 //加载表格
	@RequestMapping(value = "/userfile")
	public void getuserfile(
			int limit,// 总页数
			int page,// 每页条目				
			HttpServletRequest request,
			HttpServletResponse response,
			Model model) throws IOException {
		
		userFileDAO auda = new userFileDAOimpl();
		List<VFile> List = auda.getVFilesList(page,limit);				
		
		int size = auda.getVFilesListAmount();
		
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
	
	@RequestMapping(value = "/userfileByName")
	public void adduser(int limit,
			int page, 
			String selectid,
			String method,
			String realname, 
			String starttime,
			String endtime,
			HttpServletRequest request, 
			HttpServletResponse response,
			Model model) throws IOException {

		userFileDAO auda = new userFileDAOimpl();
		util.Expression exp = new util.Expression();
		// 根据条件获取模糊查询
		if (selectid != null && !selectid.equals("")) {
			exp.andLike("typename", selectid, String.class);
		}
		if (method != null && !method.equals("")) {
			exp.andLike("filename", method, String.class);
		}
		if (realname != null && !realname.equals("")) {
			exp.andLike("username", realname, String.class);
		}
		if (starttime != null && !starttime.equals("")) {
			exp.andBetween("uptime", starttime, String.class);
		}
		if (endtime != null && !endtime.equals("")) {
			exp.andAnd(endtime, String.class);
		}

		List<VFile> list = auda.getVFilesListByName(exp.toString(), page, limit);
		int num = auda.getVFilesListByNameAmount(exp.toString());
		// 回传json字符串
		response.setCharacterEncoding("utf-8");
		response.setContentType("application/json");
		PrintWriter out = response.getWriter();
		ReturnData rj = new ReturnData();
		rj.code = ReturnData.SUCCESS;
		rj.msg = "执行成功";
		rj.data = list;
		rj.count = num;
		out.write(JSON.toJSONString(rj));
		out.flush();
		out.close();

	}

	@RequestMapping(value = "/deleteFile")
	public void deleteuserrolemanage(int fileid, HttpServletRequest request,
			HttpServletResponse response, Model model) throws IOException {

		userFileDAO auda = new userFileDAOimpl();

		 boolean num= auda.deleteUserFile(fileid); 

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
