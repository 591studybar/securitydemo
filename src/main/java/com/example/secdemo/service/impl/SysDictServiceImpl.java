package com.example.secdemo.service.impl;

import com.example.secdemo.dao.SysDictDataDao;
import com.example.secdemo.model.SysDictData;
import com.example.secdemo.service.SySDictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author sharplee
 * @version 1.0.0
 * @ClassName com.example.secdemo.service.impl.SysDictServiceImpl
 * @Description
 * @createTime 2020/1/14
 */
@Service
public class SysDictServiceImpl implements SySDictService {

    @Autowired
    private SysDictDataDao sysDictDataDao;

    @Override
    public List<SysDictData> getSysDictDataByType(String type) {
        return sysDictDataDao.getDictDataByType(type);
    }
}
