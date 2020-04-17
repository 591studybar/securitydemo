package com.example.secdemo.dao;

import com.example.secdemo.model.SysConfig;

/**
 * @author sharplee
 * @version 1.0.0
 * @ClassName com.example.secdemo.dao.SysConfigDao
 * @Description
 * @createTime 2020/1/14
 */
public interface SysConfigDao {
    SysConfig selectConfig(SysConfig config);
}
