package com.xxxx.server.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xxxx.server.param.FeedBackParam;
import com.xxxx.server.pojo.Feedback;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author zjr
 * @since 2023-05-04
 */
public interface IFeedbackService extends IService<Feedback> {
    List<FeedBackParam> getAllFeedbacks(Integer page);
    Integer getNumFeedbacks();
}
