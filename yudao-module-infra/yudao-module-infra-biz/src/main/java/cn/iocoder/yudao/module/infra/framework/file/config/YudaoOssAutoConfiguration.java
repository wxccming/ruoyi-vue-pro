package cn.iocoder.yudao.module.infra.framework.file.config;

import cn.iocoder.yudao.module.infra.framework.file.core.client.FileClientFactory;
import cn.iocoder.yudao.module.infra.framework.file.core.client.FileClientFactoryImpl;
import com.aliyun.oss.OSSClient;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 文件配置类
 *
 * @author 晟云鑫通
 */
@Configuration
@EnableConfigurationProperties({OssProperties.class})
public class YudaoOssAutoConfiguration {

    @Bean
    public OSSClient ossClient(OssProperties properties){
        return new OSSClient(properties.getEndpoint(), properties.getAccessKeyId(), properties.getAccessKeySecret());
    }
}
