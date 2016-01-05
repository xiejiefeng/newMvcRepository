/*
 * Copyright (C), 2013-2014, 上海汽车集团股份有限公司
 * FileName: EventMessage.java
 * Author:   wanglijun
 * Date:     2014年8月19日 下午11:44:03
 * Description: //模块目的、功能描述      
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名             修改时间            版本号                  描述
 */
package com.xjf.wemall.api.entity.wechat.request;

import com.xjf.wemall.api.entity.wechat.message.Message;
import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * 接收事件推送消息<br> 
 * 〈功能详细描述〉
 *
 * @author wanglijun
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
@XStreamAlias("xml")
public class EventMessage extends Message {
    /**事件类型*/
    @XStreamAlias("Event")
    private String event;
    /**事件KEY值:事件KEY值，qrscene_为前缀，后面为二维码的参数值*/
    @XStreamAlias("EventKey")
    private String eventKey;
    /**二维码的ticket*/
    @XStreamAlias("Ticket")
    private String ticket;
    /**地理位置纬度*/
    @XStreamAlias("Latitude")
    private Double latitude;
    /**地理位置经度*/
    @XStreamAlias("Longitude")
    private Double longitude;
    /**地理位置精度*/
    @XStreamAlias("Precision")
    private Double precision;
    /**卡券ID*/
    @XStreamAlias("CardId")
    private Double cardId;
    /**是否为转赠，1 代表是，0 代表否*/
    @XStreamAlias("IsGiveByFriend")
    private Double isGiveByFriend;
    /**code 序列号*/
    @XStreamAlias("UserCardCode")
    private Double userCardCode;
    /**领取场景值，用于领取渠道数据统计*/
    @XStreamAlias("OuterId")
    private Double outerId;
    /**
     * @return the event
     */
    public String getEvent() {
        return event;
    }
    /**
     * @param event the event to set
     */
    public void setEvent(String event) {
        this.event = event;
    }
    /**
     * @return the eventKey
     */
    public String getEventKey() {
        return eventKey;
    }
    /**
     * @param eventKey the eventKey to set
     */
    public void setEventKey(String eventKey) {
        this.eventKey = eventKey;
    }
    /**
     * @return the ticket
     */
    public String getTicket() {
        return ticket;
    }
    /**
     * @param ticket the ticket to set
     */
    public void setTicket(String ticket) {
        this.ticket = ticket;
    }
    /**
     * @return the latitude
     */
    public Double getLatitude() {
        return latitude;
    }
    /**
     * @param latitude the latitude to set
     */
    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }
    /**
     * @return the longitude
     */
    public Double getLongitude() {
        return longitude;
    }
    /**
     * @param longitude the longitude to set
     */
    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }
    /**
     * @return the precision
     */
    public Double getPrecision() {
        return precision;
    }
    /**
     * @param precision the precision to set
     */
    public void setPrecision(Double precision) {
        this.precision = precision;
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return "EventMessage [event=" + event + ", eventKey=" + eventKey + ", ticket=" + ticket + ", latitude="
                + latitude + ", longitude=" + longitude + ", precision=" + precision
                + ", cardId=" + cardId + ", isGiveByFriend=" + isGiveByFriend + ", userCardCode=" + userCardCode + ", outerId=" + outerId+ "]";
    }
	/**
	 * @return the cardId
	 */
	public Double getCardId() {
		return cardId;
	}
	/**
	 * @param cardId the cardId to set
	 */
	public void setCardId(Double cardId) {
		this.cardId = cardId;
	}
	/**
	 * @return the isGiveByFriend
	 */
	public Double getIsGiveByFriend() {
		return isGiveByFriend;
	}
	/**
	 * @param isGiveByFriend the isGiveByFriend to set
	 */
	public void setIsGiveByFriend(Double isGiveByFriend) {
		this.isGiveByFriend = isGiveByFriend;
	}
	/**
	 * @return the userCardCode
	 */
	public Double getUserCardCode() {
		return userCardCode;
	}
	/**
	 * @param userCardCode the userCardCode to set
	 */
	public void setUserCardCode(Double userCardCode) {
		this.userCardCode = userCardCode;
	}
	/**
	 * @return the outerId
	 */
	public Double getOuterId() {
		return outerId;
	}
	/**
	 * @param outerId the outerId to set
	 */
	public void setOuterId(Double outerId) {
		this.outerId = outerId;
	}
  
    
    
}
