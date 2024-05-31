package cn.iocoder.yudao.module.infra.service.bookqtcodeitem;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;
import cn.iocoder.yudao.module.infra.controller.admin.bookqtcodeitem.vo.BookQtcodeItemPageReqVO;
import cn.iocoder.yudao.module.infra.controller.admin.bookqtcodeitem.vo.BookQtcodeItemSaveReqVO;
import cn.iocoder.yudao.module.infra.dal.dataobject.bookqtcodeitem.BookQtcodeItemDO;
import cn.iocoder.yudao.module.infra.dal.mysql.bookqtcodeitem.BookQtcodeItemMapper;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.annotation.Resource;

import static cn.iocoder.yudao.framework.common.exception.util.ServiceExceptionUtil.exception;
import static cn.iocoder.yudao.module.infra.enums.ErrorCodeConstants.BOOK_QTCODE_ITEM_NOT_EXISTS;

/**
 * 二维码项目 Service 实现类
 *
 * @author 管理员
 */
@Service
@Validated
public class BookQtcodeItemServiceImpl implements BookQtcodeItemService {

    @Resource
    private BookQtcodeItemMapper bookQtcodeItemMapper;

    @Override
    public Long createBookQtcodeItem(BookQtcodeItemSaveReqVO createReqVO) {
        // 插入
        BookQtcodeItemDO bookQtcodeItem = BeanUtils.toBean(createReqVO, BookQtcodeItemDO.class);
        bookQtcodeItemMapper.insert(bookQtcodeItem);
        // 返回
        return bookQtcodeItem.getId();
    }

    @Override
    public void updateBookQtcodeItem(BookQtcodeItemSaveReqVO updateReqVO) {
        // 校验存在
        validateBookQtcodeItemExists(updateReqVO.getId());
        // 更新
        BookQtcodeItemDO updateObj = BeanUtils.toBean(updateReqVO, BookQtcodeItemDO.class);
        bookQtcodeItemMapper.updateById(updateObj);
    }

    @Override
    public void deleteBookQtcodeItem(Long id) {
        // 校验存在
        validateBookQtcodeItemExists(id);
        // 删除
        bookQtcodeItemMapper.deleteById(id);
    }

    private void validateBookQtcodeItemExists(Long id) {
        if (bookQtcodeItemMapper.selectById(id) == null) {
            throw exception(BOOK_QTCODE_ITEM_NOT_EXISTS);
        }
    }

    @Override
    public BookQtcodeItemDO getBookQtcodeItem(Long id) {
        return bookQtcodeItemMapper.selectById(id);
    }

    @Override
    public PageResult<BookQtcodeItemDO> getBookQtcodeItemPage(BookQtcodeItemPageReqVO pageReqVO) {
        return bookQtcodeItemMapper.selectPage(pageReqVO);
    }

}