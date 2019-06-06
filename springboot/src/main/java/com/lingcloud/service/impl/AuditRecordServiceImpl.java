package com.lingcloud.service.impl;

import com.lingcloud.dto.request.AuditRecordRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import com.lingcloud.entity.AuditRecord;
import com.lingcloud.mapper.AuditRecordMapper;
import com.lingcloud.service.AuditRecordService;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;

/**
 * Created by wushiyuan on 2018/4/20 0020.
 */
@Service
public class AuditRecordServiceImpl implements AuditRecordService {

  @Autowired
  private AuditRecordMapper auditRecordMapper;
  @Autowired
  private TransactionTemplate transactionTemplate;
  @Autowired
  private JdbcTemplate jdbcTemplate;

  @Override
  public AuditRecord getAuditRecordById(Long id) {
    AuditRecord audit = auditRecordMapper.selectById(id);
    return audit;
  }

  @Override
  @Transactional(propagation = Propagation.REQUIRED)
  public AuditRecord getAtRandom(final AuditRecordRequest request) throws Exception {
    testNested();
    return null;
    //throw new Exception("123");
  }

  public void testNested(){
    transactionTemplate.execute(new TransactionCallback<Object>() {
      @Override
      public Object doInTransaction(TransactionStatus status) {
        //AuditRecord auditRecord = auditRecordMapper.selectAtRandom(request);
        auditRecordMapper.update();
        jdbcTemplate.execute("update article set trial_state = 'trialPass' where id = "+1);
        Integer result = 1/1;
        return result;
      }
    });
  }
}
