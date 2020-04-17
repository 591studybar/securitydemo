package com.example.secdemo.service;

import com.example.secdemo.model.SysDictData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author sharplee
 * @version 1.0.0
 * @ClassName com.example.secdemo.service.DictService
 * @Description
 * @createTime 2020/1/14
 */
@Service("dict")
public class DictService {

    @Autowired
    private SySDictService sysDictService;

    public List<SysDictData> getType(String type){
       return  sysDictService.getSysDictDataByType(type);
    }
}
