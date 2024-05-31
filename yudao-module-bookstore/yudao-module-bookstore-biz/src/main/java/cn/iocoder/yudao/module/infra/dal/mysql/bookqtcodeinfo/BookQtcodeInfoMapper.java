package cn.iocoder.yudao.module.infra.dal.mysql.bookqtcodeinfo;

import java.util.*;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import cn.iocoder.yudao.module.infra.dal.dataobject.bookqtcodeinfo.BookQtcodeInfoDO;
import org.apache.ibatis.annotations.Mapper;
import cn.iocoder.yudao.module.infra.controller.admin.bookqtcodeinfo.vo.*;

/**
 * 图书二维码信息 Mapper
 *
 * @author 管理员
 */
@Mapper
public interface BookQtcodeInfoMapper extends BaseMapperX<BookQtcodeInfoDO> {

    default PageResult<BookQtcodeInfoDO> selectPage(BookQtcodeInfoPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<BookQtcodeInfoDO>()
                .likeIfPresent(BookQtcodeInfoDO::getDtcodeName, reqVO.getDtcodeName())
                .eqIfPresent(BookQtcodeInfoDO::getItemId, reqVO.getItemId())
                .eqIfPresent(BookQtcodeInfoDO::getDtcodeAddress, reqVO.getDtcodeAddress())
                .eqIfPresent(BookQtcodeInfoDO::getDtcodeContext, reqVO.getDtcodeContext())
                .betweenIfPresent(BookQtcodeInfoDO::getCreateTime, reqVO.getCreateTime())
                .eqIfPresent(BookQtcodeInfoDO::getDtcodeCategory, reqVO.getDtcodeCategory())
                .eqIfPresent(BookQtcodeInfoDO::getDtcodeId, reqVO.getDtcodeId())
                .eqIfPresent(BookQtcodeInfoDO::getChapterId, reqVO.getChapterId())
                .eqIfPresent(BookQtcodeInfoDO::getBookNo, reqVO.getBookNo())
                .orderByDesc(BookQtcodeInfoDO::getId));
    }

}