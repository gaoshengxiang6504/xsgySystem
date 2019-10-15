package servlet.student;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
 * ����ѧ�������ݿ�
 */
@WebServlet("/DoUpdate")
public class DoUpdate extends HttpServlet
{
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DoUpdate()
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
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		// ������Ӧ��������
		response.setContentType("text/json; charset=utf-8");
		PrintWriter out = response.getWriter();
		// ��֤Ȩ��
		HttpSession session = request.getSession();
		if (session.getAttribute("username") == null || session.getAttribute("username").toString().equals(""))
		{
			response.setStatus(403);
			out.println("403 Forbidden");
			return;
		}
		
		// ��ȡurl�еĲ���ֵ
		String id = "", name = "", sex = "", major = "", className = "",college="",Bno="",Dno="";
		String jsonString =Func.readJSONString(request);
		JSONObject obj = JSONObject.fromObject(jsonString);
		id = obj.get("_id").toString();
		name = obj.get("_name").toString();
		sex = obj.get("_sex").toString();
		major = obj.get("_major").toString();
		className = obj.get("_class").toString();
		college = obj.get("_college").toString();
		//Bno = obj.get("_bno").toString();
		//Dno = obj.get("_dno").toString();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try
		{
			// �������
			connection = JDBCUtils.getConnection();
			// ����SQL���
			String sql="update student set name=?,sex=?,college=?,major=?,class=? where no=?";
			// ���preparedStatement����
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, name);
			preparedStatement.setString(2, sex);
			preparedStatement.setString(3, college);
			preparedStatement.setString(4, major);
			preparedStatement.setString(5, className);
			preparedStatement.setString(6, id);
			int result = preparedStatement.executeUpdate();
			JSONObject jsonmain = new JSONObject();
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
}
