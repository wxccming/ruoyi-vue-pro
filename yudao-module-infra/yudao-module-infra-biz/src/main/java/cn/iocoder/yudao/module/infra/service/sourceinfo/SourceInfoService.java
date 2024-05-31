package cn.iocoder.yudao.module.infra.service.sourceinfo;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.module.infra.controller.admin.sourceinfo.vo.*;
import cn.iocoder.yudao.module.infra.dal.dataobject.sourceinfo.SourceInfoDO;

import javax.validation.Valid;

/**
 * 资源信息 Service 接口
 *
 * @author 管理员
 */
public interface SourceInfoService {

    /**
     * 创建资源信息
     *
     * @param createReqVO 创建信息
     * @return 编号
     */
    Long createSourceInfo(@Valid SourceInfoSaveReqVO createReqVO);

    /**
     * 更新资源信息
     *
     * @param updateReqVO 更新信息
     */
    void updateSourceInfo(@Valid SourceInfoSaveReqVO updateReqVO);

    /**
     * 删除资源信息
     *
     * @param id 编号
     */
    void deleteSourceInfo(Long id);

    /**
     * 获得资源信息
     *
     * @param id 编号
     * @return 资源信息
     */
    SourceInfoDO getSourceInfo(Long id);

    /**
     * 获得资源信息分页
     *
     * @param pageReqVO 分页查询
     * @return 资源信息分页
     */
    PageResult<SourceInfoDO> getSourceInfoPage(SourceInfoPageReqVO pageReqVO);

}