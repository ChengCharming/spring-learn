package com.java.crm.service;

import java.util.List;

import com.java.crm.pojo.BaseDict;

public interface BaseDictService {

	// 查询
	public List<BaseDict> selectBaseDictListByCode(String code);

}
