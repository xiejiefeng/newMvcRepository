/*
 * Copyright (C), 2013-2014, 上海汽车集团股份有限公司
 * FileName: NumberUtil.java
 * Author:   wanglijun
 * Date:     2014年9月3日 下午5:11:21
 * Description: //模块目的、功能描述      
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名             修改时间            版本号                  描述
 */
package com.xjf.wemall.api.util;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;

import org.springframework.util.StringUtils;

/**
 * 数字工具类<br>
 * 〈功能详细描述〉
 * 
 * @author wanglijun
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public  final class NumberUtil {
    /**保留正数*/
    public static final String POSITIVE_NUMBER="#";
    /**保留一位小数,并四舍五入*/
    public static final String DECIMAL_POINT_1="#.#";
    /**保留一位小数,并四舍五入*/
    public static final String DECIMAL_POINT_2="#.##";
    /***
     * 
     * 功能描述:格式化保留两位小数  四舍五入<br>
     * 〈功能详细描述〉
     *
     * @param number
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    public static Double format(Double number) {
        DecimalFormat df = new DecimalFormat("#.##");
        df.setRoundingMode(RoundingMode.HALF_UP);
        return Double.parseDouble(df.format(number));
    }
    
    /***
     * 
     * 功能描述:格式化保留两位小数  四舍五入<br>
     * 〈功能详细描述〉
     *
     * @param number
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    public static Double toDouble(String number) {
        DecimalFormat df = new DecimalFormat("#.##");
        df.setRoundingMode(RoundingMode.HALF_UP);
        return Double.parseDouble(df.format(number));
    }
    
    /***
     * 
     * 功能描述:根据格式保留转换为字符串<br>
     * 〈功能详细描述〉
     *
     * @param number
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    public static String format(Double number, String pettern) {
        DecimalFormat df = new DecimalFormat(pettern);
        df.setRoundingMode(RoundingMode.HALF_UP);
        return df.format(number);
    }
    
    /***
     * 
     * 功能描述:转换为字符串(保留两位小数)<br>
     * 〈功能详细描述〉
     *
     * @param number
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    public static String formatPoint2(BigDecimal number) {
        DecimalFormat df = new DecimalFormat(DECIMAL_POINT_2);
        df.setRoundingMode(RoundingMode.HALF_UP);
        return df.format(number);
    }
    
    /***
     * 
     * 功能描述:根据格式保留转换为字符串<br>
     * 〈功能详细描述〉
     *
     * @param number
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    public static String format(BigDecimal number, String pettern) {
        DecimalFormat df = new DecimalFormat(pettern);
        df.setRoundingMode(RoundingMode.HALF_UP);
        return df.format(number);
    }
    
    /**
     * 
     * 功能描述: 字符串转BigDecimal<br>
     * Empty或Null或非数字型，默认转换为Zero
     *
     * @param str
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    public static BigDecimal toBigDecimal(final String str) {
        if (StringUtils.isEmpty(str)) {
            return BigDecimal.ZERO;
        }
        try {
            return new BigDecimal(str);
        } catch (final NumberFormatException nfe) {
            return BigDecimal.ZERO;
        }
    }
    
    
    public static void main(String[] args) {
       String str=NumberUtil.format(920.866D,NumberUtil.DECIMAL_POINT_2);
       System.out.println(str);
    }
}
