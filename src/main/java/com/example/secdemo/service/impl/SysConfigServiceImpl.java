package com.example.secdemo.service.impl;

import com.example.secdemo.dao.SysConfigDao;
import com.example.secdemo.model.SysConfig;
import com.example.secdemo.model.SysDept;
import com.example.secdemo.service.SysConfigService;
import com.example.secdemo.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author sharplee
 * @version 1.0.0
 * @ClassName com.example.secdemo.service.impl.SysConfigServiceImpl
 * @Description
 * @createTime 2020/1/14
 */
@Service
public class SysConfigServiceImpl implements SysConfigService {

    @Autowired
    private SysConfigDao sysConfigDao;

    @Override
    public String selectConfigByKey(String configKey) {
        SysConfig config = new SysConfig();
        config.setConfigKey(configKey);
        SysConfig retConfig = sysConfigDao.selectConfig(config);
        return StringUtils.isNotNull(retConfig) ? retConfig.getConfigValue() : "";
    }
}
