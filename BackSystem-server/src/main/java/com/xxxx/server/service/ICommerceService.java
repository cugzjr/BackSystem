package com.xxxx.server.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xxxx.server.param.CommerceParam;
import com.xxxx.server.pojo.Commerce;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author zjr
 * @since 2023-05-03
 */
public interface ICommerceService extends IService<Commerce> {
    List<CommerceParam> getAllCommerces(Integer page);
    Integer getNumCommerces();
}
