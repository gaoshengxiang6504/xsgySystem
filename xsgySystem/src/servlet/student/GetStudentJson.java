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
 * ��ȡѧ�������� ����json
 */
@WebServlet("/GetStudentJson")
public class GetStudentJson extends HttpServlet
{
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public GetStudentJson()
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
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/json; charset=utf-8");
		String keyword = "";
		String key_bno = "", key_dno = "";
		int page = 0, limit = 0;
		if (request.getParameter("_keyword") != null)
		{
			// ���ν��� ����ISO-8859-1���룬����UTF-8
			keyword = new String(request.getParameter("_keyword").getBytes("ISO-8859-1"), "UTF-8");
			System.out.println(keyword);
		}
		// ����ָ����Ԣ������Ų�ѯѧ�����
		if (request.getParameter("bno") != null)
			key_bno = request.getParameter("bno");
		if (request.getParameter("dno") != null)
			key_dno = request.getParameter("dno");
		if (request.getParameter("page") != null)
			page = Integer.parseInt(request.getParameter("page"));
		if (request.getParameter("limit") != null)
			limit = Integer.parseInt(request.getParameter("limit"));
		int count = 0; // ���������
		int percount = 0; // ÿҳ���������
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
			String sqltemp = "select count(*) totalCount from student";
			if (keyword != "")
			{
				sqltemp += (" where no Like '%{key}%' OR name Like '%{key}%' OR sex Like '%{key}%' OR college Like '%{key}%' OR major Like '%{key}%' OR class Like '%{key}%' OR Bno Like '%{key}%' OR Dno Like '%{key}%'")
						.replace("{key}", keyword);
			}
			if (key_bno != "" && key_dno != "")
				sqltemp += " where Bno='" + key_bno + "' AND Dno='" + key_dno + "'";
			ResultSet rset = statement.executeQuery(sqltemp);
			int rowCount = 0;
			if (rset.next())
			{
				rowCount = rset.getInt("totalCount");
			}

			String sql = "select * from student";
			if (keyword != "")
			{
				sql += (" where no Like '%{key}%' OR name Like '%{key}%' OR sex Like '%{key}%' OR college Like '%{key}%' OR major Like '%{key}%' OR class Like '%{key}%' OR Bno Like '%{key}%' OR Dno Like '%{key}%'")
						.replace("{key}", keyword);
			}
			if (key_bno != "" && key_dno != "")
				sql += " where Bno='" + key_bno + "' AND Dno='" + key_dno + "'";
			resultSet = statement.executeQuery(sql);
			JSONObject jsonmain = new JSONObject();
			jsonmain.put("code", "200");
			jsonmain.put("msg", "none");
			jsonmain.put("count", rowCount);
			JSONArray jsonarray = new JSONArray();
			JSONObject jsonobj = new JSONObject();
			// չ����������ݿ�
			while (resultSet.next())
			{
				if (count++ < (page - 1) * limit)
					continue;
				if (percount > limit)
					break;
				// ͨ���ֶμ���
				jsonobj.put("_id", resultSet.getString("no"));
				jsonobj.put("_name", resultSet.getString("name"));
				jsonobj.put("_sex", resultSet.getString("sex"));
				jsonobj.put("_class", resultSet.getString("class"));
				jsonobj.put("_major", resultSet.getString("major"));
				jsonobj.put("_college", resultSet.getString("college"));
				jsonobj.put("_bno", resultSet.getString("Bno"));
				jsonobj.put("_dno", resultSet.getString("Dno"));

				jsonarray.add(jsonobj);
				count++;
				percount++;
			}
			// �������
			jsonmain.put("data", jsonarray);
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
