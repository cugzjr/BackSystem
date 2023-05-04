package com.xxxx.server.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xxxx.server.mapper.FeedbackMapper;
import com.xxxx.server.param.FeedBackParam;
import com.xxxx.server.pojo.Feedback;
import com.xxxx.server.service.IFeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
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
 * @since 2023-05-04
 */
@Service
public class FeedbackServiceImpl extends ServiceImpl<FeedbackMapper, Feedback> implements IFeedbackService {
    @Autowired
    private FeedbackMapper feedbackMapper;

    @Override
    public List<FeedBackParam> getAllFeedbacks(Integer page){
        QueryWrapper<Feedback> feedbackQueryWrapper = new QueryWrapper<>();
        feedbackQueryWrapper.isNotNull("id");
        List<Feedback> feedbackList = feedbackMapper.selectList(feedbackQueryWrapper);
        List<FeedBackParam> res = new ArrayList<>();
        if(page >= feedbackList.size()){
            return res;
        }
        int count = 8;
        Integer i = feedbackList.size() - page * count - 1;
        while(count>0)
        {
            try {
                Feedback feedback = feedbackList.get(i);
                FeedBackParam feedBackParam = new FeedBackParam();
                feedBackParam.setId(feedback.getId());
                feedBackParam.setUsername(feedback.getUsername());
                feedBackParam.setContent(feedback.getContent());
                DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
                feedBackParam.setTime(feedback.getTime().format(fmt));
                res.add(feedBackParam);
            } catch (Exception e) {
                return res;
            }
            i--;
            --count;
        }
        return res;
    }
    @Override
    public Integer getNumFeedbacks(){
        QueryWrapper<Feedback> feedbackQueryWrapper = new QueryWrapper<>();
        feedbackQueryWrapper.isNotNull("id");
        List<Feedback> feedbackList = feedbackMapper.selectList(feedbackQueryWrapper);
        return feedbackList.size();
    }
}
