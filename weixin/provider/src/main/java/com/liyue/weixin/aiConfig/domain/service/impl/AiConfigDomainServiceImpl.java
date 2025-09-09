package com.liyue.weixin.aiConfig.domain.service.impl;

import com.liyue.weixin.aiConfig.domain.entity.AiConfigDO;
import com.liyue.weixin.aiConfig.domain.repo.AiConfigRepository;
import com.liyue.weixin.aiConfig.domain.service.AiConfigDomainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class AiConfigDomainServiceImpl implements AiConfigDomainService {

    @Autowired
    private AiConfigRepository aiConfigRepository;


    @Override
    public List<AiConfigDO> getAllAiConfigs() {
        return aiConfigRepository.findAll();
    }

    @Override
    public AiConfigDO getAiConfigById(Integer id) {
        return aiConfigRepository.findById(id);
    }

    @Override
    public void addAiConfig(AiConfigDO aiConfigDO) {
        aiConfigRepository.save(aiConfigDO);
    }

    @Override
    public void modifyAiConfig(AiConfigDO aiConfigDO) {
        aiConfigRepository.update(aiConfigDO);
    }

    @Override
    public void removeAiConfig(Integer id) {
        aiConfigRepository.deleteById(id);
    }
}
