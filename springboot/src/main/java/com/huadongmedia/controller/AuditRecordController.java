package com.huadongmedia.controller;

import com.huadongmedia.common.ResponseResult;
import com.huadongmedia.dto.AuditRecordDTO;
import com.huadongmedia.dto.request.AuditRecordRequest;
import com.huadongmedia.entity.AuditRecord;
import com.huadongmedia.service.AuditRecordService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.*;

/**
 * Created by wushiyuan on 2018/4/20 0020.
 */
@RestController
@EnableAutoConfiguration
@RequestMapping("/record")
public class AuditRecordController {

  @Autowired
  private AuditRecordService auditRecordService;

  @RequestMapping(value = "/getRecord",method = RequestMethod.GET)
  public ResponseResult<AuditRecordDTO> getById(@RequestParam Long id){
    ResponseResult<AuditRecordDTO> result = new ResponseResult<>();
    AuditRecord auditRecord = auditRecordService.getAuditRecordById(id);
    AuditRecordDTO dto = new AuditRecordDTO();
    BeanUtils.copyProperties(auditRecord,dto);
    result.setData(dto);
    return result;
  }

  @RequestMapping(value = "/getAtRandom",method = RequestMethod.POST)
  public ResponseResult<AuditRecord> getAtRandom(@RequestBody(required = false) AuditRecordRequest request){
    ResponseResult<AuditRecord> result = new ResponseResult<>();
    result.setData(auditRecordService.getAtRandom(request));
    return result;
  }

}
