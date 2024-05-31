package cn.iocoder.yudao.module.infra.controller.admin.file.vo.file;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * 获取OSS上传文件授权返回结果
 * @auther 团子
 * @date 2019-07-31 11:31
 */

@Schema(description = "管理后台 - 获取OSS上传文件授权返回结果")
@Data
public class OssPolicyResult {
    @Schema(description = "访问身份验证中用到用户标识", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "访问身份验证中用到用户标识")
    private String accessKeyId;

    @Schema(description = "用户表单上传的策略,经过base64编码过的字符串", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "用户表单上传的策略")
    private String policy;

    @Schema(description = "对policy签名后的字符串", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "对policy签名后的字符串")
    private String signature;

    @Schema(description = "上传文件夹路径前缀", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "上传文件夹路径前缀")
    private String dir;

    @Schema(description = "oss对外服务的访问域名", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "oss对外服务的访问域名")
    private String host;

    @Schema(description = "上传成功后的回调设置", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "上传成功后的回调设置")
    private String callback;
}