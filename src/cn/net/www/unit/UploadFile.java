package cn.net.www.unit;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.naming.NamingException;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import cn.net.www.bean.FileUploadBean;
import cn.net.www.bean.XuntaUser;
import cn.net.www.dao.InsertDao;
import cn.net.www.session.RegisterSession;

public class UploadFile {
	private String path;
	private String filename = "";
	public static long FILE_SIZE=2*1024*1024;
	private Map map = new HashMap();
	private XuntaUser xtu = new XuntaUser();
    private RegisterSession rs=null;
	public final String getPath() {
		return path;
	}

	public final void setPath(String path) {
		this.path = path;
	}

	public String getFilename() {
		return filename;
	}

	public final void setFilename(String filename) {
		this.filename = filename;
	}

	public boolean createDirectory(int id, HttpServletRequest request) {
		// setPath(request.getServletPath()+"/image/user/"+id);
		// setPath(request.getServletPath()+"/image/user/"+id);
		setPath(request.getRealPath("image/user") + "/" + id);
		File file = new File(path);
		boolean flag = false;
		if (file.exists())
			flag = true;
		else {
			try {
				flag = file.mkdirs();
				flag = true;
			} catch (Exception e) {
				flag = false;
			}
		}
		return flag;
	}
   public static File isExists(String image_url,HttpServletRequest request){
	   boolean flag=false;
	   File file=new File(request.getRealPath("image/user"),image_url);
	   flag=file.exists();
	   if(!flag){
		   file=null;
	   }
	   return file;
   }
	public void createDirectory(String phone, HttpServletRequest request) {
		// setPath(request.getServletPath()+"/image/user/"+id);
		// setPath(request.getServletPath()+"/image/user/"+id);
		setPath(request.getRealPath("image/user") + "/" + phone);
		File file = new File(path);
		if (!file.exists())
			file.mkdirs();
	}

	public static FileUploadBean parseUploadRequest(FileUploadBean fub,
			HttpServletRequest request) throws Exception {
		boolean flag = false;
		String filename_total = "";
		FileUploadBean fub_this = new FileUploadBean();
		if (ServletFileUpload.isMultipartContent(request)) {// 判断是否是上传文件
			DiskFileItemFactory factory = new DiskFileItemFactory();
			factory.setSizeThreshold(20 * 1024 * 1024);
			factory.setRepository(factory.getRepository());
			ServletFileUpload upload = new ServletFileUpload(factory);
			// int size=2*1024*1024;
			int size = fub.getSize();
			List formlists = null;
			try {
				formlists = upload.parseRequest(request);
			} catch (FileUploadException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}// 获取上传文件集合
			Iterator iter = formlists.iterator();
			int i = 0;
			while (iter.hasNext()) {
				FileItem formitem = (FileItem) iter.next();
				if (!formitem.isFormField()) {
					String name = formitem.getName();
					if (formitem.getSize() > size) {
						fub_this.setMsg("您上传的文件太大,请选择不超过" + size + "的文件");
						flag = false;
						fub_this.setFlag(flag);
						break;
					}
					String adjunctname = "";
					String adjunctsize = new Long(formitem.getSize())
							.toString();
					if ((name == null || (name.equals(""))
							&& (adjunctsize.equals("0"))))
						continue;
					// adjunctname=name.substring(name.lastIndexOf("/")+1);
					adjunctname = fub.getFilename() + i
							+ name.substring(name.lastIndexOf("."));
					filename_total += adjunctname + ",";
					i++;
					String address = fub.getPath() + "/" + adjunctname;
					File saveFile = new File(address);
					formitem.write(saveFile);
					fub_this.setMsg("文件上传成功!!");
					flag = true;
					fub_this.setFlag(flag);
				}
			}
		}
		boolean sql_flag = false;
		sql_flag = new InsertDao().insertImage(filename_total, request);
		return fub_this;
	}

