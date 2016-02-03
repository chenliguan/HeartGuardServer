package cn.itcast.web.controller;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.locale.converters.DateLocaleConverter;

import cn.itcast.domain.User;
import cn.itcast.exception.UsernameExistException;
import cn.itcast.service.UserService;
import cn.itcast.service.impl.UserServiceImpl;
import cn.itcast.util.WebFormBeanUtils;
import cn.itcast.web.formbean.LoginFormBean;
import cn.itcast.web.formbean.RegistFormBean;

@SuppressWarnings("serial")
public class WebController extends HttpServlet {
	private UserService s = new UserServiceImpl();
	private String encoding = "UTF-8";
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding(encoding);
		response.setContentType("text/html;charset="+encoding);
		String operation = request.getParameter("operation");
		if("regist".equals(operation)){
			regist(request,response);
		}else if("login".equals(operation)){
			login(request,response);
		}else if("logout".equals(operation)){
			logout(request,response);
		}
	}
	private void logout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String result = "";
		request.getSession().removeAttribute("user");
		request.setAttribute("message", "注销成功！2秒后自动转向主页。<meta http-equiv='Refresh' content='2;URL="+request.getContextPath()+"'>'");
		result = "/message.jsp";
		request.getRequestDispatcher(result).forward(request, response);
	}
	//用户登录
	private void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//封装数据到formBean中，验证
		String result = "";
		LoginFormBean formBean = WebFormBeanUtils.fillFormBean(request, LoginFormBean.class);
		if(!formBean.validate()){
			request.setAttribute("formBean", formBean);
			result = "/login.jsp";
		}else{
			User user = s.login(formBean.getUsername(), formBean.getPassword());
			if(user==null){
				// 错误的用户名或密码
				formBean.getErrors().put("message", "错误的用户名或密码");
				request.setAttribute("formBean", formBean);
				result = "/login.jsp";
			}else{
				//登录成功
				request.getSession().setAttribute("user", user);
				response.setHeader("Refresh", "2;URL="+request.getContextPath());
				request.setAttribute("message", "登录成功！2秒后自动转向主页。");
				result = "/message.jsp";
			}
		}
		request.getRequestDispatcher(result).forward(request, response);
	}
	//用户注册
	private void regist(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String result = "";//结果页面的URL地址
		RegistFormBean formBean = null;
		try {
			//获取用户输入的数据
			formBean = WebFormBeanUtils.fillFormBean(request,RegistFormBean.class);
			//封装；验证：RegistFormBean（与表单的输入域完全对应；完成验证功能）
			if(!formBean.validate()){
				//验证不通过：数据回显；还要提示具体的错误信息
				request.setAttribute("formBean", formBean);
				result = "/regist.jsp";
			}else{
				User user = new User();
				//把FormBean中的数据转移到User中：填充模型
				ConvertUtils.register(new DateLocaleConverter(), Date.class);
				BeanUtils.copyProperties(user, formBean);// 遍历formBean中的所有的属性。找User中的同名称的属性。user.setUsername(formBean.getUsername())
				s.regist(user);
				request.setAttribute("message", "保存成功<a href='"+request.getContextPath()+"'>主页<a/>");
				result = "/message.jsp";
			}
		}catch(UsernameExistException e){
			//用户名重复
			formBean.getErrors().put("username", "用户名已被占用，请换一个");
			request.setAttribute("formBean",formBean);
			result = "/regist.jsp";
		}catch (Exception e) {
			request.setAttribute("message", "对不起！服务器忙");
			result = "/message.jsp";
		}
		request.getRequestDispatcher(result).forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
