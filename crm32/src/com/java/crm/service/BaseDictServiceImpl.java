package com.java.crm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.java.crm.mapper.BaseDictMapper;
import com.java.crm.pojo.BaseDict;

@Service
//@Transactional
public class BaseDictServiceImpl implements BaseDictService {
	@Autowired
	private BaseDictMapper baseDictMapper;

	@Override
	public List<BaseDict> selectBaseDictListByCode(String code) {
		return baseDictMapper.selectBaseDictListByCode(code);
	}

}
