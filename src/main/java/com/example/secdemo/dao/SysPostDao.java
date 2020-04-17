package com.example.secdemo.dao;

import com.example.secdemo.model.SysPost;

import java.util.List;

/**
 * @author sharplee
 * @version 1.0.0
 * @ClassName com.example.secdemo.dao.SysPostDao
 * @Description
 * @createTime 2020/1/14
 */
public interface SysPostDao {

    List<SysPost> selectPostAll();
}
