package com.java.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import com.java.dao.mapper.ItemsMapper;
import com.java.pojo.Items;

@Service
public class ItemsServiceImpl implements ItemsService {
	@Autowired
	private ItemsMapper itemsMapper;
	@Override
	public List<Items> selectAllItems(){
		return itemsMapper.selectAll();
	}
	@Override
	public Items selectByid(Integer id) {
		return itemsMapper.selectByid(id);
	}
	@Override
	public void updateItems(Items item) {
		itemsMapper.updateItems(item);
	}
	
	

	
}
