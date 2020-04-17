package com.example.secdemo.service.impl;

import com.example.secdemo.dao.SysPostDao;
import com.example.secdemo.model.SysPost;
import com.example.secdemo.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author sharplee
 * @version 1.0.0
 * @ClassName com.example.secdemo.service.impl.PostServiceImpl
 * @Description
 * @createTime 2020/1/14
 */
@Service
public class PostServiceImpl implements PostService {

    @Autowired
    private SysPostDao sysPostDao ;

    @Override
    public List<SysPost> selectPostAll() {
        return sysPostDao.selectPostAll();
    }
}
