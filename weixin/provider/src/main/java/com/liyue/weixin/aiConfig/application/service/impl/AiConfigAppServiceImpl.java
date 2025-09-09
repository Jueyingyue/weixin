package com.liyue.weixin.aiConfig.application.service.impl;

import com.liyue.weixin.aiConfig.application.service.AiConfigAppService;
import com.liyue.weixin.aiConfig.domain.entity.AiConfigDO;
import com.liyue.weixin.aiConfig.domain.service.AiConfigDomainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AiConfigAppServiceImpl implements AiConfigAppService {

    @Autowired
    private AiConfigDomainService aiConfigDomainService;

    @Override
    public List<AiConfigDO> listAll() {
        return aiConfigDomainService.getAllAiConfigs();
    }

    @Override
    public AiConfigDO getById(Integer id) {
        return aiConfigDomainService.getAiConfigById(id);
    }

    @Override
    public void create(AiConfigDO aiConfigDO) {
        aiConfigDomainService.addAiConfig(aiConfigDO);
    }

    @Override
    public void update(AiConfigDO aiConfigDO) {
        aiConfigDomainService.modifyAiConfig(aiConfigDO);
    }

    @Override
    public void delete(Integer id) {
        aiConfigDomainService.removeAiConfig(id);
    }
}
