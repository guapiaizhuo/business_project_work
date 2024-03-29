package com.OSSUpload.controller;

import com.OSSUpload.config.AliyunConfig;
import com.OSSUpload.model.OSSResult;
import com.OSSUpload.service.OSService;
import com.aliyun.oss.model.OSSObjectSummary;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/file")
public class UploadController {
    @Autowired
    private OSService fileUploadService;
    @Autowired
    private AliyunConfig aliyunConfig;

    /**
     * @author lastwhisper
     * @desc 文件上传到oss
     * @return FileUploadResult
     * @Param uploadFile
     */
    @RequestMapping("/upload")
    @ResponseBody
    public OSSResult upload(@RequestParam("file") MultipartFile uploadFile)
            throws Exception {
        return this.fileUploadService.upload(uploadFile);
    }

    /**
     * @return FileUploadResult
     * @desc 根据文件名删除oss上的文件
     * http://localhost:8080/file/delete?fileName=images/2019/04/28/1556429167175766.jpg
     * @author lastwhisper
     * @Param objectName
     */
    @RequestMapping("/delete")
    @ResponseBody
    public OSSResult delete(@RequestParam("fileName") String objectName)
            throws Exception {
        return this.fileUploadService.delete(objectName);
    }

    @RequestMapping("getEndPoint")
    @ResponseBody
    public Map<String,String> getEndPoint(){
        Map<String,String> map = new HashMap<>();
        map.put("url",aliyunConfig.getUrlPrefix());
        return map;
    }

    /**
     * @author lastwhisper
     * @desc 查询oss上的所有文件
     * http://localhost:8080/file/list
     * @return List<OSSObjectSummary>
     * @Param
     */
    @RequestMapping("/list")
    @ResponseBody
    public List<OSSObjectSummary> list()
            throws Exception {
        return this.fileUploadService.list();
    }

    /**
     * @author lastwhisper
     * @desc 根据文件名下载oss上的文件
     * @return
     * @Param objectName
     */
    @RequestMapping("/download")
    @ResponseBody
    public void download(@RequestParam("fileName") String objectName, HttpServletResponse response) throws IOException {
        //通知浏览器以附件形式下载
        response.setHeader("Content-Disposition",
                "attachment;filename=" + "/" + new String(objectName.getBytes(), "ISO-8859-1"));
        this.fileUploadService.exportOssFile(response.getOutputStream(),objectName);
    }
    @RequestMapping("/uploadIndex")
    public String uploadIndex() {
        System.out.println("index");
        return "upload-test";
    }
    @RequestMapping("/showIndex")
    public String showIndex() {
        System.out.println("index");
        return "show-test";
    }
}
