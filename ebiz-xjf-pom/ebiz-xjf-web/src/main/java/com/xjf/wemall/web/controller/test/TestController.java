/*
 * Copyright (C), 2013-2014, 上海汽车集团股份有限公司
 * FileName: ProductController.java
 * Author:   yzq
 * Date:     2014年8月21日 下午5:29:17
 * Description: //模块目的、功能描述      
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名             修改时间            版本号                  描述
 */
package com.xjf.wemall.web.controller.test;


import java.util.List;
import java.util.ArrayList;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mysql.fabric.xmlrpc.base.Array;
import com.xjf.wemall.annotation.NeedLogin;
import com.xjf.wemall.api.constant.WemallConstants;
import com.xjf.wemall.api.entity.common.AjaxObject;
import com.xjf.wemall.api.util.Base64Operate;
import com.xjf.wemall.api.util.JSONParser;
import com.xjf.wemall.api.util.URLUtil;
import com.xjf.wemall.web.controller.BaseController;
import com.xjf.wemall.web.factory.BeanFactory;

/**
 * 系统参数controller<br> 
 * 〈功能详细描述〉
 *
 * @author xiejiefeng
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
@Controller
@RequestMapping("/test")
public class TestController extends BaseController {
	@Autowired
	private BeanFactory beanFactory;
    
    @SuppressWarnings("unchecked")
    @RequestMapping(value = "/initJS")
    @ResponseBody
    public String initCxbNative(String execType, String jsonPara, HttpServletResponse response)
            throws Exception {
        
        StringBuffer temp = new StringBuffer();
        // push车享宝native唤起使用的js
        temp.append("<script language=\"javascript\" type=\"text/javascript\" src=\""
                + "http://s1.preimg.com" + "/jssdk/1.0.0/lb.js?j=1458890845125\">");
        temp.append("</script>");
        // 唤醒车享宝native-service所用js
        temp.append("<script language=\"javascript\" type=\"text/javascript\" src=\""
                + "http://s1.preimg.com"
                + "/jssdk/lbservice/lbservice.js?j=1458890845144\">");
        temp.append("</script>");
        temp.append("<script language=\"javascript\" type=\"text/javascript\" src=\""
                + "http://s1.preimg.com"
                + "/wemallweb/js/base64.js?t=20160325152343\">");
        temp.append("</script>");
        temp.append("<script language=\"javascript\" type=\"text/javascript\" src=\""
                + "http://s1.preimg.com"
                + "/wemallweb/js/jqmin.js?t=20160325152343\">");
        temp.append("</script>");
        temp.append("<script>");
        // push操作状态
        temp.append("var execType=\"" + execType + "\";");

        Map<String, String> sPara = null;
        if (!StringUtils.isEmpty(jsonPara) && !StringUtils.isEmpty(jsonPara.trim())) {
            try {
                sPara = JSONParser.toStringObject(URLUtil.decode(jsonPara), Map.class);
                for (Map.Entry<String, String> entry : sPara.entrySet()) {
                    temp.append("var " + entry.getKey() + "=\"" + entry.getValue() + "\";");
                }
            } catch (Exception e) {
                logger.info("CxbController -- initCxbNative paraMap to json wrong");
            }
        }
        /******************** 公用js ********************************/
        temp.append("var userInfoJsonObject = {};");
        temp.append("");
        temp.append("function redUrl(backUrl, url) {");
        temp.append("    var resultUrl = \"\";");
        temp.append("    if (backUrl.indexOf(\"?\") > -1) {");
        temp.append("        resultUrl = backUrl + \"&\" + url;");
        temp.append("    } else {");
        temp.append("        resultUrl = backUrl + \"?\" + url;");
        temp.append("    }");
        temp.append("    window.location.href = resultUrl;");
        temp.append("}");
        temp.append("");
        temp.append("function lbLogin() {");
        temp.append("    lb.redirect(\"login\",");
        temp.append("    function(data) {");
        temp.append("        if (data.errorCode == \'0\') {");
        temp.append("            getUserInfo();");
        temp.append("        } else {}");
        temp.append("    })");
        temp.append("}");
        temp.append("");
        temp.append("function getUserInfo() {");
        temp.append("    lbService.getUserInfoCXJ(function(data) {");
        temp.append("        if (data.errorCode == \'0\') {");
        temp.append("            userInfoJsonObject = {};");
        temp.append("            userInfoJsonObject.userId = data.text.userId;");
        temp.append("            userInfoJsonObject.custName = data.text.custName;");
        temp.append("            userInfoJsonObject.mobilePhone = data.text.mobilePhone;");
        temp.append("            userInfoJsonObject.sourceType = 2;");
        temp.append("            userInfoJsonObject.equId = data.text.equId;");
        temp.append("            userInfoJsonObject.cityName = data.text.cityName;");
        temp.append("            userInfoJsonObject.localX = data.text.localX;");
        temp.append("            userInfoJsonObject.localY = data.text.localY;");
        temp.append(
                "            redUrl(back_redirect_url, (\"userInfo=\" + base64encode(encodeURI(JSON.stringify(userInfoJsonObject)))));");
        temp.append("        }");
        temp.append("    })");
        temp.append("}");
        temp.append("");
        temp.append("function lbGetDefaultCarInfo() {");
        temp.append("    var option = {");
        temp.append("        \"bizType\": 101");
        temp.append("    };");
        temp.append("    userInfoJsonObject = {};");
        temp.append("    lbService.getCarInfo(option,");
        temp.append("    function(data) {");
        temp.append("        userInfoJsonObject = data;");
        temp.append(
                "        if (!userInfoJsonObject || !userInfoJsonObject.uid || !userInfoJsonObject.carMdmId || !userInfoJsonObject.assetId || !userInfoJsonObject.carYear) {");
        temp.append("            lbGetCarInfo();");
        temp.append("        } else {");
        temp.append("            userInfoJsonObject.userId = userInfoJsonObject.uid;");
        temp.append("            userInfoJsonObject.sourceType = 2;");
        temp.append(
                "            redUrl(back_redirect_url, (\"userInfo=\" + base64encode(encodeURI(JSON.stringify(userInfoJsonObject)))));");
        temp.append("        }");
        temp.append("    });");
        temp.append("}");
        temp.append("");
        temp.append("function lbGetCarInfo() {");
        temp.append("    lb.getCarInfo(101,");
        temp.append("    function(data) {");
        temp.append("        if (data.errorCode == \'0\') {");
        temp.append("            userInfoJsonObject = {};");
        temp.append("            userInfoJsonObject.carMdmId = data.text.carMdmId;");
        temp.append("            userInfoJsonObject.assetId = data.text.assetId;");
        temp.append("            userInfoJsonObject.carYear = data.text.carYear;");
        temp.append("            userInfoJsonObject.userId = data.text.UID;");
        temp.append("            userInfoJsonObject.sourceType = 2;");
        temp.append(
                "            if (!userInfoJsonObject || !userInfoJsonObject.userId || !userInfoJsonObject.carMdmId || !userInfoJsonObject.assetId || !userInfoJsonObject.carYear) {} else {");
        temp.append(
                "                redUrl(back_redirect_url, (\"userInfo=\" + base64encode(encodeURI(JSON.stringify(userInfoJsonObject)))));");
        temp.append("            }");
        temp.append("        } else {}");
        temp.append("    })");
        temp.append("}");
        temp.append("");
        temp.append("function reloadPay() {");
        temp.append(
                "    window.location.href = \"/order/detail_preorder.htm?orderNo=\" + orderId;");
        temp.append("}");
        temp.append("");
        temp.append("function lbPay() {");
        temp.append("    var payInfo = {};");
        temp.append("    payInfo.partner = partner;");
        temp.append("    payInfo.orderId = orderId;");
        temp.append("    payInfo.txnAmount = txnAmount;");
        temp.append("    payInfo.mdseName = mdseName;");
        temp.append("    payInfo.body = body;");
        temp.append("    payInfo.returnUrl = returnUrl;");
        temp.append("    payInfo.notifyUrl = notifyUrl;");
        temp.append("    payInfo.finishUrl = finishUrl;");
        temp.append("    payInfo.timeout = timeout;");
        temp.append("    payInfo.sign = decodeURI(sign);");
        temp.append("    payInfo.terminalType = terminalType;");
        temp.append("    payInfo.storeId = storeId;");
        temp.append("    lb.pay(payInfo,");
        temp.append("    function(data) {");
        temp.append("        if (data.errorCode == \'0\') {");
        temp.append("            paySuccess(\"success\");");
        temp.append("        } else if (data.errorCode == \'1\') {");
        temp.append(
                "            window.location.href = \"/order/detail_preorder.htm?orderNo=\" + orderId;");
        temp.append("        } else {");
        temp.append(
                "            window.location.href = \"/order/detail_preorder.htm?orderNo=\" + orderId + \"&payFail=true\";");
        temp.append("        }");
        temp.append("    })");
        temp.append("}");
        temp.append("");
        temp.append("function paySuccess(payStatus) {");
        temp.append("    if (payStatus != \"success\") {");
        temp.append(
                "        window.location.href = \"/order/detail_preorder.htm?orderNo=\" + orderId;");
        temp.append("    } else {");
        temp.append("        $(\"#paySuccessButton\").click(function() {");
        temp.append("            paySuccess(\"success\");");
        temp.append("        });");
        temp.append("        window.location.href = \"/service/success.htm?orderNo=\" + orderId;");
        temp.append("    }");
        temp.append("}");
        temp.append("</script>");
        temp.append("<script>");
        /******************** 状态js ********************************/
        temp.append("$(document).ready(");
        temp.append("       function(){");
        temp.append("           alert('aaaaaa');");
        temp.append("       }");
        temp.append("     );");
        
        temp.append("</script>");
        response.getWriter().append(temp.toString());
        response.flushBuffer();
        return null;
    }
    
}