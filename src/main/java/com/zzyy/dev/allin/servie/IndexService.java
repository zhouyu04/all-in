package com.zzyy.dev.allin.servie;

import com.zzyy.dev.allin.entity.Kvs;
import com.zzyy.dev.allin.entity.User;

public interface IndexService {
    Kvs getCodeByKey(String code);

    User getUserByname(String username);
}
