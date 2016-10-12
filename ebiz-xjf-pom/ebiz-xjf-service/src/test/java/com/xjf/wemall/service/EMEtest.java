package com.xjf.wemall.service;

import java.io.ByteArrayInputStream;  
  



import org.apache.axiom.om.OMAbstractFactory;
import org.apache.axiom.om.OMElement;  
import org.apache.axiom.om.OMFactory;
import org.apache.axiom.om.OMNamespace;
//import org.apache.axiom.om.impl.builder.StAXOMBuilder;  
//import org.apache.axis2.databinding.utils.BeanUtil;  
//import org.apache.axis2.engine.DefaultObjectSupplier;  
//import org.dom4j.Document;  
//import org.dom4j.DocumentHelper;  
  
public class EMEtest  
{  
    public static void main(String[] arg) {
    	OMFactory fac = OMAbstractFactory.getOMFactory();
		OMNamespace omNs = fac.createOMNamespace("www.baidu.com",
				"tns");
		OMElement header = fac.createOMElement("RequestSOAPHeader", omNs);
		OMElement ome_user = fac.createOMElement("spId", omNs);
		OMElement ome_pass = fac.createOMElement("spPassword", omNs);

		ome_user.setText("text1");
		ome_pass.setText("text2");

		header.addChild(ome_user);
		header.addChild(ome_pass);
		System.out.println(header);
		//return header;
    }
}   