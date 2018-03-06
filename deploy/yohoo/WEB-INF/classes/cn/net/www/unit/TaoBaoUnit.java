package cn.net.www.unit;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import javax.naming.NamingException;
import javax.servlet.http.HttpServletRequest;

import cn.net.www.bean.YohooCheckCode;
import cn.net.www.dao.InsertDao;
import cn.net.www.dao.UpdateDao;

import com.taobao.api.ApiException;
import com.taobao.api.DefaultTaobaoClient;
import com.taobao.api.TaobaoClient;
import com.taobao.api.request.AlibabaAliqinFcSmsNumSendRequest;
import com.taobao.api.response.AlibabaAliqinFcSmsNumSendResponse;

public class TaoBaoUnit {
	private String url;
	private String appkey;
	private String secret;
	private String SmsfreesignName;
	private String SmsTemplateCode;

	public TaoBaoUnit(String url, String appkey, String secret,
			String smsfreesignName, String smsTemplateCode) {
		super();
		this.url = url;
		this.appkey = appkey;
		this.secret = secret;
		SmsfreesignName = smsfreesignName;
		SmsTemplateCode = smsTemplateCode;
	}

	public String getSmsfreesignName() {
		return SmsfreesignName;
	}

	public void setSmsfreesignName(String smsfreesignName) {
		SmsfreesignName = smsfreesignName;
	}

	public String getSmsTemplateCode() {
		return SmsTemplateCode;
	}

	public void setSmsTemplateCode(String smsTemplateCode) {
		SmsTemplateCode = smsTemplateCode;
	}

	public final String getUrl() {
		return url;
	}

	public final void setUrl(String url) {
		this.url = url;
	}

	public final String getAppkey() {
		return appkey;
	}

	public final void setAppkey(String appkey) {
		this.appkey = appkey;
	}

	public final String getSecret() {
		return secret;
	}

	public final void setSecret(String secret) {
		this.secret = secret;
	}

	public void sendMessage(HttpServletRequest request) {
		TaobaoClient client = new DefaultTaobaoClient(this.url, this.appkey, this.secret);
		AlibabaAliqinFcSmsNumSendRequest req = new AlibabaAliqinFcSmsNumSendRequest();
		String type = request.getParameter("type");
		YohooCheckCode ycc=(YohooCheckCode) request.getAttribute("ycc");
		String phone = ycc.getPhone();
		if(type.equals("xunta")){
			type="优活寻Ta";
		}
		String checkcode = ycc.getCheckcode();
		req.setExtend(phone);
		req.setSmsType("normal");
		req.setSmsFreeSignName(this.SmsfreesignName);
		req.setSmsParamString("{\"checkcode\":\"" + checkcode + "\",\"type\":\"" +type+ "\"}");
		req.setRecNum(phone);
		req.setSmsTemplateCode(this.SmsTemplateCode);
		AlibabaAliqinFcSmsNumSendResponse rsp = null;
		try {
			rsp =client.execute(req);
			System.out.print(this.toString());
		} catch (ApiException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String transaction=String.valueOf(request.getAttribute("transaction"));
		if(transaction.equals("insert")){
			try {
				new InsertDao().insertObject(ycc,YohooCheckCode.class);
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (NamingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else if(transaction.equals("update")){
			try {
				new UpdateDao().updateObject(ycc,YohooCheckCode.class);
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (NamingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println(rsp.getBody());
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.appkey+this.secret+this.SmsfreesignName+this.SmsTemplateCode+this.url;
	}
}
