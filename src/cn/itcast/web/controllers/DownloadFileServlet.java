package cn.itcast.web.controllers;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * ͨ��Servlet ����ļ�����
 * 
 * @author seawind
 * 
 */
@SuppressWarnings("serial")
public class DownloadFileServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// ��ÿͻ����ύfile ����
		String file = request.getParameter("file");

		System.out.println("�ļ��ǣ�" + file);

		// �����ļ����ӷ������˶�ȡ�ļ������ļ�����д�ؿͻ���
		String serverFilePath = getServletContext().getRealPath(
				"/WEB-INF/upload/" + file);

		// ������Ӧͷ
		response.setContentType(getServletContext().getMimeType(file));// �����ļ���չ�����MIME����
		// �ȼ��� response.setHeader("Content-Type",xxx);
		response.setHeader("Content-Disposition", "attachment;filename=" + file);// �Ը�������

		InputStream in = new BufferedInputStream(new FileInputStream(
				serverFilePath));
		// ��Ҫ����������
		OutputStream out = response.getOutputStream();
		int temp;
		while ((temp = in.read()) != -1) {
			out.write(temp);
		}
		out.close();
		in.close();
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}







