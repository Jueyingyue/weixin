package com.liyue.weixin.aiConfig.infra.persistent;

import com.liyue.weixin.aiConfig.domain.entity.AiConfigDO;
import com.liyue.weixin.aiConfig.domain.repo.AiConfigRepository;
import com.liyue.weixin.aiConfig.infra.persistent.mapper.AiConfigMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class AiConfigRepositoryImpl implements AiConfigRepository {

    @Autowired
    private AiConfigMapper aiConfigMapper;

    @Override
    public List<AiConfigDO> findAll() {
        return aiConfigMapper.selectAll();
    }

    @Override
    public AiConfigDO findById(Integer id) {
        return aiConfigMapper.selectById(id);
    }

    @Override
    public void save(AiConfigDO aiConfigDO) {
        aiConfigMapper.insert(aiConfigDO);
    }

    @Override
    public void update(AiConfigDO aiConfigDO) {
        aiConfigMapper.update(aiConfigDO);
    }

    @Override
    public void deleteById(Integer id) {
        aiConfigMapper.deleteById(id);
    }
}
