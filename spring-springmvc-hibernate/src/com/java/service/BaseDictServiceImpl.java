package com.java.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.java.bean.BaseDict;
import com.java.dao.BaseDictDao;

@Service
@Transactional
public class BaseDictServiceImpl implements BaseDictService {
	@Autowired
	private BaseDictDao baseDictDao;

	@Override
	public List<BaseDict> selectBaseDictByCode(String code) {
		return baseDictDao.selectBaseDictByCode(code);
	}

}
