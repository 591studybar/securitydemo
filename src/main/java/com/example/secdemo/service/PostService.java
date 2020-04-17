package com.example.secdemo.service;

import com.example.secdemo.model.SysPost;

import java.util.List;

/**
 * @author sharplee
 * @version 1.0.0
 * @ClassName com.example.secdemo.service.PostService
 * @Description
 * @createTime 2020/1/14
 */
public interface PostService {
    List<SysPost> selectPostAll();
}
