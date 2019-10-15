package servlet.property;

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
 * ��ȡ��Ʒ��Ϣ������json�ַ���
 */
@WebServlet("/GetPropertyJson")
public class GetPropertyJson extends HttpServlet
{
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public GetPropertyJson()
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
		String dormitory = "", building = "";
		if (request.getParameter("building") != null)
		{
			// ���ν��� ����ISO-8859-1���룬����UTF-8
			building = new String(request.getParameter("building").getBytes("ISO-8859-1"), "UTF-8");
		}
		int page = 1;
		int limit = 15;
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
			String sqltemp = "select count(*) totalCount from asset";
			if (building != "")
			{
				sqltemp += (" where Bno = '{buidling}' OR belongSchool Like '%{key}%'")
						.replace("{buidling}", building);
			}
			ResultSet rset = statement.executeQuery(sqltemp);
			int rowCount = 0;
			if (rset.next())
			{
				rowCount = rset.getInt("totalCount");
			}

			String sql = "select * from asset";
			if (building != "")
			{
				sql += (" where Bno = '{buidling}' AND OR belongSchool Like '%{key}%'")
						.replace("{buidling}", building);
			}
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
				jsonobj.put("_pname", resultSet.getString("pname"));
				jsonobj.put("_price", resultSet.getString("price"));
				jsonobj.put("_ptotal", resultSet.getString("ptotal"));

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
