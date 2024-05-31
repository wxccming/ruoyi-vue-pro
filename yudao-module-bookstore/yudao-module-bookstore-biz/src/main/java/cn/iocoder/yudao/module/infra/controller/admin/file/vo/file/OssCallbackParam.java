package cn.iocoder.yudao.module.infra.controller.admin.file.vo.file;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import javax.validation.constraints.NotNull;


/**
 * oss上传成功后的回调参数
 * @author 团子
 * @date 2019-07-31 11:31
 */
@Schema(description = "管理后台 - oss上传成功后的回调参数")
@Data
public class OssCallbackParam {
    @Schema(description = "请求的回调地址", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "请求的回调地址")
    private String callbackUrl;

    @Schema(description = "回调是传入request中的参数", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "回调是传入request中的参数")
    private String callbackBody;

    @Schema(description = "回调时传入参数的格式，比如表单提交形式", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "回调时传入参数的格式，比如表单提交形式")
    private String callbackBodyType;

}