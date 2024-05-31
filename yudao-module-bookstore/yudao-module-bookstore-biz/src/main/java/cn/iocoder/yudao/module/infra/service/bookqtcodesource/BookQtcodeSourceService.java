package cn.iocoder.yudao.module.infra.service.bookqtcodesource;

import java.util.*;
import javax.validation.*;
import cn.iocoder.yudao.module.infra.controller.admin.bookqtcodesource.vo.*;
import cn.iocoder.yudao.module.infra.dal.dataobject.bookqtcodesource.BookQtcodeSourceDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.pojo.PageParam;

/**
 * 二维码资源 Service 接口
 *
 * @author 管理员
 */
public interface BookQtcodeSourceService {

    /**
     * 创建二维码资源
     *
     * @param createReqVO 创建信息
     * @return 编号
     */
    Long createBookQtcodeSource(@Valid BookQtcodeSourceSaveReqVO createReqVO);

    /**
     * 更新二维码资源
     *
     * @param updateReqVO 更新信息
     */
    void updateBookQtcodeSource(@Valid BookQtcodeSourceSaveReqVO updateReqVO);

    /**
     * 删除二维码资源
     *
     * @param id 编号
     */
    void deleteBookQtcodeSource(Long id);

    /**
     * 获得二维码资源
     *
     * @param id 编号
     * @return 二维码资源
     */
    BookQtcodeSourceDO getBookQtcodeSource(Long id);

    /**
     * 获得二维码资源分页
     *
     * @param pageReqVO 分页查询
     * @return 二维码资源分页
     */
    PageResult<BookQtcodeSourceDO> getBookQtcodeSourcePage(BookQtcodeSourcePageReqVO pageReqVO);

}