package com.liyue.weixin.aiConfig.domain.service;

import com.liyue.weixin.aiConfig.domain.entity.AiConfigDO;
import java.util.List;

public interface AiConfigDomainService {
    List<AiConfigDO> getAllAiConfigs();
    AiConfigDO getAiConfigById(Integer id);
    void addAiConfig(AiConfigDO aiConfigDO);
    void modifyAiConfig(AiConfigDO aiConfigDO);
    void removeAiConfig(Integer id);
}
