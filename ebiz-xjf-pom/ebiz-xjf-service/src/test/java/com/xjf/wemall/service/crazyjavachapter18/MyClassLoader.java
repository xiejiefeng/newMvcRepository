package com.xjf.wemall.service.crazyjavachapter18;
import java.util.Arrays;  
import javax.tools.SimpleJavaFileObject;  
import javax.tools.JavaFileObject;  
import javax.tools.JavaCompiler;  
import javax.tools.ToolProvider;  
import javax.tools.DiagnosticCollector;  
import java.net.URI;  
  
  
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
  
public class MyClassLoader extends ClassLoader {  
    @Override  
    public Class<?> findClass(String str) throws ClassNotFoundException {  
        JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();  
        //用于诊断源代码编译错误的对象  
        DiagnosticCollector diagnostics = new DiagnosticCollector();  
        //内存中的源代码保存在一个从JavaFileObject继承的类中   
        JavaFileObject file = new JavaSourceFromString("Sim", str.toString());  
        Iterable compilationUnits = Arrays.asList(file);  
        //建立一个编译任务  
        JavaCompiler.CompilationTask task = compiler.getTask(null, null, null, null, null, compilationUnits);  
        //编译源程序
        boolean result = task.call();  
        if (result)   
        {  
            return Class.forName("Sim");  
        }  
        return null;  
    }  
}  
  
class JavaSourceFromString extends SimpleJavaFileObject   
{  
    private String name;  
    private String code;  
    public JavaSourceFromString(String name, String code)  
    {  
        super(URI.create("string:///" + name.replace('.', '/') + Kind.SOURCE.extension), Kind.SOURCE);  
        this.code = code;  
    }  
  
    public CharSequence getCharContent(boolean ignoreEncodingErrors)  
    {  
        return code;  
    }  
}  
