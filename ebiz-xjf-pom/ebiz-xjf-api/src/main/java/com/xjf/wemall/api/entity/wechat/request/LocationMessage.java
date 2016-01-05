/*
 * Copyright (C), 2013-2014, 上海汽车集团股份有限公司
 * FileName: LocationMessage.java
 * Author:   wanglijun
 * Date:     2014年8月19日 下午11:30:45
 * Description: //模块目的、功能描述      
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名             修改时间            版本号                  描述
 */
package com.xjf.wemall.api.entity.wechat.request;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * 地理位置消息<br> 
 * 〈功能详细描述〉
 *
 * @author wanglijun
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
@XStreamAlias("xml")
public class LocationMessage extends CMNMessage {
    /**地理位置消息:地理位置维度*/
    @XStreamAlias("Location_X")
    private double locationX;
    /**地理位置消息:地理位置经度*/
    @XStreamAlias("Location_Y")
    private double locationY;
    /**地理位置消息:地图缩放大小*/
    @XStreamAlias("Scale")
    private int scale;
    /**地理位置消息:地理位置信息*/
    @XStreamAlias("Label")
    private String label;
    /**
     * @return 地理位置维度
     */
    public double getLocationX() {
        return locationX;
    }
    /**
     * @param locationX 地理位置维度
     */
    public void setLocationX(double locationX) {
        this.locationX = locationX;
    }
    /**
     * @return the locationY 地理位置经度
     */
    public double getLocationY() {
        return locationY;
    }
    /**
     * @param locationY  地理位置经度
     */
    public void setLocationY(double locationY) {
        this.locationY = locationY;
    }
    /**
     * @return the scale 地图缩放大小
     */
    public int getScale() {
        return scale;
    }
    /**
     * @param scale the 地图缩放大小
     */
    public void setScale(int scale) {
        this.scale = scale;
    }
    /**
     * @return 地理位置信息
     */
    public String getLabel() {
        return label;
    }
    /**
     * @param label  地理位置信息
     */
    public void setLabel(String label) {
        this.label = label;
    }
    
    
}
