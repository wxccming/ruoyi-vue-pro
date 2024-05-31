package cn.iocoder.yudao.module.infra.dal.mysql.bookinfo;

import java.util.*;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import cn.iocoder.yudao.module.infra.dal.dataobject.bookinfo.BookInfoDO;
import org.apache.ibatis.annotations.Mapper;
import cn.iocoder.yudao.module.infra.controller.admin.bookinfo.vo.*;

/**
 * 图书信息 Mapper
 *
 * @author 管理员
 */
@Mapper
public interface BookInfoMapper extends BaseMapperX<BookInfoDO> {

    default PageResult<BookInfoDO> selectPage(BookInfoPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<BookInfoDO>()
                .eqIfPresent(BookInfoDO::getBookNo, reqVO.getBookNo())
                .likeIfPresent(BookInfoDO::getBookName, reqVO.getBookName())
                .eqIfPresent(BookInfoDO::getAuditedYear, reqVO.getAuditedYear())
                .eqIfPresent(BookInfoDO::getBookCategory, reqVO.getBookCategory())
                .eqIfPresent(BookInfoDO::getPeriod, reqVO.getPeriod())
                .eqIfPresent(BookInfoDO::getGrade, reqVO.getGrade())
                .eqIfPresent(BookInfoDO::getSubject, reqVO.getSubject())
                .eqIfPresent(BookInfoDO::getEdition, reqVO.getEdition())
                .eqIfPresent(BookInfoDO::getVolume, reqVO.getVolume())
                .eqIfPresent(BookInfoDO::getPublishUnit, reqVO.getPublishUnit())
                .eqIfPresent(BookInfoDO::getBookStatus, reqVO.getBookStatus())
                .eqIfPresent(BookInfoDO::getBookSeq, reqVO.getBookSeq())
                .eqIfPresent(BookInfoDO::getIntro, reqVO.getIntro())
                .eqIfPresent(BookInfoDO::getSpareFiled1, reqVO.getSpareFiled1())
                .eqIfPresent(BookInfoDO::getSpareFiled2, reqVO.getSpareFiled2())
                .betweenIfPresent(BookInfoDO::getCreateTime, reqVO.getCreateTime())
                .orderByDesc(BookInfoDO::getId));
    }

}