package com.xjf.wemall.api.entity.user;

public class PointVo {
	
	// 微信openId 或 车享Id
	private String userId;
	
	// 经度
	private Double longitude;
	
	// 纬度
	private Double latitude;

	public PointVo() {
		super();
	}

	public PointVo(Double longitude, Double latitude) {
		super();
		this.longitude = longitude;
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

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "PointVo [longitude=" + longitude + ", latitude=" + latitude + "]";
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

}
