package com.xjf.wemall.service.crazyjavachapter18;

import java.lang.reflect.Method;  

/** 
 * Description: 
 * <br/>网站: <a href="http://www.crazyit.org" mce_href="http://www.crazyit.org">疯狂Java联盟</a>  
 * <br/>Copyright (C), 2001-2010, Leeyohn 
 * <br/>This program is protected by copyright laws. 
 * <br/>Program Name: 
 * <br/>Date: 
 * @author  Leeyohn leeyohn@hotmail.com 
 * @version  1.0 
 */  
  
public class Eval   
{  
    public static Object eval(String str) throws Exception  
    {  
        StringBuffer sb = new StringBuffer();  
        sb.append("public class Sim");  
        sb.append("{");  
        sb.append("    public Object getObject()");  
        sb.append("    {");  
        sb.append("        " + str + "return new Object();");  
        sb.append("    }");  
        sb.append("}");  
        //调用自定义类加载器加载编译在内存中class文件  
        Class clazz = new MyClassLoader().findClass(sb.toString());  
        Method method = clazz.getMethod("getObject");  
        //通过反射调用方法  
        return method.invoke(clazz.newInstance());  
    }  
  
    public static void main(String[] args) throws Exception  
    {  
        Object rval = eval("System.out.println(\"Hello World\");");  
        System.out.println(rval);  
    }  
}  