package cn.iocoder.yudao.module.infra.service.sourceinfo;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;
import cn.iocoder.yudao.module.infra.controller.admin.sourceinfo.vo.*;
import cn.iocoder.yudao.module.infra.dal.dataobject.sourceinfo.SourceInfoDO;
import cn.iocoder.yudao.module.infra.dal.mysql.sourceinfo.SourceInfoMapper;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.annotation.Resource;

import static cn.iocoder.yudao.framework.common.exception.util.ServiceExceptionUtil.exception;
import static cn.iocoder.yudao.module.infra.enums.ErrorCodeConstants.SOURCE_INFO_NOT_EXISTS;

/**
 * 资源信息 Service 实现类
 *
 * @author 管理员
 */
@Service
@Validated
public class SourceInfoServiceImpl implements SourceInfoService {

    @Resource
    private SourceInfoMapper sourceInfoMapper;

    @Override
    public Long createSourceInfo(SourceInfoSaveReqVO createReqVO) {
        // 插入
        SourceInfoDO sourceInfo = BeanUtils.toBean(createReqVO, SourceInfoDO.class);
        sourceInfoMapper.insert(sourceInfo);
        // 返回
        return sourceInfo.getId();
    }

    @Override
    public void updateSourceInfo(SourceInfoSaveReqVO updateReqVO) {
        // 校验存在
        validateSourceInfoExists(updateReqVO.getId());
        // 更新
        SourceInfoDO updateObj = BeanUtils.toBean(updateReqVO, SourceInfoDO.class);
        sourceInfoMapper.updateById(updateObj);
    }

    @Override
    public void deleteSourceInfo(Long id) {
        // 校验存在
        validateSourceInfoExists(id);
        // 删除
        sourceInfoMapper.deleteById(id);
    }

    private void validateSourceInfoExists(Long id) {
        if (sourceInfoMapper.selectById(id) == null) {
            throw exception(SOURCE_INFO_NOT_EXISTS);
        }
    }

    @Override
    public SourceInfoDO getSourceInfo(Long id) {
        return sourceInfoMapper.selectById(id);
    }

    @Override
    public PageResult<SourceInfoDO> getSourceInfoPage(SourceInfoPageReqVO pageReqVO) {
        return sourceInfoMapper.selectPage(pageReqVO);
    }

}