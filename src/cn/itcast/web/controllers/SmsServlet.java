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
	 * ������֤��
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
		String smsText = "[使�ϴ��]���ĵ�¼��֤�룺" + code;
		daoService.SendCode(smsMob, code); // ����dao��ӵ����ݿ�
		SendSms(smsMob, smsText); // ���Ͷ���
	}

	/**
	 * ����使�ϴ����֤��
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
		String smsText = "��л��ʹ������ʿ������ע����֤���ǣ�" + code + "������й©�����ˣ�";
		daoService.SendCode(smsMob, code); // ����dao��ӵ����ݿ�
		SendSms(smsMob, smsText); // ���Ͷ���
	}


	/**
	 * ��������
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	private void SendPassword(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String smsMob = request.getParameter("username");
		String password = daoService.SendPassword(smsMob); // �����ݿ��ȡ����
		String smsText = "��л��ʹ������ʿ�����������ǣ�" + password + "�������Ʊ��ܣ�";
		String result = "��ȡ����ʧ�ܣ������»�ȡ";
		request.setAttribute("json", jsonOne(result)); // �����ص�������ӵ�Attribute�У���ֵ��request
		if (password != null) {
			// ���Ͷ���
			if (SendSms(smsMob, smsText).equals(1)) {
				request.getRequestDispatcher("/WEB-INF/page/jsonvideonews.jsp")
						.forward(request, response); // ת������ڿͻ��˷���
			}
		} else {
			request.getRequestDispatcher("/WEB-INF/page/jsonvideonews.jsp")
					.forward(request, response); // ת������ڿͻ��˷���
		}
	}

	/**
	 * ���Ͳ������֪ͨ
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
		String smsText = "��ܰ��ʾ��" + nick + "���ڽ���һ���ĵ����������쳣��ƽ�����ʣ�"
				+ rate_grade + "�����ʲ�֢��" + symptoms_rhythm + "���ķ���֢��"
				+ symptoms_heart + "��";
		
		System.out.println("smsText:" +smsMob + ":" + smsText);
		
		SendSms(smsMob, smsText); // ���Ͷ���
	}

	/**
	 * ���ŷ��񷽷�
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
			// uid�����й�������վ��ע����û�id
			// key:�й�����Ϊע���û��ṩ�Ķ�����Ҫ
			// username�����Ͷ��ŵ��ֻ���
			// smsText:��������
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
	 * ��װjson����
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
