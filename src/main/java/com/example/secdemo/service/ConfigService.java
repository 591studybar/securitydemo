package com.example.secdemo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author sharplee
 * @version 1.0.0
 * @ClassName com.example.secdemo.service.ConfigService
 * @Description
 * @createTime 2020/1/14
 */
@Service("config")
public class ConfigService {

    @Autowired
    private SysConfigService sysConfigService;


    public String getKey(String configKey)
    {
        return sysConfigService.selectConfigByKey(configKey);
    }

}
