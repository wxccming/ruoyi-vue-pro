package cn.iocoder.yudao.module.infra.dal.dataobject.bookinfo;

import lombok.*;
import java.util.*;
import java.time.LocalDateTime;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.*;
import cn.iocoder.yudao.framework.mybatis.core.dataobject.BaseDO;

/**
 * 图书信息 DO
 *
 * @author 管理员
 */
@TableName("infra_book_info")
@KeySequence("infra_book_info_seq") // 用于 Oracle、PostgreSQL、Kingbase、DB2、H2 数据库的主键自增。如果是 MySQL 等数据库，可不写。
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BookInfoDO extends BaseDO {

    /**
     * 文件编号
     */
    @TableId
    private Long id;
    /**
     * 图书编号
     */
    private String bookNo;
    /**
     * 图书名称
     */
    private String bookName;
    /**
     * 图书审定年份
     */
    private String auditedYear;
    /**
     * 图书分类
     */
    private String bookCategory;
    /**
     * 学段
     */
    private String period;
    /**
     * 年级
     */
    private String grade;
    /**
     * 学科
     */
    private String subject;
    /**
     * 版本
     */
    private String edition;
    /**
     * 册次
     */
    private String volume;
    /**
     * 出版单位
     */
    private String publishUnit;
    /**
     * 图书状态
     */
    private String bookStatus;
    /**
     * 排序
     */
    private String bookSeq;
    /**
     * 简介
     */
    private String intro;

    /**
     * 图书封面
     */
    private String bookPic;

    /**
     * 备用字段1
     */
    private String spareFiled1;
    /**
     * 备用字段2
     */
    private String spareFiled2;

}