package cn.iocoder.yudao.module.infra.controller.admin.bookqtcodesource;

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

import cn.iocoder.yudao.module.infra.controller.admin.bookqtcodesource.vo.*;
import cn.iocoder.yudao.module.infra.dal.dataobject.bookqtcodesource.BookQtcodeSourceDO;
import cn.iocoder.yudao.module.infra.service.bookqtcodesource.BookQtcodeSourceService;

@Tag(name = "管理后台 - 二维码资源")
@RestController
@RequestMapping("/infra/book-qtcode-source")
@Validated
public class BookQtcodeSourceController {

    @Resource
    private BookQtcodeSourceService bookQtcodeSourceService;

    @PostMapping("/create")
    @Operation(summary = "创建二维码资源")
    @PreAuthorize("@ss.hasPermission('infra:book-qtcode-source:create')")
    public CommonResult<Long> createBookQtcodeSource(@Valid @RequestBody BookQtcodeSourceSaveReqVO createReqVO) {
        return success(bookQtcodeSourceService.createBookQtcodeSource(createReqVO));
    }

    @PutMapping("/update")
    @Operation(summary = "更新二维码资源")
    @PreAuthorize("@ss.hasPermission('infra:book-qtcode-source:update')")
    public CommonResult<Boolean> updateBookQtcodeSource(@Valid @RequestBody BookQtcodeSourceSaveReqVO updateReqVO) {
        bookQtcodeSourceService.updateBookQtcodeSource(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "删除二维码资源")
    @Parameter(name = "id", description = "编号", required = true)
    @PreAuthorize("@ss.hasPermission('infra:book-qtcode-source:delete')")
    public CommonResult<Boolean> deleteBookQtcodeSource(@RequestParam("id") Long id) {
        bookQtcodeSourceService.deleteBookQtcodeSource(id);
        return success(true);
    }

    @GetMapping("/get")
    @Operation(summary = "获得二维码资源")
    @Parameter(name = "id", description = "编号", required = true, example = "1024")
    @PreAuthorize("@ss.hasPermission('infra:book-qtcode-source:query')")
    public CommonResult<BookQtcodeSourceRespVO> getBookQtcodeSource(@RequestParam("id") Long id) {
        BookQtcodeSourceDO bookQtcodeSource = bookQtcodeSourceService.getBookQtcodeSource(id);
        return success(BeanUtils.toBean(bookQtcodeSource, BookQtcodeSourceRespVO.class));
    }

    @GetMapping("/page")
    @Operation(summary = "获得二维码资源分页")
    @PreAuthorize("@ss.hasPermission('infra:book-qtcode-source:query')")
    public CommonResult<PageResult<BookQtcodeSourceRespVO>> getBookQtcodeSourcePage(@Valid @ParameterObject BookQtcodeSourcePageReqVO pageReqVO) {
        //查询全部数据
        if(pageReqVO.getPageNo() <= 0 ){
            pageReqVO.setPageSize(PageParam.PAGE_SIZE_NONE);
        }
        PageResult<BookQtcodeSourceDO> pageResult = bookQtcodeSourceService.getBookQtcodeSourcePage(pageReqVO);
        return success(BeanUtils.toBean(pageResult, BookQtcodeSourceRespVO.class));
    }

    @GetMapping("/export-excel")
    @Operation(summary = "导出二维码资源 Excel")
    @PreAuthorize("@ss.hasPermission('infra:book-qtcode-source:export')")
    @ApiAccessLog(operateType = EXPORT)
    public void exportBookQtcodeSourceExcel(@Valid BookQtcodeSourcePageReqVO pageReqVO,
              HttpServletResponse response) throws IOException {
        pageReqVO.setPageSize(PageParam.PAGE_SIZE_NONE);
        List<BookQtcodeSourceDO> list = bookQtcodeSourceService.getBookQtcodeSourcePage(pageReqVO).getList();
        // 导出 Excel
        ExcelUtils.write(response, "二维码资源.xls", "数据", BookQtcodeSourceRespVO.class,
                        BeanUtils.toBean(list, BookQtcodeSourceRespVO.class));
    }

}