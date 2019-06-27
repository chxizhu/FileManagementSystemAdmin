package controller.server;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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

		@RequestMapping(value = "/commonuser")
		public void getuserrolemanagerlist(
				int limit,// 总页数
				int page,// 每页条目				
				HttpServletRequest request,
				HttpServletResponse response,
				Model model) throws IOException {

			/*util.Expression exp = new util.Expression();
			//根据条件获取模糊查询
			if(userid!=null && !userid.equals("")){
				exp.andLike("userid", userid, String.class);
			}*/
			
			SystemUserDAO sudao = new SystemUserDAOImpl();
			List<VUser> List = sudao.getCommonUserUser(page,limit);
			
			int size = sudao.getCommonUserUserAmount();
			
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
	
	@RequestMapping(value = "getcommonuserUserByID")
	public void getCommonUserUserByID(
			String userName,
			int limit,// 总页数
			int page,// 每页条目
			HttpServletRequest request,
			HttpServletResponse response, Model model) throws IOException {
		
		SystemUserDAO sudao = new SystemUserDAOImpl();
		List list = sudao.getCommonUserUserByID(userName, page,limit);
		System.out.println("查询条件为：" + userName);
		
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
	
}
