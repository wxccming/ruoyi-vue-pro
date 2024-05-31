package cn.iocoder.yudao.module.infra.service.bookqtcodeitem;

import java.util.*;
import javax.validation.*;
import cn.iocoder.yudao.module.infra.controller.admin.bookqtcodeitem.vo.*;
import cn.iocoder.yudao.module.infra.dal.dataobject.bookqtcodeitem.BookQtcodeItemDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.pojo.PageParam;

/**
 * 二维码项目 Service 接口
 *
 * @author 管理员
 */
public interface BookQtcodeItemService {

    /**
     * 创建二维码项目
     *
     * @param createReqVO 创建信息
     * @return 编号
     */
    Long createBookQtcodeItem(@Valid BookQtcodeItemSaveReqVO createReqVO);

    /**
     * 更新二维码项目
     *
     * @param updateReqVO 更新信息
     */
    void updateBookQtcodeItem(@Valid BookQtcodeItemSaveReqVO updateReqVO);

    /**
     * 删除二维码项目
     *
     * @param id 编号
     */
    void deleteBookQtcodeItem(Long id);

    /**
     * 获得二维码项目
     *
     * @param id 编号
     * @return 二维码项目
     */
    BookQtcodeItemDO getBookQtcodeItem(Long id);

    /**
     * 获得二维码项目分页
     *
     * @param pageReqVO 分页查询
     * @return 二维码项目分页
     */
    PageResult<BookQtcodeItemDO> /**/getBookQtcodeItemPage(BookQtcodeItemPageReqVO pageReqVO);

}