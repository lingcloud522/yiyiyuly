package com.huadongmedia.service.impl;

import com.huadongmedia.dto.request.AuditRecordRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.huadongmedia.entity.AuditRecord;
import com.huadongmedia.mapper.AuditRecordMapper;
import com.huadongmedia.service.AuditRecordService;

/**
 * Created by wushiyuan on 2018/4/20 0020.
 */
@Service
public class AuditRecordServiceImpl implements AuditRecordService {

  @Autowired
  private AuditRecordMapper auditRecordMapper;

  @Override
  public AuditRecord getAuditRecordById(Long id) {
    AuditRecord audit = auditRecordMapper.selectById(id);
    return audit;
  }

  @Override
  public AuditRecord getAtRandom(AuditRecordRequest request) {
    try{
      return auditRecordMapper.selectAtRandom(request);
    }catch (IllegalArgumentException e){
      e.getStackTrace();
    }
    return null;
  }
}
