package com.xxxx.server.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xxxx.server.mapper.RatingMapper;
import com.xxxx.server.pojo.Rating;
import com.xxxx.server.service.IRatingService;
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
public class RatingServiceImpl extends ServiceImpl<RatingMapper, Rating> implements IRatingService {

}
