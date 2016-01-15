package com.xjf.wemall.web.freemarker;
import java.util.List;
import com.xjf.wemall.api.constant.WemallConstants;

import freemarker.template.TemplateMethodModel;
import freemarker.template.TemplateModelException;

/**
 * 
 * @author tgou 实现静态资源自动多域名处理
 * 
 */
public class xiejfTest implements TemplateMethodModel {



    @Override
    public Object exec(List arguments) throws TemplateModelException {
        return WemallConstants.TIME;
    }
}

