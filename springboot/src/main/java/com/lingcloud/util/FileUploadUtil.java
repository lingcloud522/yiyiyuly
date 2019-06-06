package com.lingcloud.util;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

/**
 * Created by wushiyuan on 2018/5/2 0002.
 */
@Component
public class FileUploadUtil {

  /**
   * 文件上传
   * enctype设置为multipart/form-data
   * @param file
   * @return
   * @throws Exception
   */
  public String upload(MultipartFile file,String path) throws Exception{
    if(!file.isEmpty()){
      String filename = file.getOriginalFilename();
      File filepath = new File(path,filename);
      if(!filepath.getParentFile().exists()){
        filepath.getParentFile().mkdirs();
      }
      file.transferTo(new File(path+File.separator + filename));
      return "success";
    }
    return "fail";
  }

}
