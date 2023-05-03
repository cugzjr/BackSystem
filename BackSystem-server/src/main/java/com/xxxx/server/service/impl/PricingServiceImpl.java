package com.xxxx.server.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xxxx.server.mapper.PricingMapper;
import com.xxxx.server.pojo.Pricing;
import com.xxxx.server.service.IPricingService;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zjr
 * @since 2023-05-03
 */
@Service
public class PricingServiceImpl extends ServiceImpl<PricingMapper, Pricing> implements IPricingService {

}
