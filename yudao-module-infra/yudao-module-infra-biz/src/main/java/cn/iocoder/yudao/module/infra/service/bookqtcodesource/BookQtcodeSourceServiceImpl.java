package cn.iocoder.yudao.module.infra.service.bookqtcodesource;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;
import cn.iocoder.yudao.module.infra.controller.admin.bookqtcodesource.vo.BookQtcodeSourcePageReqVO;
import cn.iocoder.yudao.module.infra.controller.admin.bookqtcodesource.vo.BookQtcodeSourceSaveReqVO;
import cn.iocoder.yudao.module.infra.dal.dataobject.bookqtcodesource.BookQtcodeSourceDO;
import cn.iocoder.yudao.module.infra.dal.mysql.bookqtcodesource.BookQtcodeSourceMapper;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.annotation.Resource;

import static cn.iocoder.yudao.framework.common.exception.util.ServiceExceptionUtil.exception;
import static cn.iocoder.yudao.module.infra.enums.ErrorCodeConstants.BOOK_QTCODE_SOURCE_NOT_EXISTS;

/**
 * 二维码资源 Service 实现类
 *
 * @author 管理员
 */
@Service
@Validated
public class BookQtcodeSourceServiceImpl implements BookQtcodeSourceService {

    @Resource
    private BookQtcodeSourceMapper bookQtcodeSourceMapper;

    @Override
    public Long createBookQtcodeSource(BookQtcodeSourceSaveReqVO createReqVO) {
        // 插入
        BookQtcodeSourceDO bookQtcodeSource = BeanUtils.toBean(createReqVO, BookQtcodeSourceDO.class);
        bookQtcodeSourceMapper.insert(bookQtcodeSource);
        // 返回
        return bookQtcodeSource.getId();
    }

    @Override
    public void updateBookQtcodeSource(BookQtcodeSourceSaveReqVO updateReqVO) {
        // 校验存在
        validateBookQtcodeSourceExists(updateReqVO.getId());
        // 更新
        BookQtcodeSourceDO updateObj = BeanUtils.toBean(updateReqVO, BookQtcodeSourceDO.class);
        bookQtcodeSourceMapper.updateById(updateObj);
    }

    @Override
    public void deleteBookQtcodeSource(Long id) {
        // 校验存在
        validateBookQtcodeSourceExists(id);
        // 删除
        bookQtcodeSourceMapper.deleteById(id);
    }

    private void validateBookQtcodeSourceExists(Long id) {
        if (bookQtcodeSourceMapper.selectById(id) == null) {
            throw exception(BOOK_QTCODE_SOURCE_NOT_EXISTS);
        }
    }

    @Override
    public BookQtcodeSourceDO getBookQtcodeSource(Long id) {
        return bookQtcodeSourceMapper.selectById(id);
    }

    @Override
    public PageResult<BookQtcodeSourceDO> getBookQtcodeSourcePage(BookQtcodeSourcePageReqVO pageReqVO) {
        return bookQtcodeSourceMapper.selectPage(pageReqVO);
    }

}