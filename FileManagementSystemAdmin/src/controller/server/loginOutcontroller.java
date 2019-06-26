package controller.server;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.VAdminUser;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import util.ReturnData;
import business.dao.SystemModelDAO;
import business.impl.SystemModelDAOimpl;

import com.alibaba.fastjson.JSON;

@Controller
@RequestMapping(value = "/sysadminusermanager")
public class loginOutcontroller {
	@RequestMapping(value = "/logoutsystem")
	public void getGetSystemModelList(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		
		HttpSession session = request.getSession();
		VAdminUser user = (VAdminUser) session.getAttribute("user");
		session.removeAttribute("user");
		
		// 回传json字符串
		response.setCharacterEncoding("utf-8");
		response.setContentType("application/json");
		PrintWriter out = response.getWriter();
		ReturnData td = new ReturnData();
		if (user != null) {
			td.code = ReturnData.SUCCESS;
			td.msg = "退出成功";
		} else {
			td.code = ReturnData.ERROR;
			td.msg = "退出失败";
		}
		out.write(JSON.toJSONString(td));
		System.out.println(JSON.toJSONString(td));
		// {"code":10001,"msg":"执行成功","result1":"......."}
		out.flush();
		out.close();

	}
}
