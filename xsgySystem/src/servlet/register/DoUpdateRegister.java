package servlet.register;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.Func;
import net.sf.json.JSONObject;
import utils.JDBCUtils;

/**
 * �������ݿ���³�����Ϣ
 */
@WebServlet("/DoUpdateRegister")
public class DoUpdateRegister extends HttpServlet
{
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DoUpdateRegister()
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
		PrintWriter out = response.getWriter();

		// ��ȡurl�еĲ���ֵ
		String id = "", in_time = "";
		id = request.getParameter("id");
		in_time = java.net.URLDecoder.decode(request.getParameter("in_time"), "UTF-8");
		// ��֤Ȩ��
		HttpSession session = request.getSession();
		if (session.getAttribute("username") == null || session.getAttribute("username").toString().equals(""))
		{
			response.setStatus(403);
			out.println("403 Forbidden");
			return;
		}
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try
		{
			// �������
			connection = JDBCUtils.getConnection();
			// ����json����
			JSONObject jsonmain = new JSONObject();

			// ����SQL���
			String sql = "update in_or_out set out_time=?,count_time=? where id=?";
			// ���preparedStatement����
			preparedStatement = connection.prepareStatement(sql);
			String outTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
			preparedStatement.setString(1, outTime);
			preparedStatement.setString(2, Func.getTimeDifference(outTime, in_time));
			preparedStatement.setString(3, id);
			int result = preparedStatement.executeUpdate();
			if (result != 0)
			{
				response.setStatus(200);
				jsonmain.put("code", "200");
				jsonmain.put("msg", "updated");
			}
			else
			{
				response.setStatus(500);
				jsonmain.put("code", "500");
				jsonmain.put("msg", "Error");
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
			JDBCUtils.release(resultSet, preparedStatement, connection);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{

		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

}
