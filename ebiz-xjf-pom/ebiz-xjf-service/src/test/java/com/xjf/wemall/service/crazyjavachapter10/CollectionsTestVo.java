package com.xjf.wemall.service.crazyjavachapter10;

public class CollectionsTestVo implements Comparable<CollectionsTestVo> {
	private String id;
	private String name;
	public CollectionsTestVo(String id) {
		this.id = id;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public int compareTo(CollectionsTestVo o) {
		if (this.id.compareTo(o.getId()) <= 0) {
			return -1;
		} else {
			return 1;
		}
	}
}
