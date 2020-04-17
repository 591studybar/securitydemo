package com.example.secdemo.service;

import com.example.secdemo.model.SysDictData;

import java.util.List;

/**
 * @author sharplee
 * @version 1.0.0
 * @ClassName com.example.secdemo.service.SySDictService
 * @Description
 * @createTime 2020/1/14
 */
public interface SySDictService {

    List<SysDictData> getSysDictDataByType(String type);

}