	public int register(HttpServletRequest request) throws Exception {
		int flag = 0;
		// ParseInputStream pis=new ParseInputStream();
		// map=pis.packStringtoMap(is,"utf-8");
		// String phone=String.valueOf(map.get("phone"));
		if (ServletFileUpload.isMultipartContent(request)) {
			DiskFileItemFactory factory = new DiskFileItemFactory();
			factory.setRepository(new File(request.getRealPath("/temp")));
			factory.setSizeThreshold(20 * 1024 * 1024);
			ServletFileUpload upload = new ServletFileUpload(factory);
			List formlists = upload.parseRequest(request);
			if (!formlists.isEmpty()) {
				// Iterator iter=formlists.iterator();
				// while(iter.hasNext()){
				// FileItem fileitems=(FileItem)iter.next();
				// String filename="";
				// if(!fileitems.isFormField()){
				// filename=fileitems.getName();
				// String
				// endname=filename.substring(filename.lastIndexOf(".")+1);
				// if(fileitems.getSize()>2*1024){
				// flag=1;//有图片超过限制大小
				// break;}
				// else
				// if(!endname.equalsIgnoreCase("png")&&!endname.equalsIgnoreCase("jpeg")&&!endname.equalsIgnoreCase("bmp")&&!endname.equalsIgnoreCase("gif")){
				// flag=2;//有图片格式不对
				// break;}
				// }
				// }
				for (FileItem fileitems : (List<FileItem>) formlists) {
					String filename = "";
					if (fileitems.isFormField()) {
						xtu.setInvoker(fileitems.getFieldName(),
								fileitems.getString("utf-8"));
						continue;
					}
					filename = fileitems.getName();
					if (fileitems.getSize() > 2 * 1024 * 1024) {
						flag = 1;// 有图片超过限制大小
						break;
					} else {
						if (new Long(fileitems.getSize()).toString()
								.equals("0") || filename.equals(""))
							continue;
						String endname = filename.substring(filename
								.lastIndexOf(".") + 1);
						if (!endname.equalsIgnoreCase("png")
								&& !endname.equalsIgnoreCase("bmp")
								&& !endname.equalsIgnoreCase("jpeg")
								&& !endname.equalsIgnoreCase("gif")
								&& !endname.equalsIgnoreCase("rgb")
								&& !endname.equalsIgnoreCase("jpg")) {
							flag = 2;// 有图片格式不对
							break;
						}
					}
				}
				if (flag == 1 || flag == 2)
					return flag;
				else {
					String filename_total = "";
					int file_count=0;
					for (FileItem fileitems : (List<FileItem>)formlists) {
						String filename = "";
						if (fileitems.isFormField())
							continue;
						// InputStream is=request.getInputStream();
						// ParseInputStream pis=new ParseInputStream();
						// map=pis.packStringtoMap(is,"utf-8");
						// String phone=String.valueOf(map.get("phone"));
						filename = fileitems.getName();
						if (new Long(fileitems.getSize()).toString()
								.equals("0") || filename.equals("")){
							if(file_count==0){
								flag=5;
								return flag;
							}else
							continue;}
						String phone = xtu.getPhone();
						createDirectory(phone, request);
						filename = fileitems.getName();
						file_count++;
						filename = new Date().getTime()+String.valueOf(file_count)
								+ filename.substring(filename.lastIndexOf("."));
						filename_total += phone + "/" + filename + ",";
						fileitems.write(new File(request
								.getRealPath("/image/user"), phone + "/"
								+ filename));
					}
					flag = new InsertDao().register_xunta(filename_total, xtu);
					if (flag == 4){
						rs=new RegisterSession();
						rs.setPhone(xtu.getPhone());
						rs.setType("xunta");
						rs.setWhere("1");
						rs.setWant("2");
						request.getSession().setAttribute("rs",rs);}
				}

			}
		}
		return flag;
	}
	public void uploadOne(ServletContext sc,HttpServletRequest request,HttpServletResponse response) throws Exception{
	PrintWriter out=response.getWriter();
	response.setContentType("text/html;charset=utf-8");
	String phone="";
	String image_url="";
	if(ServletFileUpload.isMultipartContent(request)){
		DiskFileItemFactory factory = new DiskFileItemFactory();
		factory.setRepository(new File(request.getRealPath("/temp")));
		factory.setSizeThreshold(20 * 1024 * 1024);
		ServletFileUpload upload = new ServletFileUpload(factory);
		List<FileItem> formlists = upload.parseRequest(request);
		if(!formlists.isEmpty()){
			boolean flag=false;
			for(FileItem fi:formlists){
				if(fi.isFormField()){
					if(fi.getFieldName().equals("phone")){
						phone=fi.getString();
					}
					if(fi.getFieldName().equals("image_url")){
						image_url=fi.getString();
					}
				continue;
				}
				if(fi.getSize()>UploadFile.FILE_SIZE){
					out.print("图片超过2M");
					out.close();
					return;
				}
				File change_file=UploadFile.isExists(image_url, request);
				if(change_file==null){
					this.createDirectory(phone, request);
					change_file=new File(request.getRealPath("image/user"),image_url);
				}
			    try{
					fi.write(change_file);
					out.println("修改成功!!");
                    out.println("<script>" +
                    		"window.close()</script>");
					}catch(Exception e){
						e.printStackTrace();
						out.println("修改失败");
					}finally{
						out.close();
					}
			}
			return;
		}else{
			response.sendError(404,"操作出错");
		}
	}
		out.close();
	}
}
