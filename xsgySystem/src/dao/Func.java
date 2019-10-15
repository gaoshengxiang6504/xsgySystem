package dao;

import java.io.BufferedReader;
import java.io.File;
import java.security.MessageDigest;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

/**
 * ͨ�ú���
 */

public class Func
{
	// ��ȡrequest������Ϊ�ַ���
	public static String readJSONString(HttpServletRequest request)
	{
		StringBuffer json = new StringBuffer();
		String line = null;
		try
		{
			BufferedReader reader = request.getReader();
			while ((line = reader.readLine()) != null)
			{
				json.append(line);
			}
		}
		catch (Exception e)
		{
			System.out.println(e.toString());
		}
		return json.toString();
	}

	/***
	 * @comments ��������ʱ���ʱ���
	 * @param strTime1
	 * @param strTime2
	 */
	public static String getTimeDifference(String strTime1, String strTime2)
	{
		// ��ʽ���ڸ�ʽ���ڴ����õ���"2018-01-24 19:49:50"���ָ�ʽ
		// ���Ը���Ϊ�Լ�ʹ�õĸ�ʽ�����磺yyyy/MM/dd HH:mm:ss ������
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try
		{
			Date now = df.parse(strTime1);
			Date date = df.parse(strTime2);
			long l = now.getTime() - date.getTime(); // ��ȡʱ���
			long day = l / (24 * 60 * 60 * 1000);
			long hour = (l / (60 * 60 * 1000) - day * 24);
			long min = ((l / (60 * 1000)) - day * 24 * 60 - hour * 60);
			long s = (l / 1000 - day * 24 * 60 * 60 - hour * 60 * 60 - min * 60);
			return (day + "��" + hour + "ʱ" + min + "��" + s + "��");
		}
		catch (Exception e)
		{
			return "";
		}
	}

	// �ϲ�·��
	public static String combine(String path1, String path2)
	{
		File file1 = new File(path1);
		File file2 = new File(file1, path2);
		return file2.getPath();
	}

	// �Զ����MD5�����ַ���
	public static String MD5(String s)
	{
		try
		{
			MessageDigest md = MessageDigest.getInstance("MD5");
			byte[] bytes = md.digest(s.getBytes("utf-8"));
			return toHex(bytes);
		}
		catch (Exception e)
		{
			throw new RuntimeException(e);
		}
	}

	private static String toHex(byte[] bytes)
	{
		//final char[] HEX_DIGITS = "0123456789ABCDEF".toCharArray();
		final char[] HEX_DIGITS = "ABCDEFGHIJKLMNOP".toCharArray();
		StringBuilder ret = new StringBuilder(bytes.length * 2);
		for (int i = 0; i < bytes.length; i++)
		{
			ret.append(HEX_DIGITS[(bytes[i] >> 4) & 0x0f]);
			ret.append(HEX_DIGITS[bytes[i] & 0x0f]);
		}
		return ret.toString();
	}
}
