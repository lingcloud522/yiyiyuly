package com.huadongmedia.service;

import com.huadongmedia.dto.request.AuditRecordRequest;
import com.huadongmedia.entity.AuditRecord;

/**
 * Created by wushiyuan on 2018/4/20 0020.
 */
public interface AuditRecordService {

  AuditRecord getAuditRecordById(Long id);

  AuditRecord getAtRandom(AuditRecordRequest request);

}
