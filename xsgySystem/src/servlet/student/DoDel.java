package servlet.student;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import utils.JDBCUtils;

/**
 * ɾ��ѧ��������Ŀ
 */
@WebServlet("/DoDel")
public class DoDel extends HttpServlet
{
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DoDel()
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
		String id = request.getParameter("id");
		PrintWriter out = response.getWriter();
		// ��֤Ȩ��
		HttpSession session = request.getSession();
		if (session.getAttribute("username") == null || session.getAttribute("username").toString().equals(""))
		{
			response.setStatus(403);
			out.println("403 Forbidden");
			return;
		}
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		try
		{
			// �������
			connection = JDBCUtils.getConnection();
			// ���statement����
			statement = connection.createStatement();
			// ����SQL���
			String sql = "delete from student where no='" + id + "'";
			int result = statement.executeUpdate(sql);
			JSONObject jsonmain = new JSONObject();
			jsonmain.put("code", "200");
			if (result != 0) {
				jsonmain.put("msg", "deleted");
				response.setStatus(200);
			}
			else {
				jsonmain.put("msg", "Error");
				response.setStatus(500);  //ɾ��ʧ��
			}
			// �������
			out.println(jsonmain);
		}
		catch (ClassNotFoundException e)
		{
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
		catch (SQLException e)
		{
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
		finally
		{
			JDBCUtils.release(resultSet, statement, connection);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
