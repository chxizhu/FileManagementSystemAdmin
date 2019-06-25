package controller.server;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.el.Expression;

import model.TsystemLog;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.alibaba.fastjson.JSON;

import util.ReturnData;
import business.impl.SystemLogDAOimpl;

/**
 * 系统日志操作业务控制类
 * @author xizhu
 *
 */
@Controller
public class SystemLogcontroller {
	
	@RequestMapping(value = "/log")
	public void  adduser(
			@RequestParam("limit") int limit,
			@RequestParam("page") int page,
			String  selectid,
			String  method,
			String  realname,
			String  starttime,
			String  endtime,
			HttpServletRequest request, 
			HttpServletResponse response,
			Model model) throws IOException {
		
		SystemLogDAOimpl auda =new SystemLogDAOimpl();
		util.Expression exp = new util.Expression();
		//根据条件获取模糊查询
		if(selectid!=null && !selectid.equals("")){
			exp.andLike("opertype", selectid, String.class);
		}
		if(method!=null && !method.equals("")){
			exp.andLike("opertype", method, String.class);
		}
		if(realname!=null && !realname.equals("")){
			exp.andLike("createby", realname, String.class);
		}
		if(starttime!=null && !starttime.equals("")){
			exp.andBetween("createdate", starttime, String.class);
		}
		if(endtime!=null && !endtime.equals("")){
			exp.andAnd(endtime, String.class);
		}
		
		List<TsystemLog> list =auda.getLogList(exp.toString(), page, limit);
		int num =auda.getSystemLog();
		//回传json字符串
		response.setCharacterEncoding("utf-8");
		response.setContentType("application/json");
		PrintWriter out =response.getWriter();
		ReturnData rj = new ReturnData();
		rj.code=ReturnData.SUCCESS;
		rj.msg="执行成功"  ;
		rj.data=list;
		rj.count=num;
		out.write(JSON.toJSONString(rj));
		out.flush();
		out.close();
		
	}
	
	
}
