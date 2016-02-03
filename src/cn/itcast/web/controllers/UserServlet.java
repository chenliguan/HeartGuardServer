package cn.itcast.web.controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.itcast.domain.User;
import cn.itcast.service.UserService;
import cn.itcast.service.impl.UserServiceImpl;

@SuppressWarnings("serial")
public class UserServlet extends HttpServlet {
	private UserService userService = new UserServiceImpl();
	private String encoding = "UTF-8";
	private String username;
	private String operation;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding(encoding);
		response.setContentType("text/html;charset=" + encoding);
		operation = request.getParameter("operation");
		username = request.getParameter("username");
		if ("userinfo".equals(operation)) {
			QueryUserInfo(request, response);
		} else if ("modifyuser".equals(operation)) {
			ReceiveModifyUser(request, response);
		} else if ("modifypassword".equals(operation)) {
			ReceiveModifyPassword(request, response);
		}
	}

	/**
	 * ��ѯ�û��Ĳ�����Ϣ
	 * 
	 * @param request
	 * @param response
	 */
	private void QueryUserInfo(HttpServletRequest request,
			HttpServletResponse response) {

		List<User> list = userService.UserInfo(username);
		request.setAttribute("json", jsonUserInfo(list)); // �����ص��������ӵ�Attribute�У���ֵ��request
		try {
			// ת������ڿͻ��˷���
			request.getRequestDispatcher("/WEB-INF/page/jsonvideonews.jsp")
					.forward(request, response);
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * ���տͻ��˴��͵ĸ�����Ϣ�޸�����
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	private void ReceiveModifyUser(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		User user = new User();
		user.setUsername(request.getParameter("username"));
		user.setNick(request.getParameter("nick"));
		user.setBirthday(request.getParameter("birthday"));
		user.setGender(request.getParameter("gender"));
		user.setHigh(request.getParameter("high"));
		user.setWeight(request.getParameter("weight"));
		userService.ModifyUser(user); // ����service��
	}

	/**
	 * ���տͻ��˴��͵��޸�����
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	private void ReceiveModifyPassword(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String username, old_password, new_password, ok_new_password;
		username = request.getParameter("username");
		old_password = request.getParameter("old_password");
		new_password = request.getParameter("new_password");
		ok_new_password = request.getParameter("ok_new_password");

		userService.ModifyPassword(username,old_password,new_password,ok_new_password); // ����service��
	}

	/*
	 * json����
	 */
	private Object jsonUserInfo(List<User> list) {
		StringBuilder builder = new StringBuilder();
		builder.append('[');
		for (User user : list) {
			builder.append('{');
			builder.append("username:\"").append(user.getUsername())
					.append("\",");
			builder.append("nick:\"").append(user.getNick()).append("\",");
			builder.append("birthday:\"").append(user.getBirthday())
					.append("\",");
			builder.append("gender:\"").append(user.getGender()).append("\",");
			builder.append("high:\"").append(user.getHigh()).append("\",");
			builder.append("weight:\"").append(user.getWeight()).append("\",");
			builder.append("code:\"").append(user.getCode()).append("\"");
			builder.append("},");
		}
		builder.deleteCharAt(builder.length() - 1);
		builder.append(']');
		System.out.println(builder.toString());
		return builder.toString();
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}