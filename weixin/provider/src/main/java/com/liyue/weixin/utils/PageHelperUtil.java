package com.liyue.weixin.utils;

import java.util.Collections;
import java.util.List;

public class PageHelperUtil {

    /**
     * 通用的分页查询方法（基于内存中传入的完整 List<T> 进行分页，非数据库分页）
     *
     * @param pageNum  当前页码，从1开始，如果为null或小于1，默认为1
     * @param pageSize 每页条数，如果为null或小于1，默认为10
     * @param records  完整的数据列表（比如从数据库查询出来的所有数据），不能为null但允许为空集合
     * @return 分页结果 PageResult<T>，包含总记录数、当前页码、每页大小、当前页数据
     */
    public <T> PageResult queryTestRecordPageWithResult(
            int pageNum,
            int pageSize,
            List<T> records, int total) {

        // 1. 设置默认值
        pageNum = (pageNum == 0 || pageNum < 1) ? 1 : pageNum;
        pageSize = (pageSize == 0 || pageSize < 1) ? 10 : pageSize;

        // 3. 如果传入的 records 为 null 或空集合，直接返回空分页结果
        if (records == null || records.isEmpty()) {
            return new PageResult<>(0, pageNum, pageSize, Collections.emptyList());
        }

        // 4. 计算分页范围
        int fromIndex = (pageNum - 1) * pageSize;
        if (fromIndex >= total) {
            // 如果起始索引超过或等于总记录数，说明没有当前页数据了
            return new PageResult<>(total, pageNum, pageSize, Collections.emptyList());
        }

        // 5. 返回分页结果
        return new PageResult<>(total, pageNum, pageSize, records);
    }

}
