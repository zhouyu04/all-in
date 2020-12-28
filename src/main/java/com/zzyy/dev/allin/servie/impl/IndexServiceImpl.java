package com.zzyy.dev.allin.servie.impl;

import com.zzyy.dev.allin.entity.Kvs;
import com.zzyy.dev.allin.mapper.IndexMapper;
import com.zzyy.dev.allin.servie.IndexService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class IndexServiceImpl implements IndexService {

    @Resource
    IndexMapper indexMapper;

    @Override
    public Kvs getCodeByKey(String code) {

        return indexMapper.getCodeByKey(code);
    }
}
