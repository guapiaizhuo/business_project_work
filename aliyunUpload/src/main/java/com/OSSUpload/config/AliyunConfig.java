package com.OSSUpload.config;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSBuilder;
import com.aliyun.oss.OSSClient;
import com.aliyun.oss.OSSClientBuilder;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@RefreshScope
@ConfigurationProperties(prefix = "aliyun")
@Data
public class AliyunConfig {
//    accessKeyId:
//    accessKeySecret:
//    endpoint: http://oss-cn-chengdu.aliyuncs.com
//    urlPrefix: bucket.oss-cn-guangzhou.aliyuncs.com
    private String bucketName;
    private String accessKeyId;
    private String accessKeySecret;
    private String endpoint;
    private String urlPrefix;

    @Bean
    public OSS oSSClient() {
        System.out.println(bucketName);
        return new OSSClientBuilder().build(endpoint,accessKeyId,accessKeySecret);
    }
}
