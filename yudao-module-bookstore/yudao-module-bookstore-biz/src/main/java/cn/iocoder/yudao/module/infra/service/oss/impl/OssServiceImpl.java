package cn.iocoder.yudao.module.infra.service.oss.impl;

import cn.hutool.json.JSONUtil;
import cn.iocoder.yudao.module.infra.controller.admin.file.vo.file.OssCallbackParam;
import cn.iocoder.yudao.module.infra.controller.admin.file.vo.file.OssCallbackResult;
import cn.iocoder.yudao.module.infra.controller.admin.file.vo.file.OssPolicyResult;
import cn.iocoder.yudao.module.infra.enums.BookStoreErrorCodeConstants;
import cn.iocoder.yudao.module.infra.framework.file.config.OssConfig;
import cn.iocoder.yudao.module.infra.service.oss.OssService;
import com.aliyun.oss.OSSClient;
import com.aliyun.oss.common.utils.BinaryUtil;
import com.aliyun.oss.model.MatchMode;
import com.aliyun.oss.model.PolicyConditions;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.auth.sts.AssumeRoleRequest;
import com.aliyuncs.auth.sts.AssumeRoleResponse;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.http.ProtocolType;
import com.aliyuncs.profile.DefaultProfile;
import com.aliyuncs.profile.IClientProfile;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;

import static cn.iocoder.yudao.framework.common.exception.util.ServiceExceptionUtil.exception;

/**
 * @author 团子
 * @date 2019-10-27 14:48
 */
@Service
public class OssServiceImpl implements OssService {

    private static final Logger LOGGER = LoggerFactory.getLogger(OssServiceImpl.class);

    @Resource
    private OssConfig ossConfig;
    @Resource
    private OSSClient ossClient;

    @Override
    public AssumeRoleResponse.Credentials sts() {
        //roleSessionName时临时Token的会话名称，自己指定用于标识你的用户，或者用于区分Token颁发给谁
        try {
            // 创建一个 Aliyun Acs Client, 用于发起 OpenAPI 请求
            DefaultProfile.addEndpoint( "", "Sts", ossConfig.getStsEndpoint());
            IClientProfile profile = DefaultProfile.getProfile("", ossConfig.getAccessKeyId(), ossConfig.getAccessKeySecret());
            DefaultAcsClient client = new DefaultAcsClient(profile);
            // 创建一个 AssumeRoleRequest 并设置请求参数
            final AssumeRoleRequest request = new AssumeRoleRequest();
            //POST请求
            request.setMethod(MethodType.POST);
            //https协议
            request.setProtocol(ProtocolType.HTTPS);
            //持续时间, 只能设置 15min - 1hr 之间
            request.setDurationSeconds(Long.valueOf(ossConfig.getExpire()));
            //角色id
            request.setRoleArn(ossConfig.getRoleArn());
            //应用程序标识(自己定义)
            request.setRoleSessionName(ossConfig.getRoleSessionName());
            // 发起请求，并得到response
            AssumeRoleResponse acsResponse = client.getAcsResponse(request);
            return acsResponse.getCredentials();
        } catch (Exception e) {
            throw exception(BookStoreErrorCodeConstants.OSS_STS_SIGN_FAIL);
        }
    }
}
