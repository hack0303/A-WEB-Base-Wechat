package cn.net.www.unit;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.Properties;

public class PropertiesUnit {
private Properties ppt;
public static final String ALIDAYU="alidayu.properties";
	public PropertiesUnit(String filename) {
		ppt=new Properties();
		String root=Thread.currentThread().getContextClassLoader().getResource("/").getPath();
		try {
			root=URLDecoder.decode(root, "utf-8");
		} catch (UnsupportedEncodingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		String path=root+filename;
		File f=new File(path);
		FileReader fr=null;
		try {
			fr = new FileReader(f);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			ppt.load(fr);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	// TODO Auto-generated constructor stub

}
public String getValue(String key){
	return  ppt.getProperty(key);
}
}
