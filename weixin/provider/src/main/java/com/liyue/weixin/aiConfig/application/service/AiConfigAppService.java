package com.liyue.weixin.aiConfig.application.service;

import com.liyue.weixin.aiConfig.domain.entity.AiConfigDO;
import java.util.List;

public interface AiConfigAppService {
    List<AiConfigDO> listAll();
    AiConfigDO getById(Integer id);
    void create(AiConfigDO aiConfigDO);
    void update(AiConfigDO aiConfigDO);
    void delete(Integer id);
}
