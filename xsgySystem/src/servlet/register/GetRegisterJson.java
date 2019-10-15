package servlet.register;

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
 * ��ȡ�����¼ ����json
 */
@WebServlet("/GetRegisterJson")
public class GetRegisterJson extends HttpServlet
{
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public GetRegisterJson()
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
			String sqltemp = "select count(*) totalCount from in_or_out";
			ResultSet rset = statement.executeQuery(sqltemp);
			int rowCount = 0;
			if (rset.next())
			{
				rowCount = rset.getInt("totalCount");
			}

			String sql = "select * from in_or_out";
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
				jsonobj.put("_id", resultSet.getString("id"));
				jsonobj.put("_peoname", resultSet.getString("peoname"));
				jsonobj.put("_peotype", resultSet.getString("peotype"));
				jsonobj.put("_goodsname", resultSet.getString("goodsname"));
				jsonobj.put("_in_time", resultSet.getString("in_time"));
				jsonobj.put("_out_time", resultSet.getString("out_time"));
				jsonobj.put("_count_time", resultSet.getString("count_time"));

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
