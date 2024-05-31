package cn.iocoder.yudao.module.infra.dal.mysql.bookqtcodeitem;

import java.util.*;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import cn.iocoder.yudao.module.infra.dal.dataobject.bookqtcodeitem.BookQtcodeItemDO;
import org.apache.ibatis.annotations.Mapper;
import cn.iocoder.yudao.module.infra.controller.admin.bookqtcodeitem.vo.*;

/**
 * 二维码项目 Mapper
 *
 * @author 管理员
 */
@Mapper
public interface BookQtcodeItemMapper extends BaseMapperX<BookQtcodeItemDO> {

    default PageResult<BookQtcodeItemDO> selectPage(BookQtcodeItemPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<BookQtcodeItemDO>()
                .eqIfPresent(BookQtcodeItemDO::getItemId, reqVO.getItemId())
                .likeIfPresent(BookQtcodeItemDO::getItemName, reqVO.getItemName())
                .eqIfPresent(BookQtcodeItemDO::getSourceOrigin, reqVO.getSourceOrigin())
                .eqIfPresent(BookQtcodeItemDO::getBookNo, reqVO.getBookNo())
                .eqIfPresent(BookQtcodeItemDO::getRemarks, reqVO.getRemarks())
                .eqIfPresent(BookQtcodeItemDO::getDtcodeStatus, reqVO.getDtcodeStatus())
                .betweenIfPresent(BookQtcodeItemDO::getCreateTime, reqVO.getCreateTime())
                .orderByDesc(BookQtcodeItemDO::getId));
    }

}