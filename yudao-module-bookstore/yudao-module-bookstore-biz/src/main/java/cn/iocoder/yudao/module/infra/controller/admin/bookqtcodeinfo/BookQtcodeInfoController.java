package cn.iocoder.yudao.module.infra.controller.admin.bookqtcodeinfo;

import cn.hutool.core.img.ImgUtil;
import cn.hutool.extra.qrcode.QrCodeUtil;
import cn.hutool.extra.qrcode.QrConfig;
import org.apache.commons.lang3.StringUtils;
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

import cn.iocoder.yudao.module.infra.controller.admin.bookqtcodeinfo.vo.*;
import cn.iocoder.yudao.module.infra.dal.dataobject.bookqtcodeinfo.BookQtcodeInfoDO;
import cn.iocoder.yudao.module.infra.service.bookqtcodeinfo.BookQtcodeInfoService;

@Tag(name = "管理后台 - 图书二维码信息")
@RestController
@RequestMapping("/infra/book-qtcode-info")
@Validated
public class BookQtcodeInfoController {

    @Resource
    private BookQtcodeInfoService bookQtcodeInfoService;

    @PostMapping("/create")
    @Operation(summary = "创建图书二维码信息")
    @PreAuthorize("@ss.hasPermission('infra:book-qtcode-info:create')")
    public CommonResult<Long> createBookQtcodeInfo(@Valid @RequestBody BookQtcodeInfoSaveReqVO createReqVO) {
        return success(bookQtcodeInfoService.createBookQtcodeInfo(createReqVO));
    }

    @PutMapping("/update")
    @Operation(summary = "更新图书二维码信息")
    @PreAuthorize("@ss.hasPermission('infra:book-qtcode-info:update')")
    public CommonResult<Boolean> updateBookQtcodeInfo(@Valid @RequestBody BookQtcodeInfoSaveReqVO updateReqVO) {
        bookQtcodeInfoService.updateBookQtcodeInfo(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "删除图书二维码信息")
    @Parameter(name = "id", description = "编号", required = true)
    @PreAuthorize("@ss.hasPermission('infra:book-qtcode-info:delete')")
    public CommonResult<Boolean> deleteBookQtcodeInfo(@RequestParam("id") Long id) {
        bookQtcodeInfoService.deleteBookQtcodeInfo(id);
        return success(true);
    }

    @GetMapping("/get")
    @Operation(summary = "获得图书二维码信息")
    @Parameter(name = "id", description = "编号", required = true, example = "1024")
    @PreAuthorize("@ss.hasPermission('infra:book-qtcode-info:query')")
    public CommonResult<BookQtcodeInfoRespVO> getBookQtcodeInfo(@RequestParam("id") Long id) {
        BookQtcodeInfoDO bookQtcodeInfo = bookQtcodeInfoService.getBookQtcodeInfo(id);
        bookQtcodeInfo.setDtcodeContext(bookQtcodeInfoService.genQrCode(bookQtcodeInfo.getDtcodeAddress()));
        return success(BeanUtils.toBean(bookQtcodeInfo, BookQtcodeInfoRespVO.class));
    }

    @GetMapping("/page")
    @Operation(summary = "获得图书二维码信息分页")
    @PreAuthorize("@ss.hasPermission('infra:book-qtcode-info:query')")
    public CommonResult<PageResult<BookQtcodeInfoRespVO>> getBookQtcodeInfoPage(@Valid @ParameterObject BookQtcodeInfoPageReqVO pageReqVO) {
        //查询全部数据
        if(pageReqVO.getPageNo() <= 0 ){
            pageReqVO.setPageSize(PageParam.PAGE_SIZE_NONE);
        }
        PageResult<BookQtcodeInfoDO> pageResult = bookQtcodeInfoService.getBookQtcodeInfoPage(pageReqVO);
        pageResult.getList().forEach(vo -> {
            vo.setDtcodeContext(bookQtcodeInfoService.genQrCode(vo.getDtcodeAddress()));
        });
        return success(BeanUtils.toBean(pageResult, BookQtcodeInfoRespVO.class));
    }

    @GetMapping("/export-excel")
    @Operation(summary = "导出图书二维码信息 Excel")
    @PreAuthorize("@ss.hasPermission('infra:book-qtcode-info:export')")
    @ApiAccessLog(operateType = EXPORT)
    public void exportBookQtcodeInfoExcel(@Valid BookQtcodeInfoPageReqVO pageReqVO,
              HttpServletResponse response) throws IOException {
        pageReqVO.setPageSize(PageParam.PAGE_SIZE_NONE);
        List<BookQtcodeInfoDO> list = bookQtcodeInfoService.getBookQtcodeInfoPage(pageReqVO).getList();
        // 导出 Excel
        ExcelUtils.write(response, "图书二维码信息.xls", "数据", BookQtcodeInfoRespVO.class,
                        BeanUtils.toBean(list, BookQtcodeInfoRespVO.class));
    }

}