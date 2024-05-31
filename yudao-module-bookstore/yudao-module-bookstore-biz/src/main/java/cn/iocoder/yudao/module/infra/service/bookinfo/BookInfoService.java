package cn.iocoder.yudao.module.infra.service.bookinfo;

import java.util.*;
import javax.validation.*;
import cn.iocoder.yudao.module.infra.controller.admin.bookinfo.vo.*;
import cn.iocoder.yudao.module.infra.dal.dataobject.bookinfo.BookInfoDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.pojo.PageParam;

/**
 * 图书信息 Service 接口
 *
 * @author 管理员
 */
public interface BookInfoService {

    /**
     * 创建图书信息
     *
     * @param createReqVO 创建信息
     * @return 编号
     */
    Long createBookInfo(@Valid BookInfoSaveReqVO createReqVO);

    /**
     * 更新图书信息
     *
     * @param updateReqVO 更新信息
     */
    void updateBookInfo(@Valid BookInfoSaveReqVO updateReqVO);

    /**
     * 删除图书信息
     *
     * @param id 编号
     */
    void deleteBookInfo(Long id);

    /**
     * 获得图书信息
     *
     * @param id 编号
     * @return 图书信息
     */
    BookInfoDO getBookInfo(Long id);

    /**
     * 获得图书信息分页
     *
     * @param pageReqVO 分页查询
     * @return 图书信息分页
     */
    PageResult<BookInfoDO> getBookInfoPage(BookInfoPageReqVO pageReqVO);

}