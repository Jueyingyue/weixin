package com.liyue.weixin.aiConfig.infra.persistent.mapper;

import com.liyue.weixin.aiConfig.domain.entity.AiConfigDO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * ai_config 表对应的 Mapper 接口
 */
@Component
public interface AiConfigMapper {
    List<AiConfigDO> selectAll();
    AiConfigDO selectById(Integer id);
    int insert(AiConfigDO aiConfigDO);
    int update(AiConfigDO aiConfigDO);
    int deleteById(Integer id);
}
