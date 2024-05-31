package cn.iocoder.yudao.module.infra.controller.admin.file.vo.file;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import javax.validation.constraints.NotNull;


/**
 * oss上传文件的回调结果
 * @author 团子
 * @date 2019-07-31 11:31
 */
@Schema(description = "管理后台 - oss上传文件的回调结果")
@Data
public class OssCallbackResult {
    @Schema(description = "文件名称", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "文件名称")
    private String filename;

    @Schema(description = "文件大小", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "文件大小")
    private String size;


    @Schema(description = "文件的mimeType", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "文件的mimeType")
    private String mimeType;


    @Schema(description = "图片文件的宽")
    private String width;
    @Schema(description = "图片文件的高")
    private String height;

}
