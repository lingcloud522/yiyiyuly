package com.huadongmedia.controller;

import com.huadongmedia.util.FileUploadUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by wushiyuan on 2018/5/2 0002.
 */
@RestController
public class FileUploadController {

  @Autowired
  FileUploadUtil fileUploadUtil;

  @RequestMapping(value = "/upload",method = RequestMethod.POST)
  public String upload(HttpServletRequest request, @RequestParam("file") MultipartFile file) throws Exception {
    String path = request.getServletContext().getRealPath("/images");
    return fileUploadUtil.upload(file,path);
  }

}
