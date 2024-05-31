package cn.iocoder.yudao.module.infra.service.bookqtcodeinfo;

import java.util.*;
import javax.validation.*;
import cn.iocoder.yudao.module.infra.controller.admin.bookqtcodeinfo.vo.*;
import cn.iocoder.yudao.module.infra.dal.dataobject.bookqtcodeinfo.BookQtcodeInfoDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.pojo.PageParam;

/**
 * 图书二维码信息 Service 接口
 *
 * @author 管理员
 */
public interface BookQtcodeInfoService {

    /**
     * 创建图书二维码信息
     *
     * @param createReqVO 创建信息
     * @return 编号
     */
    Long createBookQtcodeInfo(@Valid BookQtcodeInfoSaveReqVO createReqVO);

    /**
     * 更新图书二维码信息
     *
     * @param updateReqVO 更新信息
     */
    void updateBookQtcodeInfo(@Valid BookQtcodeInfoSaveReqVO updateReqVO);

    /**
     * 删除图书二维码信息
     *
     * @param id 编号
     */
    void deleteBookQtcodeInfo(Long id);

    /**
     * 获得图书二维码信息
     *
     * @param id 编号
     * @return 图书二维码信息
     */
    BookQtcodeInfoDO getBookQtcodeInfo(Long id);

    /**
     * 获得图书二维码信息分页
     *
     * @param pageReqVO 分页查询
     * @return 图书二维码信息分页
     */
    PageResult<BookQtcodeInfoDO> getBookQtcodeInfoPage(BookQtcodeInfoPageReqVO pageReqVO);


    /**
     * 生成二维码
     *
     * @param dtcodeAddress 二维码内容
     * @return 二维码 base64码
     */
    String genQrCode(String dtcodeAddress);

}