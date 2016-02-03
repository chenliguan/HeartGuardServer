package cn.itcast.web.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.httpclient.Header;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.PostMethod;

import cn.itcast.service.SmsService;
import cn.itcast.service.impl.SmsServiceImpl;
import cn.itcast.util.Random;

@SuppressWarnings("serial")
public class SmsServlet extends HttpServlet {
	private String encoding = "UTF-8";
	private SmsService daoService = new SmsServiceImpl();

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding(encoding);
		response.setContentType("text/html;charset=" + encoding);
		String operation = request.getParameter("operation");
		System.out.println("operation1:" + operation);
		
		if ("sendcode".equals(operation)) {
			SendCode(request, response);
		} else if ("sendpassword".equals(operation)) {
			SendPassword(request, response);
		} else if ("sendnotice".equals(operation)) {
			System.out.println("operation2:" + operation);
			SendNotice(request, response);
		} else if ("sendHKcode".equals(operation)) {
			SendHKCode(request, response);
		} 
	}

	/**
	 * 发送验证码
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	private void SendHKCode(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String smsMob = request.getParameter("username");
		int code = Random.RandomTest(1000000);
		String smsText = "[浣客洗衣]您的登录验证码：" + code;
		daoService.SendCode(smsMob, code); // 调用dao添加到数据库
		SendSms(smsMob, smsText); // 发送短信
	}

	/**
	 * 发送浣客洗衣验证码
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	private void SendCode(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String smsMob = request.getParameter("username");
		int code = Random.RandomTest(1000000);
		String smsText = "感谢您使用心卫士，您的注册验证码是：" + code + "，请无泄漏给他人！";
		daoService.SendCode(smsMob, code); // 调用dao添加到数据库
		SendSms(smsMob, smsText); // 发送短信
	}


	/**
	 * 发送密码
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	private void SendPassword(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String smsMob = request.getParameter("username");
		String password = daoService.SendPassword(smsMob); // 从数据库获取密码
		String smsText = "感谢您使用心卫士，您的密码是：" + password + "，请妥善保管！";
		String result = "获取密码失败，请重新获取";
		request.setAttribute("json", jsonOne(result)); // 将返回的数据添加到Attribute中，传值到request
		if (password != null) {
			// 发送短信
			if (SendSms(smsMob, smsText).equals(1)) {
				request.getRequestDispatcher("/WEB-INF/page/jsonvideonews.jsp")
						.forward(request, response); // 转向才能在客户端访问
			}
		} else {
			request.getRequestDispatcher("/WEB-INF/page/jsonvideonews.jsp")
					.forward(request, response); // 转向才能在客户端访问
		}
	}

	/**
	 * 发送测量结果通知
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	private void SendNotice(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String smsMob = request.getParameter("username");
		String nick = request.getParameter("nick");
//		String time = request.getParameter("time");
		String rate_grade = request.getParameter("rate_grade");
		String symptoms_rhythm = request.getParameter("symptoms_rhythm");
		String symptoms_heart = request.getParameter("symptoms_heart");
		String smsText = "温馨提示：" + nick + "正在进行一次心电测量！结果异常，平均心率："
				+ rate_grade + "；心率病症：" + symptoms_rhythm + "；心房病症："
				+ symptoms_heart + "！";
		
		System.out.println("smsText:" +smsMob + ":" + smsText);
		
		SendSms(smsMob, smsText); // 发送短信
	}

	/**
	 * 短信服务方法
	 * 
	 * @param smsMob
	 * @param smsText
	 */
	public String SendSms(String smsMob, String smsText) {

		try {
			HttpClient client = new HttpClient();
			PostMethod post = new PostMethod("http://gbk.sms.webchinese.cn");
			post.addRequestHeader("Content-Type",
					"application/x-www-form-urlencoded;charset=gbk");
			// uid：在中国网建网站上注册的用户id
			// key:中国网建为注册用户提供的短信秘要
			// username：发送短信的手机号
			// smsText:短信内容
			NameValuePair[] data = { new NameValuePair("Uid", "chenliguan"),
					new NameValuePair("Key", "1dad5da868cade10efbf"),
					new NameValuePair("smsMob", smsMob),
					new NameValuePair("smsText", smsText) };
			post.setRequestBody(data);
			client.executeMethod(post);
			Header[] headers = post.getResponseHeaders();
			int statusCode = post.getStatusCode();
			System.out.println("statusCode:" + statusCode);
			for (Header h : headers) {
				System.out.println(h.toString());
			}
			String result = new String(post.getResponseBodyAsString().getBytes(
					"gbk"));
			System.out.println("result:" + result);
			post.releaseConnection();
			return result;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}

	/*
	 * 封装json数据
	 */
	public String jsonOne(String result) {
		// [{id:56,title:"xxxxx",timelength:90},{id:16,title:"xbbx",timelength:20}]
		StringBuilder builder = new StringBuilder();
		builder.append('[');
		builder.append('{');
		builder.append("title:\"").append(result).append("\"");
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
