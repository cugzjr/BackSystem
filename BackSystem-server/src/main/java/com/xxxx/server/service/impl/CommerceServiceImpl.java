package com.xxxx.server.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xxxx.server.mapper.CommerceMapper;
import com.xxxx.server.param.CommerceParam;
import com.xxxx.server.pojo.Commerce;
import com.xxxx.server.service.ICommerceService;
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
public class CommerceServiceImpl extends ServiceImpl<CommerceMapper, Commerce> implements ICommerceService {
    @Autowired
    private CommerceMapper commerceMapper;

    @Override
    public List<CommerceParam> getAllCommerces(Integer page){
        QueryWrapper<Commerce> commerceQueryWrapper = new QueryWrapper<>();
        commerceQueryWrapper.isNotNull("commerceid");
        List<Commerce> commerceList = commerceMapper.selectList(commerceQueryWrapper);
        List<CommerceParam> res = new ArrayList<>();
        if(page >= commerceList.size()){
            return res;
        }
        int count = 8;
        Integer i= commerceList.size() - page * count - 1;
        while(count>0)
        {
            try {
                Commerce commerce = commerceList.get(i);
                CommerceParam commerceParam = new CommerceParam();
                commerceParam.setCommodityid(commerce.getCommodityid());
                commerceParam.setSellerid(commerce.getSellerid());
                commerceParam.setBuyerid(commerce.getBuyerid());
                commerceParam.setPrice(commerce.getPrice());
                commerceParam.setPlace(commerce.getPlace());
                DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
                commerceParam.setTime(commerce.getTime().format(fmt));
                res.add(commerceParam);
            } catch (Exception e) {
                return res;
            }
            i--;
            --count;
        }
        return res;
    }
    @Override
    public Integer getNumCommerces(){
        QueryWrapper<Commerce> commerceQueryWrapper = new QueryWrapper<>();
        commerceQueryWrapper.isNotNull("commerceid");
        List<Commerce> commerceList = commerceMapper.selectList(commerceQueryWrapper);
        return commerceList.size();
    }
}
