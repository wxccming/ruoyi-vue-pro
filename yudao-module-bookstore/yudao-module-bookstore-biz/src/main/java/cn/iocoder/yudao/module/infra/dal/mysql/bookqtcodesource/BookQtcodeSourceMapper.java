package cn.iocoder.yudao.module.infra.dal.mysql.bookqtcodesource;

import java.util.*;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import cn.iocoder.yudao.module.infra.dal.dataobject.bookqtcodesource.BookQtcodeSourceDO;
import org.apache.ibatis.annotations.Mapper;
import cn.iocoder.yudao.module.infra.controller.admin.bookqtcodesource.vo.*;

/**
 * 二维码资源 Mapper
 *
 * @author 管理员
 */
@Mapper
public interface BookQtcodeSourceMapper extends BaseMapperX<BookQtcodeSourceDO> {

    default PageResult<BookQtcodeSourceDO> selectPage(BookQtcodeSourcePageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<BookQtcodeSourceDO>()
                .eqIfPresent(BookQtcodeSourceDO::getSourceId, reqVO.getSourceId())
                .likeIfPresent(BookQtcodeSourceDO::getSourceName, reqVO.getSourceName())
                .eqIfPresent(BookQtcodeSourceDO::getSourceForm, reqVO.getSourceForm())
                .eqIfPresent(BookQtcodeSourceDO::getApplicaScens, reqVO.getApplicaScens())
                .betweenIfPresent(BookQtcodeSourceDO::getCreateTime, reqVO.getCreateTime())
                .eqIfPresent(BookQtcodeSourceDO::getDtcodeId, reqVO.getDtcodeId())
                .orderByDesc(BookQtcodeSourceDO::getId));
    }

}