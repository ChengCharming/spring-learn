package com.java.pojo;

import java.sql.Date;

public class Items {

	private Integer id ;
	private String name;
	private String pic;
	private Date createtime;	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPic() {
		return pic;
	}
	public void setPic(String pic) {
		this.pic = pic;
	}
	public Date getCreatetime() {
		return createtime;
	}
	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}
	@Override
	public String toString() {
		return "Items [id=" + id + ", name=" + name + ", pic=" + pic + ", createtime=" + createtime + "]";
	}
	
	
	
}
