package com.java.mapper;

import java.util.List;

import com.java.pojo.Orders;
import com.java.pojo.User;

public interface OrderMapper {

	//查询订单所有数据
	public List<Orders>  selectOrdersList();
	public List<Orders>  selectOrdersByidnumber(Orders o);
	
	//根据多个id查询orders
	public List<Orders>  selectOrdersByids(Integer [] ids);
	//一对一查询，以订单为中心
	public List<Orders>  selectOrders();
	//一对多关联，以用户为中心
	public  List<User>  selectUserList();
	 
}
