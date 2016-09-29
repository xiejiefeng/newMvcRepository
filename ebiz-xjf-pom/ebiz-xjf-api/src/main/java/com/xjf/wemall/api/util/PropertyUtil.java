package com.xjf.wemall.api.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

/**
 * Properties文件配置
 */
public class PropertyUtil {

    private static Properties prepayProp = null;
	
    public static Properties getPrepayProperties() {
        return prepayProp;  
    }
    
    static {
    	Resource rs = new ClassPathResource("application-javaSource.properties");
    	prepayProp = new Properties();  
		try {
			prepayProp.load(new FileInputStream(rs.getFile()));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
    }
    
}
