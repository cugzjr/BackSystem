package com.xxxx.server.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xxxx.server.param.ProductParam;
import com.xxxx.server.pojo.Commodity;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author zjr
 * @since 2023-05-03
 */
public interface ICommodityService extends IService<Commodity> {
    List<ProductParam> getAllProducts(Integer page);
    Integer getNumProducts();
}
