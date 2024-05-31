package cn.iocoder.yudao.module.infra.dal.mysql.sourceinfo;

import java.util.*;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import cn.iocoder.yudao.module.infra.dal.dataobject.sourceinfo.SourceInfoDO;
import org.apache.ibatis.annotations.Mapper;
import cn.iocoder.yudao.module.infra.controller.admin.sourceinfo.vo.*;

/**
 * 资源信息 Mapper
 *
 * @author 管理员
 */
@Mapper
public interface SourceInfoMapper extends BaseMapperX<SourceInfoDO> {

    default PageResult<SourceInfoDO> selectPage(SourceInfoPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<SourceInfoDO>()
                .eqIfPresent(SourceInfoDO::getSourceId, reqVO.getSourceId())
                .likeIfPresent(SourceInfoDO::getSourceName, reqVO.getSourceName())
                .eqIfPresent(SourceInfoDO::getSourceForm, reqVO.getSourceForm())
                .eqIfPresent(SourceInfoDO::getSourceOrigin, reqVO.getSourceOrigin())
                .eqIfPresent(SourceInfoDO::getSourceUrl, reqVO.getSourceUrl())
                .eqIfPresent(SourceInfoDO::getSourceStatus, reqVO.getSourceStatus())
                .eqIfPresent(SourceInfoDO::getPeriod, reqVO.getPeriod())
                .eqIfPresent(SourceInfoDO::getGrade, reqVO.getGrade())
                .eqIfPresent(SourceInfoDO::getSubject, reqVO.getSubject())
                .eqIfPresent(SourceInfoDO::getEdition, reqVO.getEdition())
                .eqIfPresent(SourceInfoDO::getVolume, reqVO.getVolume())
                .eqIfPresent(SourceInfoDO::getChapter, reqVO.getChapter())
                .eqIfPresent(SourceInfoDO::getSourceKnnm, reqVO.getSourceKnnm())
                .eqIfPresent(SourceInfoDO::getApplicaObjects, reqVO.getApplicaObjects())
                .eqIfPresent(SourceInfoDO::getApplicaScens, reqVO.getApplicaScens())
                .eqIfPresent(SourceInfoDO::getFormat, reqVO.getFormat())
                .eqIfPresent(SourceInfoDO::getSize, reqVO.getSize())
                .eqIfPresent(SourceInfoDO::getSizeUnit, reqVO.getSizeUnit())
                .eqIfPresent(SourceInfoDO::getLableTag, reqVO.getLableTag())
                .eqIfPresent(SourceInfoDO::getRemaks, reqVO.getRemaks())
                .eqIfPresent(SourceInfoDO::getStorageAddress, reqVO.getStorageAddress())
                .eqIfPresent(SourceInfoDO::getSpareFiled1, reqVO.getSpareFiled1())
                .eqIfPresent(SourceInfoDO::getSpareFiled2, reqVO.getSpareFiled2())
                .eqIfPresent(SourceInfoDO::getUploadUserId, reqVO.getUploadUserId())
                .eqIfPresent(SourceInfoDO::getAuditUser1Id, reqVO.getAuditUser1Id())
                .eqIfPresent(SourceInfoDO::getAuditUser2Id, reqVO.getAuditUser2Id())
                .betweenIfPresent(SourceInfoDO::getCreateTime, reqVO.getCreateTime())
                .orderByDesc(SourceInfoDO::getId));
    }

}