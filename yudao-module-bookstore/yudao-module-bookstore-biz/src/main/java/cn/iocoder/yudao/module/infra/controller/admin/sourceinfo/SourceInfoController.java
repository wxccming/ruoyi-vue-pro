package cn.iocoder.yudao.module.infra.controller.admin.sourceinfo;

import org.springdoc.api.annotations.ParameterObject;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import org.springframework.validation.annotation.Validated;
import org.springframework.security.access.prepost.PreAuthorize;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Operation;

import javax.validation.constraints.*;
import javax.validation.*;
import javax.servlet.http.*;
import java.util.*;
import java.io.IOException;

import cn.iocoder.yudao.framework.common.pojo.PageParam;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;
import static cn.iocoder.yudao.framework.common.pojo.CommonResult.success;

import cn.iocoder.yudao.framework.excel.core.util.ExcelUtils;

import cn.iocoder.yudao.framework.apilog.core.annotation.ApiAccessLog;
import static cn.iocoder.yudao.framework.apilog.core.enums.OperateTypeEnum.*;

import cn.iocoder.yudao.module.infra.controller.admin.sourceinfo.vo.*;
import cn.iocoder.yudao.module.infra.dal.dataobject.sourceinfo.SourceInfoDO;
import cn.iocoder.yudao.module.infra.service.sourceinfo.SourceInfoService;

@Tag(name = "管理后台 - 资源信息")
@RestController
@RequestMapping("/infra/source-info")
@Validated
public class SourceInfoController {

    @Resource
    private SourceInfoService sourceInfoService;

    @PostMapping("/create")
    @Operation(summary = "创建资源信息")
    @PreAuthorize("@ss.hasPermission('infra:source-info:create')")
    public CommonResult<Long> createSourceInfo(@Valid @RequestBody SourceInfoSaveReqVO createReqVO) {
        return success(sourceInfoService.createSourceInfo(createReqVO));
    }

    @PutMapping("/update")
    @Operation(summary = "更新资源信息")
    @PreAuthorize("@ss.hasPermission('infra:source-info:update')")
    public CommonResult<Boolean> updateSourceInfo(@Valid @RequestBody SourceInfoSaveReqVO updateReqVO) {
        sourceInfoService.updateSourceInfo(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "删除资源信息")
    @Parameter(name = "id", description = "编号", required = true)
    @PreAuthorize("@ss.hasPermission('infra:source-info:delete')")
    public CommonResult<Boolean> deleteSourceInfo(@RequestParam("id") Long id) {
        sourceInfoService.deleteSourceInfo(id);
        return success(true);
    }

    @GetMapping("/get")
    @Operation(summary = "获得资源信息")
    @Parameter(name = "id", description = "编号", required = true, example = "1024")
    @PreAuthorize("@ss.hasPermission('infra:source-info:query')")
    public CommonResult<SourceInfoRespVO> getSourceInfo(@RequestParam("id") Long id) {
        SourceInfoDO sourceInfo = sourceInfoService.getSourceInfo(id);
        return success(BeanUtils.toBean(sourceInfo, SourceInfoRespVO.class));
    }

    @GetMapping("/page")
    @Operation(summary = "获得资源信息分页")
    @PreAuthorize("@ss.hasPermission('infra:source-info:query')")
    public CommonResult<PageResult<SourceInfoRespVO>> getSourceInfoPage(@Valid @ParameterObject SourceInfoPageReqVO pageReqVO) {
        //查询全部数据
        if(pageReqVO.getPageNo() <= 0 ){
            pageReqVO.setPageSize(PageParam.PAGE_SIZE_NONE);
        }
        PageResult<SourceInfoDO> pageResult = sourceInfoService.getSourceInfoPage(pageReqVO);
        return success(BeanUtils.toBean(pageResult, SourceInfoRespVO.class));
    }

    @GetMapping("/export-excel")
    @Operation(summary = "导出资源信息 Excel")
    @PreAuthorize("@ss.hasPermission('infra:source-info:export')")
    @ApiAccessLog(operateType = EXPORT)
    public void exportSourceInfoExcel(@Valid SourceInfoPageReqVO pageReqVO,
              HttpServletResponse response) throws IOException {
        pageReqVO.setPageSize(PageParam.PAGE_SIZE_NONE);
        List<SourceInfoDO> list = sourceInfoService.getSourceInfoPage(pageReqVO).getList();
        // 导出 Excel
        ExcelUtils.write(response, "资源信息.xls", "数据", SourceInfoRespVO.class,
                        BeanUtils.toBean(list, SourceInfoRespVO.class));
    }

}