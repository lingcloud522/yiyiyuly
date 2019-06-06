package com.lingcloud.service;

import com.lingcloud.dto.request.AuditRecordRequest;
import com.lingcloud.entity.AuditRecord;

/**
 * Created by wushiyuan on 2018/4/20 0020.
 */
public interface AuditRecordService {

  AuditRecord getAuditRecordById(Long id);

  AuditRecord getAtRandom(AuditRecordRequest request) throws Exception;

}
