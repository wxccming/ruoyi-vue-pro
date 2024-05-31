package cn.iocoder.yudao.module.infra.dal.dataobject.bookqtcodesource;

import lombok.*;
import java.util.*;
import java.time.LocalDateTime;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.*;
import cn.iocoder.yudao.framework.mybatis.core.dataobject.BaseDO;

/**
 * 二维码资源 DO
 *
 * @author 管理员
 */
@TableName("infra_book_qtcode_source")
@KeySequence("infra_book_qtcode_source_seq") // 用于 Oracle、PostgreSQL、Kingbase、DB2、H2 数据库的主键自增。如果是 MySQL 等数据库，可不写。
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BookQtcodeSourceDO extends BaseDO {

    /**
     * 编号
     */
    @TableId
    private Long id;
    /**
     * 资源编号
     */
    private String sourceId;
    /**
     * 资源名称
     */
    private String sourceName;
    /**
     * 资源形式
     */
    private String sourceForm;
    /**
     * 适用场景
     */
    private String applicaScens;
    /**
     * 二维码编号
     */
    private String dtcodeId;

}