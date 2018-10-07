package com.java.service;

import java.util.List;

import com.java.pojo.Items;

public interface ItemsService {
	public List<Items> selectAllItems();
	public Items selectByid(Integer id);
	public void updateItems(Items item);
}
