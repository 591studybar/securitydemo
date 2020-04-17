package com.example.secdemo.dao;

import com.example.secdemo.model.SysDictData;

import java.util.List;

/**
 * @author sharplee
 * @version 1.0.0
 * @ClassName com.example.secdemo.dao.SysDictDataDao
 * @Description
 * @createTime 2020/1/14
 */
public interface SysDictDataDao {

    List<SysDictData> getDictDataByType(String type);
}
