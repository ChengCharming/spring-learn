package com.java.dao;

import java.util.List;

import com.java.bean.BaseDict;

public interface BaseDictDao {
	
	public List<BaseDict>  selectBaseDictByCode(String code);
}
