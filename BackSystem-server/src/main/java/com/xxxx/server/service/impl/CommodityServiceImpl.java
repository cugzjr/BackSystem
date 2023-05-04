package com.xxxx.server.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xxxx.server.mapper.CommodityMapper;
import com.xxxx.server.param.ProductParam;
import com.xxxx.server.pojo.Commodity;
import com.xxxx.server.service.ICommodityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zjr
 * @since 2023-05-03
 */
@Service
public class CommodityServiceImpl extends ServiceImpl<CommodityMapper, Commodity> implements ICommodityService {
    @Autowired
    private CommodityMapper commodityMapper;

    @Override
    public List<ProductParam> getAllProducts(Integer page){
        QueryWrapper<Commodity> commodityQueryWrapper = new QueryWrapper<>();
        commodityQueryWrapper.isNotNull("id");
        List<Commodity> commodityList = commodityMapper.selectList(commodityQueryWrapper);
        List<ProductParam> res = new ArrayList<>();
        if(page >= commodityList.size()){
            return res;
        }
        int count = 8;
        Integer i=  commodityList.size() - page * count - 1;
        while(count>0)
        {
            try {
                Commodity commodity = commodityList.get(i);
                ProductParam productParam = new ProductParam();
                productParam.setProductId(commodity.getId());
                productParam.setUserId(commodity.getUserId());
                productParam.setProductCategory(commodity.getCategory());
                productParam.setProductBrand(commodity.getBrand());
                productParam.setProductQuality(commodity.getQuality());
                productParam.setProductDescription(commodity.getDescription());
                productParam.setProductPrice(commodity.getPrice());
                DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
                productParam.setProductTime(commodity.getTime().format(fmt));
                res.add(productParam);
            } catch (Exception e) {
                return res;
            }
            i--;
            --count;
        }
        return res;
    }
    @Override
    public Integer getNumProducts(){
        QueryWrapper<Commodity> commodityQueryWrapper = new QueryWrapper<>();
        commodityQueryWrapper.isNotNull("id");
        List<Commodity> commodityList = commodityMapper.selectList(commodityQueryWrapper);
        return commodityList.size();
    }
}
