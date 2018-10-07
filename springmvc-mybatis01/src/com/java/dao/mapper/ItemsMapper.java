package com.java.dao.mapper;

import java.util.List;

import com.java.pojo.Items;

public interface ItemsMapper {

    String selectName(Integer id);
    List<Items> selectAll();
    Items selectByid(Integer id);
    void updateItems(Items item);
}