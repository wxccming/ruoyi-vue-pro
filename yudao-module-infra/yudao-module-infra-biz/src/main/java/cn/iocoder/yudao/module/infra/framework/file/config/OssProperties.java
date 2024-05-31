package cn.iocoder.yudao.module.infra.framework.file.config;

import cn.hutool.extra.spring.SpringUtil;
import cn.iocoder.yudao.module.infra.framework.file.core.client.s3.S3FileClientConfig;
import cn.iocoder.yudao.module.infra.service.file.FileConfigService;
import com.aliyun.oss.OSSClient;
import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.annotation.Validated;

/**
 * oss配置文件
 * @auther 团子
 * @date 2019-07-31 10:03
 */
@ConfigurationProperties(prefix = "aliyun.oss")
@Data
public class OssProperties {

    private String endpoint;
    private String accessKeyId;
    private String accessKeySecret;
    private int policyExpire;
    private int maxSize;
    private String bucketName;
    private String dirPrefix;
    private String callback;
}