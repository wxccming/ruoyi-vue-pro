package cn.iocoder.yudao.module.infra.dal.dataobject.bookqtcodeinfo;

import lombok.*;
import java.util.*;
import java.time.LocalDateTime;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.*;
import cn.iocoder.yudao.framework.mybatis.core.dataobject.BaseDO;

/**
 * 图书二维码信息 DO
 *
 * @author 管理员
 */
@TableName("infra_book_qtcode_info")
@KeySequence("infra_book_qtcode_info_seq") // 用于 Oracle、PostgreSQL、Kingbase、DB2、H2 数据库的主键自增。如果是 MySQL 等数据库，可不写。
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BookQtcodeInfoDO extends BaseDO {

    /**
     * 编号
     */
    @TableId
    private Long id;
    /**
     * 二维码名称
     */
    private String dtcodeName;
    /**
     * 所属项目编号
     */
    private String itemId;
    /**
     * 二维码地址
     */
    private String dtcodeAddress;
    /**
     * 二维码内容(图片流)
     */
    private String dtcodeContext;
    /**
     * 二维码分类
     */
    private String dtcodeCategory;
    /**
     * 二维码编号
     */
    private String dtcodeId;
    /**
     * 章节编号
     */
    private String chapterId;

    /**
     * 图书编号
     */
    private String bookNo;

}