package cn.iocoder.yudao.module.infra.controller.admin.file;

import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import cn.iocoder.yudao.module.infra.controller.admin.file.vo.file.OssCallbackResult;
import cn.iocoder.yudao.module.infra.controller.admin.file.vo.file.OssPolicyResult;
import cn.iocoder.yudao.module.infra.service.oss.OssService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import static cn.iocoder.yudao.framework.common.pojo.CommonResult.success;

/**
 * Oss相关操作接口
 * @auther 团子
 * @date 2019-07-31 11:31
 */
@Tag(name = "管理后台 - 文件存储-oss")
@RestController
@RequestMapping("/infra/file-oss")
@Validated
@Slf4j
public class OssController {

    public static final Logger logger = LoggerFactory.getLogger(OssController.class);

    @Resource
    private OssService ossService;

    @PostMapping("/policy")
    @Operation(summary = "oss上传签名生成", description = "oss上传签名生成")
    public CommonResult<OssPolicyResult> policy() {
        logger.info("policy --------------> start");
        OssPolicyResult result = ossService.policy();
        logger.info("policy --------------> end");
        return success(result);
    }

    @PostMapping("/callback")
    @Operation(summary = "oss上传成功回调", description = "oss上传成功回调地址设置")
    public CommonResult<OssCallbackResult> callback(HttpServletRequest request) {
        logger.info("callback --------------> start");
        OssCallbackResult ossCallbackResult = ossService.callback(request);
        logger.info("callback --------------> end");
        return CommonResult.success(ossCallbackResult);
    }
}
