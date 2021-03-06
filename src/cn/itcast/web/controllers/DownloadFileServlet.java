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
 * 通过Servlet 完成文件下载
 * 
 * @author seawind
 * 
 */
@SuppressWarnings("serial")
public class DownloadFileServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 获得客户端提交file 参数
		String file = request.getParameter("file");

		System.out.println("文件是：" + file);

		// 下载文件，从服务器端读取文件，将文件内容写回客户端
		String serverFilePath = getServletContext().getRealPath(
				"/WEB-INF/upload/" + file);

		// 设置响应头
		response.setContentType(getServletContext().getMimeType(file));// 根据文件扩展名获得MIME类型
		// 等级于 response.setHeader("Content-Type",xxx);
		response.setHeader("Content-Disposition", "attachment;filename=" + file);// 以附件下载

		InputStream in = new BufferedInputStream(new FileInputStream(
				serverFilePath));
		// 需要浏览器输出流
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








