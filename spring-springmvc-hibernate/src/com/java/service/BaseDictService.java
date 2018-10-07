package com.java.service;

import java.util.List;

import com.java.bean.BaseDict;

public interface BaseDictService {

	public List<BaseDict>  selectBaseDictByCode(String code);
	
}
