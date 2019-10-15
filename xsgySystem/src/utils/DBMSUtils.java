package utils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

/**
 * ���ݿ�ı�����ָ�
 */

public class DBMSUtils
{
	public static boolean backup(String command, String savePath)
	{
		boolean flag;
		// ����뵱ǰӦ�ó��������Runtime����
		Runtime r = Runtime.getRuntime();
		BufferedReader br = null;
		BufferedWriter bw = null;
		try
		{
			// �ڵ����Ľ�����ִ��ָ�����ַ�������
			Process p = r.exec(command);
			// ������ӵ�������������������������������Ӹ�Process�����ʾ�Ľ��̵ı�׼����л�ȡ����
			InputStream is = p.getInputStream();
			// InputStreamReader�Ǵ��ֽ������ַ���������������ȡ�ֽڣ���ʹ��ָ����charset�������Ϊ�ַ�
			InputStreamReader isr = new InputStreamReader(is, "utf-8");
			// BufferedReader���ַ���������ȡ�ı��������ַ����ṩ�ַ���������еĸ�Ч��ȡ
			br = new BufferedReader(isr);
			String s;
			StringBuffer sb = new StringBuffer("");
			// ��װ�ַ���
			while ((s = br.readLine()) != null)
			{
				sb.append(s + "\r\n");
			}
			s = sb.toString();
			// �����ļ������
			FileOutputStream fos = new FileOutputStream(savePath);
			// OutputStreamWriter�Ǵ��ַ������ֽ�������������ʹ��ָ����charset��д����ַ�����Ϊ�ֽ�
			OutputStreamWriter osw = new OutputStreamWriter(fos, "utf-8");
			// BufferedWriter���ı�д���ַ�������������ַ������ṩ�����ַ���������ַ����ĸ�Чд��
			bw = new BufferedWriter(osw);
			bw.write(s);
			bw.flush();
			flag = true;
		}
		catch (IOException e)
		{
			flag = false;
			e.printStackTrace();
		}
		finally
		{
			// �������������ʹ�õ���װ����ģʽ�������ڹر���ʱֻ��Ҫ�������װ�����close()�������ɣ�
			// �����Զ������ڲ�����close()����
			try
			{
				if (null != bw)
				{
					bw.close();
				}
			}
			catch (IOException e)
			{
				e.printStackTrace();
			}

			try
			{
				if (null != br)
				{
					br.close();
				}
			}
			catch (IOException e)
			{
				e.printStackTrace();
			}
		}
		return flag;
	}

	public static boolean recover(String command, String savePath)
	{
		boolean flag;
		Runtime r = Runtime.getRuntime();
		BufferedReader br = null;
		BufferedWriter bw = null;
		try
		{
			Process p = r.exec(command);
			OutputStream os = p.getOutputStream();
			FileInputStream fis = new FileInputStream(savePath);
			InputStreamReader isr = new InputStreamReader(fis, "utf-8");
			br = new BufferedReader(isr);
			String s;
			StringBuffer sb = new StringBuffer("");
			while ((s = br.readLine()) != null)
			{
				sb.append(s + "\r\n");
			}
			s = sb.toString();
			OutputStreamWriter osw = new OutputStreamWriter(os, "utf-8");
			bw = new BufferedWriter(osw);
			bw.write(s);
			bw.flush();
			flag = true;
		}
		catch (IOException e)
		{
			flag = false;
			e.printStackTrace();
		}
		finally
		{
			try
			{
				if (null != bw)
				{
					bw.close();
				}
			}
			catch (IOException e)
			{
				e.printStackTrace();
			}

			try
			{
				if (null != br)
				{
					br.close();
				}
			}
			catch (IOException e)
			{
				e.printStackTrace();
			}
		}
		return flag;
	}
}
