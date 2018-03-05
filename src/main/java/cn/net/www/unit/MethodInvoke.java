package cn.net.www.unit;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.net.www.servlet.MyServlet;

public class MethodInvoke {
public static void invokeMethod(Object object, String methodname,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		// Object property=getProperty(object,"public");
		Method method = object.getClass().getMethod(
				methodname,
				new Class[] { HttpServletRequest.class,
						HttpServletResponse.class });
		method.invoke(object, new Object[] { request, response });

	}
	public static void invokeMethod(Object object, String methodname,
			ServletContext sc,HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		// Object property=getProperty(object,"public");
		Method method = object.getClass().getMethod(methodname,new Class[] {ServletContext.class, HttpServletRequest.class,
						HttpServletResponse.class });
		method.invoke(object, new Object[] {sc, request, response });
	}
	public static void invokeMethod(Object object, String methodname,String step,
			ServletContext sc,HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		// Object property=getProperty(object,"public");
		Method	method = object.getClass().getMethod(methodname,new Class[] {String.class,ServletContext.class, HttpServletRequest.class,
						HttpServletResponse.class });
		method.invoke(object, new Object[] {step,sc, request, response });
	}
	public static void invokeMethod(Object object, String methodname,
			String args) throws Exception {
		// Object property=getProperty(object,"public");
		Method method = object.getClass().getMethod(methodname,
				new Class[] { String.class });
		method.invoke(object, new Object[] { args });

	}

	public static void invokeMethod(Object object, String methodname,
			String[] args) throws Exception {
		// Object property=getProperty(object,"public");
		String string = "";
		Method method = object.getClass().getMethod(methodname,
				new Class[] { String.class });
		for (String str : args) {
			string += str + ",";
		}
		string = string.substring(0, string.length() - 1);
		method.invoke(object, new Object[] { string });
	}

	public static Object getProperty(Object owner, String fieldName)
			throws Exception {
		Class ownerClass = owner.getClass();
		Field field = ownerClass.getField(fieldName);
		Object property = field.get(owner);
		return property;
	}
}
