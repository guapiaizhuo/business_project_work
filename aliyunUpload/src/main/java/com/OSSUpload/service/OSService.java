package com.OSSUpload.service;

import com.OSSUpload.model.OSSResult;
import com.aliyun.oss.model.OSSObjectSummary;
import jakarta.servlet.ServletOutputStream;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface OSService {
    OSSResult upload(MultipartFile uploadFile);

    OSSResult delete(String objectName);

    List<OSSObjectSummary> list();

    void exportOssFile(ServletOutputStream os, String objectName) throws IOException;

}
