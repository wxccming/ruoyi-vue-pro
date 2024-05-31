package cn.iocoder.yudao.module.infra.service.oss;

import cn.iocoder.yudao.module.infra.controller.admin.file.vo.file.OssCallbackResult;
import cn.iocoder.yudao.module.infra.controller.admin.file.vo.file.OssPolicyResult;

import javax.servlet.http.HttpServletRequest;

/**
 * oss上传管理Service
 * @auther 团子
 * @date 2019-07-31 11:31
 */

public interface OssService {
    /**
     * oss上传策略生成
     */
    OssPolicyResult policy();

    /**
     * oss上传成功回调
     */
    OssCallbackResult callback(HttpServletRequest request);
}
