package com.jade.http;

import org.apache.commons.fileupload.DiskFileUpload;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import java.io.UnsupportedEncodingException;
import java.util.*;

/**
 * 重写 request 实现 文件上传的透明传输
 */
public class MultipartRequest extends HttpServletRequestWrapper {

    HashMap parameters = new HashMap();

    HashMap files = new HashMap();


    public MultipartRequest(HttpServletRequest request) throws FileUploadException {
        super(request);

        DiskFileUpload fu = new DiskFileUpload();
        // 最多上传200M 数据文件
        fu.setSizeMax(200 * 1024 * 1024);
        // 超过 1M 的字段数据采用临时文件缓存
        fu.setSizeThreshold(1 * 1024 * 1024);
        // 采用默认的临时文件存储位置
        // fu.setRepositoryPath("");

        // 设置上传的普通字段和文件字段的文件名称采用的字符编码
        fu.setHeaderEncoding("utf-8");

        // 获取所有表单字段对象的结合
        List fileItems = fu.parseRequest(request);
        // 如果解析数据时出现问题，直接将FileUploadException 抛出

        // 处理每个表单字段
        Iterator i = fileItems.iterator();
        while (i.hasNext()) {

            FileItem fi = (FileItem) i.next();
            if (fi.isFormField()) {
                String fieldName = fi.getFieldName();
                String content = null;
                try {
                    content = fi.getString("utf-8");
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
                setParameter(fieldName, content);

            } else {

                String pathSrc = fi.getName();
                /*如果用户没有在form表单文件字段中选择任何文件，那么将忽略对该字段的处理*/
                if (pathSrc.trim().equals("")) {
                    continue;
                }

                String fieldName = fi.getFieldName();
                files.put(fieldName, fi);

            }

        }


    }


    /*向集合中添加个参数，主要是考虑到多个同名参数字段的情况*/
    public void setParameter(String name, String value) {

        String[] mValue = (String[]) parameters.get(name);

        if (mValue == null) {
            mValue = new String[0];
        }

        String[] newValue = new String[mValue.length + 1];

        System.arraycopy(mValue, 0, newValue, 0, mValue.length);
        newValue[mValue.length] = value;

        parameters.put(name, newValue);

    }

    /*返回某个名称的参数值，如果一个名称对应多个参数值，那么返回第一个参数值*/
    public String getParameter(String name) {
        String[] mValue = (String[]) parameters.get(name);
        if (mValue != null && (mValue.length > 0))
            return mValue[0];
        return null;
    }

    /*返回所有参数名称的结合*/
    public Enumeration<String> getParameterNames(){
        Collection c = parameters.keySet();
        return Collections.enumeration(c);
    }

    /*返回某个名称对应的所有参数值*/
    public String[] getParameterValues(String name) {
        String[] values = (String[])parameters.get(name);
        return values;
    }

    /*返回包含所有参数名称和参数值的 Map 集合*/
    @Override
    public Map getParameterMap() {
        return parameters;
    }

    /*返回某个表字段对应的 FileItem 对象*/
    public FileItem getFileItem(String name){
        FileItem fileItem = (FileItem)files.get(name);
        return fileItem;
    }

    /*返回所有上传了文件的文件字段的名称集合*/
    public Enumeration getFileItemNames(){
        Collection c = files.keySet();
        Enumeration enumeration = Collections.enumeration(c);
        return enumeration;
    }

}
