package com.lingcloud.mapper;

import com.lingcloud.dto.request.AuditRecordRequest;
import com.lingcloud.entity.AuditRecord;
import org.apache.ibatis.annotations.Param;

/**
 * Created by wushiyuan on 2018/4/20 0020.
 */
public interface AuditRecordMapper {

  AuditRecord selectById(@Param("id") Long id);

  AuditRecord selectAtRandom(@Param("request") AuditRecordRequest request);
  Integer update();

}
