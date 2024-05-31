package cn.iocoder.yudao.module.infra.controller.admin.bookinfo;

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

import cn.iocoder.yudao.module.infra.controller.admin.bookinfo.vo.*;
import cn.iocoder.yudao.module.infra.dal.dataobject.bookinfo.BookInfoDO;
import cn.iocoder.yudao.module.infra.service.bookinfo.BookInfoService;

@Tag(name = "管理后台 - 图书信息")
@RestController
@RequestMapping("/infra/book-info")
@Validated
public class BookInfoController {

    @Resource
    private BookInfoService bookInfoService;

    @PostMapping("/create")
    @Operation(summary = "创建图书信息")
    @PreAuthorize("@ss.hasPermission('infra:book-info:create')")
    public CommonResult<Long> createBookInfo(@Valid @RequestBody BookInfoSaveReqVO createReqVO) {
        return success(bookInfoService.createBookInfo(createReqVO));
    }

    @PutMapping("/update")
    @Operation(summary = "更新图书信息")
    @PreAuthorize("@ss.hasPermission('infra:book-info:update')")
    public CommonResult<Boolean> updateBookInfo(@Valid @RequestBody BookInfoSaveReqVO updateReqVO) {
        bookInfoService.updateBookInfo(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "删除图书信息")
    @Parameter(name = "id", description = "编号", required = true)
    @PreAuthorize("@ss.hasPermission('infra:book-info:delete')")
    public CommonResult<Boolean> deleteBookInfo(@RequestParam("id") Long id) {
        bookInfoService.deleteBookInfo(id);
        return success(true);
    }

    @GetMapping("/get")
    @Operation(summary = "获得图书信息")
    @Parameter(name = "id", description = "编号", required = true, example = "1024")
    @PreAuthorize("@ss.hasPermission('infra:book-info:query')")
    public CommonResult<BookInfoRespVO> getBookInfo(@RequestParam("id") Long id) {
        BookInfoDO bookInfo = bookInfoService.getBookInfo(id);
        return success(BeanUtils.toBean(bookInfo, BookInfoRespVO.class));
    }

    @GetMapping("/page")
    @Operation(summary = "获得图书信息分页")
    @PreAuthorize("@ss.hasPermission('infra:book-info:query')")
    public CommonResult<PageResult<BookInfoRespVO>> getBookInfoPage(@Valid @ParameterObject BookInfoPageReqVO pageReqVO) {
        //查询全部数据
        if(pageReqVO.getPageNo() <= 0 ){
            pageReqVO.setPageSize(PageParam.PAGE_SIZE_NONE);
        }
        PageResult<BookInfoDO> pageResult = bookInfoService.getBookInfoPage(pageReqVO);
        return success(BeanUtils.toBean(pageResult, BookInfoRespVO.class));
    }

    @GetMapping("/export-excel")
    @Operation(summary = "导出图书信息 Excel")
    @PreAuthorize("@ss.hasPermission('infra:book-info:export')")
    @ApiAccessLog(operateType = EXPORT)
    public void exportBookInfoExcel(@Valid BookInfoPageReqVO pageReqVO,
              HttpServletResponse response) throws IOException {
        pageReqVO.setPageSize(PageParam.PAGE_SIZE_NONE);
        List<BookInfoDO> list = bookInfoService.getBookInfoPage(pageReqVO).getList();
        // 导出 Excel
        ExcelUtils.write(response, "图书信息.xls", "数据", BookInfoRespVO.class,
                        BeanUtils.toBean(list, BookInfoRespVO.class));
    }

}