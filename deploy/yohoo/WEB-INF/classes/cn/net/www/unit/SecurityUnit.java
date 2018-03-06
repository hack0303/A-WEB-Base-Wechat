package cn.net.www.unit;

import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import cn.net.www.base.PhoneDigest;

public class SecurityUnit {
	private String returnstr = "";
	private MessageDigest md = null;
	private String type = "";
public SecurityUnit() {
	// TODO Auto-generated constructor stub
}
	public SecurityUnit(String type) throws NoSuchAlgorithmException {
		this.type = type;
		md = MessageDigest.getInstance(type);
	}

	public String returnMD5(String digest_need) {
		md.update(digest_need.getBytes());
		byte mdBytes[] = md.digest();
		int temp;
		String hash = "";
		for (int i = 0; i < mdBytes.length; i++) {
			if (mdBytes[i] < 0)
				temp = 256 + mdBytes[i];
			else
				temp = mdBytes[i];
			if (temp < 16)
				hash += "0";
			hash += Integer.toString(temp, 16);
		}
		return hash;
	}

	public String returnSHA(String digest_need) {
		md.update(digest_need.getBytes());
		byte myBytes[] = md.digest();
		String returnstr = bytetoStr(myBytes);
		return "";
	}

	private String bytetoStr(byte[] digest) {
		// TODO Auto-generated method stub
		String strDigest = "";
		for (int i = 0; i < digest.length; i++) {
			strDigest += byteToHexStr(digest[i]);
		}
		return strDigest;
	}

	private String byteToHexStr(byte b) {
		// TODO Auto-generated method stub
		char[] Digit = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A',
				'B', 'C', 'D', 'E', 'F' };
		char[] tempArr = new char[2];
		tempArr[0] = Digit[b >>> 4 & 0x0F];// 右移位与运算即高4位,与运算
		tempArr[1] = Digit[b & 0x0F];// 低4位与运算
		String s = new String(tempArr);
		return s;
	}

	public static void main(String args[]) {
		String str = "";
		SecurityUnit security = null;
		String returnstr = "";
		try {
			// security = new Security("MD5");
			security = new SecurityUnit("SHA");
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (str.isEmpty()) {
			System.out.println("请输入内容");
		}
		while (true) {
			byte[] b = new byte[1024];
			try {
				int length = System.in.read(b);
				str = new String(b, 0, length);
				System.out.println(str);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			returnstr = security.returnMD5(str);
			System.out.println(returnstr);
		}
	}
	public static String phoneEncode(String decode_phone) throws Exception{//轮盘加密
		String partA=decode_phone.substring(0,3);
		String partB=decode_phone.substring(3);
		System.out.println(decode_phone.length());
		if((partB.length())!=8){
			throw new Exception("手机长度出错!");
		}else{
			char[] c = new char[8];
			partB.getChars(0,8,c,0);
			int length=8;
			for(int i=0,base=1;i<length;i++){
				base*=2;
			int index=0;
				index+=(Integer.parseInt(String.valueOf(c[i]),10)+base+i+1);
				c[i]=PhoneDigest.getCharByIndex(index);
				}
			partB=String.valueOf(c);
		}
			return partA+partB;
	}
    public static String phoneDecode(String encode_phone) throws Exception{
    	String partA=encode_phone.substring(0,3);
		String partB=encode_phone.substring(3);
		if((partB.length())!=8){
			throw new Exception("手机长度出错!");
		}else{
			char[] c = new char[8];
			partB.getChars(0,8,c,0);
			int length=8;
			for(int i=0,base=1;i<length;i++){
				base*=2;
				int index=0;
				index+=(Integer.parseInt(String.valueOf(c[i]),10)+300);
				index-=(1+i+base);
				c[i]=PhoneDigest.getCharByIndex(index);
				}
			partB=String.valueOf(c);
		}
			return partA+partB;
	}

}
