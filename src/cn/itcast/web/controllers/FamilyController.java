package cn.itcast.web.controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.itcast.domain.Family;
import cn.itcast.exception.UsernameExistException;
import cn.itcast.service.FamilyService;
import cn.itcast.service.impl.FamilyServiceImpl;

@SuppressWarnings("serial")
public class FamilyController extends HttpServlet {
	private FamilyService familyService = new FamilyServiceImpl();
	private String encoding = "UTF-8";
	private String username;
	private String nick;
	private String operation;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding(encoding);
		response.setContentType("text/html;charset=" + encoding);
		operation = request.getParameter("operation");
		username = request.getParameter("username");
		nick = request.getParameter("nick");
		
		if ("addfamily".equals(operation)) {
			AddFamily(request, response);
		} else if ("modifyfamily".equals(operation)) {
			ReceiveModifyFamily(request, response);
		} else if ("queryfamily".equals(operation)) {
			QueryFamilyInfo(request, response);
		} else if ("queryonefamily".equals(operation)) {
			QueryOneFamilyInfo(request, response);
		} else if ("deletefamily".equals(operation)) {
			DeleteFamily(request, response);
		}
	}

	/**
	 * 添加家人
	 * 
	 * @param request
	 * @param response
	 */
	private void AddFamily(HttpServletRequest request,
			HttpServletResponse response) {
		
		System.out.println("nick:" + nick);
		
		String result = null;
		Family family = new Family();
		family.setUsername(username);
		family.setNick(nick);
		family.setBirthday(request.getParameter("birthday"));
		family.setGender(request.getParameter("gender"));
		family.setHigh(request.getParameter("high"));
		family.setWeight(request.getParameter("weight"));
		family.setFamilygroup(request.getParameter("familygroup"));
		try {
			familyService.addFamily(family);
			result = "添加家人成功";
			System.out.println(result);
		} catch (UsernameExistException e) {
			result = "用户名已被占用，请换一个";
			System.out.println(result);
			e.printStackTrace();
		}
		request.setAttribute("json", jsonOne(result));
		try {
			request.getRequestDispatcher("/WEB-INF/page/jsonvideonews.jsp")
					.forward(request, response);
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 查询家人的部分信息
	 * 
	 * @param request
	 * @param response
	 */
	private void QueryFamilyInfo(HttpServletRequest request,
			HttpServletResponse response) {

		List<Family> list = familyService.FamilyInfo(username);
		request.setAttribute("json", jsonFamilyInfo(list)); // 将返回的数据添加到Attribute中，传值到request
		try {
			// 转向才能在客户端访问
			request.getRequestDispatcher("/WEB-INF/page/jsonvideonews.jsp")
					.forward(request, response);
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 查询某个家人的部分信息
	 * 
	 * @param request
	 * @param response
	 */
	private void QueryOneFamilyInfo(HttpServletRequest request,
			HttpServletResponse response) {
		System.out.println("nick:" + nick);
		List<Family> list = familyService.FamilyOneInfo(username,nick);
		request.setAttribute("json", jsonFamilyInfo(list)); // 将返回的数据添加到Attribute中，传值到request
		try {
			// 转向才能在客户端访问
			request.getRequestDispatcher("/WEB-INF/page/jsonvideonews.jsp")
					.forward(request, response);
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 接收客户端传送的个人信息修改数据
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	private void ReceiveModifyFamily(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		Family family = new Family();
		family.setUsername(username);
		family.setNick(nick);
		family.setBirthday(request.getParameter("birthday"));
		family.setGender(request.getParameter("gender"));
		family.setHigh(request.getParameter("high"));
		family.setWeight(request.getParameter("weight"));
		String nicked = request.getParameter("nicked");
		familyService.ModifyFamily(family, nicked); // 调用service层
	}
	
	/**
	 * 删除家人信息
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	private void DeleteFamily(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		Family family = new Family();
		family.setUsername(username);
		family.setNick(nick);
		familyService.DeleteFamily(family); // 调用service层
	}

	/**
	 * 封装Familyjson数据
	 * @param list
	 * @return
	 */
	private Object jsonFamilyInfo(List<Family> list) {
		StringBuilder builder = new StringBuilder();
		builder.append('[');
		for (Family family : list) {
			builder.append('{');
			builder.append("username:\"").append(family.getUsername())
					.append("\",");
			builder.append("nick:\"").append(family.getNick()).append("\",");
			builder.append("birthday:\"").append(family.getBirthday())
					.append("\",");
			builder.append("gender:\"").append(family.getGender())
					.append("\",");
			builder.append("high:\"").append(family.getHigh()).append("\",");
			builder.append("weight:\"").append(family.getWeight())
					.append("\",");
			builder.append("familygroup:\"").append(family.getFamilygroup())
					.append("\"");
			builder.append("},");
		}
		builder.deleteCharAt(builder.length() - 1);
		builder.append(']');
		System.out.println(builder.toString());
		return builder.toString();
	}
	/**
	 * 封装返回结果json数据
	 */
	public String jsonOne(String result) {
		// [{id:56,title:"xxxxx",timelength:90},{id:16,title:"xbbx",timelength:20}]
		StringBuilder builder = new StringBuilder();
		builder.append('[');
		builder.append('{');
		builder.append("id:").append(100).append(',');
		builder.append("title:\"").append(result).append("\",");
		builder.append("timelength:").append(10);
		builder.append("},");
		builder.deleteCharAt(builder.length() - 1);
		builder.append(']');
		return builder.toString();
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}
}
