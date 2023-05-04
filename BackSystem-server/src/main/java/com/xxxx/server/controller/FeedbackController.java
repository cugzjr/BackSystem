package com.xxxx.server.controller;


import com.xxxx.server.param.FeedBackParam;
import com.xxxx.server.pojo.Feedback;
import com.xxxx.server.pojo.RespBean;
import com.xxxx.server.service.IFeedbackService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author zjr
 * @since 2023-05-04
 */
@RestController
@RequestMapping("/feedback")
public class FeedbackController {
    @Autowired
    private IFeedbackService feedbackService;
    @ApiOperation(value = "查看所有用户反馈信息")
    @GetMapping("/eight-feedbacks")
    public List<FeedBackParam> getAllFeedbacks(@RequestParam(value = "page") Integer page){
        return feedbackService.getAllFeedbacks(page);
    }
    @ApiOperation(value = "查看所有用户反馈信息数量")
    @GetMapping("/num")
    public Integer getNumFeedbacks(){
        return feedbackService.getNumFeedbacks();
    }

}
