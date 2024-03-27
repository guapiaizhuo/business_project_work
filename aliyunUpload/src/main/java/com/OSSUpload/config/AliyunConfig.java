package com.OSSUpload.config;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSBuilder;
import com.aliyun.oss.OSSClient;
import com.aliyun.oss.OSSClientBuilder;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ConfigurationProperties(prefix = "aliyun")
@Data
public class AliyunConfig {
//    accessKeyId: LTAI5tHY12upkFof2aqGXCWL
//    accessKeySecret: fKF3tQ64lQQI68Xytg9SdNEBbMoJPD
//    endpoint: http://oss-cn-chengdu.aliyuncs.com
//    urlPrefix: http://zz-super-bucket.oss-cn-guangzhou.aliyuncs.com
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
