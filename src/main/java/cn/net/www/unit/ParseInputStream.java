package cn.net.www.unit;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;

import com.mysql.jdbc.log.Log;

/**
 * @author daxian
 * @date : 2016-7-29 下午9:32:14
 */
public class ParseInputStream {
	private static InputStream is;
	private static String str;
	private static Map<String, String> map;

	public String returnInputStreamtoString(HttpServletRequest request,
			String encode) throws IOException {
		String str_line = "";
		this.is = request.getInputStream();
		BufferedReader br = new BufferedReader(
				new InputStreamReader(is, encode));
		StringBuffer sb = new StringBuffer();
		while ((str_line = br.readLine()) != null) {
			sb.append(str_line);
		}
		this.str = sb.toString();
		return this.str;
	}

	public Map<String, String> packStringtoMap(HttpServletRequest request,
			String encode) throws IOException {
		this.map = new HashMap<String, String>();
		returnInputStreamtoString(request, encode);
		int fromindex = 0;
		int toindex = 0;
		String flag = "name=\"";
		while ((fromindex = str.indexOf(flag, toindex)) != -1) {
			toindex = str.indexOf("-", fromindex);
			String string = "";
			string = str.substring(fromindex + flag.length(), toindex);
			String[] s = string.split("\"");
			if (s[0].equalsIgnoreCase("file"))
				continue;// 过滤name为file的域
			this.map.put(new String(s[0].trim()), new String(s[1].trim()));
			System.out.println(s[0] + s[1]);
		}
		return this.map;
	}

	public String returnInputStreamtoString(InputStream is, String encode)
			throws IOException {
		String str_line = "";
		this.is = is;
		BufferedReader br = new BufferedReader(
				new InputStreamReader(is, encode));
		StringBuffer sb = new StringBuffer();
		while ((str_line = br.readLine()) != null) {
			sb.append(str_line);
		}
		this.str = sb.toString();
		return this.str;
	}

	public Map<String, String> packStringtoMap(InputStream is, String encode)
			throws IOException {
		this.map = new HashMap<String, String>();
		returnInputStreamtoString(is, encode);
		int fromindex = 0;
		int toindex = 0;
		String flag = "name=\"";
		while ((fromindex = str.indexOf(flag, toindex)) != -1) {
			toindex = str.indexOf("-", fromindex);
			String string = "";
			string = str.substring(fromindex + flag.length(), toindex);
			String[] s = string.split("\"");
			if (s[0].equalsIgnoreCase("file"))
				continue;// 过滤name为file的域
			this.map.put(new String(s[0].trim()), new String(s[1].trim()));
			System.out.println(map.isEmpty());
		}
		return this.map;
	}

	public static InputStream getIs() {
		return is;
	}

	public static void setIs(InputStream is) {
		ParseInputStream.is = is;
	}

	public static String getStr() {
		return str;
	}

	public static void setStr(String str) {
		ParseInputStream.str = str;
	}

	public static Map<String, String> getMap() {
		return map;
	}

	public static void setMap(Map<String, String> map) {
		ParseInputStream.map = map;
	}

}