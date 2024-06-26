package cn.iocoder.yudao.module.infra.controller.admin.bookchapter.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import java.util.*;
import javax.validation.constraints.*;

@Schema(description = "管理后台 - 图书章节新增/修改 Request VO")
@Data
public class BookChapterSaveReqVO {

    @Schema(description = "编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "13160")
    private Long id;

    @Schema(description = "章节编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "4649")
    @NotEmpty(message = "章节编号不能为空")
    private String chapterId;

    @Schema(description = "章节名称", requiredMode = Schema.RequiredMode.REQUIRED, example = "王五")
    @NotEmpty(message = "章节名称不能为空")
    private String chapterName;

    @Schema(description = "父节点ID(上级章节ID)章节名称", requiredMode = Schema.RequiredMode.REQUIRED, example = "21395")
    @NotEmpty(message = "父节点ID(上级章节ID)章节名称不能为空")
    private String chapterPid;

    @Schema(description = "父章节名称", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotEmpty(message = "父章节名称不能为空")
    private String chapterPtitle;

    @Schema(description = "图书编号")
    private String bookNo;

    @Schema(description = "章节等级")
    private Long depth;

    @Schema(description = "是否最小节点", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotEmpty(message = "是否最小节点不能为空")
    private String isLeaf;

    @Schema(description = "排序")
    private String chapterSeq;

    @Schema(description = "状态", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotEmpty(message = "状态不能为空")
    private String chapterStatus;

}