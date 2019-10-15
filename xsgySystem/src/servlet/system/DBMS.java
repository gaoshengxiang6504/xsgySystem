package servlet.system;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import dao.Func;
import net.sf.json.JSONObject;
import utils.DBMSUtils;

/**
 * ���ݿ�ı�����ָ�
 */
@WebServlet("/DBMS")
public class DBMS extends HttpServlet
{
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DBMS()
	{
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		// ������Ӧ��������
		response.setContentType("text/json; charset=utf-8");
		String actionType = request.getParameter("action");
		System.out.println(actionType);
		// ��֤Ȩ��
		HttpSession session = request.getSession();
		if (session.getAttribute("username") == null || session.getAttribute("username").toString().equals(""))
		{
			response.setStatus(403);
			response.getWriter().println("403 Forbidden");
			return;
		}
		if (actionType.equals("download"))
		{
			try
			{
				String command = "mysqldump -hlocalhost -uroot -proot xsgy";// ����������IP���˺š����롢���ݿ���
				String savePath = Func.combine(getServletContext().getRealPath("/WEB-INF/sqls"),
						"sql-" + new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss").format(new Date()) + ".sql");
				System.out.println(savePath);
				JSONObject resObj = new JSONObject();
				// ִ�в���
				boolean result = DBMSUtils.backup(command, savePath);
				if (result)
				{
					resObj.put("msg", "OK");
				}
				else
				{
					resObj.put("msg", "Error");
				}
				// ִ���ļ����ز���

				// ��ȡ�ļ���
				String fileName = new File(savePath.trim()).getName();
				response.setCharacterEncoding("utf-8");
				response.setContentType("multipart/form-data");
				// �������ص��������ֵı�������
				response.setHeader("Content-Disposition",
						"attachment;fileName=" + new String(fileName.getBytes("gb2312"), "ISO8859-1"));
				// ��ȡ�ļ�������·��
				String path = savePath;
				System.out.println(path);
				// ����������������ļ���������
				InputStream inputStream = new FileInputStream(new File(path));

				OutputStream os = response.getOutputStream();
				byte[] b = new byte[2048];
				int length;
				while ((length = inputStream.read(b)) > 0)
				{
					os.write(b, 0, length);
				}
				os.close();
				inputStream.close();

				// ���json
				System.out.println(resObj);
			}
			catch (FileNotFoundException e)
			{
				e.printStackTrace();
			}
			catch (IOException e)
			{
				e.printStackTrace();
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		// ������Ӧ��������
		response.setContentType("text/json; charset=utf-8");
		// ��֤Ȩ��
		HttpSession session = request.getSession();
		if (session.getAttribute("username") == null || session.getAttribute("username").toString().equals(""))
		{
			response.setStatus(403);
			response.getWriter().println("403 Forbidden");
			return;
		}
		try
		{
			// ����
			FileItemFactory fileItemFactory = new DiskFileItemFactory();
			// ������
			ServletFileUpload servletFileUpload = new ServletFileUpload(fileItemFactory);
			// ����request ,List��� FileItem
			List<FileItem> list = servletFileUpload.parseRequest(request);
			// �������ϻ������
			for (FileItem fileItem : list)
			{
				if (fileItem.isFormField())
				{
					// �Ƿ�Ϊ���ֶΣ���ͨ��Ԫ�أ�
					String fieldName = fileItem.getFieldName();
					System.out.println(fieldName);
					String fieldValue = fileItem.getString();
					System.out.println(fieldValue);
				}
				else
				{
					// �ϴ��ֶΣ��ϴ���Ԫ�أ�
					String fileName = fileItem.getName();
					fileName = fileName.substring(fileName.lastIndexOf("\\") + 1);
					// �ϴ�����
					InputStream is = fileItem.getInputStream(); // �����������
					String parentDir = this.getServletContext().getRealPath("/WEB-INF/upload");
					File file = new File(parentDir, fileName);
					if (!file.getParentFile().exists())
					{ // ��Ŀ¼������
						file.getParentFile().mkdirs();
					}
					FileOutputStream out = new FileOutputStream(file);
					byte[] buf = new byte[1024];
					int len1 = -1;
					while ((len1 = is.read(buf)) != -1)
					{
						out.write(buf, 0, len1);
					}

					// �ر�
					out.close();
					is.close();

					String command = "mysql.exe -hlocalhost -uroot -proot --default-character-set=utf8 xsgy";// ����������IP���˺š����롢���ݿ���
					String savePath = Func.combine(parentDir, fileName);
					JSONObject resObj = new JSONObject();
					// ִ�в���
					boolean result = DBMSUtils.recover(command, savePath);
					if (result)
					{
						resObj.put("msg", "OK");
					}
					else
					{
						resObj.put("msg", "Error");
					}

					// ���json
					response.getWriter().println(resObj);
				}
			}

		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

}
