package com.java.crm.mapper;

import java.util.List;

import com.java.crm.pojo.BaseDict;

public interface BaseDictMapper {

	//查询
	public List<BaseDict> selectBaseDictListByCode(String code);
	
}
