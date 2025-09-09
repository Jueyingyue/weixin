package com.liyue.weixin.aiConfig.domain.repo;

import com.liyue.weixin.aiConfig.domain.entity.AiConfigDO;
import java.util.List;

public interface AiConfigRepository {
    List<AiConfigDO> findAll();
    AiConfigDO findById(Integer id);
    void save(AiConfigDO aiConfigDO);
    void update(AiConfigDO aiConfigDO);
    void deleteById(Integer id);
}
